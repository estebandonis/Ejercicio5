/**
 * es la clase base de la que se derivan las clases jugador y enemigo
 */

public abstract class Combatiente {
    private String nombre;
    private int PuntosVida;
    private int PoderAtaque;

    Combatiente(String nombre){
        this.nombre = nombre;
    }

    /**
     * Obtenemos el valor de nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtenemos el valor de puntos de vida
     * @return
     */
    public int getPuntosVida() {
        return PuntosVida;
    }

    /**
     * Definimos el valor de puntos de vida
     * @param puntosVida
     */
    public void setPuntosVida(int puntosVida) {
        PuntosVida = puntosVida;
    }

    /**
     * Obtenemos el valor de poder de ataque
     * @return
     */
    public int getPoderAtaque() {
        return PoderAtaque;
    }

    /**
     * Definimos el valor de poder de ataque
     * @param poderAtaque
     */
    public void setPoderAtaque(int poderAtaque) {
        PoderAtaque = poderAtaque;
    }

    /**
     * Lo dejamos para usarlo en las clases hijas
     */
    public abstract Combatiente habilidadEspecial(Combatiente combatiente);

    /**
     * Lo usamos para desplegar un mensaje
     */
    public abstract String toString();
}
