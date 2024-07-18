package requestmapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("nickName")
public class MainController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/main")
    public String sessionLogin(Model model, @RequestParam String nickName) {

        model.addAttribute("nickName", nickName);

        return "main";
    }
    @GetMapping("/main")
    public String sessionLogin() {
        return "main";
    }
}
