package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.IRoles;
import com.example.demo.dao.IUser;
import com.example.demo.dao.VillageRepository;
import com.example.demo.entities.Roles;
import com.example.demo.entities.User;


@SpringBootApplication
public class SenForageSpringApplication {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SenForageSpringApplication.class, args);
		VillageRepository villageRepository = ctx.getBean(VillageRepository.class);
		
		ClientRepository clientRepository = ctx.getBean(ClientRepository.class);
		
		@SuppressWarnings("unchecked")
		IUser<User> userRepository = ctx.getBean(IUser.class);
		
		
		IRoles roleRepository = ctx.getBean(IRoles.class);
		
		userRepository.save(new User(1, "Niang", "Marame", "thiatatou@gmail.com", "Thiatasse", 1, null));
		roleRepository.save(new Roles(1,"ROLE_USER", null));
//		User user = new User();
//		user.setNom("Niang");
//		user.setPrenom("Marame");
//		user.setEmail("thiatatou@gmail.com");
//		user.setPassword("Thiatasse");
//		user.setEtat(1);
//		
//		Roles roles = new Roles();
//		roles.setId(1);
//		roles.setNom("ROLE_USER");
//		List<User> users = new ArrayList<User>();
//		users.add(user);
//		roles.setUsers(users);
//		
//		try {
//			roleRepository.save(roles);
//			System.out.println("ok");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		villageRepository.save(new Village(1, "Tataguine"));
//		villageRepository.save(new Village(2, "Fandene"));
//		villageRepository.save(new Village(3, "Ndioum"));
//		villageRepository.save(new Village(4, "Ndiouroum"));
//		
//		villageRepository.findAll().forEach(v->System.out.println(v.getNom()));
	}

}
