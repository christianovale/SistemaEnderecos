package br.com.christianovale.sistemaenderecos.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.christianovale.sistemaenderecos.dao.DAO;
import br.com.christianovale.sistemaenderecos.model.Pessoa;

/**
 * Controller Restfull
 * 
 * @author Christiano
 *
 */
@Controller
@RequestMapping("/index/pessoa")
public class PessoaController {
	@Autowired
	private DAO<Pessoa> pessoaDao;


	@RequestMapping(value="/novo", method= RequestMethod.POST)
	public @ResponseBody Pessoa novo(){
		Pessoa pessoa = new Pessoa();
		return pessoa;
	}
	
	
	@RequestMapping(value="/salvar", method= RequestMethod.POST)
	public @ResponseBody Pessoa salvar(@RequestBody Pessoa pessoa){
		try {
			pessoaDao.save(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoa;
	}
 
	
	@RequestMapping(value ="/editarRegistro.html/{codigo}", method= RequestMethod.GET)
	public Pessoa editarRegistro(@PathVariable int codigo){
		Pessoa pessoa = pessoaDao.getEntity(Pessoa.class, codigo);
		return pessoa;
	}
 
	
	@RequestMapping(value="/consultarTodos", method= RequestMethod.GET)
	public @ResponseBody List<Pessoa> consultarTodos(){
		return pessoaDao.getEntities(Pessoa.class);
	}
	

	@RequestMapping(value="/alterar", method= RequestMethod.POST)
	public @ResponseBody Pessoa alterar(@RequestBody Pessoa pessoa){
		try {
			pessoa = pessoaDao.update(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoa;
	}
 
 
	@RequestMapping(value="/excluirRegistro/{codigo}", method= RequestMethod.DELETE)
	public @ResponseBody void excluirRegistro(@PathVariable int codigo){
		Pessoa p = new Pessoa();
		p.setId(new Long(codigo));
		pessoaDao.delete(p);
	}


}
