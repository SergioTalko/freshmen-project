package dao;

import java.util.HashSet;
import java.util.Set;

public class GeneralDAO<T> {


    private Set<T> objects = new HashSet<>();


    public T add(T t) {
        if (t != null)
            objects.add(t);
        return t;
    }

    public void remove(T t) {
        objects.remove(t);
    }

    public Set<T> getAll() {
        return objects;
    }
}

