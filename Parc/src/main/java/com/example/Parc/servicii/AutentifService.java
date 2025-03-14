/** Clasa pentru definirea serviciului AutentifService, care este folosit pentru autentificarea
 * utilizatorului și a clientului în aplicație, folosind numele de utilizator(sau email) și parola
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.servicii;

import com.example.Parc.modele.Utilizator;
import com.example.Parc.modele.Client;
import com.example.Parc.repozitorii.UtilizatorRepozitoriu;
import com.example.Parc.repozitorii.ClientRepozitoriu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutentifService {

    @Autowired
    private UtilizatorRepozitoriu utilizatorRepozitoriu;

    @Autowired
    private ClientRepozitoriu clientRepozitoriu;

    public String authenticate(String identifier, String password) {
        Optional<Utilizator> utilizator = utilizatorRepozitoriu.findBynumeUser(identifier);
        if (!utilizator.isPresent()) {
            utilizator = utilizatorRepozitoriu.findByEmail(identifier);
        }
        if (utilizator.isPresent() && utilizator.get().getParola().equals(password)) {
            return "user";
        }

        Optional<Client> client = clientRepozitoriu.findBynumeUser(identifier);
        if (!client.isPresent()) {
            client = clientRepozitoriu.findByEmail(identifier);
        }
        if (client.isPresent() && client.get().getParola().equals(password)) {
            return "client";
        }

        return "error";
    }
}