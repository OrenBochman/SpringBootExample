package hello.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import hello.IDao;

@Repository
public class UserMemDao implements IDao<User>{

	private final Map<Long,User> users; 

	//	@PersistenceContext(unitName="dev")	private EntityManager entityManager;

	/////////////// Singleton /////////////////////////////

	public UserMemDao(){
		users= new HashMap<Long,User>();
		create(new User().setId(1234l).setName("alice").setAge(18).setPassword("12Al345"));
		create(new User().setId(1235l).setName("bob").setAge(19).setPassword("12Bo345"));
		create(new User().setId(1236l).setName("charlie").setAge(20).setPassword("12Ch345"));

		//		create(new User(1235l,"bob",18));
		//		create(new User(1236l,"charlie",21));
	}

	//	private static UserMemDao inst;
	//	
	//	public static UserMemDao getInstance() {
	//		if(inst==null)
	//			UserMemDao.inst=new UserMemDao();
	//		return UserMemDao.inst;
	//	}

	////////////////   CRUD    ////////////////////////////

	@Override
	public void create(User user){
		if (user.getId()==0) {
			user.setId(user.hashCode());
		}
		this.users.put(user.getId(), user);
	}

	@Override
	public Collection<User> read() {
		return this.users.values();
	}

	@Override
	public User readById(long id) {
		return users.get(id);
	}

	public Collection<User> readUserbyAge(int age) {
		List<User> res = new ArrayList<>();
		for(User user:users.values()) {
			if(user.getAge()==age)
				res.add(user);
		}
		return res;
	}

	@Override
	public void update(User user){
		this.users.put(user.getId(), user);
	}

	@Override
	public void delete(long id) {
		users.remove(id);
	}
}