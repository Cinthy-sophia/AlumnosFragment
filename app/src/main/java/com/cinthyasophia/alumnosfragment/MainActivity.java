package com.cinthyasophia.alumnosfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.IOException;
import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements IAlumnosListener, Serializable {
    FragmentListadoAlumnos frgAlumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frgAlumnos = (FragmentListadoAlumnos) getSupportFragmentManager().findFragmentById(R.id.frAlumnos);
        frgAlumnos.setAlumnosListener(this);
    }

    @Override
    public void onAlumnoSeleccionado(int position) {
        boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.frAsignaturas)!=null);
        Alumno alumno = frgAlumnos.getDatos().get(position);
        if(hayDetalle){
            FragmentDetalleAsignatura frgDetalle = (FragmentDetalleAsignatura) getSupportFragmentManager().findFragmentById(R.id.frAsignaturas);
            frgDetalle.mostrarDetalle(alumno);
        }else{
            Intent i = new Intent(this,DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, alumno);
            startActivity(i);


        }

    }
}
