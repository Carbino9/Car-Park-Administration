/** Clasa pentru definirea entității Mașină și a atributelor acesteia,
 * folosite pentru afișarea mașinilor disponibile în parc
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.time.LocalDate;

@Entity
@Table(name = "masini")
public class Masina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String marca;
    private String model;

    @Column(unique = true, nullable = false)
    private String inmat;

    private String combust;
    private int kilometraj;
    private int anFabricatie;
    private String pozaUrl;
    private LocalDate dataRevizie;
    private LocalDate itp;
    private LocalDate rca;
    private LocalDate rovinieta;

    // Getters și Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInmat() {
        return inmat;
    }

    public void setInmat(String inmat) {
        this.inmat = inmat;
    }

    public String getCombust() {
        return combust;
    }

    public void setCombust(String combust) {
        this.combust = combust;
    }

    public int getKilometraj() {
        return kilometraj;
    }

    public void setKilometraj(int kilometraj) {
        this.kilometraj = kilometraj;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public String getPozaUrl() {
        return pozaUrl;
    }

    public void setPozaUrl(String pozaUrl) {
        this.pozaUrl = pozaUrl;
    }

    public LocalDate getDataUrmatoareiRevizii() {
        return dataRevizie;
    }

    public void setDataUrmatoareiRevizii(LocalDate dataUrmatoareiRevizii) {
        this.dataRevizie = dataUrmatoareiRevizii;
    }

    public LocalDate getItp() {
        return itp;
    }

    public void setItp(LocalDate itp) {
        this.itp = itp;
    }

    public LocalDate getRca() {
        return rca;
    }

    public void setRca(LocalDate rca) {
        this.rca = rca;
    }

    public LocalDate getRovignieta() {
        return rovinieta;
    }

    public void setRovignieta(LocalDate rovignieta) {
        this.rovinieta = rovignieta;
    }
}