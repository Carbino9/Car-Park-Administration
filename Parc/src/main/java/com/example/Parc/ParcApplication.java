/** Clasa pentru definirea aplicației ParcApplication, care este folosită pentru a porni aplicația Spring Boot
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class ParcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParcApplication.class, args);
	}

}
