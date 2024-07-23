package mok.seater.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = { "/newLogin"})
    public String login(Model model) {
//        String returnUrl = mainService.returnUrlByUserGroup(sessionUser);
//        return "main".equals(returnUrl) ? returnUrl : "redirect:/" + returnUrl;
        model.addAttribute("title", "로그인");
        model.addAttribute("description", "로그인 정보를 입력해주세요.");

        return "login/newLogin";
    }
}
