package data;
import affichage.*;
import java.util.Vector;
import wr.*;
public class Gestion{
    Vector<Faritany> fart;
    public Gestion(Vector<Faritany> faritany){
        this.fart = faritany;
    }
    public Vector<String[]> donnessBureau(Vector<String[]> data, String nomBureau)
    {
        Vector<String[]> ret = new Vector<String[]>();
        for(int i = 0; i < data.size(); i++)
        {
            String[] datapiece = data.get(i);
            if(datapiece[3].equals(nomBureau))
            {
                ret.add(datapiece);
            }
        }
        return ret;
    }
        public Vector<String[]> donnessDistrict(Vector<String[]> data, String nomDistrict)
    {
        Vector<String[]> ret = new Vector<String[]>();
        for(int i = 0; i < data.size(); i++)
        {
            String[] datapiece = data.get(i);
            if(datapiece[2].equals(nomDistrict))
            {
                ret.add(datapiece);
            }
        }
        return ret;
    }
    public Vector<String[]> donnessFaritra(Vector<String[]> data, String nomFaritra)
    {
        Vector<String[]> ret = new Vector<String[]>();
        for(int i = 0; i < data.size(); i++)
        {
            String[] datapiece = data.get(i);
            if(datapiece[1].equals(nomFaritra))
            {
                ret.add(datapiece);
            }
        }
        return ret;
    }
    public Vector<String[]> donnessFaritany(Vector<String[]> data, String nomFaritany)
    {
        Vector<String[]> ret = new Vector<String[]>();
        for(int i = 0; i < data.size(); i++)
        {
            String[] datapiece = data.get(i);
            if(datapiece[0].equals(nomFaritany))
            {
                ret.add(datapiece);
            }
        }
        return ret;
    }
        public boolean estDans(Vector<String> All, String name)
    {
        for(String d : All)
        {
            if(d.equals(name))
            {
                return true;
            }
        }
        return false;
    }
    public Vector<String> getNomDeputes(Vector<String[]> alldata)
    {
        Vector<String> data = new Vector<String>();
        for(String[] datapiece : alldata)
        {
            if(!estDans(data, datapiece[4]))
            {
            data.add(datapiece[4]);
            Depute e = getDepute(datapiece[4]);
            if(e.getSecond() != null)
            {
                data.add(e.getSecond().getName()+"(Second de" + datapiece[4] +")");
            }
            }
            
        }
        return data;
    }
    public int getVoteDepute(Vector<String[]> alldata, String nomDepute)
    {
        int total = 0;
        for(String[] datapiece : alldata)
        {
            if(datapiece[4].equals(nomDepute))
            {
            total += Integer.parseInt(datapiece[5]);
            }
        }
        return total;
    }
    public Vector<Depute> getDeputes(String nomDistrict)
    {
        Vector<Depute> ret = new Vector<Depute>();
        for(Faritany farit : this.fart)
        {
            Vector<Faritra> F= farit.getFaritra();
            for(Faritra f : F)
            {
                Vector<District> D = f.getDistricts();
                for(District d : D)
                {
                    if(d.getName().equals(nomDistrict))
                    {
                        return d.getDeputes();
                    }
                }
            }
        }
        return new Vector<Depute>();
    }
        public District getDistrict(String nomDistrict)
    {
        Vector<Depute> ret = new Vector<Depute>();
        for(Faritany farit : this.fart)
        {
            Vector<Faritra> F= farit.getFaritra();
            for(Faritra f : F)
            {
                Vector<District> D = f.getDistricts();
                for(District d : D)
                {
                    if(d.getName().equals(nomDistrict))
                    {
                        return d;
                    }
                }
            }
        }
        return new District("vide", 0);
    }
        public Depute getDepute(String nomDepute)
    {
        Vector<Depute> ret = new Vector<Depute>();
        for(Faritany farit : this.fart)
        {
            Vector<Faritra> F= farit.getFaritra();
            for(Faritra f : F)
            {
                Vector<District> D = f.getDistricts();
                for(District d : D)
                {
                    Vector<Depute> dep = d.getDeputes();
                    for(Depute de : dep)
                    {
                        if(de.getName().equals(nomDepute))
                        {
                            return de;
                        }
                    }
                }
            }
        }
        return new Depute("vide");
    }
    public Vector<Depute> getElus( String nomDistrict)
    {
        Vector<String[]> alldata = Lecture.Lire("donneesVote.nh");
        Vector<String[]> data = donnessDistrict(alldata, nomDistrict);
        Vector<String> noms = getNomDeputes(data);
        Vector<Integer> votes = new Vector<Integer>();
        for(int i = 0; i < noms.size(); i++)
        {
            votes.add(getVoteDepute(data, noms.get(i)));
        }
        for(int i = 0; i<votes.size(); i++)
        {
            for(int j = 0; j<votes.size() -1 ; j++)
            {
                if(votes.get(j) < votes.get(j+1))
                {
                    int temp = votes.get(j+1);
                    votes.set(j+1, votes.get(j));
                    votes.set(j, temp);

                    String Stemp = noms.get(j+1);
                    noms.set(j+1, noms.get(j));
                    noms.set(j, Stemp);
                }
            }
        }
        District douze = getDistrict(nomDistrict);
        if(douze.getnombreElus()==2 && votes.size() >= 2)
        {
        if(2*votes.get(1) < votes.get(0))
        {
            Depute d = getDepute(noms.get(0)).getSecond();
            noms.add(1, d.getName());
        }
        Vector<Depute> ret = new Vector<Depute>();
        ret.add(getDepute(noms.get(0)));
        ret.add(getDepute(noms.get(1)));
        return ret;
        }
        else if(douze.getnombreElus()==1)
        {
        Vector<Depute> ret = new Vector<Depute>();
        ret.add(getDepute(noms.get(0)));
        return ret;
        }
        return new Vector<Depute>();
    }
    public Vector<Depute> getAllElus()
    {
        Vector<Depute> All = new Vector<Depute>();
        for(int i = 0; i < fart.size() && fart.get(i) != null; i++)
        {
        Vector<Faritra> F= fart.get(i).getFaritra();
        for(Faritra f : F)
            {
                Vector<District> D = f.getDistricts();
                for(District d : D)
                {
                    Vector<Depute> dep = getElus(d.getName());
                    for(Depute de : dep)
                    {
                        All.add(de);
                        
                    }
                }
            }
        }
        return All;
    }

}