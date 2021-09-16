package trackme.db;

import java.util.List;

public interface DAO<T> {
    T get(int id);
    List<T> getAll();
    boolean update(T t);
    boolean delete(T t);
}