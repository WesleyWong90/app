package royalstacks.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import royalstacks.app.service.RecordGenerator;

@Controller
public class HomepageController {

    @GetMapping(value ={ "" , "/", "/doLogin"})
    public ModelAndView startHandler() {
        return new ModelAndView("homepage");
    }
}
