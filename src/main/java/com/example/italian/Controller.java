package com.example.italian;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.Random;

@RestController
public class Controller {

    private final Repository repository;


    public Controller(Repository repository) {
        this.repository = repository;

    }

  

    Random random = new Random();
    int id = random.nextInt(111);


    @GetMapping(path = "/question")
    public @ResponseBody
    String getQuestion() {
        if (id == 0) {
            id++;
        }

        Optional<Italian> italian = repository.findById(id);
        String question = "";
        if (italian.isPresent()) {
            Italian italian1 = italian.get();
            question = italian1.getDescription();
        }
        return question;
    }

    @GetMapping(path = "/answer")
    public @ResponseBody
    String getAnswer() {
        if (id == 0) {
            id++;
        }
        Optional<Italian> italian = repository.findById(id);
        String answer = "";
        if (italian.isPresent()) {
            Italian italian1 = italian.get();
            answer = italian1.getName();
        }
        return answer;
    }
}
