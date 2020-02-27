package oc.projet.p6.Entity;

/**
 * Entite Research, correspond a l'entite cree lors d'une recherche multicritere pour selectionner les mots cles
 */
public class Research {

    private String country;

    private String region;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
