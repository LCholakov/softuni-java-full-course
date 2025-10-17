package main.web.resolver;

import main.model.Player;
import main.model.PlayerRole;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AdventurerHomeResolver implements HomeResolver {
    @Override
    public boolean supports(PlayerRole playerRole) {
        return playerRole.equals(PlayerRole.ADVENTURER);
    }

    @Override
    public String getViewName() {
        return "adventurer-home";
    }

    @Override
    public Map<String, Object> getModelData(Player player) {
        return Map.of();
    }
}
