/*
*Algoritmos y Estructuras de Datos
*Seccion 30
*Juan Diego Benitez - 14124
*Daniela Pocasangre - 14162
*SetFactory.java
 */

//package hdt6;

import java.util.*;

/**
 *
 * @author Juan Diego Benitez, Daniela Pocasangre
 */
public class SetFactory {
    public Set SetGrupos1(int implementacion){
        Set<Persona> hs1=null;
        if(implementacion==1){
            hs1 = new HashSet<Persona>();
        }
        if(implementacion==2){
            hs1 = new TreeSet<Persona>();
        }
        if(implementacion==3){
            hs1 = new LinkedHashSet<Persona>();
        }
        return hs1;
    }
    
    public Set SetGrupos2(int implementacion){
        Set<Persona> hs2=null;
        if(implementacion==1){
            hs2 = new HashSet<Persona>();
        }
        if(implementacion==2){
            hs2 = new TreeSet<Persona>();
        }
        if(implementacion==3){
            hs2 = new LinkedHashSet<Persona>();
        }
        return hs2;
    }
    
    public Set SetGrupos3(int implementacion){
        Set<Persona> hs3=null;
        if(implementacion==1){
            hs3 = new HashSet<Persona>();
        }
        if(implementacion==2){
            hs3 = new TreeSet<Persona>();
        }
        if(implementacion==3){
            hs3 = new LinkedHashSet<Persona>();
        }
        return hs3;
    }
    
    public Set SetSizing(int implementacion){
        Set<Integer> sizing=null;
        if(implementacion==1){
            sizing = new HashSet<Integer>();
        }
        if(implementacion==2){
            sizing = new TreeSet<Integer>();
        }
        if(implementacion==3){
            sizing = new LinkedHashSet<Integer>();
        }
        return sizing;
    }
}
