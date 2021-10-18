/**
 * Este metodo sirve para comunicarnos con el usuario
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    Scanner scan = new Scanner(System.in);

    /**
     * Este metodo inicia el programa y define el jugador
     * @return
     */
    public int inicio(){
        System.out.println("Bienvenidos combatientes");
        System.out.println("Ingrese numero de jugadores");
        String numString = scan.nextLine();
        int num = Integer.parseInt(numString);
        return num;
    }

    /**
     * Sirve para desplegar el menu de inicio
     * @param turno
     * @return numero de opcion que eligio el usuario
     */
    public int menu(String turno, int num){
        System.out.println("Turno de " + turno + ", con el numero: "+ num);
        System.out.println("Elija una opción:");
		System.out.println("1. Atacar");//Le damos todas las opciones disponibles
		System.out.println("2. Pasar turno");
		System.out.println("3. Usar habilidad especial");
        System.out.println("4. Salir/n/n");
        boolean paso = false;
        int option = 0;
        while (paso == false){//Aplicamos un metodo para que escriba el 
            try {
                String optionString = scan.nextLine();//Recibimos el valor como String para evitar un bug con el metodo nextLine()
                option = Integer.parseInt(optionString);//Lo cambiamos a int
                paso = true;
            } catch (Exception e) {
                System.out.println("Ingrese un valor correcto, por favor");
            }
        }
        return option;//regresamos el valor convertido
    }

    public String crearJugadores(){
        String role = "";
        boolean right = false;
        while (right == false){
            System.out.println("Elija un rol (1. Guerrero, 2. Explorador, 3. Cazador)");
            role = scan.nextLine();
            if (role.equalsIgnoreCase("guerrero") || role.equalsIgnoreCase("explorador") || role.equalsIgnoreCase("Cazador")){
                right = true;
            }
        } 
        return role;
    }

    /**
     * metodo que sirve para verificar que enemigo se va a atacar
     * @param enemigos
     * @return
     */
    public String enemigoAAtacar(ArrayList<Combatiente> combatientes){
        String enemigoAAtacar = "";
        boolean paso = false;
        while (paso == false){
            System.out.println("A cual enemigo desea atacar");
            enemigoAAtacar = scan.nextLine();
            for (int i = 0; i < combatientes.size(); i++){
                Combatiente combatiente = combatientes.get(i);
                if (enemigoAAtacar.equalsIgnoreCase(combatiente.getNombre())){
                    paso = true;
                    break;
                }
            }
            if(paso == false){
                System.out.println("Elija el nombre de un enemigo participante");
            }
        }
        return enemigoAAtacar;
    }

    public String jugadorAAtacar(ArrayList<Combatiente> combatientes){
        String jugadorAAtacar = "";
        boolean paso = false;
        while (paso == false){
            System.out.println("A cual jugador desea atacar");
            jugadorAAtacar = scan.nextLine();
            for (int i = 0; i < combatientes.size(); i++){
                Combatiente combatiente = combatientes.get(i);
                if (jugadorAAtacar.equalsIgnoreCase(combatiente.getNombre())){
                    paso = true;
                    break;
                }
            }
            if(paso == false){
                System.out.println("Elija el nombre de un jugador participante");
            }
        }
        return jugadorAAtacar;
    }

    public String jugadorDondeSeVaAUsarHabilidad(ArrayList<Combatiente> combatientes){
        String jugadorAfectado = "";
        boolean paso = false;
        while (paso == false){
            System.out.println("En cual jugador desea usar su Habilidad?");
            jugadorAfectado = scan.nextLine();
            for (int i = 0; i < combatientes.size(); i++){
                Combatiente combatiente = combatientes.get(i);
                if (jugadorAfectado.equalsIgnoreCase(combatiente.getNombre())){
                    paso = true;
                    break;
                }
            }
            if(paso == false){
                System.out.println("Elija el nombre de un jugador participante");
            }
        }
        return jugadorAfectado;
    }

    /**
     * Despliega las estadisticas del combate
     * @param enemigos
     * @param player
     */
    public void desplegarEstadisticas(ArrayList<Combatiente> combatientes){
        for (int i = 0; i < combatientes.size(); i++){
            Combatiente combatiente = combatientes.get(i);
            if (combatiente.getNombre().equalsIgnoreCase("enemigo1") || combatiente.getNombre().equalsIgnoreCase("enemigo2") || combatiente.getNombre().equalsIgnoreCase("enemigo3") || combatiente.getNombre().equalsIgnoreCase("enemigo4") || combatiente.getNombre().equalsIgnoreCase("enemigo5")){
                Enemigo enemy = (Enemigo) combatiente;
                System.out.println("---------------------------------");
                System.out.println("Nombre del enemigo: " + enemy.getNombre());
                System.out.println("Vida: " + enemy.getPuntosVida());
                System.out.println("Poder: " + enemy.getPoderAtaque());//Vamos extrayendo los datos de la base de datos y los vamos imprimiendo conforme los vamos extrayendo
                System.out.println("---------------------------------");
            }
            else if (combatiente.getNombre().equalsIgnoreCase("jugador1") || combatiente.getNombre().equalsIgnoreCase("jugador2") || combatiente.getNombre().equalsIgnoreCase("jugador3")){
                Jugador player = (Jugador) combatiente;
                System.out.println("---------------------------------");
                System.out.println("Nombre del jugador: " + player.getNombre());
                System.out.println("Vida: " + player.getPuntosVida());
                System.out.println("Poder: " + player.getPoderAtaque());//Vamos extrayendo los datos de la base de datos y los vamos imprimiendo conforme los vamos extrayendo
                System.out.println("Items: " + player.getItem().getCantidad());
                System.out.println("---------------------------------");
            }
        }
    }

    /**
     * Despliega los mensajes de inicio
     * @param enemigos
     * @param player
     */
    public void iniciar(ArrayList<Combatiente> combatientes){
        for (int i = 0; i < combatientes.size(); i++){
            Combatiente combatiente = combatientes.get(i);
            System.out.println(combatiente.toString());
        }
    }

    /**
     * Despliega el perdedor de la batalla
     * @param perdedor
     */
    public void perdedor(String perdedor){
        if (perdedor.equalsIgnoreCase("jugador")){
            System.out.println("El perdedor fue el jugador");
        }
        else {
            System.out.println("El perdedor fueron los enemigos");
        }
    }

    /**
     * Despliega la despedida
     */
    public void despedida(){
        System.out.println("Gracias por jugar");
    }
}
