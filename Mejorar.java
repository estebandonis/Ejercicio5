/**
 * Nos sirve para crear items de mejorar
 */

public class Mejorar extends Items{
    Mejorar(int cantidad){
        super(cantidad);
    }

    /**
     * Define el efecto que va a tener el item
     */
    @Override
    public Jugador usar(Jugador player) {
        int fuerza = player.getPoderAtaque();
        fuerza += 30;
        player.setPoderAtaque(fuerza);
        int cantidad = getCantidad();
        cantidad -= 1;
        setCantidad(cantidad);
        System.out.println(player.getNombre() + " ha mejorado sus capacidades!");
        return player;
    }
}
