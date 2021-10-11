/**
 * Sirve para crear items
 */
import java.util.Random;

public class Items {
    private int cantidad;
    Random randomint = new Random();

    Items(int cantidad){
        this.cantidad = cantidad;
    }

    /**
     * Obtenemos el valor de cantidad
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }
    
    /**
     * Definimos el valor de cantidad
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * definimos que item vamos a usar
     * @param player
     * @return
     */
    public Jugador usar(Jugador player){
        int random = randomint.nextInt((2-1)+1)+1;
        if (random == 1){
            player = curar(player);
        }
        else{
            player = mejorar(player);
        }
        return player;
    }

    /**
     * Definimos lo que va a realizar la habilidad de curar
     * @param player
     * @return
     */
    private Jugador curar(Jugador player){
        int vida = player.getPuntosVida();
        vida += 150;
        player.setPuntosVida(vida);
        return player; 
    }

    /**
     * Definimos lo que va a realizar la habilidad de mejorar
     * @param player
     * @return
     */
    private Jugador mejorar(Jugador player){
        int fuerza = player.getPoderAtaque();
        fuerza += 60;
        player.setPoderAtaque(fuerza);
        return player;
    }
}
