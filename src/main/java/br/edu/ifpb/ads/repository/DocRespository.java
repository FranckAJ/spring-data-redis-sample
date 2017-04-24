package br.edu.ifpb.ads.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifpb.ads.entity.Doc;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public interface DocRespository extends CrudRepository<Doc, String>{
	
}
