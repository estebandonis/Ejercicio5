/**
 * Nos ayuda a crear la clase cazador
 */

public class Cazador extends Jugador{
    Company Acompany = new Company("Jeffrey", this);
    Cazador(String nombre){
        super(nombre);
        setPuntosVida(150);
        setPoderAtaque(60);
        Curar curar = new Curar(12);
        setItem(curar);
    }

    /**
     * Ejecuta la habilidad especial de cazador
     */
    @Override
    public Combatiente habilidadEspecial(Combatiente combatiente) {
        Items item = getItem();
        Jugador player = item.usar(this);
        setPuntosVida(player.getPuntosVida());
        setPoderAtaque(player.getPoderAtaque());
        Acompany.habilidadEspecial(combatiente);
        return combatiente;
    }

    /**
     * Escribe un mensaje de inicio
     */
    @Override
    public String toString() {
        System.out.println("No podran vencernos a mi compañero y a mi!");
        return null;
    }
}
