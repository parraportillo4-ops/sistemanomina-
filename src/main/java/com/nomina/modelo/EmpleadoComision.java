package com.nomina.modelo;

public class EmpleadoComision extends Empleado {

    private double salarioBase;
    private double ventas;
    private double porcentajeComision;

    public EmpleadoComision(
            String nombre,
            String identificacion,
            int añosEmpresa,
            double salarioBase,
            double ventas,
            double porcentajeComision) {

        super(nombre, identificacion, añosEmpresa);

        if (salarioBase < 0) {
            throw new IllegalArgumentException(
                "El salario base no puede ser negativo."
            );
        }

        if (ventas < 0) {
            throw new IllegalArgumentException(
                "Las ventas no pueden ser negativas."
            );
        }

        this.salarioBase = salarioBase;
        this.ventas = ventas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioBase + (ventas * porcentajeComision);
    }

    @Override
    public double calcularBonos() {

        if (ventas > 20_000_000) {
            return ventas * 0.03;
        }

        return 0;
    }

    @Override
    public double calcularBeneficios() {
        return 1_000_000;
    }

    @Override
    public double calcularDeducciones() {

        return calcularSalarioBruto() * 0.04;
    }
}