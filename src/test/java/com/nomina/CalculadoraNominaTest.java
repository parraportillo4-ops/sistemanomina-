package com.nomina;

import com.nomina.modelo.EmpleadoAsalariado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraNominaTest {

    @Test
    void debeCalcularBonoDeEmpleadoAsalariado() {

        EmpleadoAsalariado empleado =
                new EmpleadoAsalariado(
                        "Carlos",
                        "1001",
                        6,
                        3_000_000
                );

        assertEquals(
                300_000,
                empleado.calcularBonos()
        );
    }

    @Test
    void noDebePermitirHorasNegativas() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new com.nomina.modelo.EmpleadoPorHoras(
                        "Laura",
                        "1002",
                        2,
                        30_000,
                        -5,
                        true
                )
        );
    }

    @Test
    void noDebePermitirVentasNegativas() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new com.nomina.modelo.EmpleadoComision(
                        "Samuel",
                        "1003",
                        2,
                        2_000_000,
                        -100,
                        0.05
                )
        );
    }
}
