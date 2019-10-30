package com.cinthyasophia.alumnosfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AsignaturaAdapter extends RecyclerView.Adapter<AsignaturaAdapter.RecyclerHolder> {
    private ArrayList<Asignatura> datos;
    private Context context;
    private Alumno alumno;

    public AsignaturaAdapter(ArrayList<Asignatura> datos, Context context, Alumno al) {
        this.datos= datos;
        this.context= context;
        this.alumno = al;

    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_asignatura, parent, false);
        return new RecyclerHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        Asignatura asig = datos.get(position);
        holder.bindAsignatura(asig, alumno);

    }


    @Override
    public int getItemCount() {
        return datos.size();
    }

    static class RecyclerHolder extends RecyclerView.ViewHolder{
        private TextView tvCAsignatura;
        private TextView tvNAsignatura;
        private TextView tvNota;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            tvCAsignatura = itemView.findViewById(R.id.tvCAsignatura);
            tvNAsignatura= itemView.findViewById(R.id.tvNAsignatura);
            tvNota= itemView.findViewById(R.id.tvNota);
        }

        public void bindAsignatura( Asignatura asig, Alumno alumno){
            tvCAsignatura.setText(asig.getCodAsignatura());
            tvNAsignatura.setText(asig.getNomAsignatura());
            for (Nota n: alumno.getNotas()) {

                if (n.getCodAsignatura().equalsIgnoreCase(tvCAsignatura.getText().toString())){
                    tvNota.setText(String.valueOf(n.getCalificacion()));

                }

            }


        }
    }

}
