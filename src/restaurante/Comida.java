package restaurante;

public class Comida extends Plato {

    private boolean tieneGuarnicion;

    public Comida() {
        super();
        this.tieneGuarnicion = false;
    }

    public Comida(String nombre, double precioBase,
                  CategoriaComida categoria, boolean tieneGuarnicion) {
        super(nombre, precioBase, categoria);
        this.tieneGuarnicion = tieneGuarnicion;
    }

    public boolean isTieneGuarnicion() {
        return tieneGuarnicion;
    }

    @Override
    public double calcularPrecio() {
        if (tieneGuarnicion) {
            return getPrecioBase() * 1.10;
        } else {
            return getPrecioBase();
        }
    }

    @Override
    public String toString() {
        return "Comida{" +
                "plato=" + super.toString() +
                ", tieneGuarnicion=" + tieneGuarnicion +
                ", precioFinal=" + calcularPrecio() +
                '}';
    }
}