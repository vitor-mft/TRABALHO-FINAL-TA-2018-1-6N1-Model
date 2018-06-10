/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author V_M_FT
 */
@Entity
@Table(name = "livros")
public class Livros implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_livros", sequenceName = "seq_livros_id"
            ,allocationSize = 1)
    @GeneratedValue(generator = "seq_livros", strategy = GenerationType.SEQUENCE)
    private Integer id;
   
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    
    @NotNull(message = "A Edição não pode ser nulo")
    @NotBlank(message = "A Edição não pode ser em branco")
    @Length(max = 40, message = "A Edição não pode ter mais que {max} caracteres")
    @Column(name = "edicao", length = 40, nullable = false)
    private String edicao;
    
    @NotNull(message = "Campo Disponivel deve ser informado")
    @Column(name = "disponivel", nullable = false)    
    private Boolean disponivel;
    
     @ManyToOne
    @JoinColumn(name = "autores", referencedColumnName = "id", 
            nullable = false, 
            foreignKey = @ForeignKey(name = "fk_autores_id"))
    private Autores autores;
     
      @ManyToOne
    @JoinColumn(name = "pessoas", referencedColumnName = "id", 
            nullable = false, 
            foreignKey = @ForeignKey(name = "fk_pessoas_id"))
    private Pessoas pessoas;
  
    
    
    
    public Livros() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }    
   
    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public Pessoas getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

     @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Livros other = (Livros) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
