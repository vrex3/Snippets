import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class SwaggerRedirectController {

	@GetMapping(value = { "/swagger", "/" })
	public String redirect() {
		return "redirect:/swagger-ui/";
	}
	
	//For older versions of swagger redirect to "redirect:/swagger-ui.html"
}
