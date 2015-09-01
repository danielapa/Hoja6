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
        
        Set<Persona> inciso4 = dJava;
        
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
                    else if (nombres[g] == null){
                        comparacion = 0;
                        binario = 1;
                    }
                    else {
                        comparacion = 1;
                    }
                    if (comparacion!=0){
                        binario = 0;
                        
                    }
                    else{
                        binario = binario + 1;
                        if (nombres[g] == null){
                            
                        }
                        else if (nombres[g]!=null){
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
        
        System.out.println(size + "\n" + size1 + "\n" + size2 + "\n");
        
        if(size>size1){
            if(size>size2){
                System.out.println("El conjunto mayor es el de desarrolladores con Java\n");
            }
            if(size2>size){
                if(size2>size1){
                    System.out.println("El conjunto mayor es el de desarrolladores de Celular\n");
                }
            }
        }
        
        if(size1>size){
            if(size1>size2){
                System.out.println("El conjunto mayor es el de desarrolladores de Web.\n");
            }
            if(size2>size1){
                if(size2>size){
                    System.out.println("El conjunto mayor es el de desarrolladores de Celular\n");
                }
            }
        }
        
        if(size2>size){
            if(size2>size1){
                System.out.println("El conjunto mayor es el de desarrolladores de Celular.\n");
            }
            if(size2>size){
                if(size1>size){
                    System.out.println("El conjunto mayor es el de desarrolladores de Web.\n");
                }
            }
        }
               
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
       
       
       //primeros tres incisos
       /*for (int x = 0; x<cantpersonas; x++){
           if((dWeb.contains(person[x])) && (dJava.contains(person[x])) && (dCelular.contains(person[x]))){ //inciso 1
              System.out.println("La persona " + person[x] + " es desarrolladora en las tres areas.");
           }
           
           if ((dJava.contains(person[x])) && (dWeb.contains(person[x]) == false)){ //inciso 2
               System.out.println("La persona " + person[x] +  " tiene experiencia en Java pero no en Web.");
           }
           
           if ((dJava.contains(person[x]) == false) && (dWeb.contains(person[x]) && (dCelular.contains(person[x])))){ //inciso 3
               System.out.println("La persona " + person[x] + " Tiene experiencia en Web y Celulares, pero no en Java.");
           }
           //para el inciso 4 hacemos la union de los desarrolladores web y de celulares, por lo que los agregamos a otro set.
           //Como el Set no acepta repetidos, no habra problema con los que se repitan.
           //Creo que esta agregando repetidos.
           if (dWeb.contains(person[x])){
               inciso4.add(person[x]);
           }
           if (dCelular.contains(person[x])){
               inciso4.add(person[x]);
           }
       }
       
       //Inciso 4: (este no quiere servirrrr)
       for (int x = 0; x<cantpersonas; x++){
           System.out.println("Size inciso4: " +inciso4.size());
           if (inciso4.contains(person[x])){ //solo trabajamos con los que esten metidos en inciso4.
               if (dJava.contains(person[x]) == false){
                   //Ok, person[x] si esta en inciso 4, entonces ya comparamos. Solo nos interesa si no lo contiene
                   System.out.println("La persona " + person[x] + " o tiene experiencia en web o celulares, pero no en java.");
               }
           }
       }*/
       
              
        Set<Persona> dJavaT = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dJavaT.addAll(dJava);
        Set<Persona> dWebT = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dWebT.addAll(dWeb);
        Set<Persona> dCelularT = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dCelularT.addAll(dCelular);
        
              
        Set<Persona> dJava1T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dJava1T.addAll(dJava);
        Set<Persona> dWeb1T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dWeb1T.addAll(dWeb);
        Set<Persona> dCelular1T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dCelular1T.addAll(dCelular);        
        
        Set<Persona> dJava2T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dJava2T.addAll(dJava);
        Set<Persona> dWeb2T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dWeb2T.addAll(dWeb);
        Set<Persona> dCelular2T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dCelular2T.addAll(dCelular);  
        
        Set<Persona> dJava3T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dJava3T.addAll(dJava);
        Set<Persona> dWeb3T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dWeb3T.addAll(dWeb);
        Set<Persona> dCelular3T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dCelular3T.addAll(dCelular);        

        Set<Persona> dJava4T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
        dJava4T.addAll(dJava);
        Set<Persona> dWeb4T = setfactory.SetGrupos3(implementacion); //Set para desarrolladores Java 
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
        
        dJava4T.retainAll(dWeb4T);
        if(dWeb4T.size()==dJava4T.size()){
            System.out.println("\nEl conjunto de Desarrolladores Java es un subconjunto de Desarrolladores Web\n");
        }
        else if(dWeb4T.size()!=dJava4T.size()){
            System.out.println("\nEl conjunto de Desarrolladores Java NO es un subconjunto de Desarrolladores Web\n");
        }
        
        System.out.println(contador);
    }
}