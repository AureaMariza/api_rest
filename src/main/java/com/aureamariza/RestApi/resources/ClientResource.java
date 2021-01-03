package com.aureamariza.RestApi.resources;

import com.aureamariza.RestApi.models.Cliente;
import com.aureamariza.RestApi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientResource {

    @Autowired
    public ClientService clientService;

    public ClientResource(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente create(@Valid @RequestBody Cliente cliente){
        return this.clientService.create(cliente);
    }

    @GetMapping
    @ResponseBody
    public List<Cliente> findAll(){
        return this.clientService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> find(@PathVariable(value = "id") Integer id) {
        var cliente = this.clientService.find(id);
        if (cliente != null) {
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> update(@PathVariable(value = "id") Integer id, @RequestBody Cliente cliente) {
        var clienteUpdated = this.clientService.update(id, cliente);

        if (clienteUpdated == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteUpdated, HttpStatus.OK);
    }
}
