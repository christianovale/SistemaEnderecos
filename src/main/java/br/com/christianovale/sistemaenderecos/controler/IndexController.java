package br.com.christianovale.sistemaenderecos.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.christianovale.sistemaenderecos.dao.DAO;
import br.com.christianovale.sistemaenderecos.model.Pessoa;

/**
 * Controler da Pagina incial da aplicação (index)
 * 
 * @author Christiano
 *
 */
@Controller
@RequestMapping("index")
public class IndexController {
	
	@Autowired
	private DAO<Pessoa> pessoaDao;
	
	
	@RequestMapping("/")
	public ModelAndView index(){
		return new ModelAndView("/index");
	}
	
}
