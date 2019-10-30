package com.cinthyasophia.alumnosfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnosViewHolder> {
    private ArrayList<Alumno> datos;
    private IAlumnosListener listener;

    public AlumnoAdapter(ArrayList<Alumno> datos, IAlumnosListener listener) {
        this.datos = datos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AlumnosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_alumno, parent,false);

        return new AlumnosViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnosViewHolder holder, int position) {
        Alumno alumno =  datos.get(position);
        holder.bindAlumno(alumno);

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


    public static class AlumnosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvNombre;
        private TextView tvEmail;
        private TextView tvEdad;
        private StringBuilder sb;
        private IAlumnosListener listener;

    public AlumnosViewHolder(@NonNull View itemView, IAlumnosListener listener) {
        super(itemView);
        tvNombre= itemView.findViewById(R.id.tvNombre);
        tvEmail= itemView.findViewById(R.id.tvEmail);
        tvEdad = itemView.findViewById(R.id.tvEdad);
        sb= new StringBuilder();
        this.listener=listener;

        itemView.setOnClickListener(this);
    }
    public void bindAlumno(Alumno alumno){
        sb.setLength(0);
        sb.append(alumno.getNombre()).append(" ").append(alumno.getApellido1()).append(" ").append(alumno.getApellido2());
        tvNombre.setText(sb.toString());
        tvEmail.setText(alumno.getEmail());
        tvEdad.setText(String.valueOf(alumno.getEdad()));

    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onAlumnoSeleccionado(getAdapterPosition());
        }

    }
}

}



