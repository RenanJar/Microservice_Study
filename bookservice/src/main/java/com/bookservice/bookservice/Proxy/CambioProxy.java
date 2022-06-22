package com.bookservice.bookservice.Proxy;


import com.bookservice.bookservice.response.CambioModel;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
@FeignClient(name = "cambio-service")
public interface CambioProxy {
    @GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
    public CambioModel getcambio(
            @PathVariable("amount") Double amount,
            @PathVariable ("from") String from,
            @PathVariable ("to") String to
    );
}
