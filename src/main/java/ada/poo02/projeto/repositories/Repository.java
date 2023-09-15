package ada.poo02.projeto.repositories;

import ada.poo02.projeto.models.CustomerModel;

import java.util.List;

public interface Repository<T> {
    // T findOne(int id);
    T findOneById(long id);
    List<T> findAll();
    T create(T object);
    void deleteByType(T object);
    void deleteById(long id);
    T updateByType(T object);
    T updateByIdAndType(int index, T object);
}
