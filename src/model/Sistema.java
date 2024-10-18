/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MIPC
 */
public class Sistema {

    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    public Servicio traerServicio(String codServicio) {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                return servicio;
            }
        }
        return null;
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosEnPromocion.add(servicio);
            }
        }
        return serviciosEnPromocion;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {

        List<Servicio> serviciosFiltrados = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosFiltrados.add(servicio);
            }
        }
        return serviciosFiltrados;
    }

    public boolean agregarGastronomia(String gastronomia, double precio, int diaSemDesc, String codServicio, double porcentajeDescuento, boolean enPromocion) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("El servicio ya existe.");
        }
        Gastronomia nuevoServicio = new Gastronomia(gastronomia, precio, diaSemDesc, codServicio, porcentajeDescuento, enPromocion);
        lstServicio.add(nuevoServicio);
        return true;
    }

    public boolean agregarHospedaje(String hospedaje, double precioPorNoche, String codServicio, double porcentajeDescuento, boolean enPromocion) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("El servicio ya existe.");
        }

        Hospedaje nuevoServicio = new Hospedaje(hospedaje, precioPorNoche, codServicio, porcentajeDescuento, enPromocion);
        lstServicio.add(nuevoServicio);
        return true;
    }

    public void imprimirServicios() {
        for (Servicio servicio : lstServicio) {
            System.out.println(servicio);
        }
    }

    public List<Servicio> traerServiciosEnPromocion(boolean enPromocion) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosEnPromocion.add(servicio);
            }
        }
        return serviciosEnPromocion;
    }

}
