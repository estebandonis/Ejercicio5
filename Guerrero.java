/**
 * Nos ayuda a crear un Guerrero
 */

public class Guerrero extends Jugador{
    Guerrero(String nombre){
        super(nombre);
        setPuntosVida(350);
        setPoderAtaque(70);
        Mejorar mejora = new Mejorar(8);
        setItem(mejora);
    }

    /**
     * Utiliza la habilidad especial que es utilizar un item
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
     * Despliega un mensaje
     */
    @Override
    public String toString() {
        System.out.println("Vamos al ataque!");
        return null;
    }
}
