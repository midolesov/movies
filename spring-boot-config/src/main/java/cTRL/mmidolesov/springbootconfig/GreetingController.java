package cTRL.mmidolesov.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("${my.list.values}") 
    private List<String> listValues;

    @Autowired
    private DbSettings dbSettings;

    @Autowired
    public Environment env;

    @GetMapping("/greeting")
    public String greeting(){
        return listValues + dbSettings.getConnection();
    }

    @GetMapping("/envdetails")
    public String envDetals(){
        return env.getProperty("");
    }

}
