//package ExamPrep.Geoglyphs;
package geoglyphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Location {
    String name;
    Collection<Geoglyph> geoglyphs;

    public Location(String name) {
        this.name = name;
        geoglyphs = new ArrayList<>();
    }

    public String addGeoglyph(Geoglyph geoglyph) {
        if (geoglyphs.contains(geoglyph)) {
            throw new IllegalArgumentException(ConstantMessages.EXISTING_GEOGLYPH);
        }
        geoglyphs.add(geoglyph);
        return String.format(ConstantMessages.GEOGLYPH_ADDED, geoglyph.getName(), this.name);
    }

    public boolean removeGeoglyph(String name) {
        return geoglyphs.removeIf(g -> g.getName().equals(name));
//        for (int i = 0; i < geoglyphs.size(); i++) {
//            if (geoglyphs.get(i).getName().equals(name)) {
//                geoglyphs.remove(i);
//                return true;
//            }
//        }
//        return false;  // this will need some reworking
    }

    public String getGeoglyphsByConstructionTechnique(String constructionTechnique) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Geoglyphs made by %s: ", constructionTechnique));
        boolean randomFlag = false;
        for (Geoglyph g : geoglyphs) {
            if(g.getConstructionTechnique().equals(constructionTechnique)) {
                result.append(g.getName() + ", ");
                randomFlag = true;
            }
        }
        if (randomFlag)
            return result.substring(0, result.length() - 2);
        else
            return String.format(ConstantMessages.NO_GEOGLYPHS_BY_TECHNIQUE, constructionTechnique);
    }

    public String getLargestGeoglyph() {
        String resultName = "";
        int resultSize = Integer.MIN_VALUE;
        for (Geoglyph g : geoglyphs) {
            if (g.getSize() > resultSize) {
                resultName = g.getName();
                resultSize = g.getSize();
            }
        }
        return String.format(ConstantMessages.LARGEST_GEOGLYPH, resultName, resultSize);
    }

    public Geoglyph getGeoglyphByName(String name) {
        Geoglyph result = null;
        for (Geoglyph g : geoglyphs) {
            if (g.getName().equals(name)) {
                result = g;
            }
        }
        return result;
    }

    public int getCount() {
        return geoglyphs.size();
    }

    public String getStatistics() {
        if (geoglyphs.isEmpty()) {
            return String.format(ConstantMessages.NO_GEOGLYPHS_DISCOVERED, name);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(ConstantMessages.GEOGLYPHS_IN_LOCATION, name)).append(System.lineSeparator());
            for (Geoglyph g : geoglyphs) {
                sb.append("* ").append(g.getName()).append("\n");
            }
            return sb.toString();
        }
    }
}
