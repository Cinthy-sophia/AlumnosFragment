package com.cinthyasophia.alumnosfragment;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AsignaturaParser {
    private ArrayList<Asignatura> asignaturas;
    private InputStream asigsFile;

    public AsignaturaParser(Context context) {

        asigsFile= context.getResources().openRawResource(R.raw.asignaturas);
    }

    public boolean parse(){
        byte[] buffer=null;
        String json = new String();
        boolean parsed= false;
        try {
            buffer= new byte[asigsFile.available()];

            asigsFile.read(buffer);
            asigsFile.close();

            json= new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONTokener tokener = new JSONTokener(json);
        try {
            JSONArray array = new JSONArray(tokener);
            asignaturas = new ArrayList<>();

            String codAsignatura;
            String nomAsignatura;

            for (int i = 0; i < array.length(); i++) {

                codAsignatura= array.getJSONObject(i).getString("codAsig");
                nomAsignatura=array.getJSONObject(i).getString("nomAsig");

                asignaturas.add(new Asignatura(codAsignatura,nomAsignatura));
            }
            parsed= true;

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return parsed;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }
}

