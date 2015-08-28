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
        int contador=0;
        int implementacion; /*Variable en donde se guardara la opcion de menu de la implementacion*/
        int cantpersonas; /*Variable en donde se guardara la cantidad de personas a ingresar*/
        
        Scanner escaner = new Scanner(System.in);
        SetFactory setfactory = new SetFactory();
        while (true){
            try {
                Scanner escanerper = new Scanner(System.in);
                System.out.println("Bienvenido al programa.\nPor favor ingrese el número de personas que van a pertenecer a los conjuntos:");
                cantpersonas = escanerper.nextInt();
                break;
            }
            catch (Exception d){
                System.out.println("Por favor ingrese una opcion valida.");
            }
        }
        String[] nombres = new String[cantpersonas];
        while (true) {
            try {
                while (true){
                    Scanner escanerimp = new Scanner(System.in);
                    System.out.println("Ingrese la implementacion que desea utilizar.\n1.HashSet \n2.TreeSet \n3.LinkedHashSet");
                    implementacion = escanerimp.nextInt();
                    if ((implementacion>3) || (implementacion<=0)){
                        System.out.println("Por favor ingrese una opcion valida.");
                    }
                    else {
                       break;
                    }
                }
                break;
            }
            catch (Exception e){
                System.out.println("Por favor ingrese una opcion valida.");
            }
        }
        
        Set<String> hs1 = setfactory.SetGrupos1(implementacion); /*Set para desarrolladores Java */
        Set<String> hs2 = setfactory.SetGrupos2(implementacion); /*Set para desarrolladores Web */
        Set<String> hs3 = setfactory.SetGrupos3(implementacion); /*Set para desarrolladores de Celulares*/
        
        for(int x=0;x<cantpersonas;x++){
            System.out.println("Ingrese el nombre de la persona " + (x+1) + ": ");
            nombres[x] = escaner.next();
            while (true){
                try{
                    while (true){
                        Scanner escanergrupo = new Scanner(System.in);
                        System.out.println("Ingrese al grupo al que perdenece. \n1.Desarrollador Java\n2.Desarrollador Web\n3.Desarrollador de Celulares");
                        int grupo = escanergrupo.nextInt();
                        if (grupo==1){
                            hs1.add(nombres[x]);
                            break;
                        }
                        else if (grupo==2){
                            hs2.add(nombres[x]);
                            break;
                        }
                        else if (grupo==3){
                            hs3.add(nombres[x]);
                            break;
                        }
                        else if ((grupo<=0) || (grupo>3)){
                            System.out.println("Por vaor ingrese una opcion valida.");
                        }
                    }
                    break;
                }
                catch (Exception j){
                        System.out.println("Por favor ingrese una opcion valida.");
                        }
            }
        }
        
        for(int y=0; y<cantpersonas;y++){
            if(hs1.contains(nombres[y])){
                    contador++;
            }
        }
        
        System.out.println(contador);
    }
}