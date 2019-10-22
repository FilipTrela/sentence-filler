package pl.sda.gdajava25.sentencfiller.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("randomizing-machine")
public interface Randomizer {
    @GetMapping("/word")
    public String randomWord();

    @GetMapping("/number")
    public String randomNumber();
}