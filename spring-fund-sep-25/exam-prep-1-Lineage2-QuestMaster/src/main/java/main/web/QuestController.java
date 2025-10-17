package main.web;

import main.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quests")
public class QuestController {
    private final QuestService questService;


    public QuestController(QuestService questService) {
        this.questService = questService;
    }
}
