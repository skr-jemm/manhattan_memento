import java.io.Serializable;

/**
 * Fecha: 29/05/21
 * Autor: Jorge Eduardo Martínez Mohedano
 * Descripcion:
 * Versión:
 */
public class SavePoint implements Serializable {
    private BuildCache cache;
    public SavePoint(BuildCache cache_param){
        cache = cache_param;
    }
    public BuildCache getCache(){
        return cache;
    }

}
