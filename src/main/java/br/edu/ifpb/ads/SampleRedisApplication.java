package br.edu.ifpb.ads;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import br.edu.ifpb.ads.entity.Doc;
import br.edu.ifpb.ads.repository.DocRespository;

@EnableRedisRepositories
@SpringBootApplication
public class SampleRedisApplication {

	@Autowired
	private DocRespository docRespository;
	
	private Doc doc = new Doc("JUSA", "image".getBytes());
	
	/**
	 * 
	 */
	@PostConstruct
	public void onLoad() {
		
		Doc docSaved = docRespository.save(doc);
		
		System.out.println(docSaved);
		
	}


	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleRedisApplication.class, args).close();
	}
}
