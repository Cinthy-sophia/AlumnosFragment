package com.cinthyasophia.alumnosfragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentListadoAlumnos extends Fragment {
    private ArrayList<Alumno> datos;
    private RecyclerView rvAlumnos;
    private IAlumnosListener listener;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AlumnoParser parser =  new AlumnoParser(getActivity());

        if (parser.parse()){

        }
        this.datos = parser.getAlumnos();
        return inflater.inflate(R.layout.fragment_listado_alumno,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvAlumnos = getView().findViewById(R.id.rvAlumnos);
        rvAlumnos.setAdapter( new AlumnoAdapter(datos,listener));
        rvAlumnos.setLayoutManager( new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    public void setAlumnosListener(IAlumnosListener listener){
        this.listener=listener;
    }

    public ArrayList<Alumno> getDatos() {
        return datos;
    }
}
