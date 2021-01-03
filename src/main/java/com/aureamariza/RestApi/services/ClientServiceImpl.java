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
    public Cliente find(Integer id) {
        var cliente = this.clientRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        return null;
    }

    @Override
    public Cliente create(Cliente cliente) {
        return this.clientRepository.save(cliente);
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        if (!this.clientRepository.existsById(id)) {
            return null;
        }
        cliente.setId(id);
        this.clientRepository.save(cliente);
        return cliente;
    }

    @Override
    public void delete(Integer id) {
        if (this.clientRepository.existsById(id)) {
            this.clientRepository.deleteById(id);
        }
    }



}
