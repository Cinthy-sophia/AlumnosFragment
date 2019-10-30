package com.cinthyasophia.alumnosfragment;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.cinthyasophia.alumnosfragment.Util.Lib;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Alumno implements Serializable {
    private Lib lib;
    private int nia;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private GregorianCalendar fechaNac;
    private String email;
    private Nota[] notas;
    private int edad;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Alumno(int nia, String nombre, String apellido1, String apellido2, GregorianCalendar fechaNac, String email, Nota[] notas) {
        lib= new Lib();
        this.nia = nia;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNac = fechaNac;
        this.email = email;
        this.notas = notas;
        this.edad = lib.getEdad(fechaNac);
    }

    public int getEdad() {
        return edad;
    }

    public int getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public Nota[] getNotas() {
        return notas;
    }
}
