package Model;

public class Animal {
    private String nume;
    private String specie;
    private String alimentatie;
    private String habitat;

    public Animal() {
    }

    public Animal(String nume, String specie, String alimentatie, String habitat) {
        this.nume = nume;
        this.specie = specie;
        this.alimentatie = alimentatie;
        this.habitat = habitat;
    }

    public Animal (Animal animal){
        new Animal(animal.getNume(),animal.getSpecie(),animal.getHabitat(),animal.getAlimentatie());
    }

    public String getNume() {
        return nume;
    }

    public String getSpecie() {
        return specie;
    }

    public String getAlimentatie() {
        return alimentatie;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void setAlimentatie(String alimentatie) {
        this.alimentatie = alimentatie;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String[] toStringAn() {
        return new String[]{nume, specie,alimentatie,habitat};
    }
}
