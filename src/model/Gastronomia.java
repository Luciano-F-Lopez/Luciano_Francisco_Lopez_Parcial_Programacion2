/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author MIPC
 */
public class Gastronomia extends Servicio {

    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String gastronomia, double precio, int diaSemDesc, String codServicio, double porcentajeDescuento, boolean enPromocion) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precio;

        if (isEnPromocion() && dia.getDayOfWeek().getValue() == diaSemDesc) {   //si esta  en promocion y el dia es igual al dia de la semana con descuento hace lo siguiente
            precioFinal *= (1 - getPorcentajeDescuento() / 100);                //calculo nuevo precio reduciendoe el precio1 original menos el descuento  
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Gastronomia{" + "gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemDesc=" + diaSemDesc + '}';
    }

}
