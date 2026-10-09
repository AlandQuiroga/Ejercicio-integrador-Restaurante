package restaurante;

import java.util.ArrayList;

public class Pedido implements Descontable, Entregable {

    private Cliente cliente;
    private ArrayList<Plato> platos;
    private MetodoEntrega metodoEntrega;
    private boolean confirmado;
    private double descuento;

    public Pedido(Cliente cliente, MetodoEntrega metodoEntrega) {
        this(cliente, metodoEntrega, 0.0);
    }

    public Pedido(Cliente cliente, MetodoEntrega metodoEntrega,
                  double descuento) {
        this.cliente = cliente;
        this.metodoEntrega = metodoEntrega;
        this.descuento = descuento;
        this.platos = new ArrayList<>();
        this.confirmado = false;
    }

    
    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    public void confirmar() {
        if (platos.isEmpty()) {
            System.out.println(
                "No se puede confirmar un pedido sin platos."
            );
            return;
        }

        if (confirmado) {
            System.out.println("El pedido ya está confirmado.");
            return;
        }

        confirmado = true;
        System.out.println("Pedido confirmado correctamente.");
    }

    private double calcularSubtotal() {
        double subtotal = 0.0;

        for (Plato plato : platos) {
            subtotal += plato.calcularPrecio();
        }

        return subtotal;
    }

    public double calcularTotal() {
        return aplicarDescuento(descuento);
    }
    
    public boolean isConfirmado() {
        return confirmado;
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        double subtotal = calcularSubtotal();

        if (platos.size() > 2 && porcentaje > 0) {
            return subtotal * (1 - porcentaje / 100.0);
        }

        return subtotal;
    }

    @Override
    public void entregar() {
        if (metodoEntrega == MetodoEntrega.DELIVERY) {
            System.out.println(
                "Pedido en camino hacia " + cliente.getNombre()
            );
        } else if (metodoEntrega == MetodoEntrega.LOCAL) {
            System.out.println(
                "Pedido listo para servir en mesa."
            );
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente +
                ", platos=" + platos +
                ", metodoEntrega=" + metodoEntrega +
                ", confirmado=" + confirmado +
                ", descuento=" + descuento + "%" +
                ", total=" + calcularTotal() +
                '}';
    }
}