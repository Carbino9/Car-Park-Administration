/** Clasa pentru gestionarea operațiilor CRUD pe mașini(creare, citire, actualizare, ștergere),
 * funcționalități de programare revizie, reînnoire ITP, RCA și rovinieta,
 * acestea fiind accesibile doar administratorilor
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.controllere;

import com.example.Parc.modele.MasinaOtd;
import com.example.Parc.modele.Masina;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import com.example.Parc.repozitorii.MasinaRepozitoriu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/masini")
public class MasinaController {

    @Autowired
    private MasinaRepozitoriu masinaRepo;

    @GetMapping({"", "/"})
    public String getMasini(Model model) {
        var masini = masinaRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("masini", masini);

        return "masini/index";
    }

    @GetMapping("/creeaza")
    public String creeazaMasina(Model model) {
        MasinaOtd masinaOtd = new MasinaOtd();
        model.addAttribute("masinaOtd", masinaOtd);

        return "masini/creeaza";
    }

    @PostMapping("/revizie")
    public String programeazaRevizie(
            @RequestParam int id,
            @RequestParam("dataRevizie") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataRevizie,
            Model model
    ) {
        if (dataRevizie.isBefore(LocalDate.now())) {
            model.addAttribute("error", "Data reviziei trebuie să fie în viitor.");
            var masini = masinaRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
            model.addAttribute("masini", masini);
            return "masini/index";
        }

        Masina masina = masinaRepo.findById(id).orElse(null);
        if (masina == null) {
            return "redirect:/masini";
        }

        masina.setDataUrmatoareiRevizii(dataRevizie);
        masinaRepo.save(masina);

        return "redirect:/masini";
    }

    @PostMapping("/renewITP")
    public String renewITP(@RequestParam int id) {
        Masina masina = masinaRepo.findById(id).orElse(null);
        if (masina != null) {
            LocalDate today = LocalDate.now();
            if (masina.getItp().isAfter(today)) {
                masina.setItp(masina.getItp().plusYears(2));
            } else {
                masina.setItp(today.plusYears(2));
            }
            masinaRepo.save(masina);
        }
        return "redirect:/masini";
    }

    @PostMapping("/renewRCA")
    public String renewRCA(@RequestParam int id) {
        Masina masina = masinaRepo.findById(id).orElse(null);
        if (masina != null) {
            LocalDate today = LocalDate.now();
            if (masina.getRca().isAfter(today)) {
                masina.setRca(masina.getRca().plusYears(1));
            } else {
                masina.setRca(today.plusYears(1));
            }
            masinaRepo.save(masina);
        }
        return "redirect:/masini";
    }

    @PostMapping("/renewRoVINIETA")
    public String renewRoVINIETA(@RequestParam int id) {
        Masina masina = masinaRepo.findById(id).orElse(null);
        if (masina != null) {
            LocalDate today = LocalDate.now();
            if (masina.getRovignieta().isAfter(today)) {
                masina.setRovignieta(masina.getRovignieta().plusYears(1));
            } else {
                masina.setRovignieta(today.plusYears(1));
            }
            masinaRepo.save(masina);
        }
        return "redirect:/masini";
    }

    @PostMapping("/creeaza")
    public String creeazaMasina(
            @Valid @ModelAttribute MasinaOtd masinaOtd,
            BindingResult result
    ) {
        if (masinaRepo.findByInmat(masinaOtd.getInmat()) != null) {
            result.addError(
                    new FieldError("masinaOtd", "inmat", masinaOtd.getInmat(),
                            false, null, null, "Numărul de înmatriculare este deja utilizat")
            );
        }

        if (result.hasErrors()) {
            return "masini/creeaza";
        }

        Masina masina = new Masina();
        masina.setMarca(masinaOtd.getMarca());
        masina.setModel(masinaOtd.getModel());
        masina.setInmat(masinaOtd.getInmat());
        masina.setCombust(masinaOtd.getCombust());
        masina.setKilometraj(masinaOtd.getKilometraj());
        masina.setAnFabricatie(masinaOtd.getAnFabricatie());
        masina.setPozaUrl(masinaOtd.getPozaUrl());
        masina.setItp(masinaOtd.getItp());
        masina.setRca(masinaOtd.getRca());
        masina.setRovignieta(masinaOtd.getRovignieta());

        masinaRepo.save(masina);

        return "redirect:/masini";
    }

    @GetMapping("/editeaza")
    public String editMasina(Model model, @RequestParam int id) {
        Masina masina = masinaRepo.findById(id).orElse(null);
        if (masina == null) {
            return "redirect:/masini";
        }

        MasinaOtd masinaOtd = new MasinaOtd();
        masinaOtd.setMarca(masina.getMarca());
        masinaOtd.setModel(masina.getModel());
        masinaOtd.setInmat(masina.getInmat());
        masinaOtd.setCombust(masina.getCombust());
        masinaOtd.setKilometraj(masina.getKilometraj());
        masinaOtd.setAnFabricatie(masina.getAnFabricatie());
        masinaOtd.setPozaUrl(masina.getPozaUrl());
        masinaOtd.setItp(masina.getItp());
        masinaOtd.setRca(masina.getRca());
        masinaOtd.setRovignieta(masina.getRovignieta());

        model.addAttribute("masina", masina);
        model.addAttribute("masinaOtd", masinaOtd);

        return "masini/editeaza";
    }

    @PostMapping("/editeaza")
    public String editMasina(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute MasinaOtd masinaOtd,
            BindingResult result
    ) {
        Masina masina = masinaRepo.findById(id).orElse(null);
        if (masina == null) {
            return "redirect:/masini";
        }

        model.addAttribute("masina", masina);

        if (result.hasErrors()) {
            return "masini/editeaza";
        }

        masina.setMarca(masinaOtd.getMarca());
        masina.setModel(masinaOtd.getModel());
        masina.setInmat(masinaOtd.getInmat());
        masina.setCombust(masinaOtd.getCombust());
        masina.setKilometraj(masinaOtd.getKilometraj());
        masina.setAnFabricatie(masinaOtd.getAnFabricatie());
        masina.setPozaUrl(masinaOtd.getPozaUrl());
        masina.setItp(masinaOtd.getItp());
        masina.setRca(masinaOtd.getRca());
        masina.setRovignieta(masinaOtd.getRovignieta());

        try {
            masinaRepo.save(masina);
        } catch (Exception ex) {
            result.addError(
                    new FieldError("masinaOtd", "inmat", masinaOtd.getInmat(),
                            false, null, null, "Numărul de înmatriculare este deja utilizat")
            );
            return "masini/editeaza";
        }

        return "redirect:/masini";
    }

    @GetMapping("/elimina")
    public String deleteMasina(@RequestParam int id) {
        Masina masina = masinaRepo.findById(id).orElse(null);

        if (masina != null) {
            masinaRepo.delete(masina);
        }

        return "redirect:/masini";
    }

}