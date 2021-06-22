import entities.A_entities;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Fecha: 27/05/21
 * Autor: Jorge Eduardo Martínez Mohedano
 * Descripcion:
 * Versión:
 */
public class classmain {
    public static void main(String[] args) {
        Facade prueba = new Facade();
        Scanner lector = new Scanner(System.in);
        int contador = 0;

        System.out.println(contador);

        A_entities obj1 = new A_entities();
        A_entities obj2 = new A_entities();
        ArrayList<A_entities> entities = new ArrayList<>();
        obj1.setDescription("Prueba");
        obj1.setId("1");
        obj2.setDescription("Prueba");
        obj2.setId("2");
        entities.add(obj1);
        entities.add(obj2);
        prueba.SaveCache(entities,"prueba");
        contador++;

        System.out.println(contador);

        System.out.println(prueba.SelectAll(0,"prueba"));
        System.out.println(prueba.SelectById(0, 1));
        prueba.DeleteById(0, 1);
        System.out.println(prueba.SelectAll(0,"prueba"));
        prueba.UpdateById(0, 2, "Actualización de campo");
        System.out.println(prueba.SelectAll(0,"prueba"));
        prueba.DeleteAll(0);
        System.out.println(prueba.SelectAll(0,"prueba"));


        obj1.setDescription("Prueba"+contador);
        obj1.setId("1");
        obj2.setDescription("Prueba"+contador);
        obj2.setId("2");
        entities.add(obj1);
        entities.add(obj2);
        prueba.SaveCache(entities,"prueba");

        System.out.println(prueba.SelectAll(contador,"prueba"));
        System.out.println(prueba.SelectById(contador, 1));
        prueba.DeleteById(contador, 1);
        System.out.println(prueba.SelectAll(contador,"prueba"));
        prueba.UpdateById(contador, 2, "Actualización de campo"+contador);
        System.out.println(prueba.SelectAll(contador,"prueba"));

        contador++;
        System.out.println(contador);

        obj1.setDescription("Prueba"+contador);
        obj1.setId("1");
        obj2.setDescription("Prueba"+contador);
        obj2.setId("2");
        entities.add(obj1);
        entities.add(obj2);
        prueba.SaveCache(entities,"prueba");

        System.out.println(prueba.SelectAll(contador,"prueba"));
        System.out.println(prueba.SelectById(contador, 1));
        prueba.DeleteById(contador, 1);
        System.out.println(prueba.SelectAll(contador,"prueba"));
        prueba.UpdateById(contador, 2, "Actualización de campo"+contador);
        System.out.println(prueba.SelectAll(contador,"prueba"));

        contador++;
        System.out.println(contador);

        obj1.setDescription("Prueba"+contador);
        obj1.setId("1");
        obj2.setDescription("Prueba"+contador);
        obj2.setId("2");
        entities.add(obj1);
        entities.add(obj2);
        prueba.SaveCache(entities,"prueba");

        System.out.println(prueba.SelectAll(contador-1,"prueba"));
        System.out.println(prueba.SelectById(contador-1, 1));
        prueba.DeleteById(contador-1, 1);
        System.out.println(prueba.SelectAll(contador-1,"prueba"));
        prueba.UpdateById(contador-1, 2, "Actualización de campo"+contador);
        System.out.println(prueba.SelectAll(contador-1,"prueba"));

        contador++;
        System.out.println(contador);

        obj1.setDescription("Prueba"+contador);
        obj1.setId("1");
        obj2.setDescription("Prueba"+contador);
        obj2.setId("2");
        entities.add(obj1);
        entities.add(obj2);
        prueba.SaveCache(entities,"prueba");

        System.out.println(prueba.SelectAll(contador-2,"prueba"));
        System.out.println(prueba.SelectById(contador-2, 1));
        prueba.DeleteById(contador-2, 1);
        System.out.println(prueba.SelectAll(contador-2,"prueba"));
        prueba.UpdateById(contador-2, 2, "Actualización de campo"+contador);
        System.out.println(prueba.SelectAll(contador-2,"prueba"));


    }
}
