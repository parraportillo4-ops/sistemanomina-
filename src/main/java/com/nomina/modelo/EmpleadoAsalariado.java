package com.nomina.modelo;

// Representa a un empleado con salario mensual fijo.
public class EmpleadoAsalariado extends Empleado {

    private double salarioMensual;

    public EmpleadoAsalariado(
            String nombre,
            String identificacion,
            int añosEmpresa,
            double salarioMensual) {

        super(nombre, identificacion, añosEmpresa);

        // El salario mensual debe ser válido.
        if (salarioMensual < 0) {
            throw new IllegalArgumentException(
                    "El salario no puede ser negativo."
            );
        }

        this.salarioMensual = salarioMensual;
    }

    // El salario bruto corresponde al salario mensual.
    @Override
    public double calcularSalarioBruto() {
        return salarioMensual;
    }

    // Se entrega un bono del 10% después de 5 años.
    @Override
    public double calcularBonos() {

        if (getAñosEmpresa() > 5) {
            return salarioMensual * 0.10;
        }

        return 0;
    }

    // Los empleados permanentes reciben el bono de alimentación.
    @Override
    public double calcularBeneficios() {
        return 1_000_000;
    }

    // Se descuenta el 4% correspondiente a seguridad social y pensión.
    @Override
    public double calcularDeducciones() {
        return salarioMensual * 0.04;
    }
}