public class Explorador extends Jugador{
    Explorador(String nombre){
        super(nombre);
        setPuntosVida(200);
        setPoderAtaque(50);
        Curar curar = new Curar(12);
        setItem(curar);
    }

    @Override
    public Combatiente habilidadEspecial(Combatiente combatiente) {
        Items item = getItem();
        Jugador player = item.usar(this);
        setPuntosVida(player.getPuntosVida());
        setPoderAtaque(player.getPoderAtaque());
        return combatiente;
    }

    @Override
    public String toString() {
        System.out.println("No nos pueden vencer!");
        return null;
    }
}
