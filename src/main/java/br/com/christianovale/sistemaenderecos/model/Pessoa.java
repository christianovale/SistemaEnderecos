package br.com.christianovale.sistemaenderecos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * CREATE TABLE `sistema_enderecos`.`pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `idade` INT NULL,
  `profissao` VARCHAR(200) NULL,
  PRIMARY KEY (`idPessoa`));
  
  
 * @author Christiano
 *
 */

@Entity
public class Pessoa implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="idPessoa")
	private Long id;
	private String nome;
	private int idade;
	private String profissao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<Endereco> enderecos;
	
	public Pessoa() {
	}

	public Pessoa(String nome, int idade, String profissao) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.profissao = profissao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("Nome "+this.nome).append(" - Profissão ").append(getProfissao()).append(" - Endereços:");
		for(Endereco e : this.enderecos){
			str.append("[").append(e.getLogradouro()).append(", ").append(e.getNumero()).append("] ");
		}
		return str.toString();
	}

}
