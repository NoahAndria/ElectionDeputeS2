package affichage;

import java.util.*;
import wr.*;
import data.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.awt.*;
public class Listener1 implements MouseMotionListener,MouseListener
{

    Fenetre f;

    public Listener1(Fenetre f)
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
        Faritany faritany = f.getSelectedFaritany();
        Faritra faritra = f.getSelectedFaritra();
        District district = f.getSelectedDistrict();
        BureauVote bureauVote = f.getSelectedBureauVote();
        Depute depute = f.getSelectedDepute();
        String nbVote = f.getNbVote();

        if (faritany != null && faritra != null && district != null && bureauVote != null && depute != null && !nbVote.isEmpty()) {
            Ecriture.ecrirefichier("donneesVote.nh", faritany, faritra, district,bureauVote, depute, Integer.parseInt(nbVote));
        }
    }
	 public void mouseMoved(MouseEvent e) 
	 {
		
	 }
	 public void mouseDragged(MouseEvent e) {
         
	}
}