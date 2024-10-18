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
        List<Servicio> serviciosEnPromocion = new ArrayList<>();  //creo una lista vacia para meter a los que cumplan con la condicion
        for (Servicio servicio : lstServicio) {                  //itera sobre cada servicio que hay en la lista 
            if (servicio.isEnPromocion() == enPromocion) {      //verifica si el servicio esta en promocion
                serviciosEnPromocion.add(servicio);             // agrega el servicio en promocion a la lista
            }
        }
        return serviciosEnPromocion;                      //devuelve la lista con los servicios en promocion 
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {     

        List<Servicio> serviciosFiltrados = new ArrayList<>();  //creo una lista vacia para meter a los que cumplan con la condicion
        for (Servicio servicio : lstServicio) {              //itera sobre cada servicio que hay en la lista
            if (servicio.isEnPromocion() == enPromocion) {   //verifica si el servicio esta en promocion
                serviciosFiltrados.add(servicio);
            }
        }
        return serviciosFiltrados;
    }

    public boolean agregarGastronomia(String gastronomia, double precio, int diaSemDesc, String codServicio, double porcentajeDescuento, boolean enPromocion) {
        if (traerServicio(codServicio) != null) {            // Verifica si ya existe un servicio con el mismo código.
            throw new IllegalArgumentException("El servicio ya existe.");  //tira excepcion si el servicio ya existe
        }
        Gastronomia nuevoServicio = new Gastronomia(gastronomia, precio, diaSemDesc, codServicio, porcentajeDescuento, enPromocion);   //crea objeto gastronomia con los parametros dados
        lstServicio.add(nuevoServicio);     //agrega el nuevo servicio a la lista de servicios disponibles 
        return true;
    }

    public boolean agregarHospedaje(String hospedaje, double precioPorNoche, String codServicio, double porcentajeDescuento, boolean enPromocion) {
        if (traerServicio(codServicio) != null) {              // Verifica si ya existe un servicio con el mismo código.
            throw new IllegalArgumentException("El servicio ya existe.");  //tira excepcion si el servicio ya existe
        }

        Hospedaje nuevoServicio = new Hospedaje(hospedaje, precioPorNoche, codServicio, porcentajeDescuento, enPromocion);   //crea objeto hospedaje con los parametros dados
        lstServicio.add(nuevoServicio);    //agrega el nuevo servicio a la lista de servicios disponibles
        return true;           //devulve true si se agrego con exito
    }

    public void imprimirServicios() {
        for (Servicio servicio : lstServicio) {   //itera cada objeto sobre la lista lstServicio
            System.out.println(servicio);       // imprime cada iteracion de la lista 
        }
    }

    public List<Servicio> traerServiciosEnPromocion(boolean enPromocion) { 
        List<Servicio> serviciosEnPromocion = new ArrayList<>(); // Crea una nueva lista para almacenar los servicios que están en promoción
        for (Servicio servicio : lstServicio) {   // Itera sobre cada objeto Servicio en la lista 
            if (servicio.isEnPromocion() == enPromocion) {  // Verifica si el servicio cumple con el estado de promoción solicitada 
                serviciosEnPromocion.add(servicio);   // Si el servicio está en promoción lo añade a la lista de servicios
            }
        }
        return serviciosEnPromocion; //devuelve la lista 
    }

}
