/*
*Algoritmos y Estructuras de Datos
*Seccion 30
*Juan Diego Benitez - 14124
*Daniela Pocasangre - 14162
*MainSet.java
 */

package hdt6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Daniela
 */
public class DriverSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<String> hs1 = new HashSet<String>();
        Set<String> hs2 = new HashSet<String>();
        Set<String> hs3 = new HashSet<String>();
        int contador=0;
        
        Scanner escaner = new Scanner(System.in);
        System.out.println("Bienvenido al programa.\nPor favor ingrese el número de personas que van a pertenecer a los conjuntos:");
        int cantpersonas = escaner.nextInt();
        String[] nombres = new String[cantpersonas];
        System.out.println("Ingrese la implementacion que desea utilizar.\n1.HashSet 2.TreeSet 3.LinkedHashSet");
        int implementacion = escaner.nextInt();        
        
        for(int x=0;x<cantpersonas;x++){
            System.out.println("Ingrese el nombre de la persona: ");
            nombres[x] = escaner.next();
            hs1.add(nombres[x]);
        }
        
        for(int y=0; y<cantpersonas;y++){
            if(hs1.contains(nombres[y])){
                    contador++;
            }
        }
        
        System.out.println(contador);
    }
}