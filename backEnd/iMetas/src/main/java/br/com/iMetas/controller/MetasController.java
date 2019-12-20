package br.com.iMetas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.iMetas.model.Metas;
import br.com.iMetas.repository.MetasRepository;



@RestController
@RequestMapping(value="/api")
public class MetasController {

	
	@Autowired
	private MetasRepository mr;
	
	
	@GetMapping(produces="application/json")
	public  @ResponseBody Iterable<Metas> listaMetas() {
		Iterable<Metas> listaVagas = mr.findAll();
		return listaVagas;
	}
	
	@PostMapping()
	public Metas CadastraMeta(@RequestBody @Valid Metas metas) {
		return mr.save(metas);
	}
	
	@DeleteMapping()
	public Metas deletaMeta( @RequestBody Metas metas ) {
		mr.delete(metas);
		return metas;
	}
	@PutMapping("/{id}")
	public Metas editartaMeta( @RequestBody Metas metas, @PathVariable Integer id ) {
		if(id != null)
			return mr.save(metas);
		else
			return metas;
	}
	
	
}
