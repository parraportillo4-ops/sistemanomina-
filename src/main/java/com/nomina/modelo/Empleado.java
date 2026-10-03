package com.nomina.modelo;

public abstract class Empleado {

    private String nombre;
    private String identificacion;
    private int añosEmpresa;

    public Empleado(String nombre, String identificacion, int añosEmpresa) {
        this.nombre = nombre;
        this.identificacion = identificacion;

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

    public abstract double calcularSalarioBruto();

    public abstract double calcularBonos();

    public abstract double calcularBeneficios();

    public abstract double calcularDeducciones();

    public double calcularSalarioNeto() {

        double salarioNeto =
                calcularSalarioBruto()
                + calcularBonos()
                + calcularBeneficios()
                - calcularDeducciones();

        if (salarioNeto < 0) {
            throw new IllegalArgumentException(
                "El salario neto no puede ser negativo."
            );
        }

        return salarioNeto;
    }
}