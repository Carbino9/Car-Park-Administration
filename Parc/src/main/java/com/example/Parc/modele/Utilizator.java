/** Clasa pentru definirea entității Utilizator și a atributelor acesteia,
 * folosită pentru conectarea la aplicație(Utilizator=Administator)
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.modele;

import jakarta.persistence.*;

@Entity
@Table(name = "utilizatori")
public class Utilizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeUser;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String parola;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeUser() {
        return numeUser;
    }

    public void setNumeUser(String numeUser) {
        this.numeUser = numeUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}