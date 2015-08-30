/*
*Algoritmos y Estructuras de Datos
*Seccion 30
*Juan Diego Benitez - 14124
*Daniela Pocasangre - 14162
*MainSet.java
 */

package hdt6;

import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Daniela Pocasangre, Juan Diego Benitez
 */
public class DriverSet {

    public static void main(String[] args) {
        int contador=0;
        int implementacion; /*Variable en donde se guardara la opcion de menu de la implementacion*/
        int cantpersonas; /*Variable en donde se guardara la cantidad de personas a ingresar*/
        int cantgrupos; /*Variable en donde se guardara la cantidad de grupos a los que la persona pertenec.*/
        int contapersonas = 0; /*Contador para ver la cantidad de personas que se han ingresado*/
        int binario=0;
        int forpersonas=0;
        String ingresonom;
        int comparacion; //para el compareTo
        
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
        
        Set<Persona> dJava = setfactory.SetGrupos1(implementacion); /*Set para desarrolladores Java */
        Set<Persona> dWeb = setfactory.SetGrupos2(implementacion); /*Set para desarrolladores Web */
        Set<Persona> dCelular = setfactory.SetGrupos3(implementacion); /*Set para desarrolladores de Celulares*/
        
        Persona[] person = new Persona[cantpersonas];
        
        for(int x=0;x<cantpersonas;x++){ //For para pedir la cantidad de datos dependiendo de la cantidad de personas ingresadas anteriormente.
            System.out.println("Ingrese el nombre de la persona " + (x+1) + ": ");
            ingresonom = escaner.next();
            
            if (contapersonas==0){
                nombres[x] = ingresonom;
                binario = 0;
            }              
            else if (contapersonas>=1){
                for (int g = 0; g<contapersonas; g++){
                    if (nombres[g]!=null){
                        comparacion = nombres[g].compareTo(ingresonom);
                    }
                    else {
                        comparacion = 1;
                    }
                    if (comparacion!=0){
                        binario = 0;
                        
                    }
                    else{
                        binario = binario + 1;
                        System.out.println("Este nombre ya fue ingresado.");
                        forpersonas = cantpersonas - 1; //resta cant personas ya que estan repetidas
                        g = contapersonas; //"break"
                    }
                }
            }
            
            if (binario==0){
                nombres[x] = ingresonom;
                person[x] = new Persona(nombres[x]);
                contapersonas++;
                while (true){
                    try{
                        System.out.println("Ingrese la cantidad de grupos a los que la persona pertenece: ");
                        Scanner escanercant = new Scanner(System.in);
                        cantgrupos = escanercant.nextInt();
                        if ((cantgrupos>0) && (cantgrupos<=3)){ /*Si pertenece entre 1 y 3 grupos, es correcto el ingreso.*/
                            break;
                        }
                        else { /*Si se ingresa un numero mayor que 3 (porque solo hay 3 grupos), o 0, es un error.*/
                            System.out.println("Por favor ingrese una cantidad valida.");
                        }
                    }
                    catch (Exception e){ //Si ingresa una letra (opcion no valida), para evitar que el programa se arruine, utilizamos el try-catch.
                        System.out.println("Por favor ingrese una cantidad valida.");
                    }

                }
                
                for (int j = 0; j<cantgrupos; j++){ //Este for nos sirve para meter a la persona a la cantidad de grupos a los que pertenece.
                while (true){
                    try{
                        while (true){
                            Scanner escanergrupo = new Scanner(System.in); //Pedimos al usuario que ingrese al grupo al que pertenece
                            System.out.println("Ingrese al grupo al que perdenece. \n1.Desarrollador Java\n2.Desarrollador Web\n3.Desarrollador de Celulares");
                            int grupo = escanergrupo.nextInt();
                            if (grupo==1){ //Si pertenece al grupo de desarrolladores java, los mete en hs1.
                                dJava.add(person[x]);
                                break;
                            }
                            else if (grupo==2){ //Si pertenece al grupo de desarrolladores web, los mete en hs2.
                                dWeb.add(person[x]);
                                break;
                            }
                            else if (grupo==3){ //Si pertenece al grupo de desarrolladores de celulares, los mete en hs3.
                                dCelular.add(person[x]);
                                break;
                            }
                            else if ((grupo<=0) || (grupo>3)){ //Si se ingresa una opcion que no es valida, se muestra al usuario.
                                System.out.println("Por favor ingrese una opcion valida.");
                            }
                        }
                        break;
                    }
                    catch (Exception m){ //Si ingresa una letra (opcion no valida), para evitar que el programa se arruine, utilizamos el try-catch.
                        System.out.println("Por favor ingrese una opcion valida.");
                    }
                }
                
                }
                
                
            }

            System.out.println("Hay " + forpersonas + " personas.");

        }
        
        int size = dJava.size();
        int size1 = dWeb.size();
        int size2 = dCelular.size();
        
        System.out.println(size + "\n" + size1 + "\n" + size2 + "\n");
        
        if(size>size1){
            if(size>size2){
                System.out.println("El conjunto mayor es el de desarrolladores con Java");
            }
        }
        
        if(size1>size){
            if(size1>size2){
                System.out.println("El conjunto mayor es el de desarrolladores de Web.");
            }
        }
        
        if(size2>size){
            if(size2>size1){
                System.out.println("El conjunto mayor es el de desarrolladores de Celular.");
            }
        }
               
       for(int y=0; y<forpersonas;y++){
            System.out.println(person[y]);
            if(dJava.contains(person[y])){
                    contador++;
            }
        }
        
        System.out.println(contador);
    }
}