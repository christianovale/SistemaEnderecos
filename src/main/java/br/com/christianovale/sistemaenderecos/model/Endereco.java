package br.com.christianovale.sistemaenderecos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * CREATE TABLE `sistema_enderecos`.`endereco` (
  `idendereco` INT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(100) NULL,
  `numero` VARCHAR(45) NULL,
  `bairro` VARCHAR(100) NULL,
  `cidade` VARCHAR(100) NULL,
  `estado` VARCHAR(2) NULL,
  `cep` VARCHAR(45) NULL,
  `pessoa_idPessoa` INT NOT NULL,
  PRIMARY KEY (`idendereco`));
  
  ALTER TABLE `sistema_enderecos`.`endereco`
	ADD CONSTRAINT FK_pessoa_idPessoa
	FOREIGN KEY(pessoa_idPessoa)
	REFERENCES Pessoa(idPessoa);
  
  
 * @author Christiano
 *
 */
@Entity
public class Endereco implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="idendereco")
	private Long id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	@ManyToOne
	private Pessoa pessoa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
