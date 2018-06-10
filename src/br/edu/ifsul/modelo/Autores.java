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
@Table(name = "autores")
public class Autores implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_autores", sequenceName = "seq_autores_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_autores", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome do Autor não pode ser nulo")
    @NotBlank(message = "O nome do Autor  não pode ser em branco")
    @Length(max = 50, message = "O nome do Autor não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "O Genero não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "genero", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_autor_genero"))
    private Genero genero;

    public Autores() {
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Autores other = (Autores) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
