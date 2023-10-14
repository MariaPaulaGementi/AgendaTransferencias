package com.agenda.transferencias;

import com.agenda.transferencias.DTO.Transferencia;
import com.agenda.transferencias.Repository.TransferenciaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TransferenciasController {
    private TransferenciaRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferenciasController.class);

    public TransferenciasController(TransferenciaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("transferencias")
    public String get(){
        return "Teste";
    }

    @PostMapping("salvar")
    public void salvar(@RequestBody Transferencia transferencia) {
        try {
            repository.save(transferencia);
        } catch (Exception ex) {
            LOGGER.error("Ocorreu um problema ao salvar no banco!", ex);
        }
    }
}
