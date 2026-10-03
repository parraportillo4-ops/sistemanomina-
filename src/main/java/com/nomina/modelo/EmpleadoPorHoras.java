package com.nomina.modelo;

// Representa a un empleado cuyo salario depende de las horas trabajadas.
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

        // La tarifa y las horas no pueden ser negativas.
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

    // Se separan las horas normales de las horas extras.
    @Override
    public double calcularSalarioBruto() {

        double horasNormales = Math.min(horasTrabajadas, 40);
        double horasExtras = Math.max(horasTrabajadas - 40, 0);

        // Las horas extras se pagan al 1.5 de la tarifa normal.
        return (horasNormales * tarifaHora)
                + (horasExtras * tarifaHora * 1.5);
    }

    // Los empleados por horas no reciben bonos.
    @Override
    public double calcularBonos() {
        return 0;
    }

    // El fondo de ahorro no se suma al salario del empleado.
    @Override
    public double calcularBeneficios() {

        if (getAñosEmpresa() > 1 && aceptaFondoAhorro) {
            return 0;
        }

        return 0;
    }

    // Se calcula la deducción del 4% y, si corresponde, el fondo de ahorro.
    @Override
    public double calcularDeducciones() {

        double salarioBruto = calcularSalarioBruto();

        double seguridadSocial = salarioBruto * 0.04;

        double fondoAhorro = 0;

        // El fondo corresponde al 2% para empleados con más de un año.
        if (getAñosEmpresa() > 1 && aceptaFondoAhorro) {
            fondoAhorro = salarioBruto * 0.02;
        }

        return seguridadSocial + fondoAhorro;
    }
}