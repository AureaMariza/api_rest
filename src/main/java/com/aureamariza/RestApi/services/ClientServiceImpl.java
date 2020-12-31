package com.aureamariza.RestApi.services;

import com.aureamariza.RestApi.models.Cliente;
import com.aureamariza.RestApi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Cliente> findAll() {
       return this.clientRepository.findAll();
    }

    @Override
    public Cliente find() {
        return null;
    }

    @Override
    public Cliente create(Cliente cliente) {
        return this.clientRepository.save(cliente);
    }

    @Override
    public Cliente update() {
        return null;
    }

    @Override
    public void delete() {
    }



}
