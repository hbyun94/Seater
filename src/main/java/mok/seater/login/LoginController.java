package mok.seater.login;

import mok.seater.join.JoinService;
import mok.seater.login.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired LoginService loginService;

    @GetMapping(value = { "/newLogin"})
    public String login(Model model) {
//        String returnUrl = mainService.returnUrlByUserGroup(sessionUser);
//        return "main".equals(returnUrl) ? returnUrl : "redirect:/" + returnUrl;
        model.addAttribute("title", "로그인");
        model.addAttribute("description", "로그인 정보를 입력해주세요.");

        return "login/newLogin";
    }

    @PostMapping(value = "/login/login")
    public String login(@RequestBody LoginRequest loginRequest) throws Exception {
        boolean validated = loginService.login(loginRequest);
        return validated ? "main" : "login/newLogin";
    }
}
