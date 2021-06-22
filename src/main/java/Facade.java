import entities.A_entities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Fecha: 29/05/21
 * Autor: Jorge Eduardo Martínez Mohedano
 * Descripcion:
 * Versión:
 */
public class Facade{
    private PointSave save = new PointSave();
    private String class_name;

    public boolean SaveCache(ArrayList<A_entities> atribuos, String classname) {
        BuildCache cache_auxiliar = new BuildCache();
        cache_auxiliar.setClassName(classname);
        cache_auxiliar.SaveCache(atribuos);
        SavePoint savePoint = new SavePoint(cache_auxiliar);
        if(save.savePoint(savePoint)){
            System.out.println("Guardado correctamente");
            return true;
        }
        else{
            System.out.println("No guardado");
            return false;
        }

    }

    public String SelectById(int id_cache, int id) {
        SavePoint auxiliar;
        BuildCache cache;
        auxiliar = save.getPoint(id_cache);

        cache = auxiliar.getCache();
        return cache.SelectById(id);
    }

    public String SelectAll(int id_cache,String nombre) {
        SavePoint auxiliar;
        BuildCache cache;
        save.setClassSave(nombre);
        auxiliar = save.getPoint(id_cache);

        cache = auxiliar.getCache();
        return cache.SelectAll();
    }

    public boolean DeleteById(int id_cache, int id) {
        SavePoint auxiliar;
        BuildCache cache;
        auxiliar = save.getPoint(id_cache);

        cache = auxiliar.getCache();
        return cache.DeleteById(id);
    }

    public boolean DeleteAll(int id_cache) {
        SavePoint auxiliar;
        BuildCache cache;
        auxiliar = save.getPoint(id_cache);

        cache = auxiliar.getCache();
        return cache.DeleteAll();
    }

    public boolean UpdateById(int id_cache, int id, String campo) {
        SavePoint auxiliar;
        BuildCache cache;
        auxiliar = save.getPoint(id_cache);

        cache = auxiliar.getCache();
        return cache.UpdateById(id,campo);

    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
