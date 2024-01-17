import model.Persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Javier","Vescio");
        Persona p2 = new Persona("Leonardo","Tamburello");
        Persona p3 = new Persona("Daiana","Melgarejo");
        Persona p4 = new Persona("Marcelo","Bustamante");
        Persona p5 = new Persona("Walter","Erviti");

        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
        listaPersonas.add(p4);
        listaPersonas.add(p5);

        Comparator<Persona> ordenarPorNombreAsc = new Comparator<Persona>() {
            public int compare(Persona p1, Persona p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        };
        Comparator<Persona> ordenarPorApellidoAsc = new Comparator<Persona>() {
            public int compare(Persona p1, Persona p2) {
                return p1.getApellido().compareTo(p2.getApellido());
            }
        };
        Comparator<Persona> ordenarPorApellidoDesc = new Comparator<Persona>() {
            public int compare(Persona p1, Persona p2) {
                return p2.getApellido().compareTo(p1.getApellido());
            }
        };

        System.out.println("ORDEN POR NOMBRE ASCENDENTE");
        Collections.sort(listaPersonas, ordenarPorNombreAsc);
        for (int i=0; i<listaPersonas.size(); i++){
            System.out.println(listaPersonas.get(i));
        }

        System.out.println("\nORDEN POR APELLIDO ASCENDENTE");
        Collections.sort(listaPersonas, ordenarPorApellidoAsc);
        for (int i=0; i<listaPersonas.size(); i++){
            System.out.println(listaPersonas.get(i));
        }

        System.out.println("\nORDEN POR APELLIDO DESCENDENTE/INVERSO");
        Collections.sort(listaPersonas, ordenarPorApellidoDesc);
        for (int i=0; i<listaPersonas.size(); i++){
            System.out.println(listaPersonas.get(i));
        }
    }
}