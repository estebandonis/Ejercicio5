/**
 * Método que realiza las conexiones necesarias para poder obtener y devolver la
 * información necesario según sea el caso. Esta es la clase Controlador,
 * siguiendo la metodología M-V-C
 * 
 * @author Esteban Donis
 * @since
 * @version 1.0
 */

public class Controlador {

/**
 * Es donde corre el programa principal
 * @param args
 */
    public static void main(String[] args) {
        Sistema sistem = new Sistema();
        Vista vis = new Vista();
        int opcion = 0;
        String turno = "jugadores";
        int turnoJugador = 1;
        int turnoEnemigo = 1;

            int cantidad = vis.inicio();
            for (int i = 0; i < cantidad; i++){
                String rol = vis.crearJugadores();
                sistem.crearJugador(rol);
            }
            sistem.crearEnemigos();
            vis.iniciar(sistem.getCombatientes());
        
            while (opcion != 7){
                if (sistem.getPerdedor() != null){
                    vis.perdedor(sistem.getPerdedor());
                    vis.despedida();
                    System.exit(0);//Se sale del programa
                }
                else {
                    vis.desplegarEstadisticas(sistem.getCombatientes());
                    if (turno.equalsIgnoreCase("jugadores")){
                        opcion = vis.menu(turno, turnoJugador);
                    }
                    else{
                        opcion = vis.menu(turno, turnoEnemigo);
                    }
                    if (opcion == 1){
                        if (turno.equalsIgnoreCase("jugadores")){
                            String enemigoAAtacar = vis.enemigoAAtacar(sistem.getCombatientes());
                            sistem.atacarEnemigo(enemigoAAtacar, turnoJugador);
                            String[] datos = sistem.administradorTurnos(turno, turnoJugador, turnoEnemigo);
                            turnoJugador = Integer.parseInt(datos[0]);
                            turnoEnemigo = Integer.parseInt(datos[1]);                     
                            turno = datos[2];
                        }
                        else if (turno.equalsIgnoreCase("enemigos")){
                            String jugadorAAtacar = vis.jugadorAAtacar(sistem.getCombatientes());
                            sistem.atacarJugador(jugadorAAtacar, turnoEnemigo);
                            String[] datos = sistem.administradorTurnos(turno, turnoJugador, turnoEnemigo);
                            turnoJugador = Integer.parseInt(datos[0]);
                            turnoEnemigo = Integer.parseInt(datos[1]);                       
                            turno = datos[2];
                        }
                    }
                    else if (opcion == 2){
                        String[] datos = sistem.administradorTurnos(turno, turnoJugador, turnoEnemigo);
                        turnoJugador = Integer.parseInt(datos[0]);
                        turnoEnemigo = Integer.parseInt(datos[1]);                     
                        turno = datos[2];
                    }
                    else if (opcion == 3){
                        if (turno.equalsIgnoreCase("jugadores")){
                            sistem.usarHabilidadJugador(turnoJugador);
                            String[] datos = sistem.administradorTurnos(turno, turnoJugador, turnoEnemigo);
                            turnoJugador = Integer.parseInt(datos[0]);
                            turnoEnemigo = Integer.parseInt(datos[1]);                     
                            turno = datos[2];
                        }
                        else if (turno.equalsIgnoreCase("enemigos")){
                            String jugadorAAfectar = vis.jugadorDondeSeVaAUsarHabilidad(sistem.getCombatientes());
                            sistem.usarHabilidadEnemigo(jugadorAAfectar, turnoEnemigo);
                            String[] datos = sistem.administradorTurnos(turno, turnoJugador, turnoEnemigo);
                            turnoJugador = Integer.parseInt(datos[0]);
                            turnoEnemigo = Integer.parseInt(datos[1]);                       
                            turno = datos[2];
                        }
                    }
                    else if (opcion == 4){
                        System.exit(0);//Se sale del programa
                    }
                    else{
                        System.out.println("Elija una opcion valida");
                    }
                }
            
            }
        
    }
}
