/*
 Crear una clase llamada Alumno que mantenga información sobre las notas de 
distintos alumnos. La clase Alumno tendrá como atributos, su nombre y una lista 
de tipo Integer con sus 3 notas.
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se 
pide toda la información al usuario y ese Alumno se guarda en una lista de tipo 
Alumno y se le pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular 
su nota final y se lo busca en la lista de Alumnos. Si está en la lista, se 
llama al método. Dentro del método se usará la lista notas para calcular el 
promedio final de alumno. Siendo estepromedio final, devuelto por el método y 
mostrado en el main.
 */
package registroalumnos;

import Entidad.Alumno;
import Servicio.ServicioAlumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author leonardodanielalvez@gmail.com
 */
public class RegistroAlumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ///Construimos el Scanner, la lista de alumnos y el service para usar.
        
        Scanner leer = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList();
        ServicioAlumno sA = new ServicioAlumno();
        
        ///Llamamos a la función crearAlumno con la lista de alumnos como
        ///Parametro para que vaya agregando ahí los alumnos.
        sA.crearAlumno(alumnos);
        
        ///Pedimos al usuario que ingrese el nombre del alumno para promediar.
        System.out.println("Por favor ingrese el nombre del alumno para "
                + "calcular la nota final:");
        String nombre = leer.nextLine();
        
        ///Usamos el iterador con la lista de alumnos
        Iterator<Alumno> it = alumnos.iterator();
        ///Creamos un indice en cero para que comience por el primer objeto.
        ///Si el nombre está en la lista, toma las notas y devuelve el promedio.
        int indice = 0;
         while (it.hasNext()){
            
            if (it.next().getNombre().equalsIgnoreCase(nombre)){
                
                double notafinal = sA.notaFinal(alumnos.get(indice).getNotas());
                System.out.println("La nota final del alumno " + nombre 
                        + " es " + notafinal);
            } else {
                indice++;
            }
        }       
    }
}
