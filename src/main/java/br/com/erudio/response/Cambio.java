package br.com.erudio.response;

import java.io.Serializable;
import java.util.Objects;

public class Cambio implements Serializable {
    private Long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double convertedValue;
    private String enviorment;

    public Cambio() {}

    public Cambio(Long id, String from, String to, Double conversionFactor, Double convertedValue, String enviorment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.enviorment = enviorment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnviorment() {
        return enviorment;
    }

    public void setEnviorment(String enviorment) {
        this.enviorment = enviorment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cambio cambio = (Cambio) o;
        return Objects.equals(id, cambio.id) && Objects.equals(from, cambio.from) && Objects.equals(to, cambio.to) && Objects.equals(conversionFactor, cambio.conversionFactor) && Objects.equals(convertedValue, cambio.convertedValue) && Objects.equals(enviorment, cambio.enviorment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, conversionFactor, convertedValue, enviorment);
    }
}
