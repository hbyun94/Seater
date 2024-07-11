package mok.seater.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {




    @GetMapping(value = {"/adminForm"})
    public String adminForm(Model model) {
//        String returnUrl = mainService.returnUrlByUserGroup(sessionUser);
//        return "main".equals(returnUrl) ? returnUrl : "redirect:/" + returnUrl;
        return "admin/adminForm";
    }
}
