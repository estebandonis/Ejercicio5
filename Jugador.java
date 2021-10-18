/**
 * Es la clase que usamos para el jugador
 */

public abstract class Jugador extends Combatiente {
    private Items item;

    Jugador(String nombre){
        super(nombre);
    }

    /**
     * Obtenemos el valor de item
     * @return
     */
    public Items getItem() {
        return item;
    }

    /**
     * Definimos el valor de item
     * @param item
     */
    public void setItem(Items item) {
        this.item = item;
    }

    /**
     * Utilizamos los items que tenemos
     */
    public abstract Combatiente habilidadEspecial(Combatiente combatiente);

    /**
     * Utilizamos para atacar a los enemigos
     * @param enemy
     * @return
     */
    public Combatiente atacar(Combatiente enemy){
        int cantidadVida = enemy.getPuntosVida();
        cantidadVida -= super.getPoderAtaque();
        enemy.setPuntosVida(cantidadVida);
        return enemy;
    }

    /**
     * Lo usamos para desplegar un mensaje
     */
    public abstract String toString();
}
