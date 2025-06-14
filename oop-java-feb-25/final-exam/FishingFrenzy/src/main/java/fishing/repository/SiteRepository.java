package fishing.repository;

import fishing.entity.site.Site;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SiteRepository implements Repository<Site>{
    Collection<Site> sites;

    public SiteRepository() {
        sites = new ArrayList<>();
    }

    @Override
    public Collection<Site> getCollection() {
        return sites;
    }

    @Override
    public void add(Site site) {
        sites.add(site);
    }

    @Override
    public boolean remove(Site site) {
        return sites.remove(site);
    }

    @Override
    public Site byName(String name) {
        return sites.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst().orElse(null);
    }
}
