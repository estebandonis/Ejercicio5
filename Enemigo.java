/**
 * Clase base para crear enemigos
 */

public class Enemigo extends Combatiente{
    private Habilidades habilidad;

    Enemigo(String nombre){
        super(nombre);
        setPuntosVida(150);
        setPoderAtaque(30);
        habilidad = new Rayo(70);
    }

    /**
     * Obtenemos la habilidad
     * @return
     */
    public Habilidades getHabilidad() {
        return habilidad;
    }

    /**
     * Utilizamos la habilidad especial
     */
    public Combatiente habilidadEspecial(Combatiente combatiente){
        combatiente = habilidad.usar(combatiente);
        return combatiente;
    }

    /**
     * Utilizamos para atacar a los jugadores
     * @param player
     * @return
     */
    public Combatiente atacar(Combatiente player){
        int cantidadVida = player.getPuntosVida();
        cantidadVida -= super.getPoderAtaque();
        player.setPuntosVida(cantidadVida);
        return player;
    }

    /**
     * Los usamos para desplegar un mensaje
     */
    public String toString(){
        return "'No dejen al jugador salir con vida'";
    }
}
