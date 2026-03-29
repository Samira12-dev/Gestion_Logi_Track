package com.example.testLogiTrack.controller;

import com.example.testLogiTrack.entity.Client;
import com.example.testLogiTrack.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }
    @PostMapping()
    public Client saveClient(@RequestBody Client client){
        return clientService.addClient(client);
    }
    @GetMapping
    public List<Client> getAllCLient(){
        return clientService.findAllClient();
    }
    @GetMapping("/{id}")
    public  Client getById(@PathVariable Long id){
        return clientService.findCLientById(id);
    }
    @DeleteMapping ("/{id}")
    public void deleteById(@PathVariable Long id){
        clientService.deleteClientById(id);
    }
}
