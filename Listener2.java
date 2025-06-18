package affichage;

import java.util.*;
import wr.*;
import data.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.awt.*;
public class Listener2 implements MouseMotionListener,MouseListener
{

    Classement f;

    public Listener2(Classement f)
    {
        this.f = f;
        
    }
	public void mouseEntered(MouseEvent e) {
		
	}
	 
	 public void mouseExited(MouseEvent e) {
		
	 }
	 
	 public void mousePressed(MouseEvent e) 
	 {
		
	 }
	 
	 public void mouseReleased(MouseEvent e) 
	 {
		
	 }
        public void mouseClicked(MouseEvent e) {
			Vector<Faritany> fart =f.getFaritany();
        Faritany faritany = f.getSelectedFaritany();
        Faritra faritra = f.getSelectedFaritra();
        District district = f.getSelectedDistrict();
        BureauVote bureauVote = f.getSelectedBureauVote();
		Gestion g = new Gestion(fart);
		Vector<String[]> alldata = Lecture.Lire("donneesVote.nh");
        if (bureauVote != null ) {
            Vector<String[]> data = g.donnessBureau(alldata, bureauVote.getName());
			Vector<String> noms = g.getNomDeputes(data);
			for(String nom : noms)
			{
				System.out.println(nom + " " + g.getVoteDepute(data, nom));
			}
			System.out.println("------------------");
			f.getPanelDessin().setData(data);
			f.getPanelDessin().repaint();

        }
		if (district!= null && bureauVote == null) {
            Vector<String[]> data = g.donnessDistrict(alldata, district.getName());
			Vector<String> noms = g.getNomDeputes(data);
			for(String nom : noms)
			{
				System.out.println(nom + " " + g.getVoteDepute(data, nom));
			}
			System.out.println("------------------");
			f.getPanelDessin().setData(data);
			f.getPanelDessin().repaint();
        }
			if (faritra != null && district == null && bureauVote == null) {
            Vector<String[]> data = g.donnessFaritra(alldata, faritra.getName());
			Vector<String> noms = g.getNomDeputes(data);
			for(String nom : noms)
			{
				System.out.println(nom + " " + g.getVoteDepute(data, nom));
			}
			System.out.println("------------------");
			f.getPanelDessin().setData(data);
			f.getPanelDessin().repaint();

        }
		if (faritany != null && faritra == null && district == null && bureauVote == null) {
            Vector<String[]> data = g.donnessFaritany(alldata, faritany.getName());
			Vector<String> noms = g.getNomDeputes(data);
			for(String nom : noms)
			{
				System.out.println(nom + " " + g.getVoteDepute(data, nom));
			}
			System.out.println("------------------");
			f.getPanelDessin().setData(data);
			f.getPanelDessin().repaint();

        }
    }
	 public void mouseMoved(MouseEvent e) 
	 {
		
	 }
	 public void mouseDragged(MouseEvent e) {
         
	}
}