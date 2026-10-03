package com.nomina.modelo;

public class EmpleadoPorHoras extends Empleado {

    private double tarifaHora;
    private double horasTrabajadas;
    private boolean aceptaFondoAhorro;

    public EmpleadoPorHoras(
            String nombre,
            String identificacion,
            int añosEmpresa,
            double tarifaHora,
            double horasTrabajadas,
            boolean aceptaFondoAhorro) {

        super(nombre, identificacion, añosEmpresa);

        if (tarifaHora < 0) {
            throw new IllegalArgumentException(
                "La tarifa por hora no puede ser negativa."
            );
        }

        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException(
                "Las horas trabajadas no pueden ser negativas."
            );
        }

        this.tarifaHora = tarifaHora;
        this.horasTrabajadas = horasTrabajadas;
        this.aceptaFondoAhorro = aceptaFondoAhorro;
    }

    @Override
    public double calcularSalarioBruto() {

        double horasNormales = Math.min(horasTrabajadas, 40);
        double horasExtras = Math.max(horasTrabajadas - 40, 0);

        return (horasNormales * tarifaHora)
                + (horasExtras * tarifaHora * 1.5);
    }

    @Override
    public double calcularBonos() {
        return 0;
    }

    @Override
    public double calcularBeneficios() {

        if (getAñosEmpresa() > 1 && aceptaFondoAhorro) {
            return 0;
        }

        return 0;
    }

    @Override
    public double calcularDeducciones() {

        double salarioBruto = calcularSalarioBruto();

        double seguridadSocial = salarioBruto * 0.04;

        double fondoAhorro = 0;

        if (getAñosEmpresa() > 1 && aceptaFondoAhorro) {
            fondoAhorro = salarioBruto * 0.02;
        }

        return seguridadSocial + fondoAhorro;
    }
}