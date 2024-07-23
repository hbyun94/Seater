package mok.seater.store;

import mok.seater.store.dto.StoreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping(value = "/store/new")
    public String storeForm(Model model) {
        List<String> checkboxList = Arrays.asList("주차 가능", "콜키지 가능", "대관 가능", "발렛 가능", "반려동물 동반");

        model.addAttribute("checkboxList", checkboxList);

        model.addAttribute("title", "가게 정보 입력");
        model.addAttribute("description", "시터에 가게로 입점하기 위해서는 가게 정보 입력이 필요합니다.");
        return "store/storeForm";
    }

    @PostMapping(value = "/store/new")
    public void insert(@RequestBody StoreRequest storeRequest) {

        System.out.println(storeRequest.getStoreName());



        storeService.save(storeRequest);
    }

}
