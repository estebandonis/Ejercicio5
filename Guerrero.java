public class Guerrero extends Jugador{
    Guerrero(String nombre){
        super(nombre);
        setPuntosVida(350);
        setPoderAtaque(70);
        Mejorar mejora = new Mejorar(8);
        setItem(mejora);
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
        System.out.println("Vamos al ataque!");
        return null;
    }
}
