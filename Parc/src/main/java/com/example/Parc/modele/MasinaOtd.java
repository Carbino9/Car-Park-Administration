/** Clasa pentru definirea entității Mașină și a atributelor acesteia,
 * folosite pentru realizarea operațiilor CRUD pe aceasta
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.modele;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class MasinaOtd {

    @NotEmpty(message = "Marca este obligatorie")
    private String marca;

    @NotEmpty(message = "Modelul este obligatoriu")
    private String model;

    @NotEmpty(message = "Numărul de înmatriculare este obligatoriu")
    private String inmat;

    @NotEmpty(message = "Tipul de combustibil este obligatoriu")
    private String combust;

    @Positive(message = "Kilometrajul trebuie să fie un număr pozitiv")
    private int kilometraj;

    @Positive(message = "Anul fabricației trebuie să fie un număr pozitiv")
    private int anFabricatie;

    private String pozaUrl;

    private LocalDate itp;

    private LocalDate rca;

    private LocalDate rovinieta;

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

    public void setRovignieta(LocalDate rovinieta) {
        this.rovinieta = rovinieta;
    }
}