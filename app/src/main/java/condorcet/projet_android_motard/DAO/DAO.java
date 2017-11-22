package condorcet.projet_android_motard.DAO;

import java.util.ArrayList;



public interface DAO<T> {

    ArrayList<T> readAll();

    T readById();

    int create(T act);


}

