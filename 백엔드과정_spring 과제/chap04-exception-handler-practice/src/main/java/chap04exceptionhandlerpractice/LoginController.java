package chap04exceptionhandlerpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (!(username.equals("user01") && password.equals("pass01"))) {
            throw new InvalidCredentialsException("에러발생");
        }
        return "redirect:/main";
    }
}
