/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt6;

import java.util.Objects;

/**
 *
 * @author dbs_jd
 */
public class Persona {
    private String nombre;
    private int grupo1;
    private int grupo2;
    private int grupo3;


    public Persona(String nombre, int grupo1, int grupo2, int grupo3) {
        this.nombre = nombre;
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
        this.grupo3 = grupo3;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGrupo1() {
        return grupo1;
    }

    public void setGrupo1(int grupo1) {
        this.grupo1 = grupo1;
    }
    public int getGrupo2() {
        return grupo2;
    }

    public void setGrupo2(int grupo2) {
        this.grupo2 = grupo2;
    }    
    
    public int getGrupo3() {
        return grupo3;
    }

    public void setGrupo3(int grupo3) {
        this.grupo3 = grupo3;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        boolean retornando=false;
        if (obj == null) {
            retornando = false;
        }
        if (getClass() != obj.getClass()) {
            retornando = false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            retornando = false;
        }
        if (this.grupo1 != other.grupo1 || this.grupo2 != other.grupo2 || this.grupo3 != other.grupo3) {
            retornando = false;
        }
        retornando = true;
        return retornando;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + this.grupo1;
        hash = 53 * hash + this.grupo2;
        hash = 53 * hash + this.grupo3;
        return hash;
    }
}
