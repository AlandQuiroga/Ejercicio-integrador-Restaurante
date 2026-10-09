package restaurante;

public class Postre extends Plato {

    private boolean conHelado;

    public Postre() {
        super();
        this.conHelado = false;
    }

    public Postre(String nombre, double precioBase,
                  CategoriaComida categoria, boolean conHelado) {
        super(nombre, precioBase, categoria);
        this.conHelado = conHelado;
    }

    public boolean isConHelado() {
        return conHelado;
    }

    @Override
    public double calcularPrecio() {
        if (conHelado) {
            return getPrecioBase() * 1.15;
        } else {
            return getPrecioBase();
        }
    }

    @Override
    public String toString() {
        return "Postre{" +
                "plato=" + super.toString() +
                ", conHelado=" + conHelado +
                ", precioFinal=" + calcularPrecio() +
                '}';
    }
}