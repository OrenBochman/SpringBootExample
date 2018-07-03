package hello.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.IDao;

@Controller
public class UserController implements  IDao<User> {
	
	@Autowired
	//UserMemDao users;
	UserDBDao users;
	
	@Override
	public void create(User user) throws Exception {
		if (validate(user))
				users.create(user);
	}

	private boolean validate(User user) throws Exception  {
		if (user.getPassword().length()>20)
			throw new Exception("Password too long");
		if (user.getPassword().length()<5)
			throw new Exception("Password too short");
		return true;
				
	}

	@Override
	public void update(User user) {
		users.update(user);
	}

	@Override
	public Collection<User> read() throws Exception {
		return users.read() ;
	}

	
	public Collection<User> readUserbyAge(int age) {
		return users.readUserbyAge(age);
	}

	@Override
	public User readById(long id) {
		return users.readById(id);
	}

	@Override
	public void delete(long id) {
		users.delete(id);
	}
	
}