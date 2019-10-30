package com.cinthyasophia.alumnosfragment;

import java.io.Serializable;

public class Asignatura implements Serializable {

    private String codAsignatura;
    private String nomAsignatura;

    public Asignatura(String codAsignatura, String nomAsignatura) {
        this.codAsignatura = codAsignatura;
        this.nomAsignatura = nomAsignatura;
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public String getNomAsignatura() {
        return nomAsignatura;
    }
}
