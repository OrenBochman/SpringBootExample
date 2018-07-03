package hello.bid;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.IDao;

@Controller
public class BidController implements IDao<Bid>{
	
	@Autowired
	BidRepository bidRepository;

	@Override
	public Collection<Bid> read() {
		return (Collection<Bid>) this.bidRepository.findAll();
	}

	@Override
	public Bid readById(long id) {
		return this.bidRepository.findOne(id);
	}
	
	public void create(Bid bid) {
		this.bidRepository.save(bid);
	}

	public void update(Bid bid) {
		this.bidRepository.save(bid);

	}

	public void delete(long id) {
		this.bidRepository.delete(id);
	}
}
