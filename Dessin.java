package affichage;
import javax.swing.*;

import data.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Dessin extends JPanel{
    private Classement c;

    private Vector<String[]> data;
    public Dessin() {
        data = new Vector<String[]>();
    }
        public Dessin(Classement a) {
        this.c = a;
        data = new Vector<String[]>();
    }
    public Dessin(Vector<String[]> data) {
        this.data = data;
    }
    public Dessin(Classement c, Vector<String[]> data) {
        this.c = c; 
        this.data = data;
    }
    public void setData(Vector<String[]> data)
    {
        this.data = data;
    }
    public void dessinerTableau(Graphics2D g)
    {
        int y = 100; int x = 50;
        Gestion ge = new Gestion(c.getFaritany());
        String[] headers = new String[] {"Depute", "Nombre Vote"};
        for(int i = 0 ; i < 2; i++)
        {
            g.drawRect(x, y, 150, 50);
            g.drawString(headers[i], x+60, y + 20);
            x += 150;
        }
        y += 50;

        Vector<String> noms = ge.getNomDeputes(data);
        Vector<Integer> votes = new Vector<Integer>();
        for(int i = 0; i < noms.size(); i++)
        {
            votes.add(ge.getVoteDepute(data, noms.get(i)));
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
        Vector<Depute> all = ge.getAllElus();
        String droit = "1";
        for(String nom : noms){
                    for(Depute d: all)
        {
            Depute t = ge.getDepute(nom);
                    String detail = "";
                    for(Depute r : all)
                    {
                        if(r.getSecond() != null)
                        {
                            if(r.getSecond().getName().equals(t.getName()))
                            {
                                detail = "2";
                            }
                        }
                    }
        }
        }

        for(String nom : noms)
        {
            for(Depute d : all)
            {
                if(d.getName().equals(nom))
                {
                    Depute t = ge.getDepute(nom);
                    String detail = "";
                    for(Depute r : all)
                    {
                        if(r.getSecond() != null)
                        {
                            if(r.getSecond().getName().equals(t.getName()))
                            {
                                detail = "(Second de " + r.getName() +")";
                            }
                        }
                    }
                    x=50;
                    g.drawRect(x, y, 150, 50);
                    g.drawString(nom, x+60, y + 20);
                    g.drawString(droit , x+80, y + 20);


                    x += 150;
                    
                    g.drawRect(x, y, 150, 50);
                    g.drawString(detail+ge.getVoteDepute(data, nom), x+60, y + 20);
                    y += 50;


                }
            }
            
        }
        
    }
    public void paint(Graphics gp) {
        super.paint(gp);
        Graphics2D g = (Graphics2D) gp;
        g.setColor(Color.BLACK);
        dessinerTableau(g);
    }
}
