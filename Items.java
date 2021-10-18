/**
 * Sirve para crear items
 */

public abstract class Items {
    private int cantidad;

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
     * Define el ejecto del item
     * @param player
     * @return
     */
    public abstract Jugador usar(Jugador player);
}
