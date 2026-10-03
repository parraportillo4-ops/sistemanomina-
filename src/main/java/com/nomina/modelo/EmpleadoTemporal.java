package com.nomina.modelo;

// Representa a un empleado con contrato por tiempo definido.
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

        // Se validan el salario y la duración del contrato.
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

    // El empleado temporal recibe un salario mensual fijo.
    @Override
    public double calcularSalarioBruto() {
        return salarioMensual;
    }

    // Los empleados temporales no reciben bonos.
    @Override
    public double calcularBonos() {
        return 0;
    }

    // Según las reglas, no recibe beneficios adicionales.
    @Override
    public double calcularBeneficios() {
        return 0;
    }

    // Se descuenta el 4% del salario bruto.
    @Override
    public double calcularDeducciones() {
        return salarioMensual * 0.04;
    }
}