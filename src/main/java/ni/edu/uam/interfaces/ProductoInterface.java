package ni.edu.uam.interfaces;

import ni.edu.uam.modelos.Producto;

import java.util.List;

public interface ProductoInterface {
    public void agregarProducto(String nombre, double precio, int cantidad);

    public List<Producto> getProductos();

    public boolean buscarProducto(String nombre, int cantidad, double precio);

    public void actualizarProducto(String nuevoNombre, double nuevoPrecio, int nuevaCantidad);

    public void eliminarProducto(String nombre);

    public Producto buscarProductoPorNombre(String nombreBuscado);

}
