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

			appUserService.addUser(new AppUser(null, "Clem", "password", "https://avatars.steamstatic.com/396d94b9a2c073c2e0f1f2516f201aeb61c9900f_full.jpg", "France", "CTO de l'Univers 👸🏼", new PlayerHabits(null, 2L, 3L, true, true, true, false, true, null), new UserBehavior(null, true, true, false, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "Goudale", "password", "https://avatars.steamstatic.com/af18751e8925aa0b87480cbc326ff3d33f20a515_full.jpg", "France", "A bouère ou ch'tues l'chien 🤪", new PlayerHabits(null, 6L, 2L, true, true, false, false, true, null), new UserBehavior(null, false, false, true,true,  "Les Kiwis", null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "Mafia37", "password", "https://avatars.steamstatic.com/bc9b5c43005a2d4ec81a8f309692af63a8142f57_full.jpg", "Italie", "Lambert savait que rien n'était insignifiant pour le parrain de la mafia. Il jugea inutile de finasser.", new PlayerHabits(null, 7L, 2L, false, true, false, false, true, null), new UserBehavior(null, true, true, false,true,  "Cosa Nostra", null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "Michou", "password", "https://cdn-s-www.vosgesmatin.fr/images/7E00D845-BC79-4A14-841B-3CB7E2474211/NW_raw/michel-drucker-presentera-son-spectacle-de-vous-a-moi-a-remiremont-en-fevrier-2022-photo-vm-dr-1622398296.jpg", "France", "Je vous ai vu naître, je vous verrai mourrir 😏", new PlayerHabits(null, 1L, 2L, false, true, false, true, false, null), new UserBehavior(null, true, false, false,true,  "France Télévisions", null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "Pangaï", "password", "https://avatars.steamstatic.com/dbd16fb38fc7afb4d1187eaf138c06c776d2de6e_full.jpg", "Corée du Sud", "Cherche pas, je suis le meilleur 😎", new PlayerHabits(null, 7L, 6L, true, true, true, true, true, null), new UserBehavior(null, true, true, true, true, "KoreaOne", null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "AleXepXress", "password", "https://avatars.steamstatic.com/e2dfcd8e57ecec719f99a20725aaf03064f30a0b_full.jpg", "Belgique", "Je joue beaucoup la nuit. Il fait souvent nuit en Belgique. Coïncidence? Je ne crois pas.", new PlayerHabits(null, 7L, 2L, true, false, false, true, false, null), new UserBehavior(null, true, false, false, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "DGRSman", "password", "https://avatars.steamstatic.com/02e89bb36f9e1a35e92863ddac44a24a561052a3_full.jpg", "Belgique", "Me cherche pas, je suis plus fort que tu crois.", new PlayerHabits(null, 3L, 3L, true, true, true, true, false, null), new UserBehavior(null, false, true, true, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "johnStone", "password", "https://avatars.steamstatic.com/2cb988e41de65c409e430cd02906baa943af2ae1_full.jpg", "Roumanie", "Dur comme un rock 💪💪", new PlayerHabits(null, 5L, 12L, true, true, false, false, true, null), new UserBehavior(null, true, true, true, true, "Les briseurs de cailloux", null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "EvanBeak_du_93", "password", "https://avatars.steamstatic.com/7da440978de8e8e1db51dd251d1425dfc3952abf_full.jpg", "France", "Streamer et joueur compulsif", new PlayerHabits(null, 7L, 10L, true, true, true, true, true, null), new UserBehavior(null, true, true, true, true, "StreamFR", null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "DemonNoob", "password", "https://avatars.steamstatic.com/b9d19a02f842f40cd80868284ad5e185f8ce49e5_full.jpg", "Canada", "J'adore les chats mi-cuits 🤤", new PlayerHabits(null, 1L, 2L, false, false, false, true, false, null), new UserBehavior(null, true, false, true, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "ShootChicken", "password", "https://avatars.steamstatic.com/2e81031f7fe9e4e66176aa2d6e142c61a47aaed6_full.jpg", "USA", "Je tire sur tout mais je ne vise pas très bien! 🫣", new PlayerHabits(null, 5L, 2L, true, true, false, true, true, null), new UserBehavior(null, true, false, true, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "FreestyleEagle", "password", "https://avatars.steamstatic.com/2f0e679e3bd479ba62e9f1b3fb23e9b31c8cc051_full.jpg", "USA", "J'aime les aigles et le freestyle ⚡️", new PlayerHabits(null, 3L, 4L, true, false, false, true, false, null), new UserBehavior(null, false, false, false, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "JolieKimberley", "password", "https://avatars.steamstatic.com/2f0bba1a7d11483e2aa8d04f82a85bf20985b659_full.jpg", "Vatican", "Tu veux jouer avec moi ?", new PlayerHabits(null, 7L, 12L, false, false, false, true, false, null), new UserBehavior(null, true, true, false, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "TekGamer", "password", "https://avatars.steamstatic.com/2ea082ee87f00fb2ffb57e4cd0d2b5f5743e6250_full.jpg", "France", "Plus fort que le roquefort! Joueur pro, soit pas jaloux 🤤", new PlayerHabits(null, 5L, 10L, false, true, true, true, true, null), new UserBehavior(null, true, true, true, true, "HackFR", null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "WarDela", "password", "https://avatars.steamstatic.com/2e963f372ec3d6bf56da7c700461dc79e830dd92_full.jpg", "Espagne", "Je suis loin frère!", new PlayerHabits(null, 4L, 4L, false, false, false, false, true, null), new UserBehavior(null, false, false, false, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "EpicRaptor", "password", "https://avatars.steamstatic.com/2ed96ea933cb68b252d49fe93f3a187ce3294fec_full.jpg", "France", "J'aime bien les reptiliens, les crocos, les aligators; les iguanes...", new PlayerHabits(null, 4L, 2L, true, true, false, true, false, null), new UserBehavior(null, false, true, true, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "PrimusUranium", "password", "https://avatars.steamstatic.com/2e9bf6a597b791c955959aa1328501f122a33165_full.jpg", "France", "Grand fan de Toyota Prius", new PlayerHabits(null, 7L, 5L, true, true, true, false, true, null), new UserBehavior(null, false, true, true, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "PhantomWait", "password", "https://avatars.steamstatic.com/7627a219ab53ae7a950dfd69f74500c2a96dbd93_full.jpg", "Belgique", "J'aime bien les grosses voitures et les taxis", new PlayerHabits(null, 5L, 2L, false, true, false, true, false, null), new UserBehavior(null, true, true, true, false, null, null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "WitcherDemon", "password", "https://avatars.steamstatic.com/510cc3d7b94cea0ce98b0bd38aafce22e76b28d4_full.jpg", "France", "Jouer c'est plus qu'une passion, pour moi c'est aussi mon job 😎", new PlayerHabits(null, 5L, 6L, false, true, true, true, true, null), new UserBehavior(null, true, true, true, true, "Witcher Team", null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
			appUserService.addUser(new AppUser(null, "GoatSunshine", "password", "https://avatars.steamstatic.com/d1156a01aa0cb46134fda23692d9eb2433924bf1_full.jpg", "France", "Je vis ma vie de rêves depuis que je suis sponsorisé 💪💪", new PlayerHabits(null, 5L, 6L, false, true, true, false, true, null), new UserBehavior(null, true, true, true, true, "SunEA", null), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

			appUserService.addRoleToUser("Clem", "ROLE_USER");
			appUserService.addRoleToUser("Clem", "ROLE_ADMIN");
			appUserService.addRoleToUser("Goudale", "ROLE_USER");
			appUserService.addRoleToUser("Mafia37", "ROLE_USER");
			appUserService.addRoleToUser("Michou", "ROLE_USER");
			appUserService.addRoleToUser("Pangaï", "ROLE_USER");
			appUserService.addRoleToUser("AleXepXress", "ROLE_USER");
			appUserService.addRoleToUser("DGRSman", "ROLE_USER");
			appUserService.addRoleToUser("johnStone", "ROLE_USER");
			appUserService.addRoleToUser("EvanBeak_du_93", "ROLE_USER");
			appUserService.addRoleToUser("DemonNoob", "ROLE_USER");
			appUserService.addRoleToUser("ShootChicken", "ROLE_USER");
			appUserService.addRoleToUser("FreestyleEagle", "ROLE_USER");
			appUserService.addRoleToUser("JolieKimberley", "ROLE_USER");
			appUserService.addRoleToUser("TekGamer", "ROLE_USER");
			appUserService.addRoleToUser("WarDela", "ROLE_USER");
			appUserService.addRoleToUser("Michou", "ROLE_USER");
			appUserService.addRoleToUser("EpicRaptor", "ROLE_USER");
			appUserService.addRoleToUser("PrimusUranium", "ROLE_USER");
			appUserService.addRoleToUser("PhantomWait", "ROLE_USER");
			appUserService.addRoleToUser("WitcherDemon", "ROLE_USER");
			appUserService.addRoleToUser("GoatSunshine", "ROLE_USER");
		};
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
