package dev.mvc.calc;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
  // 3가지 주소 접속을 허용
  // http://localhost:9090/calc/index.do
	// http://localhost:9090/calc
  // http://localhost:9090/calc/
	@RequestMapping(value = {"/", "/index.do"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "index"; // /WEB-INF/views/index.jsp의 반환
	}
}
