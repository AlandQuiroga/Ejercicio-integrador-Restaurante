/**
 *
 * @author Alan David Quiroga
 */
package restaurante;

public class Main {

    public static void main(String[] args) {

        Restaurante restaurante = new Restaurante("Sabores del Sur");

        Comida milanesa = new Comida(
                "Milanesa", 10000, CategoriaComida.PRINCIPAL, true
        );

        Comida ensalada = new Comida(
                "Ensalada César", 8000, CategoriaComida.ENTRADA, false
        );

        Bebida cerveza = new Bebida(
                "Cerveza", 2000, CategoriaComida.BEBIDA, true
        );

        Postre helado = new Postre(
                "Helado", 4000, CategoriaComida.POSTRE, true
        );

        restaurante.agregarPlato(milanesa);
        restaurante.agregarPlato(ensalada);
        restaurante.agregarPlato(cerveza);
        restaurante.agregarPlato(helado);

        Cliente maria = new Cliente(
                "María", "maria@gmail.com", "1122334455"
        );

        Cliente juan = new Cliente(
                "Juan", "juan@gmail.com", "1166778899"
        );

        restaurante.agregarCliente(maria);
        restaurante.agregarCliente(juan);

        System.out.println("==================================");
        System.out.println(" ESCENARIO A: PEDIDO DE MARÍA");
        System.out.println("==================================");

        Pedido pedidoMaria = new Pedido(maria, MetodoEntrega.LOCAL);

        pedidoMaria.agregarPlato(milanesa);
        pedidoMaria.agregarPlato(ensalada);
        pedidoMaria.confirmar();
        pedidoMaria.entregar();
        restaurante.registrarPedido(pedidoMaria);

        System.out.println("Total del pedido de María: $"
                + pedidoMaria.calcularTotal());

        System.out.println();
        System.out.println("==================================");
        System.out.println(" ESCENARIO B: PEDIDO DE JUAN");
        System.out.println("==================================");

        Pedido pedidoJuan = new Pedido(
                juan, MetodoEntrega.DELIVERY, 10
        );

        pedidoJuan.agregarPlato(milanesa);
        pedidoJuan.agregarPlato(cerveza);
        pedidoJuan.agregarPlato(helado);


        pedidoJuan.confirmar();
        pedidoJuan.entregar();
        restaurante.registrarPedido(pedidoJuan);

        System.out.println("Total del pedido de Juan: $"
                + pedidoJuan.calcularTotal());


        System.out.println();
        System.out.println("==================================");
        System.out.println(" TODOS LOS PEDIDOS");
        System.out.println("==================================");

        restaurante.listarPedidos();


        System.out.println();
        System.out.println("==================================");
        System.out.println(" RECAUDACIÓN DEL RESTAURANTE");
        System.out.println("==================================");

        System.out.println("Total recaudado: $"
                + restaurante.calcularRecaudacionTotal());

    }
}