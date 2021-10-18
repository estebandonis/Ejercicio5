public class Curar extends Items{
    Curar(int cantidad){
        super(cantidad);
    }

    @Override
    public Jugador usar(Jugador player) {
        int vida = player.getPuntosVida();
        vida += 150;
        player.setPuntosVida(vida);
        int cantidad = getCantidad();
        cantidad -= 1;
        setCantidad(cantidad);
        System.out.println(player.getNombre() + " ha usado curacion");
        return player;    
    }
}
