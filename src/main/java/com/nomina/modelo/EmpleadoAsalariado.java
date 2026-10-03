package com.nomina.modelo;

public class EmpleadoAsalariado extends Empleado {

    private double salarioMensual;

    public EmpleadoAsalariado(
            String nombre,
            String identificacion,
            int añosEmpresa,
            double salarioMensual) {

        super(nombre, identificacion, añosEmpresa);

        if (salarioMensual < 0) {
            throw new IllegalArgumentException(
                "El salario no puede ser negativo."
            );
        }

        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioMensual;
    }

    @Override
    public double calcularBonos() {

        if (getAñosEmpresa() > 5) {
            return salarioMensual * 0.10;
        }

        return 0;
    }

    @Override
    public double calcularBeneficios() {
        return 1_000_000;
    }

    @Override
    public double calcularDeducciones() {
        return salarioMensual * 0.04;
    }
}