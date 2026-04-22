package org.example;

import ni.edu.uam.modelos.Producto;
import ni.edu.uam.servicios.ProductoServicio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ProductoServicio productos = new ProductoServicio();

        //productos.agregarProducto("Cafe", 40, 3);
        //productos.agregarProducto("Tajadas con queso", 60, 3);

        //System.out.println("---Factura---");
        //System.out.println(productos.getProductos());
        //System.out.println("Total a pagar: " + productos.getMonto());

        String menu = "Jaguar Coffee \n1.Agregar \n2. Ver \n3.Salir \nOpcion:";
        String nombre, precio, cantidad, opcion="0";

        do{
            opcion = JOptionPane.showInputDialog(null, menu);
            switch (opcion){
                case "1"->{
                        nombre = JOptionPane.showInputDialog(null, "Nombre del producto:");
                        precio = JOptionPane.showInputDialog(null, "Precio del producto:");
                        cantidad = JOptionPane.showInputDialog(null, "Cantidad del producto:");
                        productos.agregarProducto(nombre, Double.parseDouble(precio), Integer.parseInt(cantidad));
                }
                case "2"->{
                    JOptionPane.showMessageDialog(null, productos.getFactura());

                }
                case "3"->{
                    JOptionPane.showMessageDialog(null, "Adios");
                }
                default -> JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        } while(!opcion.equals("3"));


    }
}