package com.playerbook.demo;

import com.playerbook.demo.domains.playerHabits.PlayerHabits;
import com.playerbook.demo.domains.role.Role;
import com.playerbook.demo.domains.role.RoleService;
import com.playerbook.demo.domains.user.AppUser;
import com.playerbook.demo.domains.user.UserService;
import com.playerbook.demo.domains.userBehavior.UserBehavior;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class PlayerbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerbookApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService appUserService, RoleService roleService){
		return args -> {
			roleService.saveRole(new Role(null, "ROLE_USER"));
			roleService.saveRole(new Role(null, "ROLE_ADMIN"));

			appUserService.addUser(new AppUser(null, "Clem", "password", "https://logo-marque.com/wp-content/uploads/2020/07/Barbie-Symbole.jpg", "France", "No Ken needed", new PlayerHabits(), new UserBehavior(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "Goudale", "password", "https://static.wikia.nocookie.net/seigneur-des-anneaux/images/2/26/Gimli-lord-of-the-rings.jpg/revision/latest?cb=20140206131605&path-prefix=fr", "France", "A bouère ou ch'tues l'chien", new PlayerHabits(), new UserBehavior(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

			appUserService.addRoleToUser("Clem", "ROLE_USER");
			appUserService.addRoleToUser("Clem", "ROLE_ADMIN");
			appUserService.addRoleToUser("Goudale", "ROLE_USER");
		};
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
