package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Spell;
import main.model.Wizard;
import main.service.WizardService;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {

    // TODO: Implement the necessary here.

    private final WizardService wizardService;

    public IndexController(WizardService wizardService) {
        this.wizardService = wizardService;
    }


    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("registerRequest", new RegisterRequest());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid RegisterRequest registerRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("register", "registerRequest", registerRequest);
        }

        wizardService.createNewWizard(registerRequest);

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("loginRequest", new LoginRequest());

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(LoginRequest loginRequest, BindingResult bindingResult, HttpSession session) {
        Wizard wizard = wizardService.login(loginRequest);
        session.setAttribute("user_id", wizard.getId());

        System.out.println();
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home")
    public ModelAndView getHome(HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("home");

        UUID wizardId = (UUID) session.getAttribute("user_id");
        Wizard wizard = wizardService.getWizardById(wizardId);
        List<Spell> learnedSpells = wizard.getSpells().stream()
                .sorted(Comparator.comparing(Spell::getPower).reversed())
                .toList();
        List<Spell> availableSpells = wizardService.getAvailableSpells(wizard);
        List<Spell> lockedSpells = wizardService.getLockedSpells(wizard);


        modelAndView.addObject("wizard", wizard);
        modelAndView.addObject("learnedSpells", learnedSpells);
        modelAndView.addObject("availableSpells", availableSpells);
        modelAndView.addObject("lockedSpells", lockedSpells);

        return modelAndView;
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
