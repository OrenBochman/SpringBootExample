package hello.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path="/api/users")
public class UserApi {

	final static String version = "0.1.1";

	@Autowired
	private UserController controller;  
	//UserMemDao.getInstance();

	@GetMapping()
	public Collection<User> readAllUsers() throws Exception {
		return controller.read();
	}
	
	@GetMapping("/{id}")
	public User readUserById(@PathVariable("id") long id) {
		return controller.readById(id);
	}

	@GetMapping("/byAge/{age}")
	public Collection<User> readUserbyAge(
			@PathVariable(value="age") int age,
			@RequestParam(value="order") String order
			) {

		List<User> users = (List<User>) controller.readUserbyAge(age);

		Comparator<User> comp= new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o1.getAge()-o2.getAge();
			}
		};

		if(order.equals("inc")) {
			users.sort(comp);	
		} else 	if(order.equals("desc")){
			users.sort(comp.reversed());
		}
		return users;
	}

	@GetMapping("/byName/{name}")
	public List<User> readUserbyName(@RequestParam(value="name") String name) throws Exception {
		List<User> res = new ArrayList<>();
		for(User user: this.controller.read()) {
			if(user.getName().equals(name))
				res.add(user);
		}
		return res;
	}

	@PostMapping
	public String createUser(@RequestBody User user) {
		try {
			this.controller.create(user);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return e.getMessage();
		}
		return null;
	}

	@PutMapping
	public void updateUser(@RequestBody User user) {
			this.controller.update(user);	
	}    

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
		this.controller.delete(id);
		redirectAttributes.addFlashAttribute("message", "user was deleted");
	}

	///////////////  micro service  /////////////////////
	@GetMapping("/ver")
	public String getValueUsingQueryString(@RequestParam("version") int version){
		return UserApi.version; 
	}
	
	
	
	///////////////  micro service  /////////////////////
	@ExceptionHandler(ApplicationException.class)
	public void handleApplicationException(ApplicationException exception,HttpServletResponse response) throws Exception {
		response.sendError(HttpStatus.NOT_FOUND.value(),exception.getMessage());
		
	}
}
