/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hdt6;

import java.util.Scanner;
/**
 *
 * @author Daniela
 */
public class HDT6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        System.out.println("Bienvenido al programa.\nPor favor ingrese el número de personas que van a pertenecer a los conjuntos:");
        int cantpersonas = escaner.nextInt();
        System.out.println("Ingrese la implementacion que desea utilizar.\n1.HashSet 2.TreeSet 3.LinkedHashSet");
        int implementacion = escaner.nextInt();
    }
    
}
