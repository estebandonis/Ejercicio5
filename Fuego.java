public class Fuego extends Habilidades{
    Fuego(int cantidad){
        super(cantidad);
    }

    @Override
    public Combatiente usar(Combatiente combatiente) {
        int vida = combatiente.getPuntosVida();
        vida -= 40;
        combatiente.setPuntosVida(vida);
        
        System.out.println(combatiente.getNombre() + " ha sido quemando!");
        return combatiente; 
    }
}
