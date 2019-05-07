package model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pichau
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
    @NamedQuery(name = "Usuario.getAll", query = "select u from Usuario u")
    ,
    @NamedQuery(name = "Usuario.getEmail", query = "select u from Usuario u where u.email= :email")
    ,
    @NamedQuery(name = "Usuario.getLogin", query = "select u from Usuario u where u.email=:email and u.senha=:senha")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String nome;
    private String senha;
    private String email;

    public Usuario(Integer id, String cpf, String nome, String senha, String email) {
        this.id = id;
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }

    public Usuario(String senha, String email) {
        this.senha = senha;
        this.email = email;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void criptografaSenha() throws UnsupportedEncodingException {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte messageDigest[] = algorithm.digest(this.senha.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            String senhaCriptografada = hexString.toString();
            this.setSenha(senhaCriptografada);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return  email;
    }
    
    @Override
    public int hashCode() {
        Integer hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.senha);
        hash = 89 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
}
