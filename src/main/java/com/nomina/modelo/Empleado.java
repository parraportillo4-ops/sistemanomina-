package com.nomina.modelo;

// Clase base para los diferentes tipos de empleados.
public abstract class Empleado {

    private String nombre;
    private String identificacion;
    private int añosEmpresa;

    public Empleado(String nombre, String identificacion, int añosEmpresa) {
        this.nombre = nombre;
        this.identificacion = identificacion;

        // Los años en la empresa no pueden ser negativos.
        if (añosEmpresa < 0) {
            throw new IllegalArgumentException(
                    "Los años en la empresa no pueden ser negativos."
            );
        }

        this.añosEmpresa = añosEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public int getAñosEmpresa() {
        return añosEmpresa;
    }

    // Cada empleado calcula su salario según su tipo.
    public abstract double calcularSalarioBruto();

    // Cada tipo de empleado puede tener reglas de bonos diferentes.
    public abstract double calcularBonos();

    // Los beneficios dependen del tipo de empleado.
    public abstract double calcularBeneficios();

    // Se aplican las deducciones correspondientes al salario.
    public abstract double calcularDeducciones();

    // Calcula el salario final después de aplicar deducciones.
    public double calcularSalarioNeto() {

        double salarioNeto =
                calcularSalarioBruto()
                + calcularBonos()
                + calcularBeneficios()
                - calcularDeducciones();

        // Se valida que el salario final no sea negativo.
        if (salarioNeto < 0) {
            throw new IllegalArgumentException(
                    "El salario neto no puede ser negativo."
            );
        }

        return salarioNeto;
    }
}