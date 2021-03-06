/**
 * Nos sirve para crear habilidades de rayo
 */

public class Rayo extends Habilidades{
    Rayo(int cantidad){
        super(cantidad);
    }

    /**
     * Define el efecto de rayo
     */
    @Override
    public Combatiente usar(Combatiente combatiente) {
        int vida = combatiente.getPuntosVida();
        vida -= 40;
        combatiente.setPuntosVida(vida);
        System.out.println("Ha caido un rayo");
        return combatiente;    
    }
}
