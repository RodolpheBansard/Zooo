import java.util.ArrayList;
import java.util.List;

public class Secteur {
    private String typeAnimauxDansSecteur;
    private List<Animal> animauxDansSecteur;

    public Secteur(String typeAnimauxDansSecteur) {
        this.typeAnimauxDansSecteur = typeAnimauxDansSecteur;
        this. animauxDansSecteur = new ArrayList<Animal>();
    }

    public void ajouterAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {

        if(!animal.getTypeAnimal().equals(obtenirType())){
            throw new AnimalDansMauvaisSecteurException();
        }else{
            animauxDansSecteur.add(animal);
        }
    }

    public int getNombreAnimaux(){
        return this.animauxDansSecteur.size();
    }

    public String obtenirType(){
        return this.typeAnimauxDansSecteur;
    }

}
