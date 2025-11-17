package com.codeline.ccsb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        if (name.isEmpty()) {
            return "Hello Guest";
        }
        return "Hello " + name;
    }

    @GetMapping("/sum")
    public Integer sum(@RequestParam Integer a, @RequestParam Integer b) {

        return a + b;
    }

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        Map<String, String> newMap = new HashMap<>();
        newMap.put("Name", "Mulk");
        newMap.put("City", "Muscat");
        newMap.put("Language", "English");

        return newMap;
    }
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello " + name;
    }
    @GetMapping("/upper")
    public String upper(@RequestParam String name) {
        return name.toUpperCase();
    }
    @GetMapping("/random")
    public Integer random() {
        return new Random().nextInt(100)+1;
    }

}
