package restaurante;

public abstract class Plato {
    
    private String nombre; 
    private double precioBase; 
    private CategoriaComida categoria;
    
    public Plato() {
        this.nombre = "";
        this.precioBase = 0.0;
        this.categoria = null;
    }

    public Plato(String nombre, double precioBase, CategoriaComida categoria) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public CategoriaComida getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", precioBase=" + precioBase +
                ", categoria=" + categoria +
                '}';
    }
    
    public abstract double calcularPrecio();
    
}
