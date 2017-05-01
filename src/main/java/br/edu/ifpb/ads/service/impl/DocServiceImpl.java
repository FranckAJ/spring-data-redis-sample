package br.edu.ifpb.ads.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.ads.entity.Doc;
import br.edu.ifpb.ads.repository.DocRespository;
import br.edu.ifpb.ads.service.DocService;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Service 
class DocServiceImpl implements DocService{

	@Autowired
	private DocRespository docRepository;
	
	/**
	 * 
	 */
	@Override
	@Transactional
	public Doc save(Doc doc) {
		return docRepository.save(doc);
	}

	/**
	 * 
	 */
	@Override
	public List<Doc> findAll() {
		return StreamSupport.stream(docRepository.findAll().spliterator(), false).collect(Collectors.toList());	}

	/**
	 * 
	 */
	@Override
	@Transactional
	public void remove(Doc doc) {
		docRepository.delete(doc);
	}

}
