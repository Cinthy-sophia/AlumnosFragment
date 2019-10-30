package com.cinthyasophia.alumnosfragment;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.cinthyasophia.alumnosfragment.Util.Lib;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class AlumnoParser {
    private ArrayList<Alumno> alumnos;
    private InputStream alumFile;

    public AlumnoParser(Context context) {

        alumFile= context.getResources().openRawResource(R.raw.alumnos_notas);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean parse() {

        byte[] buffer = null;
        String json = new String();
        boolean parsed= false;
        try {
            buffer = new byte[alumFile.available()];

            alumFile.read(buffer);
            alumFile.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONTokener tokener = new JSONTokener(json);
        try {
            JSONArray array = new JSONArray(tokener);
            alumnos = new ArrayList<>();
            Lib lib = new Lib();
            int nia;
            String nombre;
            String apellido1;
            String apellido2;
            GregorianCalendar fechaNac;
            String email;
            Nota[] notas;
            JSONArray notasAux;
            double calificacion;
            String codAsignatura;

            for (int i = 0; i < array.length(); i++) {
                nia = array.getJSONObject(i).getInt("nia");
                nombre = array.getJSONObject(i).getString("nombre");
                apellido1 = array.getJSONObject(i).getString("apellido1");
                apellido2 = array.getJSONObject(i).getString("apellido2");
                fechaNac = lib.getFecha(array.getJSONObject(i).getString("fechaNacimiento"));
                email = array.getJSONObject(i).getString("email");
                notasAux= array.getJSONObject(i).getJSONArray("notas");
                notas= new Nota[notasAux.length()];
                for (int j = 0; j < notasAux.length(); j++) {
                    calificacion= notasAux.getJSONObject(i).getDouble("calificacion");
                    codAsignatura= notasAux.getJSONObject(i).getString("codAsig");

                    notas[i]= new Nota(calificacion,codAsignatura);

                }

                alumnos.add(new Alumno(nia, nombre, apellido1, apellido2, fechaNac, email, notas));
            }
            parsed = true;

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return parsed;
    }

    public ArrayList<Alumno> getAlumnos() {
        return this.alumnos;
    }
}
