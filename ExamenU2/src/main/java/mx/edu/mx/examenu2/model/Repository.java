package mx.edu.mx.examenu2.model;
import mx.edu.mx.examenu2.utils.Response;
import java.util.List;

public interface Repository <T>{
    List<T> findAll();
    List<T> findById(Long id);
    Response<T> save (T object);
    Response<T> update (T object);

}
