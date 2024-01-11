package ru.arkhipov.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    private List<String> arrayList = new ArrayList<>();
    private Map<Integer, String> hashMap = new HashMap<>();

    @GetMapping("/hello")
    public String hello (@RequestParam(value = "name",
    defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s",
            defaultValue = "") String s) {
        if (arrayList.isEmpty()) {
            arrayList.add(s);
        } else {
            arrayList.set(0, s);
        }
        return "Value added to ArrayList: " + s;
    }

    @GetMapping("/show-array")

    public List<String> showArrayList() {
        return arrayList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s") String s) {
        if (hashMap.isEmpty()) {
            hashMap.put(1, s);
        }
        else { hashMap.put(hashMap.keySet().stream().max(Integer::compareTo).get() + 1, s);
        }  return "Value added to HashMap: " + s;
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return hashMap;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int arrayListLength = arrayList.size();
        int hashMapLength = hashMap.size();

        return "ArrayList Length: " + arrayListLength + "\nHashMap Length: " + hashMapLength;
    }
}




