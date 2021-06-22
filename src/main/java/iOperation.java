import entities.A_entities;

import java.util.ArrayList;

/**
 * Fecha: 29/05/21
 * Autor: Jorge Eduardo Martínez Mohedano
 * Descripcion:
 * Versión:
 */
public interface iOperation {
    public boolean SaveCache(ArrayList<A_entities> atribuos);
    public String SelectById(int id);
    public String SelectAll();
    public boolean DeleteById(int id);
    public boolean DeleteAll();
    public boolean UpdateById(int id, String campo);
}
