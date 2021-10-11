/**
 * Clase base para crear enemigos
 */

public class Enemigo extends Combatiente{
    private String tipo;
    private Habilidades habilidad;

    Enemigo(String nombre, int tipo){
        super(nombre);

        if (tipo == 1){
            this.tipo = "Venenoso";
            habilidad = new Habilidades(this.tipo);
        }
        else if (tipo == 2){
            this.tipo = "Fuego";
        }
    }
    /**
     * obtenemos el valor de tipo
     * @return
     */
    public String getTipo() {
        return tipo;
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
    public void habilidadEspecial(){
        Enemigo enemy = habilidad.usar(this);
        this.setPoderAtaque(enemy.getPoderAtaque());
        this.setPuntosVida(enemy.getPuntosVida());
    }

    /**
     * Utilizamos para atacar a los jugadores
     * @param player
     * @return
     */
    public Jugador atacar(Jugador player){
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
