package mok.seater.join;

import mok.seater.join.dto.JoinRequest;
import mok.seater.store.dto.StoreRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping(value = { "/join"})
    public String join(Model model) {
//        String returnUrl = mainService.returnUrlByUserGroup(sessionUser);
//        return "main".equals(returnUrl) ? returnUrl : "redirect:/" + returnUrl;
        model.addAttribute("title", "회원가입");
        model.addAttribute("description", "회원가입 정보를 입력해주세요.");

        return "join/join";
    }

    @PostMapping(value = "/join/new")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody JoinRequest joinRequest) {
        joinService.save(joinRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "회원가입 완료되었습니다.");

        return ResponseEntity.ok(response);
    }
}
