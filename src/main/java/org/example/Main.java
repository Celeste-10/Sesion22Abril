package org.example;

import ni.edu.uam.modelos.Producto;
import ni.edu.uam.servicios.ProductoServicio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javax.swing.JOptionPane.showMessageDialog;


public class Main {
    public static void main(String[] args) {
        ProductoServicio productos = new ProductoServicio();

        //productos.agregarProducto("Cafe", 40, 3);
        //productos.agregarProducto("Tajadas con queso", 60, 3);

        //System.out.println("---Factura---");
        //System.out.println(productos.getProductos());
        //System.out.println("Total a pagar: " + productos.getMonto());

        String menu = "Jaguar Coffee \n1.Agregar \n2. Ver \n3.Buscar Producto \n4.Buscar producto por nombre\n5.Actualizar Producto\n6.Eliminar Producto\n7.Salir \nOpcion:";
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
                    showMessageDialog(null, productos.getFactura());

                }
                case "3"->{
                    nombre = JOptionPane.showInputDialog(null, "Nombre del producto:");
                    precio = JOptionPane.showInputDialog(null, "Precio del producto:");
                    cantidad = JOptionPane.showInputDialog(null, "Cantidad del producto:");
                    JOptionPane.showMessageDialog(null, productos.buscarProducto(nombre, Integer.parseInt(cantidad), Double.parseDouble(precio)));
                }
                case "4"->{
                    nombre = JOptionPane.showInputDialog(null, "Nombre del producto");
                    Producto producto = productos.buscarProductoPorNombre(nombre);

                }
                case "5"->{
                    nombre = JOptionPane.showInputDialog(null, "Nombre del producto a actualizar");
                    precio = JOptionPane.showInputDialog(null, "Nuevo precio del producto:");
                    cantidad = JOptionPane.showInputDialog(null, "Nueva cantidad del producto:");
                    productos.actualizarProducto(nombre, Double.parseDouble(precio), Integer.parseInt(cantidad));
                }
                case "6"->{
                    nombre = JOptionPane.showInputDialog(null, "Nombre del producto a eliminar");
                    productos.eliminarProducto(nombre);
                }
                case "7"->{
                    showMessageDialog(null, "Adios");
                }
                default -> showMessageDialog(null, "Opcion invalida");
            }
        } while(!opcion.equals("7"));


    }
}