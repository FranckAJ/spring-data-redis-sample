package br.edu.ifpb.ads.service;

import java.util.List;

import br.edu.ifpb.ads.entity.Doc;

/**
 * 
 * 
 * <p>
 * Doc Service 
 * </p>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public interface DocService {
	
	/**
	 * 
	 */
	Doc save(Doc doc);
	
	/**
	 * 
	 */
	List<Doc> findAll();
	
	/**
	 * 
	 */
	void remove(Doc doc);
	
	
	
}
