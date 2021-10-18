/**
 * Nos ayuda a crear un rol explorador
 */

public class Explorador extends Jugador{
    Explorador(String nombre){
        super(nombre);
        setPuntosVida(200);
        setPoderAtaque(50);
        Curar curar = new Curar(12);
        setItem(curar);
    }

    /**
     * Ejecuta la habilidad especial
     */
    @Override
    public Combatiente habilidadEspecial(Combatiente combatiente) {
        Items item = getItem();
        Jugador player = item.usar(this);
        setPuntosVida(player.getPuntosVida());
        setPoderAtaque(player.getPoderAtaque());
        return combatiente;
    }

    /**
     * Ejecuta el mensaje de inicio
     */
    @Override
    public String toString() {
        System.out.println("No nos pueden vencer!");
        return null;
    }
}
