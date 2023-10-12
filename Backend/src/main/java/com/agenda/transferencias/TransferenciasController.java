package com.agenda.transferencias;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferenciasController {
    @GetMapping("transferencias")
    public String get(){
        return "Teste";
    }
}
