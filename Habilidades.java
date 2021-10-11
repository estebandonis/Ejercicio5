/**
 * Sirve para crear habilidades
 */
import java.util.Random;

public class Habilidades {
    private String tipo;
    Random randomint = new Random();

    Habilidades(String tipo){
        this.tipo = tipo;
    }

    /**
     * Nos regresa el valor de tipo
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Definimos que habilidad se va a usar
     * @param enemy
     * @return
     */
    public Enemigo usar(Enemigo enemy){
        int random = randomint.nextInt((2-1)+1)+1;
        if (random == 1){
            enemy = curar(enemy);
        }
        else{
            enemy = mejorar(enemy);
        }
        return enemy;
    }

    /**
     * Definimos que va a hacer la habilidad de curar
     * @param enemy
     * @return
     */
    private Enemigo curar(Enemigo enemy){
        int vida = enemy.getPuntosVida();
        vida += 100;
        enemy.setPuntosVida(vida);
        return enemy; 
    }

    /**
     * Definimos que va a hacer la habilidad de mejorar
     * @param enemy
     * @return
     */
    private Enemigo mejorar(Enemigo enemy){
        int fuerza = enemy.getPoderAtaque();
        fuerza += 30;
        enemy.setPoderAtaque(fuerza);
        return enemy;
    }
}
