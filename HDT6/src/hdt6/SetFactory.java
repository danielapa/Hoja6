/*
*Algoritmos y Estructuras de Datos
*Seccion 30
*Juan Diego Benitez - 14124
*Daniela Pocasangre - 14162
*SetFactory.java
 */

package hdt6;

import java.util.*;

/**
 *
 * @author Daniela
 */
public class SetFactory {
    public Set SetGrupos1(int implementacion){
        Set<String> hs1=null;
        if(implementacion==1){
            hs1 = new HashSet<String>();
        }
        if(implementacion==2){
            hs1 = new TreeSet<String>();
        }
        if(implementacion==3){
            hs1 = new LinkedHashSet<String>();
        }
        return hs1;
    }
    
    public Set SetGrupos2(int implementacion){
        Set<String> hs2=null;
        if(implementacion==1){
            hs2 = new HashSet<String>();
        }
        if(implementacion==2){
            hs2 = new TreeSet<String>();
        }
        if(implementacion==3){
            hs2 = new LinkedHashSet<String>();
        }
        return hs2;
    }
    
    public Set SetGrupos3(int implementacion){
        Set<String> hs3=null;
        if(implementacion==1){
            hs3 = new HashSet<String>();
        }
        if(implementacion==2){
            hs3 = new TreeSet<String>();
        }
        if(implementacion==3){
            hs3 = new LinkedHashSet<String>();
        }
        return hs3;
    }
}
