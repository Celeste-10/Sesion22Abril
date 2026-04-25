package ni.edu.uam.servicios;

import ni.edu.uam.interfaces.ProductoInterface;
import ni.edu.uam.modelos.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoServicio implements ProductoInterface {
    private List<Producto> productos;

    public ProductoServicio() {
        this.productos = new ArrayList<>();
    }

    @Override
    public void agregarProducto(String nombre, double precio, int cantidad) {
        this.productos.add(new Producto(nombre, cantidad, precio));

    }

    @Override
    public void actualizarProducto(String nuevoNombre, double nuevoPrecio, int nuevaCantidad){
        for(Producto p: productos){
            if(p.getNombre().equals(nuevoNombre)){
                p.setNombre(nuevoNombre);
                p.setPrecio(nuevoPrecio);
                p.setCantidad(nuevaCantidad);
            }
        }
    }

    public void eliminarProducto(String nombre){
        productos.removeIf(p -> p.getNombre().equals(nombre));
    }

    @Override
    public Producto buscarProductoPorNombre(String nombreBuscado) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
                JOptionPane.showMessageDialog(null, "Producto encontrado: " + p);
                return p;
            }
            else{
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }
        }
        return null;
    }

    @Override
    public List<Producto> getProductos() {
        return productos;
    }

    public boolean buscarProducto(String nombre, int cantidad, double precio){
        Producto miProducto = new Producto(nombre, cantidad, precio);
        return productos.contains(miProducto);
    }


    public double getMonto(){
        double total = 0, monto = 0;
        for(Producto producto : productos){
            total = producto.getCantidad() * producto.getPrecio();
            monto += total;
        }
        return monto;
    }

    public StringBuilder getFactura(){
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("---Factura---\n");
        for(Producto prod: productos){
            mensaje.append(prod.getNombre());
            mensaje.append(" | ");
            mensaje.append(prod.getPrecio());
            mensaje.append(" | ");
            mensaje.append(prod.getCantidad());
            mensaje.append(" | ");
            mensaje.append(prod.getPrecio() * prod.getCantidad());
            mensaje.append("\n");
        }
        mensaje.append(this.getMonto());
        return mensaje;
    }

}
