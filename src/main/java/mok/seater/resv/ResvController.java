package mok.seater.resv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResvController {
    @GetMapping(value = {"/resvList"})
    public String resvList(Model model) {
        model.addAttribute("test", "model data kkkkk");
        return "resv/resvList";
    }
}
