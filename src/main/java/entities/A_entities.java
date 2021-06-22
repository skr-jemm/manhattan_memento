package entities;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Fecha: 31/05/21
 * Autor: Jorge Eduardo Martínez Mohedano
 * Descripcion:
 * Versión:
 */
public class A_entities implements Serializable {
    private String id;
    private String Description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        JSONObject retorno = new JSONObject();
        retorno.put("id",id);
        retorno.put("Description",Description);
        return retorno.toString();
    }
}
