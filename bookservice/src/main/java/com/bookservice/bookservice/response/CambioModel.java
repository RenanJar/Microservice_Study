package com.bookservice.bookservice.response;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class CambioModel implements Serializable {

    private static final long serialVersionUID =1L;
    private Long id;

    private String from;

    private String to;

    private Double conversionFactor;

    private Double convertedValue;

    private String environment;

    public CambioModel(){}

    public CambioModel(Long id, String from, String to, Double conversionFactor, Double convertedValue, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CambioModel that = (CambioModel) o;
        return Objects.equals(id, that.id) && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(conversionFactor, that.conversionFactor) && Objects.equals(convertedValue, that.convertedValue) && Objects.equals(environment, that.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, conversionFactor, convertedValue, environment);
    }
}
