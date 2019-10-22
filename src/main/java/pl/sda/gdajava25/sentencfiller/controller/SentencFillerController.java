package pl.sda.gdajava25.sentencfiller.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.gdajava25.sentencfiller.api.Randomizer;

@RestController
public class SentencFillerController {

    @Autowired
    private Randomizer randomizer;

    @GetMapping("/fill")
    public String fill(@RequestParam(name = "sentence", required = false) String sentence) {
        if (sentence != null) {

            while (sentence.contains("!!!")) {
                sentence = sentence.replaceFirst("!!!", getRandomNumber());
            }
            while (sentence.contains("@@@")) {
                sentence = sentence.replaceFirst("@@@", getRandomWord());
            }
            return sentence;
        }
        return "Proszę o podanie zdania do wypełnieniea";
    }

    private String getRandomNumber() {
        return randomizer.randomNumber();
    }

    private String getRandomWord() {
        return randomizer.randomWord();
    }
}
