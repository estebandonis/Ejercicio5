/**
 * es la clase base de la que se derivan las clases jugador y enemigo
 */

import java.util.Random;

public class Combatiente {
    private String nombre;
    private int PuntosVida;
    private int PoderAtaque;
    private Random randomint = new Random();

    Combatiente(String nombre){
        this.nombre = nombre;
        this.PuntosVida = randomint.nextInt((150 - 100) + 1) + 100;
        this.PoderAtaque = randomint.nextInt((30 - 20) + 1) + 20;
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
    public void habilidadEspecial(){
        
    }
}
