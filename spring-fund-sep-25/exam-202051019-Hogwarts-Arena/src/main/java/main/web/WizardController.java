package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.*;
import main.model.Wizard;
import main.service.WizardService;
import main.web.dto.EditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/profile")
public class WizardController {

    private final WizardService wizardService;

    @Autowired
    public WizardController(WizardService wizardService) {
        this.wizardService = wizardService;
    }

    @GetMapping
    public ModelAndView getProfilePage(HttpSession session) {
        UUID wizardId = (UUID) session.getAttribute("user_id");
        Wizard wizard = wizardService.getWizardById(wizardId);

        EditRequest editRequest = EditRequest.builder()
                .username(wizard.getUsername())
                .avatarUrl(wizard.getAvatarUrl())
                .build();

        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("editRequest", editRequest);
        modelAndView.addObject("wizard", wizard);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView editProfile(@Valid @ModelAttribute("editRequest") EditRequest editRequest, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            UUID wizardId = (UUID) session.getAttribute("user_id");
            Wizard wizard = wizardService.getWizardById(wizardId);

            ModelAndView modelAndView = new ModelAndView("profile");
            modelAndView.addObject("wizard", wizard);
            return modelAndView;
        }

        UUID wizardId = (UUID) session.getAttribute("user_id");
        wizardService.updateWizardProfile(wizardId, editRequest);

        return new ModelAndView("redirect:/home");
    }

    @PatchMapping("/dark-alignment")
    public ModelAndView changeToLightAlignment(HttpSession session) {
        UUID wizardId = (UUID) session.getAttribute("user_id");
        wizardService.changeWizardAlignmentToDark(wizardId);
        return new ModelAndView("redirect:/profile");
    }

}
