package br.com.kayky.storeadministration.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.kayky.storeadministration.entities.Category;
import br.com.kayky.storeadministration.entities.Product;
import br.com.kayky.storeadministration.entities.User;
import br.com.kayky.storeadministration.repository.CategoryRepository;
import br.com.kayky.storeadministration.repository.ProductRepository;
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
