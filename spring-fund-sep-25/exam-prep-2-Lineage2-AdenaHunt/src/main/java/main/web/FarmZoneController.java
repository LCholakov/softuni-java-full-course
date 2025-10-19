package main.web;

import jakarta.servlet.http.HttpSession;
import main.model.Player;
import main.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/farm-zone")
public class FarmZoneController {

    private final PlayerService playerService;

    public FarmZoneController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping
    public ModelAndView getFarmZone(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("farm-zone");

        UUID playerId = (UUID) session.getAttribute("user_id");
        Player player = playerService.getById(playerId);

        modelAndView.addObject("playerAdena", player.getAdena());

        return modelAndView;
    }


}
