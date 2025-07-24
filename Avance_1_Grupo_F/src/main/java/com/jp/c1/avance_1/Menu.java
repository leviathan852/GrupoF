/* Proyecto Curso: Introducción a la Programación 
Integrantes: Meylin Irola, Justin Serrano, Freddy Retana, Roman Elizondo*/
package com.jp.c1.avance_1;

import java.util.Random;

import javax.swing.JOptionPane;
        
public class Menu {

    private static final int MAX_CLIENTES = 100;
    private static ClienteHotel[] listaClientes = new ClienteHotel[MAX_CLIENTES];
    private static int cantidadClientes = 0;
    private static int contadorIdClientes = 1;

    public static void mostrarMenu() {
        int opcion;

        do {
            String input = JOptionPane.showInputDialog(
                " Menu Principal - Hotel Costa Sol\n"
              + "1. Registro de Clientes\n"
              + "2. Reservas de Habitaciones\n"
              + "3. Cancelaciones y Salidas\n"
              + "4. Modulo de Reportes\n"
              + "5. Salir\n\n"
              + "Seleccione una opcion:");

            if (input == null) break;

            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        registrarCliente();
                        break;
                    case 2: 
                        //hacerReserva();
                        break;
                    case 3:
                        //cancelarSalida();
                        break;
                    case 4:
                        //mostrarReportes();
                        break;
                    case 5: 
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                        return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un unmero.");
            }
        } while (true);
    }


    //Registro de Clientes

    private static String generarIdCliente() {
        String id = String.format("CL-%04d", contadorIdClientes); // id formato -> CL-0XXX
        contadorIdClientes++;
        return id;
    }

    private static void registrarCliente() {
        if (cantidadClientes >= MAX_CLIENTES) {
            JOptionPane.showMessageDialog(null, "Limite de clientes alcanzado.");
            return;
        }

        String id = generarIdCliente();

        //Validacion de Id
        for (int i = 0; i < cantidadClientes; i++) {
            if (listaClientes[i].getIdCliente().equals(id)) {
                JOptionPane.showMessageDialog(null, "Error: ID duplicado.");
                return;
            }
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        if (nombre == null || nombre.isBlank()) return;

        String correo = JOptionPane.showInputDialog("Ingrese el correo:");
        if (correo == null || correo.isBlank()) return;

        String telefono = JOptionPane.showInputDialog("Ingrese el telefono:");
        if (telefono == null || telefono.isBlank()) return;

        ClienteHotel nuevo = new ClienteHotel(nombre, correo, id, telefono);
        listaClientes[cantidadClientes] = nuevo;
        cantidadClientes++;

        JOptionPane.showMessageDialog(null, "Cliente registrado con exito.\nID asignado: " + id);
    }

}
