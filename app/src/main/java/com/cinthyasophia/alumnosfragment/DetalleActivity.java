package com.cinthyasophia.alumnosfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class DetalleActivity extends AppCompatActivity implements Serializable {
    public static final String EXTRA_TEXTO = "EXTRA_TEXTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalleAsignatura detalle = (FragmentDetalleAsignatura)getSupportFragmentManager().findFragmentById(R.id.frAsignaturas);
        detalle.mostrarDetalle((Alumno) getIntent().getSerializableExtra(EXTRA_TEXTO));
    }
}
