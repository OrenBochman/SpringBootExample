package hello;

import java.util.Collection;

public interface IDao<T> {

	void create(T t) throws Exception;
	void update(T t);
	Collection<T> read() throws Exception;
	T readById(long id);
	void delete(long id);



	

}
