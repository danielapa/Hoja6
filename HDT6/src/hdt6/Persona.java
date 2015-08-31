/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt6;

import java.util.Objects;
import java.util.*;
/**
 *
 * @author Juan Diego Benitez, Daniela Pocasangre
 */
public class Persona implements Comparable<Persona>{
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Persona o) {
        return nombre.compareTo(o.nombre);
    }
}
