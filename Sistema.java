/**
 * Es la clase en donde se trabaja la logica del programa
 */

import java.util.ArrayList;
import java.util.Random;

public class Sistema {
    private Jugador jugador;
    private ArrayList<Enemigo> Enemigos = new ArrayList<Enemigo>();
    private Random random = new Random();
    private int numEnemigos = 1;
    private String perdedor;

    /**
     * Nos ayuda a crear al jugador con todas sus caracteristicas
     * @param datos
     */
    public void crearJugador(String[] datos){
        jugador = new Jugador(datos[0], datos[1]);
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
        int randomTipo = random.nextInt((2 - 1)+1)+1;
        Enemigo newEnemigo = new Enemigo("Enemigo"+numEnemigos, randomTipo);
        numEnemigos += 1;
        Enemigos.add(newEnemigo);
    }

    /**
     * Crea a los jefes
     */
    public void crearJefe(){
        int randomTipo = random.nextInt((2 - 1)+1)+1;
        Jefe newJefe = new Jefe("Jefe"+numEnemigos, randomTipo);
        numEnemigos += 1;
        Enemigos.add(newJefe);
    }
    
    /**
     * Nos sirve para atacar a los enemigos
     * @param enemigoAAtacar
     * @param turno
     * @return
     */
    public String atacarEnemigo(String enemigoAAtacar, String turno){
        if (enemigoAAtacar.equalsIgnoreCase("Enemigo1") || enemigoAAtacar.equalsIgnoreCase("Jefe1")){
            Enemigo enemy = Enemigos.get(0);
            enemy = jugador.atacar(enemy);
            Enemigos.set(0, enemy);
            if (enemy.getPuntosVida() <= 0){
                setPerdedor("enemigo");
            }
        }
        else{
            for(int i = 0; i< Enemigos.size(); i++){
                Enemigo enemy = Enemigos.get(i);
                if (enemigoAAtacar.equalsIgnoreCase(enemy.getNombre())){
                    enemy = jugador.atacar(enemy);
                    Enemigos.set(i, enemy);
                    if (enemy.getPuntosVida() <= 0){
                        Enemigos.remove(i);
                    }
                }
            }
            if(Enemigos.size() == 0){
                if (jugador.getPuntosVida() <= 0){
                    setPerdedor("enemigo");
                }
            }
        }
        turno = "enemigo";
        return turno;
    }

    /**
     * Nos sirve para atacar al jugador
     * @param turno
     * @return
     */
    public String atacarJugador(String turno){
        if(Enemigos.size() == 1){
            Enemigo enemy = Enemigos.get(0);
            jugador = enemy.atacar(jugador);
            if (jugador.getPuntosVida() <= 0){
                setPerdedor("jugador");
            }
        }
        else {
            if (Enemigos.size() == 2){
                int randomint = random.nextInt((1-0)+1)+0;
                Enemigo enemy = Enemigos.get(randomint);
                jugador = enemy.atacar(jugador);
                if (jugador.getPuntosVida() <= 0){
                    setPerdedor("jugador");
                }
            }
            else if (Enemigos.size() == 3){
                int randomint = random.nextInt((2-0)+1)+0;
                Enemigo enemy = Enemigos.get(randomint);
                jugador = enemy.atacar(jugador);
                if (jugador.getPuntosVida() <= 0){
                    setPerdedor("jugador");
                }
            }
        }
        turno = "jugador";
        return turno;
    }

    /**
     * Nos sirve para pasar el turno
     * @param turno
     * @return
     */
    public String pasarTurno(String turno){
        if (turno.equalsIgnoreCase("jugador")){
            turno = "enemigo";
        }
        else if (turno.equalsIgnoreCase("enemigo")){
            turno = "jugador";
        }
        return turno;
    }

    /**
     * Nos sirve para usar habilidades de los combatientes
     * @param turno
     * @return
     */
    public String usarHabilidad(String turno){
        if (turno.equalsIgnoreCase("jugador")){
            jugador.habilidadEspecial();
            turno = "enemigo";
        }
        else if (turno.equalsIgnoreCase("enemigo")){
            if(Enemigos.size() == 1){
                Enemigo enemy = Enemigos.get(0);
                enemy.habilidadEspecial();
                turno = "jugador";
            }
            else {
                if (Enemigos.size() == 2){
                    int randomint = random.nextInt((1-0)+1)+0;
                    Enemigo enemy = Enemigos.get(randomint);
                    enemy.habilidadEspecial();
                    turno = "jugador";
                }
                else if (Enemigos.size() == 3){
                    int randomint = random.nextInt((2-0)+1)+0;
                    Enemigo enemy = Enemigos.get(randomint);
                    enemy.habilidadEspecial();
                    turno = "jugador";
                }
            }
        }
        return turno;       
    }

    /**
     * obtenemos el arraylist de enemigos
     * @return
     */
    public ArrayList<Enemigo> getEnemigos() {
        return Enemigos;
    }

    /**
     * definimos el valor del arraylist de enemigos
     * @param enemigos
     */
    public void setEnemigos(ArrayList<Enemigo> enemigos) {
        Enemigos = enemigos;
    }

    /**
     * recibimos al jugador
     * @return
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     * Definimos al jugador 
     * @param jugador
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
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
}
