package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EnvioOvernightStrategyTest {

    private final EnvioOvernightStrategy estrategia = new EnvioOvernightStrategy();

    @ParameterizedTest
    @CsvSource({
            "3.0, 100.0, 220.0",
            "8.0, 100.0, 227.5",
            "25.0, 100.0, 272.5"
    })
    void calculaCostoPorTramoDePeso(double pesoKg, double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(pesoKg, distanciaKm), 0.01);
    }

    @Test
    void permiteExactamente300Km() {
        assertEquals(620.0, estrategia.calcular(3.0, 300.0), 0.01);
    }

    @Test
    void rechazaDistanciasMayoresA300Km() {
        assertThrows(IllegalArgumentException.class,
                () -> estrategia.calcular(3.0, 301.0));
    }
}