/** Clasa pentru definirea interfeței UtilizatorRepozitoriu, care extinde interfața JpaRepository
 * folosită pentru identificarea utilizatorului după numele de utilizator și email
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.repozitorii;

import com.example.Parc.modele.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilizatorRepozitoriu extends JpaRepository<Utilizator, Long> {
    Optional<Utilizator> findBynumeUser(String numeUser);
    Optional<Utilizator> findByEmail(String email);
}