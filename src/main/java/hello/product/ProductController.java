package hello.product;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.IDao;

@Controller
public class ProductController implements IDao<Product> {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public void create(Product t){
		this.productRepository.save(t);
	}

	@Override
	public void update(Product t) {
		this.productRepository.save(t);
	}

	@Override
	public Collection<Product> read() {
		return (Collection<Product>) this.productRepository.findAll();
	}

	@Override
	public Product readById(long id) {
		return this.productRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		this.productRepository.delete(id);
	}
}