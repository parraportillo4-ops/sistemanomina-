package com.nomina.modelo;

// Representa a un empleado que recibe salario base y comisión por ventas.
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

        // Se validan los valores relacionados con el salario y las ventas.
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

    // El salario bruto combina el salario base con las comisiones.
    @Override
    public double calcularSalarioBruto() {
        return salarioBase + (ventas * porcentajeComision);
    }

    // Se entrega un bono del 3% cuando las ventas superan 20 millones.
    @Override
    public double calcularBonos() {

        if (ventas > 20_000_000) {
            return ventas * 0.03;
        }

        return 0;
    }

    // Los empleados permanentes reciben el bono de alimentación.
    @Override
    public double calcularBeneficios() {
        return 1_000_000;
    }

    // Se descuenta el 4% del salario bruto.
    @Override
    public double calcularDeducciones() {
        return calcularSalarioBruto() * 0.04;
    }
}