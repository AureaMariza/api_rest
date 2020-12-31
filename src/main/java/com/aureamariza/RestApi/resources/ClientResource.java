package com.aureamariza.RestApi.resources;

import com.aureamariza.RestApi.models.Cliente;
import com.aureamariza.RestApi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientResource {

    @Autowired
    public ClientService clientService;

    public ClientResource(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    @ResponseBody
    public List<Cliente> findAll(){
        return this.clientService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Cliente find(@PathVariable(value = "id") Integer id){
        return this.clientService.find();
    }

    @PostMapping
    @ResponseBody
    public Cliente create(@RequestBody Cliente cliente){
        return this.clientService.create(cliente);
    }

    @PutMapping(value = "/id")
    @ResponseBody
    public Cliente update(@PathVariable(value = "id") Integer id){
        return this.clientService.update();
    }
    @DeleteMapping(value = "/id")
    @ResponseBody
    public void  delete(@PathVariable(value = "id") Integer id){

    }

}
