package br.edu.ifpb.ads.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String openIndex() {
		
		return "index.html";
		
	}

}
