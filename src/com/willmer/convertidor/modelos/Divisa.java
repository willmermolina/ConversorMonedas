package com.willmer.convertidor.modelos;

public class Divisa {
    String monedaBase;
    String monedaCambio;
    double tipoDeCambio;
    double cambioResultante;

    public Divisa(CambioPar cambioDivisa){
        this.monedaBase = cambioDivisa.base_code();
        this.monedaCambio = cambioDivisa.target_code();
        this.tipoDeCambio = cambioDivisa.conversion_rate();
        this.cambioResultante = cambioDivisa.conversion_result();
    }

    @Override
    public String toString() {
        return "moneda Base= " + "["+ monedaBase + "]" + " | moneda Cambio= " + "[" + monedaCambio + "]" +
                " | tipo de Cambio 1 "+monedaBase+" = " + tipoDeCambio +
                " | Total convertido= " +cambioResultante;

    }
}
