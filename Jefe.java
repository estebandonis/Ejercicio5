/**
 * Se usa para crear a los jefes
 */

public class Jefe extends Enemigo {
    private Habilidades habilidad2;
    Jefe (String nombre){
        super(nombre);
        setPoderAtaque(super.getPoderAtaque()*2);
        setPuntosVida(super.getPuntosVida()*2);
        habilidad2 = new Fuego(60);
    }

    /**
     * Lo utilizamos para usar la segunda habilidad especial
     */
    public Combatiente habilidadEspecial2(Combatiente combatiente){
        combatiente = habilidad2.usar(this);
        return combatiente;
    }

    /**
     * Lo utilizamos para atacar al jugador
     */
    public Jugador atacar(Jugador player){
        int cantidadVida = player.getPuntosVida();
        cantidadVida -= super.getPoderAtaque();
        player.setPuntosVida(cantidadVida);
        return player;
    }

    /**
     * Lo usamos para escribir un mensaje
     */
    public String toString(){
        return "'Te destruire de un golpe'";
    }
}
