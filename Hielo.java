/**
 * Nos sirve para crear una habilidad de hielo
 */

public class Hielo extends Habilidades{
    Hielo(int cantidad){
        super(cantidad);
    }

    /**
     * Define el efecto de la habilidad
     */
    @Override
    public Combatiente usar(Combatiente combatiente) {
        int vida = combatiente.getPuntosVida();
        vida -= 40;
        combatiente.setPuntosVida(vida);
        System.out.println("Ha caido un bloque de hielo!");
        return combatiente;    
    }
}
