package loose.oose.fis.documents;

public class Fisier{

    private String nume,continut;
    private int id,nr_concat;
    private Fisier f;
    private static int contor;

    public Fisier(String n,String c)
    {
        nume=n;
        continut=c;
        contor++;
        id=contor;
        nr_concat=0;
    }
    public void salveazaVersiune()
    {
        Fisier g=new Fisier(nume+".bak",continut);
        if(f==null)
            f=g;
        else
        {
            g.f=this.f;
            this.f=g;
        }
    }
    public void concateneaza(Fisier x)
    {
        this.salveazaVersiune();
        continut=continut+x.continut;
        nr_concat++;
    }
    public String toString()
    {
        String ret=id+" "+nume+" [ "+continut+" ]";
        if(f!=null)
        {
            ret=ret+" < "+f.toString()+" > ";
        }
        return ret;
    }
    public int numarConcatenari()
    {
        return nr_concat;
    }
}
