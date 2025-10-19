package main.web;

import jakarta.servlet.http.HttpSession;
import main.service.SpellService;
import main.service.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/spells")
public class SpellController {

    private final WizardService wizardService;
    private final SpellService spellService;

    @Autowired
    public SpellController(WizardService wizardService, SpellService spellService) {
        this.wizardService = wizardService;
        this.spellService = spellService;
    }

    @PostMapping
    public String learnSpell(@RequestParam("spellCode") String spellCode, HttpSession session) {
        UUID wizardId = (UUID) session.getAttribute("user_id");
        if (wizardId == null) {
            return "redirect:/login";
        }

        wizardService.learnSpell(wizardId, spellCode);
        return "redirect:/home";
    }
}
