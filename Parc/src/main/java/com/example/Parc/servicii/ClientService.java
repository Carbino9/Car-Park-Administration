/** Clasa pentru definirea serviciului ClientService, care este folosit pentru
 * înregistrarea unui client în aplicație
 * @author Giaboc Claudiu-Ovidiu
 * @version 12 Decembrie 2024
 */

package com.example.Parc.servicii;

import com.example.Parc.modele.Client;
import com.example.Parc.repozitorii.ClientRepozitoriu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepozitoriu clientRepozitoriu;

    public void inregClient(Client client) {
        clientRepozitoriu.save(client);
    }
}