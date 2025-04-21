package br.com.elvisassis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
		
		genereteHashedPassword();
	}

	private static void genereteHashedPassword() {

		PasswordEncoder pbkdf2Encoder = new Pbkdf2PasswordEncoder("",
				8, 18500,
				Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);

		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("pbkdf2", pbkdf2Encoder);
		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);

		passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
		var pass1 = passwordEncoder.encode("admin123");
		var pass2 = passwordEncoder.encode("admin234");

		System.out.println("Pass 1: " + pass1);
		System.out.println("Pass 2: " + pass2);

	}

}
