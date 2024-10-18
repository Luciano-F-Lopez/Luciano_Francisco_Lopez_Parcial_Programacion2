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
public class Hospedaje extends Servicio {

    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String hospedaje, double precioPorNoche, String codServicio, double porcentajeDescuento, boolean enPromocion) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        return "Hospedaje{" + "hospedaje=" + hospedaje + ", precioPorNoche=" + precioPorNoche + '}';
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precioPorNoche;    // inicio una variable con el valor de precioPorNoche

        if (isEnPromocion() && dia.getDayOfWeek().getValue() < 6) {    //verifica si el servicio esta en promocion y si el dia es de lunes a viernes
            precioFinal *= (1 - getPorcentajeDescuento() / 100);   //calcula el descuento 
        }
        return precioFinal;
    }
}
