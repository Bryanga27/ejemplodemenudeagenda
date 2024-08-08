package basededatosalumnos;

import java.util.Scanner;

public class Basededatosalumnos {

    public static void main(String[] args) {
        //creando arreglo de estudiantes    
        basexs datos[] = new basexs[10];
        int opciones = 0;
        Scanner teclado = new Scanner(System.in);
        Scanner letra = new Scanner(System.in);
        while (opciones != 5) {
            System.out.println("------MENU-------");
            System.out.println("1. Nuevo alumno");
            System.out.println("2. Ver alumnos");
            System.out.println("3. Buscar alumno");
            System.out.println("4. Modificar alumno");
            System.out.println("5. Salir");
            System.out.println("Ingrese el numero de opcion");

            opciones = teclado.nextInt();
            System.out.println("----------------------------------------");
            if (opciones == 1) {
                System.out.println("ingresar clave");
                int clave = teclado.nextInt();
                System.out.println("Ingrese nombre");
                String nombre = letra.nextLine();
                System.out.println("Ingrese grado");
                String grado = letra.nextLine();
                System.out.println(nuevoAlumno(clave, nombre, grado, datos));

            } else if (opciones == 2) {
                System.out.println(imprimirtodo(datos));
            } else if (opciones == 3) {
                System.out.println("ingrese clave");
                int clave = teclado.nextInt();
                System.out.println(buscaralumno(clave, datos));
            } else if (opciones == 4) {
                System.out.println("ingrese clave");
                int clave = teclado.nextInt();
                if (buscaralumnobooleano(clave, datos)) {
                    System.out.println("ingrese nombre");
                    String nombre = letra.nextLine();
                    System.out.println("Ingrese grado");
                    String grado = letra.nextLine();
                    System.out.println(modificaralumno(clave, nombre, grado, datos));
                } else {
                    System.out.println("La clave no existe");
                }

            }
        }

    }

    public static String nuevoAlumno(int clave, String nombre, String grado, basexs arreglo[]) {
        boolean lleno = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new basexs(clave, nombre, grado);
                lleno = false;
                break;
            } else if (arreglo[i].getClave() == clave) {
                return "Ya existe la clave";
            }
        }
        if (!lleno) {
            return "Se guardo con exito";
        } else {
            return "Ya no hay espacio";
        }

    }

    public static String imprimirtodo(basexs arreglo[]) {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena + arreglo[i].getClave() + " | " + arreglo[i].getNombre() + " | " + arreglo[i].getGrado() + "\n";

            }
        }
        return cadena;
    }

    public static String buscaralumno(int clave, basexs arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                return "Los datos \n nombre:" + arreglo[i].getNombre() + "grado:" + arreglo[i].getGrado();

            }
        }
        return "No hay nada";
    }

    public static boolean buscaralumnobooleano(int clave, basexs arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                return true;
            }
        }
        return false;
    }

    public static String modificaralumno(int clave, String nombre, String grado, basexs arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                arreglo[i].setNombre(nombre);
                arreglo[i].setGrado(grado);
                return "se actualizo con exito";
            }
        }
        return "";
    }
}