/**
 * Nos sirve para crear nuevos Raid boses
 */

public class RaidBoss extends Jefe{
    private Habilidades habilidad3;
    private String name = "The Lord of the Caves";
    RaidBoss(String nombre){
        super(nombre);
        setPoderAtaque(130);
        setPuntosVida(700);
        habilidad3 = new Hielo(60);
    }

    /**
     * Define la tercera habilidad especial
     * @param combatiente
     * @return
     */
    public Combatiente habilidadEspecial3(Combatiente combatiente){
        combatiente = habilidad3.usar(this);
        return combatiente;
    }

    /**
     * Ataca al jugador
     */
    public Jugador atacar(Jugador player){
        int cantidadVida = player.getPuntosVida();
        cantidadVida -= super.getPoderAtaque();
        player.setPuntosVida(cantidadVida);
        return player;
    }

    /**
     * Obtenemos el valor de name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Lo usamos para escribir un mensaje
     */
    public String toString(){
        return "'No me venceran!'";
    }
}
