package com.nomina;

import com.nomina.modelo.Empleado;
import com.nomina.modelo.EmpleadoAsalariado;
import com.nomina.modelo.EmpleadoPorHoras;
import com.nomina.modelo.EmpleadoComision;
import com.nomina.modelo.EmpleadoTemporal;

public class Main {

    public static void main(String[] args) {

        // Se crean ejemplos de cada tipo de empleado.
        Empleado asalariado = new EmpleadoAsalariado(
                "Carlos",
                "1001",
                7,
                3_000_000
        );

        Empleado porHoras = new EmpleadoPorHoras(
                "Laura",
                "1002",
                2,
                30_000,
                45,
                true
        );

        Empleado comision = new EmpleadoComision(
                "Samuel",
                "1003",
                4,
                2_000_000,
                25_000_000,
                0.05
        );

        Empleado temporal = new EmpleadoTemporal(
                "Jhon",
                "1004",
                1,
                2_500_000,
                6
        );

        // Se muestra el resultado de cada empleado.
        mostrarNomina(asalariado);
        mostrarNomina(porHoras);
        mostrarNomina(comision);
        mostrarNomina(temporal);
    }

    // Muestra de forma organizada los resultados de la nómina.
    private static void mostrarNomina(Empleado empleado) {

        System.out.println("------------------------------");
        System.out.println("Empleado: " + empleado.getNombre());
        System.out.println("Salario bruto: "
                + empleado.calcularSalarioBruto());
        System.out.println("Bonos: "
                + empleado.calcularBonos());
        System.out.println("Beneficios: "
                + empleado.calcularBeneficios());
        System.out.println("Deducciones: "
                + empleado.calcularDeducciones());
        System.out.println("Salario neto: "
                + empleado.calcularSalarioNeto());
    }
}