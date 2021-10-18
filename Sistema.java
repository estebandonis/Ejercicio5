/**
 * Es la clase en donde se trabaja la logica del programa
 */

import java.util.ArrayList;
import java.util.Random;

public class Sistema {
    private ArrayList<Combatiente> combatientes = new ArrayList<Combatiente>();
    private Random random = new Random();
    private int numEnemigos = 0;
    private int numJugadores = 0;
    private String perdedor;

    /**
     * Nos ayuda a crear al jugador con todas sus caracteristicas
     * @param datos
     */
    public void crearJugador(String rol){
        if (rol.equalsIgnoreCase("Guerrero")){
            numJugadores += 1;
            Guerrero player = new Guerrero("Jugador"+numJugadores);
            combatientes.add(player);
        }
        else if (rol.equalsIgnoreCase("Explorador")){
            numJugadores += 1;
            Explorador player = new Explorador("Jugador"+numJugadores);
            combatientes.add(player);
        }
        else {
            numJugadores += 1;
            Cazador player = new Cazador("Jugador"+numJugadores);
            combatientes.add(player);
        }
    }

    /**
     * Determina cuantos enemigos se van a crear
     */
    public void crearEnemigos(){
        int randomint = random.nextInt((3-1)+1)+1;
        int randomint2 = random.nextInt((2-1)+1)+1;
        for (int i = 0; i<randomint; i++){
            if (randomint2 == 1){
                crearEnemigo();
            }
            else if(randomint2 == 2){
                crearJefe();
            }
        }
    }

    /**
     * Crea los enemigos normales
     */
    public void crearEnemigo(){
        numEnemigos += 1;
        Enemigo newEnemigo = new Enemigo("Enemigo"+numEnemigos);
        combatientes.add(newEnemigo);
    }

    /**
     * Crea a los jefes
     */
    public void crearJefe(){
        numEnemigos += 1;
        Jefe newJefe = new Jefe("Enemigo"+numEnemigos);
        combatientes.add(newJefe);
    }

    /**
     * Crea al Raid Boss
     */
    public void crearRaidBoss(){
        numEnemigos += 1;
        RaidBoss boss = new RaidBoss("Enemigo"+numEnemigos);
        combatientes.add(boss);
    }
    
    /**
     * Ejecuta a que enemigo atacar
     * @param enemigoAAtacar
     * @param numJugador
     */
    public void atacarEnemigo(String enemigoAAtacar, int numJugador){
        for(int i = 0; i< combatientes.size(); i++){
            Combatiente enemy = combatientes.get(i);
            if (enemigoAAtacar.equalsIgnoreCase(enemy.getNombre())){
                Jugador player = (Jugador) obtenerJugador(numJugador);
                enemy = player.atacar(enemy);
                combatientes.set(i, enemy);
                if (enemy.getPuntosVida() <= 0){
                    combatientes.remove(i);
                    numEnemigos -= 1;
                    if (enemy.getNombre().equalsIgnoreCase("enemigo1")){
                        perdedor = "enemigos";
                    }
                }
            }
        }
    }

    /**
     * Ejecuta a que jugador atacar
     * @param jugadorAAtacar
     * @param numEnemigo
     */
    public void atacarJugador(String jugadorAAtacar, int numEnemigo){
        for(int i = 0; i< combatientes.size(); i++){
            Combatiente player = combatientes.get(i);
            if (jugadorAAtacar.equalsIgnoreCase(player.getNombre())){
                Enemigo enemy = (Enemigo) obtenerEnemigo(numEnemigo);
                player = enemy.atacar(player);
                combatientes.set(i, player);
                if (player.getPuntosVida() <= 0){
                    combatientes.remove(i);
                    numJugadores -= 1;
                }
            }
        }
        if(numJugadores == 0){
            perdedor = "jugadores";
        }
    }

    /**
     * Determina el usar las habilidades del Raid Boss
     * @param jugadorAAtacar
     * @param numEnemigo
     * @param numHabilidad
     */
    public void usarHabilidadRaidBoss(String jugadorAAtacar, int numEnemigo, int numHabilidad){
        for(int i = 0; i< combatientes.size(); i++){
            Combatiente player = combatientes.get(i);
            if (jugadorAAtacar.equalsIgnoreCase(player.getNombre())){
                RaidBoss boss = (RaidBoss) obtenerEnemigo(numEnemigo);
                if (numHabilidad == 1){
                    player = boss.habilidadEspecial(player);
                }
                else if (numHabilidad == 2){
                    player = boss.habilidadEspecial2(player);
                }
                else if (numHabilidad == 3){
                    player = boss.habilidadEspecial3(player);
                }
                combatientes.set(i, player);
                if (player.getPuntosVida() <= 0){
                    combatientes.remove(i);
                    numJugadores -= 1;
                }
            }
        }
        if(numJugadores == 0){
            perdedor = "jugadores";
        }
    }

    /**
     * Determina el usar las habilidades de los enemigos
     * @param jugadorAAtacar
     * @param numEnemigo
     */
    public void usarHabilidadEnemigo(String jugadorAAtacar, int numEnemigo){
        for(int i = 0; i< combatientes.size(); i++){
            Combatiente player = combatientes.get(i);
            if (jugadorAAtacar.equalsIgnoreCase(player.getNombre())){
                Enemigo enemy = (Enemigo) obtenerEnemigo(numEnemigo);
                player = enemy.habilidadEspecial(player);
                combatientes.set(i, player);
                if (player.getPuntosVida() <= 0){
                    combatientes.remove(i);
                    numJugadores -= 1;
                }
            }
        }
        if(numJugadores == 0){
            perdedor = "jugadores";
        }
    }

    /**
     * Determina el usar las habilidades de los jugadores
     * @param numJugador
     */
    public void usarHabilidadJugador(int numJugador){
        Jugador player = (Jugador) obtenerJugador(numJugador);
        Combatiente combatiente = new Enemigo("default");
        player.habilidadEspecial(combatiente);
    }

    /**
     * obtenemos el arraylist de combatientes
     * @return
     */
    public ArrayList<Combatiente> getCombatientes() {
        return combatientes;
    }
    
    /**
     * definimos el valor de perdedor
     * @param perdedor
     */
    public void setPerdedor(String perdedor) {
        this.perdedor = perdedor;
    }

    /**
     * obtenemos el valor de perdedor
     * @return
     */
    public String getPerdedor(){
        return perdedor;
    }

    /**
     * Obtenemos el jugador que necesitamos
     * @param numJugador
     * @return
     */
    public Combatiente obtenerJugador(int numJugador){
        Combatiente combatiente = new Guerrero("default");
        for (int a = 0; a < combatientes.size(); a++){
            combatiente = combatientes.get(a);
            if (combatiente.getNombre().equalsIgnoreCase("jugador"+numJugador)){
                return combatiente;
            }
        }
        return combatiente;
    }

    /**
     * Obtenemos al enemigo que necesitamos
     * @param numEnemigo
     * @return
     */
    public Combatiente obtenerEnemigo(int numEnemigo){
        Combatiente combatiente = new Enemigo("default");
        for (int a = 0; a < combatientes.size(); a++){
            combatiente = combatientes.get(a);
            if (combatiente.getNombre().equalsIgnoreCase("enemigo"+numEnemigo)){
                return combatiente;
            }
        }
        return combatiente;
    }

    /**
     * Administra los turnos
     * @param turno
     * @param turnoJugador
     * @param turnoEnemigo
     * @return
     */
    public String[] administradorTurnos(String turno, int turnoJugador, int turnoEnemigo){
        String[] data = new String[3];
        System.out.println(numJugadores);
        System.out.println(numEnemigos);

        if (turno.equalsIgnoreCase("jugadores")){
            if (numJugadores == 1){
                turno = "enemigos";
                data[0] = Integer.toString(turnoJugador);
                data[1] = Integer.toString(turnoEnemigo);
                data[2] = turno;
                return data;  
            }
            else{
                for (int i = 0; i < combatientes.size(); i++){
                    Combatiente combate = combatientes.get(i);
                    String nombre = combate.getNombre();
                    if (nombre.equalsIgnoreCase("jugador1") || nombre.equalsIgnoreCase("jugador2") || nombre.equalsIgnoreCase("jugador3")){
                        String ultimo = nombre.substring(nombre.length() - 1);
                        int num = Integer.parseInt(ultimo);
                        if (num == turnoJugador){
                            if (numJugadores == 2){
                                if (nombre.equalsIgnoreCase("jugador2")){
                                    turnoJugador = 1;
                                    turno = "enemigos";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                                else {
                                    turnoJugador += 1;
                                    turno = "enemigos";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                            }
                            else if (numJugadores == 3){
                                if (nombre.equalsIgnoreCase("jugador3")){
                                    turnoJugador = 1;
                                    turno = "enemigos";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                                else {
                                    turnoJugador += 1;
                                    turno = "enemigos";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                            }
                        }
                    }
                }
            }
        }       

        else if (turno.equalsIgnoreCase("enemigos")){
            if (numEnemigos == 1){
                turno = "jugadores";
                data[0] = Integer.toString(turnoJugador);
                data[1] = Integer.toString(turnoEnemigo);
                data[2] = turno;
                return data;  
            }
            else{
                for (int i = 0; i < combatientes.size(); i++){
                    Combatiente combate = combatientes.get(i);
                    String nombre = combate.getNombre();
                    if (nombre.equalsIgnoreCase("enemigo1") || nombre.equalsIgnoreCase("enemigo2") || nombre.equalsIgnoreCase("enemigo3") || nombre.equalsIgnoreCase("enemigo4") || nombre.equalsIgnoreCase("enemigo5")){
                        String ultimo = nombre.substring(nombre.length() - 1);
                        int num = Integer.parseInt(ultimo);
                        if (num == turnoEnemigo){
                            if (numEnemigos == 2){
                                if (nombre.equalsIgnoreCase("enemigo2")){
                                    turnoEnemigo = 1;
                                    turno = "jugadores";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                                else {
                                    turnoEnemigo += 1;
                                    turno = "jugadores";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                            }
                            else if (numEnemigos == 3){
                                if (nombre.equalsIgnoreCase("enemigo3")){
                                    turnoEnemigo = 1;
                                    turno = "jugadores";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                                else {
                                    turnoEnemigo += 1;
                                    turno = "jugadores";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                            }
                            else if (numEnemigos == 4){
                                if (nombre.equalsIgnoreCase("enemigo4")){
                                    turnoEnemigo = 1;
                                    turno = "jugadores";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                                else {
                                    turnoEnemigo += 1;
                                    turno = "jugadores";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                            }
                            else if (numEnemigos == 5){
                                if (nombre.equalsIgnoreCase("enemigo5")){
                                    turnoEnemigo = 1;
                                    turno = "jugadores";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                                else {
                                    turnoEnemigo += 1;
                                    turno = "jugadores";
                                    data[0] = Integer.toString(turnoJugador);
                                    data[1] = Integer.toString(turnoEnemigo);
                                    data[2] = turno;
                                    return data;   
                                }
                            }
                        }
                    }
                }
            }
        }
        return data;
    }
}
