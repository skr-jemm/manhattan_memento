/**
 * Fecha: 29/05/21
 * Autor: Jorge Eduardo Martínez Mohedano
 * Descripcion:
 * Versión:
 */
public interface iSerializer {
    public boolean serialize(Object obj, int posicion);
    public Object deserialize(int id);
    public void borrado(int posicion, String classOf);
}
