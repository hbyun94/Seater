package mok.seater.store;

import mok.seater.store.dto.StoreRequest;
import mok.seater.store.dto.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/store/save")
    public ResponseEntity<Map<String, Object>> save(@RequestBody StoreRequest storeRequest) {
        storeService.save(storeRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "저장되었습니다");

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/store/detail/{id}")
    public String storeDetail(@PathVariable("id") Long id, Model model) {
        StoreResponse store = storeService.getStore(id);
        model.addAttribute("store", store);
        model.addAttribute("title", "가게 정보 수정");
        model.addAttribute("description", "시터에 가게로 입점하기 위해서는 가게 정보 입력이 필요합니다.");
        return "store/storeForm";
    }

    @PostMapping(value = "/store/delete")
    public ResponseEntity<Map<String, Object>> delete(@RequestBody Map<String, Object> requestBody) {
        Long id = Long.valueOf((String) requestBody.get("id"));
        storeService.updateDelYn(id);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "삭제되었습니다");

        return ResponseEntity.ok(response);
    }

}
