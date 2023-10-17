package com.agenda.transferencias;

import com.agenda.transferencias.DTO.Transferencia;
import com.agenda.transferencias.Repository.TransferenciaRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@CrossOrigin
public class TransferenciasController {
    private final TransferenciaRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferenciasController.class);

    public TransferenciasController(TransferenciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("transferencias")
    public String get(){
        return "Teste";
    }

    @PostMapping("salvar")
    public void salvar(@Valid @RequestBody Transferencia transferencia) {
        try {
            calculaTaxa(transferencia);
            repository.save(transferencia);
        } catch (Exception ex) {
            LOGGER.error("Ocorreu um problema ao salvar no banco!", ex);
        }
    }

    private void calculaTaxa(Transferencia transferencia) {
        Boolean transfA = false;
        Boolean transfB = false;
        long intervaloData = ChronoUnit.DAYS.between(transferencia.getDataAgend().toInstant(), transferencia.getDataTrans().toInstant());

        //D -1
        if (transferencia.getValorTrans().doubleValue() <= 1000.00) {
            transfA = true;
        }
        //D -2
        if (transferencia.getValorTrans().doubleValue() >= 1001.00 && transferencia.getValorTrans().doubleValue() <= 2000.00){
            transfB = true;
        }
        //D -3 e C
        if (transferencia.getValorTrans().doubleValue() > 2000.00 ) {
            if(Math.toIntExact(intervaloData) > 10) {
                transferencia.setTaxa(transferencia.getValorTrans().multiply(BigDecimal.valueOf(0.082)));
                return;
            }
            if(Math.toIntExact(intervaloData) > 20)  {
                transferencia.setTaxa(transferencia.getValorTrans().multiply(BigDecimal.valueOf(0.069)));
                return;
            }
            if(Math.toIntExact(intervaloData) > 30) {
                transferencia.setTaxa(transferencia.getValorTrans().multiply(BigDecimal.valueOf(0.047)));
                return;
            }
            if(Math.toIntExact(intervaloData) > 40) {
                transferencia.setTaxa(transferencia.getValorTrans().multiply(BigDecimal.valueOf(0.017)));
                return;
            }
        }

        //A
        if (transferencia.getDataAgend().equals(transferencia.getDataTrans()) || transfA){
            transferencia.setTaxa((transferencia.getValorTrans().multiply(BigDecimal.valueOf(0.03))).add(BigDecimal.valueOf(3)));

            return;
        }

        //B
        if (intervaloData >= 10 || transfB ){
            transferencia.setTaxa(BigDecimal.valueOf(12));
        }
    }

    @GetMapping("pesquisar")
    public List<Transferencia> pesquisar(){
        return (List<Transferencia>) repository.findAll();
    }
}
