package hello.bid;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hello.IDao;

@RestController    // This means that this class is a rest Controller
@RequestMapping(path="/api/bids") // This means URL's start with /api (after Application path)
public class BidApi implements IDao<Bid>
{
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private BidController bidController;
	
	@GetMapping
	@Override
	public @ResponseBody Collection<Bid> read() {
		// This returns a JSON or XML with the users
		return this.bidController.read();
	}
	
	@PostMapping
	@Override
	public void create(@RequestBody Bid bid) {		
		this.bidController.create(bid);
	}	
	
	@PutMapping
	@Override
	public void update(@RequestBody Bid bid 
			//,	RedirectAttributes redirectAttributes
			) {		
		this.bidController.update(bid);
	//	redirectAttributes.addFlashAttribute("message", "bid was updated");

	}
	
	@DeleteMapping("/{id}")
	public void delete(
			@PathVariable("id") String id 
			,RedirectAttributes redirectAttributes
			) {		
		this.bidController.delete(Long.parseLong(id));
		redirectAttributes.addFlashAttribute("message", "bid was deleted");
	}
	

	@Override
	public void delete(long id) {		
		this.bidController.delete(id);
	}

	@GetMapping("/{id}")
	@Override
	public Bid readById(@PathVariable("id") long id) {
		return this.bidController.readById(id);
	}
	
	
}