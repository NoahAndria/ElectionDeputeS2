package affichage;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import data.*;
public abstract class Listener1 implements MouseMotionListener{
    private Fenetre f;
    public Listener1(Fenetre f) {
        this.f = f;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO: Add your code here if needed
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO: Add your code here if needed
    }

    // Not part of MouseMotionListener; remove @Override
    public void mouseClicked(MouseEvent e) {
        Faritany faritany = f.getSelectedFaritany();
        Faritra faritra = f.getSelectedFaritra();
        District district = f.getSelectedDistrict();
        BureauVote bureauVote = f.getSelectedBureauVote();
        Depute depute = f.getSelectedDepute();
        String nbVote = f.getNbVote();

        if (faritany != null && faritra != null && district != null && bureauVote != null && depute != null && !nbVote.isEmpty()) {
            // Fonction ecrire dans un fichier
        }
    }
}
