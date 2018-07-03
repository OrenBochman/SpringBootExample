package hello;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hello.user.User;
import hello.user.UserRepository;
import hello.bid.Bid;
import hello.bid.BidRepository;
import hello.product.Product;
import hello.product.ProductRepository;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	//	@Bean
	//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	//		return args -> {
	//			System.out.println("Let's inspect the beans provided by Spring Boot:");
	//			String[] beanNames = ctx.getBeanDefinitionNames();
	//			Arrays.sort(beanNames);
	//			for (String beanName : beanNames) {
	//				System.out.println(beanName);
	//			}
	//		};
	//	}


	@Bean
	public CommandLineRunner demo(
			UserRepository userRepository, 
			ProductRepository productRepository,
			BidRepository bidRepository
			) {
		return (args) -> {
			Date exp = new Date(ZonedDateTime.now().toInstant().toEpochMilli());
			System.err.println(exp);
			// save a some of users
			userRepository.save(new User().setUserName("Jack Bauer").setAge(43).setPassword("yamba32").setName("Kiefer Sutherland").setRole(User.RoleEnum.USER).setPasswordExpiration(exp));
			userRepository.save(new User().setUserName("Chloe O'Brian").setAge(30).setPassword("yam45ba").setName("Mary Lynn Rajskub").setRole(User.RoleEnum.ADMIN).setPasswordExpiration(exp));
			userRepository.save(new User().setUserName("Kim Bauer").setAge(22).setPassword("yamba6").setName("Elisha Cuthbert").setRole(User.RoleEnum.USER).setPasswordExpiration(exp));
			userRepository.save(new User().setUserName("David Palmer").setAge(66).setPassword("ya4mba").setName("Dennis Haysbert").setRole(User.RoleEnum.EXECUTIVE).setPasswordExpiration(exp));
			userRepository.save(new User().setUserName("Michelle Dessler").setAge(40).setPassword("ya3mba").setName("Reiko Aylesworth").setRole(User.RoleEnum.USER).setPasswordExpiration(exp));
			userRepository.save(new User().setUserName("Tony Almeida").setAge(40).setPassword("ya7mba").setName("Carlos Bernard").setRole(User.RoleEnum.USER).setPasswordExpiration(exp));
			userRepository.save(new User().setUserName("Sarah Clarke").setAge(40).setPassword("ya4mba").setName("Nina Myers").setRole(User.RoleEnum.EXECUTIVE).setPasswordExpiration(exp));
			userRepository.save(new User().setUserName("Ethan Kanin").setAge(70).setPassword("ya3mba").setName("Robert Patrick Gunton").setRole(User.RoleEnum.USER).setPasswordExpiration(exp));
			userRepository.save(new User().setUserName("Morris O'Brian").setAge(40).setPassword("ya7mba").setName("Carlo Rota").setRole(User.RoleEnum.USER).setPasswordExpiration(exp));
			
			// save a some of products
			productRepository.save(new Product().setName("Barreta").setCategory("Weapon").setDescription("Cop Favourite"));
			productRepository.save(new Product().setName("Glock").setCategory("Weapon").setDescription("Terrorist Favourite"));
			productRepository.save(new Product().setName("Knife").setCategory("Weapon").setDescription("Solder Favourite"));
			productRepository.save(new Product().setName("CTU Map").setCategory("Spy Craft").setDescription("Terrorist Favourite"));
			productRepository.save(new Product().setName("Night Vision").setCategory("Spy Craft").setDescription("Terrorist Favourite"));
			productRepository.save(new Product().setName("Drone").setCategory("Spy Craft").setDescription("Government Favourite"));
			productRepository.save(new Product().setName("Spy Satelite").setCategory("Spy Craft").setDescription("Government Favourite"));
			productRepository.save(new Product().setName("Agent List").setCategory("High Value").setDescription("Terrorist Favourite"));
			productRepository.save(new Product().setName("Nuclear Codes").setCategory("High Value").setDescription("Terrorist Favourite"));
			productRepository.save(new Product().setName("McGuffin").setCategory("High Value").setDescription("Whatever"));
			// save a couple of bids
			Random rand=new Random(200);
			bidRepository.save(new Bid().setPrice(22.00).setUser_id(1l).setProduct_id(4l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(24.00).setUser_id(2l).setProduct_id(4l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(26.00).setUser_id(4l).setProduct_id(4l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(27.00).setUser_id(5l).setProduct_id(4l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(30.00).setUser_id(6l).setProduct_id(4l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(40.00).setUser_id(1l).setProduct_id(8l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(44.00).setUser_id(2l).setProduct_id(8l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(56.00).setUser_id(4l).setProduct_id(8l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(70.00).setUser_id(5l).setProduct_id(8l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(99.00).setUser_id(6l).setProduct_id(8l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(122.00).setUser_id(1l).setProduct_id(8l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(334.00).setUser_id(2l).setProduct_id(8l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(556.00).setUser_id(4l).setProduct_id(8l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(770.00).setUser_id(5l).setProduct_id(8l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			bidRepository.save(new Bid().setPrice(899.00).setUser_id(6l).setProduct_id(8l).setTimestamp(new Timestamp(System.currentTimeMillis()-rand.nextLong()%15306354090l)));
			//			// fetch all customers
			//			log.info("Customers found with findAll():");
			//			log.info("-------------------------------");
			//			for (Customer customer : repository.findAll()) {
			//				log.info(customer.toString());
			//			}
			//			log.info("");
			//
			//			// fetch an individual customer by ID
			//			repository.findById(1L)
			//				.ifPresent(customer -> {
			//					log.info("Customer found with findById(1L):");
			//					log.info("--------------------------------");
			//					log.info(customer.toString());
			//					log.info("");
			//				});
			//
			//			// fetch customers by last name
			//			log.info("Customer found with findByLastName('Bauer'):");
			//			log.info("--------------------------------------------");
			//			repository.findByLastName("Bauer").forEach(bauer -> {
			//				log.info(bauer.toString());
			//			});
			//			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//			// 	log.info(bauer.toString());
			//			// }
			//			log.info("");
		};
	}
}