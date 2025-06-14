package fishing.core;

import fishing.common.ConstantMessages;
import fishing.common.ExceptionMessages;
import fishing.entity.fisherman.AmateurFisherman;
import fishing.entity.fisherman.Fisherman;
import fishing.entity.fisherman.SkilledFisherman;
import fishing.entity.fishing.Fishing;
import fishing.entity.fishing.FishingImpl;
import fishing.entity.site.Site;
import fishing.entity.site.SiteImpl;
import fishing.repository.Repository;
import fishing.repository.SiteRepository;

import java.util.Collection;

//TODO - Implement all the methods
public class ControllerImpl implements Controller {
    private Repository<Site> sitesRepository;

    public ControllerImpl() {
        sitesRepository = new SiteRepository();
    }

    @Override
    public String addSite(String siteType, String siteName, int quota) {
        if(quota < 0) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_QUOTA_CANNOT_BE_NEGATIVE);
        }
        if(sitesRepository.byName(siteName) != null) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_SITE);
        }
        Site site = new SiteImpl(siteName, siteType, quota);
        sitesRepository.add(site);

        return String.format(ConstantMessages.SITE_ADDED, siteName, siteType);
    }

    @Override
    public String addFisherman(String siteName, String fishermanType, String fishermanName) {
        Site site = sitesRepository.byName(siteName);
        Fisherman fman = site.getFishermen()
                .stream().filter(fm -> fm.getName().equals(fishermanName))
                .findFirst().orElse(null);

        if(fman != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_FISHERMAN, fishermanName));
        }
        switch (fishermanType) {
            case "AmateurFisherman": fman = new AmateurFisherman(fishermanName);
                break;
            case "SkilledFisherman": fman = new SkilledFisherman(fishermanName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FISHERMAN);
        }
        site.getFishermen().add(fman);

        return String.format(ConstantMessages.FISHERMAN_ADDED, fishermanType, fishermanName);
    }

    @Override
    public String goFishing(String siteName) {
        Site site = sitesRepository.byName(siteName);
        if(site == null) {
            throw new NullPointerException(String.format(ExceptionMessages.NON_EXISTING_SITE, siteName));
        }
        Collection<Fisherman> fisherMen = site.getFishermen();
        Fishing fishing = new FishingImpl();
        fishing.startFishing(site);

        if(site.getQuota() > 0) {
            return String.format(ConstantMessages.FISHING_SITE, siteName, site.getType(), site.getQuota());
        }

        return String.format(ConstantMessages.NO_MORE_FISH_ALLOWED, siteName, site.getType());
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        Collection<Site> sites = sitesRepository.getCollection();

        for(Site s : sites) {
            sb.append(String.format(ConstantMessages. FINAL_FISHING_SITE_INFO, s.getName(), s.getType()))
                    .append(System.lineSeparator());
            for (Fisherman fman : s.getFishermen()) {
                sb.append(String.format("Name: %s", fman.getName())).append(System.lineSeparator());
                sb.append(String.format("Bait left: %s", fman.getBait())).append(System.lineSeparator());
                sb.append(String.format("Caught fishes: %s", fman.getHarvest())).append(System.lineSeparator());


            }

        }


        return sb.toString();
    }
}
