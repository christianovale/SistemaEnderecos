package br.com.christianovale.testes;
import java.util.ArrayList;
import java.util.List;

import br.com.christianovale.sistemaenderecos.dao.DAO;
import br.com.christianovale.sistemaenderecos.model.Endereco;
import br.com.christianovale.sistemaenderecos.model.Pessoa;

/**
 * Classe de teste para o back-end da aplicação.
 * 
 * @author Christiano
 *
 */
public class Teste {

	private static DAO<Pessoa> pessoaDao = new DAO<Pessoa>();
	
	public void executarTeste(){
		Long id;
		System.out.println("==========SALVANDO UM REGISTRO==========");
		Pessoa pessoa = this.testeSalvarUmRegistro();
		System.out.println(pessoa.toString());
		id = pessoa.getId();
		
		System.out.println("==========RECUPERANDO O REGISTRO SALVO==========");
		Pessoa p2 = this.testeRecuperarRegistro(id);
		System.out.println(p2.toString());
		
		System.out.println("==========ALTERANDO O REGISTRO SALVO==========");
		Pessoa p3 = this.testeAlteraRegistro(id);
		System.out.println(p3.toString());
		
		System.out.println("==========LIASTANDO TODOS OS REGISTROS SALVOS==========");
		List<Pessoa> lista = this.testeRecuperarRegistros();
		for (Pessoa pessoa2 : lista) {
			System.out.println(pessoa2.toString());
		}
	}
	
	//Cadastra uma pessoa com seus endereços
	private Pessoa testeSalvarUmRegistro(){
		Pessoa pessoa = new Pessoa("Chris Vale", 35, "Programador");
		pessoa.setEnderecos(new ArrayList<Endereco>());
				
			for(int i = 7 ; i <=11 ; i++){
				Endereco endereco = new Endereco();
				endereco.setBairro("Bairro "+i );
				endereco.setCep("33.333-00"+i);
				endereco.setCidade("Cidade "+i);
				endereco.setEstado("MG");
				endereco.setLogradouro("Rua "+i);
				endereco.setNumero(String.valueOf(i));
				endereco.setPessoa(pessoa);
				pessoa.getEnderecos().add(endereco);
			}
			
			pessoa = pessoaDao.save(pessoa);
			return pessoa;
	}
	
	//Recupera o cadastro e exibe
	private Pessoa testeRecuperarRegistro(Long id){
		Pessoa pessoa = (Pessoa) pessoaDao.getEntity(Pessoa.class, id);
		if(pessoa==null){
			System.out.println("Registro não encontrado");
			return null;
		}
		return pessoa;
	}
	
	//Altera um registro a base
	private Pessoa testeAlteraRegistro(Long id){
		Pessoa pessoa = testeRecuperarRegistro(id);
		if(pessoa==null){
			return null;
		}
		pessoa.setProfissao("Analista de Sistemas");
		pessoa.getEnderecos().get(0).setLogradouro("Nova rua alterada");
		pessoa = pessoaDao.update(pessoa);
		
		return pessoa;
	}
	
	private List<Pessoa> testeRecuperarRegistros(){
		List<Pessoa> lista = pessoaDao.getEntities(Pessoa.class);
		return lista;
	}
	
	
	public static void main(String[] args) {
		try {
			Teste teste = new Teste();
			teste.executarTeste();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
