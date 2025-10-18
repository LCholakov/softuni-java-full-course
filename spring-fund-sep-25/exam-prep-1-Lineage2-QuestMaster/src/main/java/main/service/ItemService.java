package main.service;

import main.model.Item;
import main.model.Player;
import main.repository.ItemRepository;
import main.web.dto.ItemCreateRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAllByOrderByCreatedOnDescXpBonusMultiplierDesc(); // Placeholder return
    }

    public void create(ItemCreateRequest itemCreateRequest, Player player) {
        Item item = Item.builder()
                .name(itemCreateRequest.getName())
                .type(itemCreateRequest.getItemType())
                .xpBonusMultiplier(itemCreateRequest.getXpBonusMultiplier())
                .iconUrl(itemCreateRequest.getUrl())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .createdBy(player.getNickname())
                .updatedBy(player.getNickname())
                .build();
        itemRepository.save(item);
    }

    public Item getById(UUID itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item with id " + itemId + " not found."));
    }
}
