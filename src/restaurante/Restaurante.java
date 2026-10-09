package restaurante;

import java.util.ArrayList;

public class Restaurante {

    private String nombre;
    private ArrayList<Plato> platosDisponibles;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> pedidos;

    public Restaurante() {
        this("Restaurante");
    }

    public Restaurante(String nombre) {
        this.nombre = nombre;
        this.platosDisponibles = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void agregarPlato(Plato plato) {
        platosDisponibles.add(plato);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Cliente buscarClientePorNombre(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }

        return null;
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    public double calcularRecaudacionTotal() {
        double recaudacion = 0.0;

        for (Pedido pedido : pedidos) {
            if (pedido.isConfirmado()) {
                recaudacion += pedido.calcularTotal();
            }
        }

        return recaudacion;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nombre='" + nombre + '\'' +
                ", platosDisponibles=" + platosDisponibles +
                ", clientes=" + clientes +
                ", pedidos=" + pedidos +
                '}';
    }
}