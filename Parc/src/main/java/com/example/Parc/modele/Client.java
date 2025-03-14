/** Clasa pentru definirea entității Client și a atributelor acesteia,
 * folosită pentru conectarea la aplicație
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clienti")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String numeUser;
    private String parola;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeUser() {
        return numeUser;
    }

    public void setNumeUser(String numeUser) {
        this.numeUser = numeUser;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}