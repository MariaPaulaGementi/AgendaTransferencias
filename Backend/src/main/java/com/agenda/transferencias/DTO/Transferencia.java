package com.agenda.transferencias.DTO;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String contaOrigem;
    @NotEmpty
    private String contaDestino;
    @NotNull
    private BigDecimal valorTrans;
    private BigDecimal taxa;
    @NotNull
    private Date dataTrans;
    @NotNull
    private Date dataAgend;

    public BigDecimal calculaTotal() {
        return this.valorTrans.add(this.taxa);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValorTrans() {
        return valorTrans;
    }

    public void setValorTrans(BigDecimal valorTrans) {
        this.valorTrans = valorTrans;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public Date getDataTrans() {
        return dataTrans;
    }

    public void setDataTrans(Date dataTrans) {
        this.dataTrans = dataTrans;
    }

    public Date getDataAgend() {
        return dataAgend;
    }

    public void setDataAgend(Date dataAgend) {
        this.dataAgend = dataAgend;
    }
}
