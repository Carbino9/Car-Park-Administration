/** Clasa pentru definirea interfeței MasinaRepozitoriu, care extinde interfața JpaRepository
 * și care este folosită pentru a realiza operații de tip CRUD pe entitatea Masina
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.repozitorii;

import com.example.Parc.modele.Masina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasinaRepozitoriu extends JpaRepository<Masina, Integer> {

    public Masina findByInmat(String inmat);
}