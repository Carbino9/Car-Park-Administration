/** Clasa pentru definirea interfeței ClientRepozitoriu, care extinde interfața JpaRepository
 * și care este folosită pentru a realiza operații de tip CRUD pe entitatea Client
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.repozitorii;

import com.example.Parc.modele.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepozitoriu extends JpaRepository<Client, Long> {
    Optional<Client> findBynumeUser(String numeUser);
    Optional<Client> findByEmail(String email);
}