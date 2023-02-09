/*
 En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
 */
package Servicio;

import Entidad.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @leonardodanielalvez@gmail.com
 */
public class ServicioAlumno {

    ///Construimos un Scanner fuera de los metodos así está disponible a toda la
    ///clase
    
    Scanner leer = new Scanner(System.in);
    
    public void crearAlumno(ArrayList<Alumno> lista){
        ///Creamos un string para la desición de continuar
        String opcion;	
        ///Armamos el bucle para que el usuario cargue los datos
        do {
            System.out.println("Por favor ingrese el nombre del alumno");
            String Alumno = leer.next();
            System.out.println("Por favor ingrese las tres notas del alumno");
            ArrayList<Integer> notas = new ArrayList();
            notas.add(leer.nextInt());
            notas.add(leer.nextInt());
            notas.add(leer.nextInt());
            System.out.println("Desea continuar?si/no");
            opcion = leer.next();
            Alumno a = new Alumno(Alumno, notas);
            lista.add(a);
        } while (opcion.equalsIgnoreCase("si"));
    } 
    
    public double notaFinal(ArrayList<Integer> notas){
        double notaFinal = 0;
        for (Integer nota : notas){
            notaFinal += nota;
        }
        notaFinal /= 3;
        return notaFinal;
    }
}
