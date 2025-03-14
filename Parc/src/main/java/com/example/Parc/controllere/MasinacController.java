/** Clasa pentru gestionarea paginii destinată clienților pentru vizualizarea mașinilor disponibile
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.controllere;

import com.example.Parc.repozitorii.MasinaRepozitoriu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MasinacController {

    @Autowired
    private MasinaRepozitoriu masinaRepo;

    @GetMapping("/masinic")
    public String viewMasini(Model model) {
        var masini = masinaRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("masini", masini);

        return "masinic";
    }
}