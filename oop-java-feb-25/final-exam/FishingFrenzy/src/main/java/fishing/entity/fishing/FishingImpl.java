package fishing.entity.fishing;

import fishing.entity.fisherman.Fisherman;
import fishing.entity.site.Site;

import java.util.ArrayList;
import java.util.List;

public class FishingImpl implements Fishing{

    @Override
    public void startFishing(Site site) {
        List<Fisherman> fishermen = new ArrayList<>(site.getFishermen());

        for (Fisherman fman : fishermen) {
            while (site.getQuota() > 0 && fman.getBait() > 0) {
                fman.fishing();
                site.reduceQuota();
            }
        }
    }
}
