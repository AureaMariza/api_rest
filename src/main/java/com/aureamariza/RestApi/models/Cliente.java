package com.aureamariza.RestApi.models;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.Date;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O nome não pode ser vazio.")
    @Size(min=3, max = 255)
    private String name;

    @CPF
    @NotEmpty
    private String cpf;

    @Email
    @NotEmpty
    private String email;

    @Past
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date data;

    public Cliente(){}

    public Cliente(String name,String cpf,String email, Date data){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.data = data;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", data=" + data +
                '}';
    }
}
