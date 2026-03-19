package com.example.testLogiTrack.service;

import com.example.testLogiTrack.entity.Client;
import com.example.testLogiTrack.repository.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private  final ClientRepo clientRepo;
    public ClientService(ClientRepo clientRepo){
        this.clientRepo=clientRepo;
    }
    public Client addClient(Client client){
        return clientRepo.save(client);
    }

    public List<Client> findAllClient(){
        return  clientRepo.findAll();
    }
    public  Client findCLientById(Long id){
        return  clientRepo.findById(id).orElseThrow(()->new RuntimeException("Client not found"));
    }

    public void deleteClientById(Long id){
         clientRepo.deleteById(id);
    }

}
