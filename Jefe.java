/**
 * Se usa para crear a los jefes
 */

public class Jefe extends Enemigo {
    Jefe (String nombre, int tipo){
        super(nombre, tipo);
        super.setPoderAtaque(super.getPoderAtaque()*2);
        super.setPuntosVida(super.getPuntosVida()*2);
    }

    /**
     * Lo utilizamos para usar la segunda habilidad especial
     */
    public void habilidadEspecial2(){
        Habilidades habilidad = getHabilidad();
        Enemigo enemy = habilidad.usar(this);
        this.setPoderAtaque(enemy.getPoderAtaque());
        this.setPuntosVida(enemy.getPuntosVida());
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
