package mok.seater.resv;

import mok.seater.resv.dto.ResvRequest;
import mok.seater.resv.dto.ResvResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ResvController {

    @Autowired
    private ResvService resvService;

    @GetMapping(value = {"/resvList"})
    public String resvList(Model model) {
        model.addAttribute("test", "model data kkkkk");
        return "resv/resvList";
    }

    @PostMapping("/resvs")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createResv() {
        resvService.createResv();

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "저장되었습니다");

        return ResponseEntity.ok(response);
    }

//    @GetMapping("/resvs")
//    @ResponseBody
//    public ResponseEntity<Map<String, Object>> getResv(String storeCd) {
//        List<ResvResponse> resvResponses = resvService.getResv(storeCd);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("success", true);
//        response.put("data", resvResponses);
//
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/resvs")
    public String getResvs(Model model, @RequestParam String storeCd) {
        List<ResvResponse> resvResponses = resvService.getResv(storeCd);
        model.addAttribute("resvList", resvResponses);
        model.addAttribute("storeCd", storeCd);
        return "resv/resvList";
    }


}
