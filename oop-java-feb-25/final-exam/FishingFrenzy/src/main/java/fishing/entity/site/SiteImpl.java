package fishing.entity.site;

import fishing.common.ExceptionMessages;
import fishing.entity.fisherman.Fisherman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SiteImpl implements Site{
    private String name;
    private String type;
    private int quota;
    private Collection<Fisherman> fishermen;

    public SiteImpl(String name, String type, int quota) {
        this.name = name;
        this.type = type;
        this.quota = quota;
        fishermen = new ArrayList<>();
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Fisherman> getFishermen() {
        return fishermen;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getQuota() {
        return quota;
    }

    @Override
    public void reduceQuota() {
        --quota;
    }
}
