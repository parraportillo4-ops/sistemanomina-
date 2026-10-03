package com.nomina.modelo;

public class EmpleadoTemporal extends Empleado {

    private double salarioMensual;
    private int mesesContrato;

    public EmpleadoTemporal(
            String nombre,
            String identificacion,
            int añosEmpresa,
            double salarioMensual,
            int mesesContrato) {

        super(nombre, identificacion, añosEmpresa);

        if (salarioMensual < 0) {
            throw new IllegalArgumentException(
                "El salario no puede ser negativo."
            );
        }

        if (mesesContrato <= 0) {
            throw new IllegalArgumentException(
                "La duración del contrato debe ser mayor que cero."
            );
        }

        this.salarioMensual = salarioMensual;
        this.mesesContrato = mesesContrato;
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioMensual;
    }

    @Override
    public double calcularBonos() {
        return 0;
    }

    @Override
    public double calcularBeneficios() {
        return 0;
    }

    @Override
    public double calcularDeducciones() {
        return salarioMensual * 0.04;
    }
}