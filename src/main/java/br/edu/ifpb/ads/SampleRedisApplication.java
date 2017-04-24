package br.edu.ifpb.ads;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifpb.ads.entity.Doc;
import br.edu.ifpb.ads.repository.DocRespository;
import br.edu.ifpb.ads.util.Util;

/**
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@SpringBootApplication
public class SampleRedisApplication {

	@Autowired
	private DocRespository docRespository;
	
	/**
	 * @throws IOException 
	 * 
	 */
	@PostConstruct
	public void onLoad() throws IOException {
		Util.createFolders();
		
		byte[] docInBytes = Util.docToByte("doc123.docx");
		Doc doc = new Doc("doc.docx", docInBytes);
		Doc docSaved = docRespository.save(doc);
		
		Util.bytesToDoc(docSaved.getDoc(), docSaved.getName());
		
		System.out.println(docSaved);
		
	}


	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleRedisApplication.class, args).close();
	}
}
