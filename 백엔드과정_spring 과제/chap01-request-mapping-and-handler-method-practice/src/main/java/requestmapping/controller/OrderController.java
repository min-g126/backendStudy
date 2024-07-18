package requestmapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import requestmapping.OrderDTO;

@Controller
@SessionAttributes("nickName")
public class OrderController {
    @PostMapping("/orders")
    public String order(OrderDTO orderDTO, Model model){
        model.addAttribute("order", orderDTO);
        return "confirm";
    }
}
