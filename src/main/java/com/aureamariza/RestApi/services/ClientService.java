package com.aureamariza.RestApi.services;

import com.aureamariza.RestApi.models.Cliente;

import java.util.List;

public interface ClientService{
    public List<Cliente> findAll();
    public Cliente  find();
    public Cliente create(Cliente cliente);
    public Cliente update();
    public void  delete();

}
