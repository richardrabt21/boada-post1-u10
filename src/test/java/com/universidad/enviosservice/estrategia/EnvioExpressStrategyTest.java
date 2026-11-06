package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioExpressStrategyTest {

    private final EnvioExpressStrategy estrategia = new EnvioExpressStrategy();

    @ParameterizedTest
    @CsvSource({
            "3.0, 100.0, 156.0",
            "8.0, 100.0, 161.85",
            "25.0, 100.0, 198.25"
    })
    void calculaCostoPorTramoDePesoConFactorExpress(double pesoKg, double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(pesoKg, distanciaKm), 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "3.0, 500.0, 780.0",
            "3.0, 501.0, 814.06"
    })
    void aplicaRecargoDe25SoloSiLaDistanciaSuperaLos500Km(double pesoKg, double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(pesoKg, distanciaKm), 0.01);
    }
}