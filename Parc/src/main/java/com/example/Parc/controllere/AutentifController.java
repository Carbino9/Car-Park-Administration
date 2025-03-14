/** Clasa pentru gestionarea autentificării și înregistrării utilizatorilor
 * și a clienților și redirecționarea acestora către paginile corespunzătoare
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.controllere;

import com.example.Parc.modele.Client;
import com.example.Parc.servicii.AutentifService;
import com.example.Parc.servicii.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutentifController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AutentifService autentifService;

    @GetMapping("/autentificare")
    public String PaginaAutentif() {
        return "autentificare";
    }

    @GetMapping("/inregistrare")
    public String PaginaInreg() {
        return "inregistrare";
    }

    @GetMapping("/indexc")
    public String viewClientPage() {
        return "indexc";
    }

    @PostMapping("/autentificare")
    public String authenticate(@RequestParam("username") String identifier, @RequestParam("password") String password, Model model) {
        String userType = autentifService.authenticate(identifier, password);
        if ("user".equals(userType)) {
            return "redirect:/";
        } else if ("client".equals(userType)) {
            return "redirect:/indexc";
        } else {
            model.addAttribute("error", "Nume de utilizator sau parolă incorecte!");
            return "autentificare";
        }
    }

    @PostMapping("/inregistrare")
    public String inregistrare(@RequestParam String numeUser,
                               @RequestParam String email,
                               @RequestParam String parola,
                               @RequestParam String confirmareParola,
                               Model model) {
        if (!parola.equals(confirmareParola)) {
            model.addAttribute("error", "Parolele nu coincid!");
            return "inregistrare";
        }

        try {
            Client client = new Client();
            client.setNumeUser(numeUser);
            client.setEmail(email);
            client.setParola(parola);

            clientService.inregClient(client);
            return "redirect:/autentificare";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "inregistrare";
        }
    }
}