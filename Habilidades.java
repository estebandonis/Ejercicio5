/**
 * Sirve para crear habilidades
 */

public abstract class Habilidades {
    int damage;

    Habilidades(int cantidad){
        damage = cantidad;
    }

    /**
     * Obtenemos el daño que que causa
     * @return
     */
    public int getdamage() {
        return damage;
    }

    /**
     * Se define el daño
     * @param damage
     */
    public void setdamage(int damage) {
        this.damage = damage;
    }

    /**
     * Definimos que habilidad se va a usar
     * @param enemy
     * @return
     */
    public abstract Combatiente usar(Combatiente combatiente);
}
