/** Clasa pentru gestionarea paginii de contact și trimiterea emailurilor
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.controllere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@RequestParam("email") String email,
                                    @RequestParam("message") String message,
                                    Model model) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo("claudiugiab@yahoo.com");
            mailMessage.setFrom("claudiugiab@yahoo.com"); // Set the from address
            mailMessage.setSubject("Contact Form Submission");
            mailMessage.setText("Email: " + email + "\n\nMessage: " + message);
            mailSender.send(mailMessage);
            model.addAttribute("success", "Mesaj trimis cu succes!");
        } catch (MailAuthenticationException e) {
            model.addAttribute("error", "Eroare de autentificare la trimiterea emailului. Verificați configurația SMTP și parola.");
        } catch (MailSendException e) {
            model.addAttribute("error", "Eroare la trimiterea emailului. Verificați conexiunea la internet și configurația SMTP.");
        } catch (Exception e) {
            model.addAttribute("error", "Eroare necunoscută la trimiterea mesajului. Vă rugăm să încercați din nou.");
        }
        return "contact";
    }
}