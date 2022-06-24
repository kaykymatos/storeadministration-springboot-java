package br.com.kayky.storeadministration.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.kayky.storeadministration.entities.Address;
import br.com.kayky.storeadministration.entities.Category;
import br.com.kayky.storeadministration.entities.Product;
import br.com.kayky.storeadministration.entities.Seller;
import br.com.kayky.storeadministration.entities.User;
import br.com.kayky.storeadministration.repository.AddressRepository;
import br.com.kayky.storeadministration.repository.CategoryRepository;
import br.com.kayky.storeadministration.repository.ProductRepository;
import br.com.kayky.storeadministration.repository.SellerRepository;
import br.com.kayky.storeadministration.repository.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	public CategoryRepository categoryRepository;
	@Autowired
	public ProductRepository productRepository;
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public SellerRepository sellerRepository;
	@Autowired
	public AddressRepository addressRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Maria", "maria@gmail.com", "password");
		User user2 = new User(null, "João", "joao@gmail.com", "password");
		User user3 = new User(null, "Pedro", "pedro@gmail.com", "password");
		User user4 = new User(null, "Antônio", "antonio@gmail.com", "password");
		User user5 = new User(null, "Carlos", "carlos@gmail.com", "password");
		User user6 = new User(null, "Joana", "joana@gmail.com", "password");
		User user7 = new User(null, "Marcia", "marcia@gmail.com", "password");
		User user8 = new User(null, "Marinalva", "marinalva@gmail.com", "password");
		User user9 = new User(null, "Jennifer", "jennifer@gmail.com", "password");
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9));

		Address addr1 = new Address(null,"Street 1","1","Texas",null);
		Address addr2 = new Address(null,"Street 2","2","Montana",null);
		Address addr3 = new Address(null,"Street 3","3","Alasca",null);
		Address addr4 = new Address(null,"Street 4","4","Havai",null);
		Address addr5 = new Address(null,"Street 5","5","Arizona",null);
		Address addr6 = new Address(null,"Street 6","6","Colorado",null);
		Address addr7 = new Address(null,"Street 7","7","Ohio",null);
		Address addr8 = new Address(null,"Street 8","8","Oregon",null);
		Address addr9 = new Address(null,"Street 9","9","Maryland",null);
		addressRepository.saveAll(Arrays.asList(addr1,addr2,addr3,addr4,addr5,addr6,addr7,addr8,addr9));

		Seller sell1 = new Seller(null, "Matias", "Matias","matias@gmail.com","(11) 11111-1111",addr1);
		Seller sell2 = new Seller(null, "Bryan", "Bryan","bryan@gmail.com","(22) 22222-2222",addr2);
		Seller sell3 = new Seller(null, "Ryan", "Ryan","ryan@gmail.com","(33) 33333-3333",addr3);
		Seller sell4 = new Seller(null, "Joana", "Joana","joana@gmail.com","(44) 44444-4444",addr4);
		Seller sell5 = new Seller(null, "Mariana", "Mariana","mariana@gmail.com","(55) 55555-5555",addr5);
		Seller sell6 = new Seller(null, "Júlia", "Júlia","julia@gmail.com","(66) 66666-6666",addr6);
		Seller sell7 = new Seller(null, "Mario", "Mario","mario@gmail.com","(77) 77777-7777",addr7);
		Seller sell8 = new Seller(null, "Marcos", "Marcos","marcos@gmail.com","(88) 88888-8888",addr8);
		Seller sell9 = new Seller(null, "Jefferson", "Jefferson","jefferson@gmail.com","(99) 99999-9999",addr9);
		sellerRepository.saveAll(Arrays.asList(sell1, sell2, sell3, sell4, sell5, sell6, sell7, sell8, sell9));

		Category cat1 = new Category(null, "Alimentos ");
		Category cat2 = new Category(null, "Congelados e frios");
		Category cat3 = new Category(null, "Hortifruti");
		Category cat4 = new Category(null, "Produtos de limpeza");
		Category cat5 = new Category(null, "Higiene pessoal");
		Category cat6 = new Category(null, "Bebidas");
		Category cat7 = new Category(null, "Papelaria");
		Category cat8 = new Category(null, "Tecnologia");
		Category cat9 = new Category(null, "Periféricos");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));

		Product prod1 = new Product(null, "Pão de Queijo", "Pão de Queijo mineiro o melhor que tem", 10.99, cat1);
		Product prod2 = new Product(null, "Carne", "Carne fresca, ótima para fazer churrascos", 30.99, cat2);
		Product prod3 = new Product(null, "Manga", "Manga fresca", 3.99, cat3);
		Product prod4 = new Product(null, "Detergente", "Detergente ótimo para lavar louça e limpar locais sujos", 5.99,
				cat4);
		Product prod5 = new Product(null, "Sabão", "Sabão, o melhor sabonete com um cheiro excelente", 10.99, cat5);
		Product prod6 = new Product(null, "Água", "Água, se idrate faz bem! Agua fresca", 6.99, cat6);
		Product prod7 = new Product(null, "Livro", "Melhor livro de histórias onde ha váris contos e fantasias", 8.99,
				cat7);
		Product prod8 = new Product(null, "Computador", "Computador completo, o melhor para trabalho!", 2000.99, cat8);
		Product prod9 = new Product(null, "Teclado", "Teclado RGB gamer, ótimo para quem gosta de jogar", 102.99, cat9);
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9));
	}
}
