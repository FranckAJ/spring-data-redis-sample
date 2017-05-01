package br.edu.ifpb.ads.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.edu.ifpb.ads.entity.Doc;
import br.edu.ifpb.ads.service.DocService;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */

@RestController
@RequestMapping("/api/upload")
public class DocRestService {

	@Autowired
	private DocService docService;

	@PostMapping
	public ResponseEntity<?> saveFile(@RequestParam("file") MultipartFile file) throws IOException {
		byte[] docInBytes = file.getBytes();
		if (!file.isEmpty()) {
			Doc document = new Doc(file.getOriginalFilename(), docInBytes);
			docService.save(document);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
