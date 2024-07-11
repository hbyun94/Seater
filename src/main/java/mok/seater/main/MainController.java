package mok.seater.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@Slf4j
//@RequiredArgsConstructor
public class MainController {

    @GetMapping(value = {"/", "/main"})
    public String main(Model model) {
//        String returnUrl = mainService.returnUrlByUserGroup(sessionUser);
//        return "main".equals(returnUrl) ? returnUrl : "redirect:/" + returnUrl;
        return "main";
    }




    // 예제용
    @GetMapping(value = {"/index"})
    public String index(Model model) {
//        String returnUrl = mainService.returnUrlByUserGroup(sessionUser);
//        return "main".equals(returnUrl) ? returnUrl : "redirect:/" + returnUrl;
        return "index";
    }

}