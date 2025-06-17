package affichage;
import data.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Fenetre extends JFrame{
    private JComboBox<Faritany> faritanyComboBox;
    private JComboBox<Faritra> faritraComboBox;
    private JComboBox<District> districtComboBox;
    private JComboBox<BureauVote> bureauVoteComboBox;
    private JComboBox<Depute> deputeComboBox;
    private JTextField nbVoteComboBox;

    public Faritany getSelectedFaritany() {
        return (Faritany) faritanyComboBox.getSelectedItem();
    }
    public Faritra getSelectedFaritra() {
        return (Faritra) faritraComboBox.getSelectedItem();
    }
    public District getSelectedDistrict() {
        return (District) districtComboBox.getSelectedItem();
    }
    public BureauVote getSelectedBureauVote() {
        return (BureauVote) bureauVoteComboBox.getSelectedItem();
    }
    public Depute getSelectedDepute() {
        return (Depute) deputeComboBox.getSelectedItem();
    }
    public String getNbVote() {
        return nbVoteComboBox.getText();
    }
    public Fenetre(Vector<Faritany> faritanyList) {
        setTitle("Election Results");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        faritanyComboBox = new JComboBox<>(faritanyList);
        faritanyComboBox.addItem(null);
        faritraComboBox = new JComboBox<>();
        faritraComboBox.addItem(null);
        districtComboBox = new JComboBox<>();
        districtComboBox.addItem(null);
        bureauVoteComboBox = new JComboBox<>();
        bureauVoteComboBox.addItem(null);
        deputeComboBox = new JComboBox<>();
        deputeComboBox.addItem(null);
        nbVoteComboBox = new JTextField();

        faritanyComboBox.addActionListener(
            e -> {
                Faritany selected = (Faritany) faritanyComboBox.getSelectedItem();
                if(selected != null){
                    faritraComboBox.removeAllItems();
                    for(Faritra f : selected.getFaritra()) {
                        faritraComboBox.addItem(f);
                    }
                    faritraComboBox.addItem(null);
                }
            }
        );

        faritraComboBox.addActionListener(
            e -> {
                Faritra selected = (Faritra) faritraComboBox.getSelectedItem();
                if(selected != null)
                {
                    districtComboBox.removeAllItems();
                    for(District d : selected.getDistricts()) {
                        districtComboBox.addItem(d);
                    }
                    districtComboBox.addItem(null);
                }
            }
        );

        districtComboBox.addActionListener(
            e -> {
                District selected = (District) districtComboBox.getSelectedItem();
                if(selected != null) {
                    deputeComboBox.removeAllItems();
                    for(Depute d : selected.getDeputes()) {
                        deputeComboBox.addItem(d);
                    }
                    deputeComboBox.addItem(null);
                    bureauVoteComboBox.removeAllItems();
                    for(BureauVote b : selected.getBureaux()) {
                        bureauVoteComboBox.addItem(b);
                    }
                    bureauVoteComboBox.addItem(null);
                }
            }
        );


        add(new JLabel("Select Faritany:"));
        add(faritanyComboBox);
        add(new JLabel("Select Faritra:"));
        add(faritraComboBox);
        add(new JLabel("Select District:"));
        add(districtComboBox);
        add(new JLabel("Select Bureau:"));
        add(bureauVoteComboBox);
        add(new JLabel("Select Depute:"));
        add(deputeComboBox);
        add(new JLabel("Number of Votes:"));
        add(nbVoteComboBox);
        JButton submitButton = new JButton("Submit");

        setVisible(true);
    }
}
