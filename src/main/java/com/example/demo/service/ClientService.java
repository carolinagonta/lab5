package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(String id) {
        if (!clientRepository.existById(id)) {
            throw new NotFoundException("Not found Client with ID: " + id);
        }

        return clientRepository.findById(id);
    }

    public void create(Client client) {
        if (clientRepository.existById(client.getId())) {
            throw new AlreadyExistException("Already exist client with ID: " + client.getId());
        }

        clientRepository.create(client);
    }

    public void update(String id, Client client) {
        clientRepository.update(id, client);
    }

    public void delete(String id) {
        clientRepository.delete(id);
    }
}
