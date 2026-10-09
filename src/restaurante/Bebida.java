package restaurante;

public class Bebida extends Plato {

    private boolean esAlcoholica;

    public Bebida() {
        super();
        this.esAlcoholica = false;
    }

    public Bebida(String nombre, double precioBase,
                  CategoriaComida categoria, boolean esAlcoholica) {
        super(nombre, precioBase, categoria);
        this.esAlcoholica = esAlcoholica;
    }

    public boolean isEsAlcoholica() {
        return esAlcoholica;
    }

    @Override
    public double calcularPrecio() {
        if (esAlcoholica) {
            return getPrecioBase() * 1.20;
        } else {
            return getPrecioBase();
        }
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "plato=" + super.toString() +
                ", esAlcoholica=" + esAlcoholica +
                ", precioFinal=" + calcularPrecio() +
                '}';
    }
}