package loose.oose.fis.documents;

public class Cabinet {
    private String numeAvocat;
    private int numarCazuri = 0;
    private String [] titluCazuri = new String [40];
    public Cabinet (String numeAvocat) {
        this.numeAvocat = numeAvocat;
    }
    public void adaugaCaz (String reclamant, String acuzat) {
        if (numarCazuri < titluCazuri.length) {
            titluCazuri[numarCazuri] = reclamant + " vs " + acuzat;
            numarCazuri++;
        }
    }
    public Cabinet formeazaAlianta (Cabinet param) {
        int k = 0;
        if (this.numarCazuri + param.numarCazuri < titluCazuri.length) {
            Cabinet alianta = new Cabinet (this.numeAvocat + " - " +param.numeAvocat);
            for (int i = 0; i < this.numarCazuri; i++) {
                alianta.titluCazuri[i] = this.titluCazuri[i];
            }
            for (int i = this.numarCazuri; i < this.numarCazuri + param.numarCazuri; i++) {
                alianta.titluCazuri[i] = param.titluCazuri[k];
                k++;
            }
            alianta.numarCazuri = this.numarCazuri + param.numarCazuri;
            return alianta;
        }
        return null;
    }
    public String toString () {
        String output = numeAvocat + "\n";
        for (int  i = 0; i < numarCazuri; i++) {
            output += titluCazuri[i] +  " / ";
        }
        return output;
    }
}

