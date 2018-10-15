import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private int visiteurs;
    private List<Secteur> secteursAnimaux;


    public Zoo(int visiteurs) {
        this.visiteurs = visiteurs;
        this.secteursAnimaux = new ArrayList<Secteur>();
    }

    public void nouveauVisiteur() throws LimiteVisiteurException {

        if(visiteurs + 1 > 15){
            throw new LimiteVisiteurException();
        }
        else{
            visiteurs ++;
        }
    }

    public int getLimiteVisiteur(){
        return 15;
    }

    public void nouvelAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
        boolean var = false;

        for(Secteur secteur : secteursAnimaux){
            if(secteur.obtenirType().equals(animal.getTypeAnimal())){
                secteur.ajouterAnimal(animal);
                var = true;
            }
        }

        if(!var){
            secteursAnimaux.add(new Secteur(animal.getTypeAnimal()));
            secteursAnimaux.get(secteursAnimaux.size()-1).ajouterAnimal(animal);
        }
    }

    public int nombreAnimaux(){
        int somme = 0;
        for (Secteur secteur : secteursAnimaux) {
            somme += secteur.getNombreAnimaux();
        }
        return somme;
    }
}
