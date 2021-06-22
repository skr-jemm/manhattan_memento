/**
 * Fecha: 29/05/21
 * Autor: Jorge Eduardo Martínez Mohedano
 * Descripcion:
 * Versión:
 */
public class Trigger {
    private BuildCache cache;

    public BuildCache getCache() {
        return cache;
    }

    public void setCache(BuildCache cache) {
        this.cache = cache;
    }
    public SavePoint saveCache(){
        return new SavePoint(cache);
    }
    public void restoreCache(SavePoint cache_param){
        cache = cache_param.getCache();
    }
}
