package mok.seater.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


// dd

    @GetMapping(value = {"/adminForm"})
    public String adminForm(Model model) {
//        String returnUrl = mainService.returnUrlByUserGroup(sessionUser);
//        return "main".equals(returnUrl) ? returnUrl : "redirect:/" + returnUrl;

        model.addAttribute("title", "가게 정보 입력");
        model.addAttribute("description", "시터에 가게로 입점하기 위해서는 가게 정보 입력이 필요합니다.");
        return "admin/adminForm";
    }
}
