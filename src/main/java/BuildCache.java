import entities.A_entities;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Fecha: 29/05/21
 * Autor: Jorge Eduardo Martínez Mohedano
 * Descripcion:
 * Versión:
 */
public class BuildCache implements Serializable, iOperation {
    private ArrayList<A_entities> buildCache;
    private String ClassName;
    private String TimeOut = new Date().toString();
    private String Cache_Num;


    public ArrayList getBuildCache() {
        return buildCache;
    }
    public void setBuildCache(ArrayList buildCache) {
        this.buildCache = buildCache;
    }
    public String getClassName() {
        return ClassName;
    }
    public void setClassName(String className) {
        ClassName = className;
    }
    public String getCache_Num() {
        return Cache_Num;
    }
    public void setCache_Num(String cache_Num) {
        Cache_Num = cache_Num;
    }

    @Override
    public boolean SaveCache(ArrayList<A_entities> atributos) {
        this.buildCache = atributos;
        return true;
    }

    @Override
    public String SelectById(int id) {
        A_entities aux;
        int rango;
        int interaccion;
        rango = buildCache.size();
        JSONObject Objecto = new JSONObject();

        if(id<=rango){
            for(interaccion=0;interaccion<=rango;interaccion++){
                aux = buildCache.get(interaccion);
                if(aux.getId().equals(String.valueOf(id))) {
                    Objecto.put(ClassName, new JSONObject(aux.toString()));
                    Objecto.put("Timestamp", TimeOut);
                    Objecto.put("CachedNum",Cache_Num);
                    return Objecto.toString();
                }
            }
        }
        return null;
    }

    @Override
    public String SelectAll() {
       JSONObject Objecto = new JSONObject();
       Objecto.put(ClassName,buildCache);
       Objecto.put("Timestamp", TimeOut);
       Objecto.put("CachedNum",Cache_Num);
       return Objecto.toString();
    }

    @Override
    public boolean DeleteById(int id) {
        A_entities aux;
        int interaccion;
        int rango = buildCache.size()-1;
        boolean bandera = false;

        if(id<=rango){
            for(interaccion=0;interaccion<=rango;interaccion++){
                aux = buildCache.get(interaccion);
                if(aux.getId().equals(String.valueOf(id))){
                    buildCache.remove(interaccion);
                    bandera = true;
                    break;
                }
            }
            return bandera;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean DeleteAll() {
        if (!buildCache.isEmpty()){
            buildCache.clear();
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean UpdateById(int id, String campo) {
        int interaccion;
        int rango = buildCache.size()-1;
        A_entities aux;
        boolean bandera = false;

        for(interaccion=0;interaccion<=rango;interaccion++){
            aux = buildCache.get(interaccion);
            if(aux.getId().equals(String.valueOf(id))){
                aux.setDescription(campo);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

}