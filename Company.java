public class Company extends Combatiente {
    Combatiente lider;
    Habilidades habilidad;

    Company(String nombre, Combatiente combatiente){
        super(nombre);
        setPuntosVida(100);
        setPoderAtaque(30);
        lider = combatiente;
        habilidad = new Rayo(60);
    }

    @Override
    public Combatiente habilidadEspecial(Combatiente combatiente) {
        combatiente = habilidad.usar(combatiente);
        return combatiente;        
    }

    @Override
    public String toString() {
        System.out.println("Yo te defiendo compañero!");
        return null;
    }
}
