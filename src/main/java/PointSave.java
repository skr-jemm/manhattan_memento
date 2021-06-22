import java.io.*;
import java.util.ArrayList;

/**
 * Fecha: 29/05/21
 * Autor: Jorge Eduardo Martínez Mohedano
 * Descripcion:
 * Versión:
 */
public class PointSave implements iSerializer {
    private ArrayList point_save = new ArrayList();
    private String classSave;
    private int contador = 0;

    public boolean savePoint(SavePoint point){
        classSave = point.getCache().getClassName();
        boolean bandera;
        if(point_save.isEmpty()){
            point_save.add(point);
            contador++;
            bandera = true;
        }
        else{
            switch (contador){
                case 1:
                    SavePoint auxiliar = (SavePoint) point_save.get(0);
                    point_save.clear();
                    bandera = serialize(auxiliar,contador);
                    point_save.add(point);
                    contador++;
                    break;
                case 2:
                    SavePoint savePoint_posicion0_1 = (SavePoint) point_save.get(0);
                    SavePoint savePoint_posicion1_2 = getPoint(1);
                    point_save.clear();
                    point_save.add(point);
                    serialize(savePoint_posicion0_1,1);
                    bandera = serialize(savePoint_posicion1_2,contador);
                    contador++;
                    break;
                case 3:
                    System.out.println("Borrado");
                    SavePoint posicion_0_1 = (SavePoint) point_save.get(0);
                    SavePoint posicion_1_2 = getPoint(1);
                    point_save.clear();
                    point_save.add(point);
                    serialize(posicion_0_1,1);
                    borrado(2,classSave);
                    bandera = serialize(posicion_1_2,2);
                    System.out.println("Giro");
                    contador = 3;
                    break;
                default:
                    bandera = false;
            }
        }
        return bandera;
    }

    public SavePoint getPoint(int posicion){
        SavePoint point;
        if(point_save.isEmpty()){
            point = (SavePoint) deserialize(1);
            point.getCache().setCache_Num("Cached_"+posicion);
            return point;
        }
        else{
            switch (posicion){
                case 0:
                    point = (SavePoint) point_save.get(posicion);
                    point.getCache().setCache_Num("Cached_"+posicion);
                    return point;
                case 1:
                    point = (SavePoint) deserialize(1);
                    point.getCache().setCache_Num("Cached_"+posicion);
                    return point;
                case 2:
                    point = (SavePoint) deserialize(2);
                    point.getCache().setCache_Num("Cached_"+posicion);
                    return point;
                default:
                    return null;
            }
        }
    }

    @Override
    public boolean serialize(Object obj, int posicion) {
        try {
            ObjectOutputStream fichero = new ObjectOutputStream(
                    new FileOutputStream("object"+classSave+posicion+".jem"));
            fichero.writeObject(obj);
            fichero.close();
            System.out.println("Serializado");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object deserialize(int id) {
        Object auxiliar;
        try {
            ObjectInputStream fichero = new ObjectInputStream(new FileInputStream("object"+classSave+id+".jem"));
            auxiliar = fichero.readObject();
            System.out.println("Deserializo correctamente");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            auxiliar = null;
        }

        return auxiliar;
    }

    @Override
    public void borrado(int posicion,String classOf ) {
        File fichero = new File("object"+classOf+posicion+".jem");
        if(fichero.delete()){
            System.out.println("Eliminado");
        }
    }

    public String getClassSave() {
        return classSave;
    }

    public void setClassSave(String classSave) {
        this.classSave = classSave;
    }
}
