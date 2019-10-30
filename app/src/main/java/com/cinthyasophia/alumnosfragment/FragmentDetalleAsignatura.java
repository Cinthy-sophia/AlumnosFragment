package com.cinthyasophia.alumnosfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentDetalleAsignatura extends Fragment {
    private RecyclerView rvAsignatura;
    private ArrayList<Asignatura> datos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AsignaturaParser parser = new AsignaturaParser(getActivity());

        if (parser.parse()){
            datos= parser.getAsignaturas();
        }

        return inflater.inflate(R.layout.fragment_detalle_asignatura,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvAsignatura= getView().findViewById(R.id.rvAsignaturas);
        rvAsignatura.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }
    public void mostrarDetalle(Alumno alumno){
        AsignaturaAdapter adapter = new AsignaturaAdapter(datos,getActivity(),alumno);
        rvAsignatura.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
