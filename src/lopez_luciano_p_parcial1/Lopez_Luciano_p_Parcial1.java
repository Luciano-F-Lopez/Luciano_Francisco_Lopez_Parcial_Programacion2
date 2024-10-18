/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lopez_luciano_p_parcial1;

import java.time.LocalDate;
import java.util.List;
import model.Gastronomia;
import model.Hospedaje;
import model.Servicio;
import model.Sistema;

/**
 *
 * @author MIPC
 */
public class Lopez_Luciano_p_Parcial1 {

    public static void main(String[] args) {
        //String gastronomia, double precio, int diaSemDesc, String codServicio, double porcentajeDescuento, boolean enPromocion

        System.out.println("1-1");

        try {
            // Intento de crear un objeto Gastronomia con un código de servicio no válido
            Gastronomia gastronomia1 = new Gastronomia("Hamburguesa criolla", 180.0, 4, "4892", 15.0, true);
            System.out.println("Objeto Gastronomia creado: " + gastronomia1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el objeto Gastronomia: " + e.getMessage());
        }

        System.out.println("1-2");

        try {
            Gastronomia gastro2 = new Gastronomia("Hamburguesa criolla", 180.0, 4, "489235", 15.0, true);
            System.out.println(gastro2.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el objeto Gastronomia: " + e.getMessage());
        }

        System.out.println("1-3");
        // String hospedaje, double precioPorNoche, String codServicio, double porcentajeDescuento, boolean enPromocion
        try {
            Hospedaje hospe = new Hospedaje("Cabania 3 personas", 1500.0, "2872", 10.0, true);
            System.out.println(hospe.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el objeto Gastronomia: " + e.getMessage());
        }

        System.out.println("1-4");
        //String hospedaje, double precioPorNoche, String codServicio, double porcentajeDescuento, boolean enPromocion
        try {
            Hospedaje hospe = new Hospedaje("Cabania 3 personas", 1500.0, "287282", 10.0, true);
            System.out.println(hospe.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear el objeto Hospedaje: " + e.getMessage());
        }

        System.out.println("2-1");
        Gastronomia gastro2 = new Gastronomia("Hamburguesa criolla", 180.0, 4, "489235", 15.0, true);
        LocalDate diaGastronomia = LocalDate.of(2020, 10, 28);
        double precioFinalGastronomia = gastro2.calcularPrecioFinal(diaGastronomia);
        System.out.println("Precio final de Gastronomia: " + precioFinalGastronomia);

        System.out.println("2-2");
        LocalDate diaHospedaje = LocalDate.of(2020, 10, 27);
        Hospedaje hospe = new Hospedaje("Cabania 3 personas", 1500.0, "287282", 10.0, true);
        double precioFinalHospedaje = hospe.calcularPrecioFinal(diaHospedaje);
        System.out.println("Precio final de Hospedaje: " + precioFinalHospedaje);

        System.out.println("3-1");

        Sistema sistema = new Sistema();

        //Gastronomia gastronomia1 = new Gastronomia("Milanesa con puré",350.0,3,"858927",15.0, true);
        //Gastronomia gastronomia2 = new Gastronomia( "Gaseosa", 120.0, 3,"182835", 20.0, false);
        //Hospedaje hospedaje1 = new Hospedaje("Habitación triple", 2200.0,"489259", 10.0, true);
        //Hospedaje hospedaje2 = new Hospedaje("Habitación simple", 1000.0,"758972", 15.0, false);
        sistema.agregarGastronomia("Milanesa con pure", 350.0, 3, "858927", 15.0, true);
        sistema.agregarGastronomia("Gaseosa", 120.0, 3, "182835", 20.0, false);
        sistema.agregarHospedaje("Habitacion triple", 2200.0, "489259", 10.0, true);
        sistema.agregarHospedaje("Habitacion simple", 1000.0, "758972", 15.0, false);

        sistema.imprimirServicios();

        System.out.println("4-1");
        System.out.println("Servicios en promocion:");
        List<Servicio> serviciosEnPromocion = sistema.traerServiciosEnPromocion(true);
        for (Servicio servicio : serviciosEnPromocion) {
            System.out.println(servicio);

        }

        System.out.println("4-2");

    }

}
