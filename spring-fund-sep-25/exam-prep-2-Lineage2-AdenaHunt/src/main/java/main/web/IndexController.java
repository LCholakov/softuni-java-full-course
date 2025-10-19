package main.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import main.model.Mob;
import main.model.Player;
import main.property.ClassProperties;
import main.property.ClassProperties.Booster;
import main.service.MobService;
import main.service.PlayerService;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {
    private final PlayerService playerService;
    private final MobService mobService;

    @Autowired
    public IndexController(PlayerService playerService, MobService mobService) {
        this.playerService = playerService;
        this.mobService = mobService;
    }

    @GetMapping
    public String getIndexPage(){

        return "index";
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
        Player player = playerService.login(loginRequest);
        session.setAttribute("user_id", player.getId());

        System.out.println();
        return new ModelAndView("redirect:/lobby");
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

        playerService.createNewPlayer(registerRequest);

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/lobby")
    public ModelAndView getLobby(HttpSession session, Model model) {
        ModelAndView modelAndView = new ModelAndView("lobby");

        UUID playerId = (UUID) session.getAttribute("user_id");
        Player player = playerService.getById(playerId);
        List<Booster> boosters = playerService.getBoosters(player.getPlayerClass());
        List<Mob> top3Mobs = mobService.findTop3Mobs();
        List<Player> partyMembers = playerService.findAllByParty(player.getParty());
        List<Player> freePlayers = playerService.findAllFreePlayersForInvite(player);

        modelAndView.addObject("player", player);
        modelAndView.addObject("boosters", boosters);
        modelAndView.addObject("mobs", top3Mobs);
        modelAndView.addObject("partyMembers", partyMembers);
        modelAndView.addObject("freePlayers", freePlayers);

        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
//
//    @GetMapping("/farm-zone")
//    public String getFarmZone() {
//        return "farm-zone";
//    }
}
