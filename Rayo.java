public class Rayo extends Habilidades{
    Rayo(int cantidad){
        super(cantidad);
    }

    @Override
    public Combatiente usar(Combatiente combatiente) {
        int vida = combatiente.getPuntosVida();
        vida -= 40;
        combatiente.setPuntosVida(vida);
        System.out.println("Ha caido un rayo");
        return combatiente;    
    }
}
