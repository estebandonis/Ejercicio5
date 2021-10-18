public class Cazador extends Jugador{
    Company Acompany = new Company("Jeffrey", this);
    Cazador(String nombre){
        super(nombre);
        setPuntosVida(150);
        setPoderAtaque(60);
        Curar curar = new Curar(12);
        setItem(curar);
    }

    @Override
    public Combatiente habilidadEspecial(Combatiente combatiente) {
        Items item = getItem();
        Jugador player = item.usar(this);
        setPuntosVida(player.getPuntosVida());
        setPoderAtaque(player.getPoderAtaque());
        Acompany.habilidadEspecial(combatiente);
        return combatiente;
    }

    @Override
    public String toString() {
        System.out.println("No podran vencernos a mi y a mi compañero!");
        return null;
    }
}
