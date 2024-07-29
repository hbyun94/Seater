package mok.seater.store;

import mok.seater.store.dto.StoreRequest;
import mok.seater.store.dto.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/store/list")
    public String storeList(Model model) {
        List<StoreResponse> storeList = storeService.list();
        model.addAttribute("storeList", storeList);

        System.out.println("Store List: " + storeList);

        model.addAttribute("title", "가게 목록");
        model.addAttribute("description", "시터에 입점한 가게 목록입니다.");

        return "store/storeList";
    }

    @GetMapping(value = "/store/new")
    public String storeForm(Model model) {
        List<String> checkboxList = Arrays.asList("주차 가능", "콜키지 가능", "대관 가능", "발렛 가능", "반려동물 동반");

        model.addAttribute("checkboxList", checkboxList);

        model.addAttribute("title", "가게 정보 입력");
        model.addAttribute("description", "시터에 가게로 입점하기 위해서는 가게 정보 입력이 필요합니다.");
        return "store/storeForm";
    }

    @PostMapping(value = "/store/new")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody StoreRequest storeRequest) {
        storeService.save(storeRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "저장되었습니다");

        return ResponseEntity.ok(response);
    }


}
