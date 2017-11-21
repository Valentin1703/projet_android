package condorcet.projet_android_motard.DAO;

import java.util.ArrayList;

/**
 * Created by lafer on 21-11-17.
 */

public interface DAO<T> {

    ArrayList<T> readAll();

    T readById();

    int create(T act);

    boolean delete();

    boolean update(T obj);

}

