/*
*Algoritmos y Estructuras de Datos
*Seccion 30
*Juan Diego Benitez - 14124
*Daniela Pocasangre - 14162
*MainSet.java
 */

package hdt6;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
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
                    if ((implementacion>3) || (implementacion<=0)){ //si no es entre 1 y 3, no es valido
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
            System.out.println("\nIngrese el nombre de la persona " + (x+1) + ": ");
            ingresonom = escaner.next();
            
            if (contapersonas==0){ //si es la primera persona, se ingresa su nombre
                nombres[x] = ingresonom;
                binario = 0;
            }              
            else if (contapersonas>=1){
                for (int g = 0; g<contapersonas; g++){
                    if (nombres[g]!=null){ //comparacion con nombres anteriores para determinar si es repetido
                        comparacion = nombres[g].compareTo(ingresonom);
                    }
                    else if (nombres[g] == null){ //si no hay nombre
                        comparacion = 0;
                        binario = 1;
                    }
                    else {
                        comparacion = 1; 
                    }
                    if (comparacion!=0){
                        binario = 0; //si no hay nombre repetido, se ingresa a los sets
                        
                    }
                    else{
                        binario = binario + 1;
                        if (nombres[g] == null){
                            
                        }
                        else if (nombres[g]!=null){ //si el nombre es repetido, se avisa y se salta esa posicion
                            System.out.println("Este nombre ya fue ingresado.");
                            g = contapersonas;
                        } //"break"
                    }
                }
            }
            
            if (binario==0){
                nombres[x] = ingresonom;
                person[x] = new Persona(nombres[x]);
                contapersonas++;
                while (true){
                    try{
                        System.out.println("\nIngrese la cantidad de grupos a los que la persona pertenece: ");
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
                        System.out.println("Por favor ingrese una cantidad valida.\n");
                    }

                }
                
                for (int j = 0; j<cantgrupos; j++){ //Este for nos sirve para meter a la persona a la cantidad de grupos a los que pertenece.
                while (true){
                    try{
                        while (true){
                            Scanner escanergrupo = new Scanner(System.in); //Pedimos al usuario que ingrese al grupo al que pertenece
                            System.out.println("\nIngrese al grupo al que pertenece. \n1.Desarrollador Java\n2.Desarrollador Web\n3.Desarrollador de Celulares");
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

            System.out.println("Hay " + cantpersonas + " personas.");

        }
        
        int size = dJava.size();
        int size1 = dWeb.size();
        int size2 = dCelular.size();

       for(int y=0; y<cantpersonas;y++){
            System.out.println(person[y]);
            if (person[y]==null){
                
            }
            else{
                if(dJava.contains(person[y])){
                        contador++;
                }
            }
        }
     
       /*Temporales utilizados para realizar intersecciones y uniones*/
        Set<Persona> dJavaT = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dJavaT.addAll(dJava);
        Set<Persona> dWebT = setfactory.SetGrupos3(implementacion); //Set para desarrolladores web 
        dWebT.addAll(dWeb);
        Set<Persona> dCelularT = setfactory.SetGrupos3(implementacion); //Set para desarrolladores de celulares 
        dCelularT.addAll(dCelular);
        
              
        Set<Persona> dJava1T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dJava1T.addAll(dJava);
        Set<Persona> dWeb1T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores web 
        dWeb1T.addAll(dWeb);
        Set<Persona> dCelular1T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores de celulares 
        dCelular1T.addAll(dCelular);        
        
        Set<Persona> dJava2T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dJava2T.addAll(dJava);
        Set<Persona> dWeb2T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores web 
        dWeb2T.addAll(dWeb);
        Set<Persona> dCelular2T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores de celulares 
        dCelular2T.addAll(dCelular);  
        
        Set<Persona> dJava3T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dJava3T.addAll(dJava);
        Set<Persona> dWeb3T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Web 
        dWeb3T.addAll(dWeb);
        Set<Persona> dCelular3T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores de Celulares
        dCelular3T.addAll(dCelular);        

        Set<Persona> dJava4T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dJava4T.addAll(dJava);
        Set<Persona> dWeb4T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores web 
        dWeb4T.addAll(dWeb); 
        
        dWebT.retainAll(dJavaT); //Si el desarrollador de java es tambien desarrollador web
        dWebT.retainAll(dCelularT); //Si esta en los tres grupos
        
        //Inciso a        
        System.out.println("\n");
        
        for (int x = 0; x<cantpersonas; x++){
            if (person[x] != null){
                if (dWebT.contains(person[x])){
                    System.out.println("La persona " + person[x] + " es desarrollador de Java, Web y Celulares. ");
                }
            }
        }
            
        
        dJava1T.removeAll(dWeb1T);
        dJava1T.removeAll(dCelular1T);
        
        for(int j=0;j<cantpersonas;j++){
            if(person[j] != null){
                if(dJava1T.contains(person[j])){
                    System.out.println("La persona "+person[j]+" tiene experiencia en Java pero no en Web.");
                }
                else if(dJava1T.contains(person[j])==false){

                }
            }
        }   

        dWeb2T.retainAll(dCelular2T);
        dWeb2T.removeAll(dJava2T);
        
        for(int j=0;j<cantpersonas;j++){
            if (person[j] != null){
                if(dWeb2T.contains(person[j])){
                    System.out.println("La persona "+person[j]+" tiene experiencia en Web y Celular pero no en Java.");
                }
                else if(dWeb2T.contains(person[j])==false){
                    
                }
            }
        }
                
        dCelular3T.removeAll(dJava3T);
        dWeb3T.removeAll(dJava3T);
        dWeb3T.addAll(dCelular3T);
        
        for(int k=0;k<cantpersonas;k++){
            if (person[k] != null){
                if(dWeb3T.contains(person[k])){
                    System.out.println("La persona "+person[k]+" tiene experiencia en Web o Celular pero no en Java.");
                }
                else if(dWeb3T.contains(person[k])==false){
                    
                }
            }
        }

        if(dWeb4T.containsAll(dJava4T)){
            System.out.println("\nEl conjunto de Desarrolladores Java es un subconjunto de Desarrolladores Web\n");
        }
        else if(!dWeb4T.containsAll(dJava4T)){
            System.out.println("\nEl conjunto de Desarrolladores Java NO es un subconjunto de Desarrolladores Web\n");
        }
        
        Set<Integer> sizing = setfactory.SetSizing(implementacion); /*Set para desarrolladores Java */
        sizing.add(size);
        sizing.add(size1);
        sizing.add(size2);
        
        System.out.println(Collections.max(sizing));
        
        if(Collections.max(sizing)==size){
            int contajavas =0;
            System.out.println("\nEl conjunto mayor es el de desarrolladores con Java\n");
            String[] javas = new String[dJava.size()]; //Hacemos el array de los nombres dependiendo del tamano del Set
            for (int x = 0; x<cantpersonas; x++){
                if (dJava.contains(person[x])){ //Solo si esta contenido en el Set se agrega el nombre y le sumamos 1 al contador de la posicion.
                    javas[contajavas] = person[x].getNombre();
                    contajavas++;
                }
            }
            //Ordenamos el array
            Arrays.sort(javas);
            System.out.println("El listado de nombres es: ");
            for (int x = 0; x<dJava.size(); x++){ //Se imprimen los nombres
                System.out.println(javas[x]);
            }
        }
        else if(Collections.max(sizing)==size1){
            int contawebs2=0;
            System.out.println("\nEl conjunto mayor es el de desarrolladores de Web.\n");
            String[] webs2 = new String[dWeb.size()]; //Hacemos el array de los nombres dependiendo del tamano del Set
            for (int x = 0; x<cantpersonas; x++){
                if (dWeb.contains(person[x])){ //Solo si esta contenido en el Set se agrega el nombre y le sumamos 1 al contador de la posicion.
                    webs2[contawebs2] = person[x].getNombre();
                    contawebs2++;
                }
            }
            //Ordenamos el array
            Arrays.sort(webs2);           
            System.out.println("El listado de nombres es: ");
            for (int x = 0; x<dWeb.size(); x++){ //Se imprimen los nombres
                System.out.println(webs2[x]);
            }
        }
        else if(Collections.max(sizing)==size2){
            int contacelus3 = 0;
            System.out.println("\nEl conjunto mayor es el de desarrolladores de Celular.\n");
            String[] celus3 = new String[dCelular.size()]; //Hacemos el array de los nombres dependiendo del tamano del Set
            for (int x = 0; x<cantpersonas; x++){
                if (dCelular.contains(person[x])){ //Solo si esta contenido en el Set se agrega el nombre y le sumamos 1 al contador de la posicion.
                    celus3[contacelus3] = person[x].getNombre();
                    contacelus3++;
                }
            }
            //Ordenamos el array
            Arrays.sort(celus3);
            System.out.println("El listado de nombres es: ");
            for (int x = 0; x<dCelular.size(); x++){ //Se imprimen los nombres
                System.out.println(celus3[x]);
            }
        }
    }
}
