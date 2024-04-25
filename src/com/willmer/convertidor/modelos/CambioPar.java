package com.willmer.convertidor.modelos;

public record CambioPar(String base_code,
                        String target_code,
                        double conversion_rate,
                        double conversion_result) {
}
