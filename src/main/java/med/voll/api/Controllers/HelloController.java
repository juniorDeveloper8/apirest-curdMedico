package med.voll.api.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/hello")
public class HelloController {
  
  @GetMapping
  public String helloWord(){
    return "Hello World";
  }
  
}
