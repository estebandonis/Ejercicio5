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
    public String[] inicio(){
        String[] datos = new String[2];
        System.out.println("Bienvenidos combatientes");
        System.out.println("¿Cual es el nombre del jugador?");
        String nombre = scan.nextLine();
        datos[0] = nombre;
        boolean right = false;
        while (right == false){
            System.out.println("Elija un rol (1. Guerrero, 2 Explorador)");
            String role = scan.nextLine();
            if (role.equalsIgnoreCase("guerrero") || role.equalsIgnoreCase("explorador")){
                right = true;
                datos[1] = role;
            }
        } 
        return datos;
    }

    /**
     * Sirve para desplegar el menu de inicio
     * @param turno
     * @return numero de opcion que eligio el usuario
     */
    public int menu(String turno){
        System.out.println("Turno de " + turno);
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

    /**
     * metodo que sirve para verificar que enemigo se va a atacar
     * @param enemigos
     * @return
     */
    public String enemigoAAtacar(ArrayList<Enemigo> enemigos){
        String enemigoAAtacar = "";
        if (enemigos.size() == 1){
            enemigoAAtacar = "Enemigo1";
        }
        else{
            boolean paso = false;
            while (paso == false){
                System.out.println("A cual enemigo desea atacar");
                enemigoAAtacar = scan.nextLine();
                for (int i = 0; i < enemigos.size(); i++){
                    Enemigo enemy = enemigos.get(i);
                    if (enemigoAAtacar.equalsIgnoreCase(enemy.getNombre())){
                        paso = true;
                        break;
                    }
                }
                if(paso == false){
                    System.out.println("Elija el nombre de un enemigo participante");
                }
            }
        }
        return enemigoAAtacar;
    }

    /**
     * Despliega las estadisticas del combate
     * @param enemigos
     * @param player
     */
    public void desplegarEstadisticas(ArrayList<Enemigo> enemigos, Jugador player){
        for (int i = 0; i < enemigos.size(); i++){
            Enemigo enemy = enemigos.get(i);
            System.out.println("---------------------------------");
            System.out.println("Nombre del enemigo: " + enemy.getNombre());
            System.out.println("Vida: " + enemy.getPuntosVida());
            System.out.println("Poder: " + enemy.getPoderAtaque());//Vamos extrayendo los datos de la base de datos y los vamos imprimiendo conforme los vamos extrayendo
            System.out.println("---------------------------------");
        }

        System.out.println("---------------------------------");
        System.out.println("Nombre del jugador: " + player.getNombre());
        System.out.println("Vida: " + player.getPuntosVida());
        System.out.println("Poder: " + player.getPoderAtaque());//Vamos extrayendo los datos de la base de datos y los vamos imprimiendo conforme los vamos extrayendo
        System.out.println("Items: " + player.getItem().getCantidad());
        System.out.println("Clase: " + player.getRol());
        System.out.println("---------------------------------");
    }

    /**
     * Despliega los mensajes de inicio
     * @param enemigos
     * @param player
     */
    public void iniciar(ArrayList<Enemigo> enemigos, Jugador player){
        for (int i = 0; i < enemigos.size(); i++){
            Enemigo enemigo = enemigos.get(i);
            System.out.println("Enemigo " + (i+1) + " dice: " + enemigo);
        }
        System.out.println("Jugador dice: " + player);
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
