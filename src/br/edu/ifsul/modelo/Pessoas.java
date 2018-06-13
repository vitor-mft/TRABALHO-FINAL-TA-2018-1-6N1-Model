/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author V_M_FT
 */
@Entity
@Table(name = "pessoas")
public class Pessoas implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_pessoas", sequenceName = "seq_pessoas_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoas", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "A pessoa não pode ser nulo")
    @NotBlank(message = "A pessoa não pode estar em branco")
    @Length(max = 50, message = "A pessoa não pode ter mais que {max} caracteres")
    @Column(name = "apelido", length = 50, nullable = false, unique = true)
    private String apelido;

    @NotNull(message = "O CPF não pode ser nulo")
    @CPF(message = "O CPF não é Valido")
    @NotBlank(message = "O CPF não pode estar em branco")
    @Length(max = 11, message = "O CPF não pode ter mais que {max} caracteres")
    @Column(name = "cpf", length = 50, nullable = false)
    private String cpf;

    @NotNull(message = "A senha não pode ser nulo")
    @NotBlank(message = "A Senha não pode estar em branco")
    @Length(max = 10, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", length = 50, nullable = false)
    private String senha;
    
    
    @ManyToMany
    @JoinTable(name = "tipos",
            joinColumns
            = @JoinColumn(name = "pessoas", referencedColumnName = "apelido", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "tipo", referencedColumnName = "titulo", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_tipos",
                        columnNames = {"pessoas", "tipo"})})
    private List<Tipo> tipo = new ArrayList<>();      

    public Pessoas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Pessoas other = (Pessoas) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Tipo> getTipo() {
        return tipo;
    }

    public void setTipo(List<Tipo> tipo) {
        this.tipo = tipo;
    }

    

   
}
