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
    JButton bouton ;

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
        setTitle("Insert election results");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        faritanyComboBox = new JComboBox<>(faritanyList);
        faritraComboBox = new JComboBox<>();
        districtComboBox = new JComboBox<>();
        bureauVoteComboBox = new JComboBox<>();
        deputeComboBox = new JComboBox<>();
        nbVoteComboBox = new JTextField();
        bouton = new JButton("Send");

        faritanyComboBox.addActionListener(
            e -> {
                Faritany selected = (Faritany) faritanyComboBox.getSelectedItem();
                if(selected != null){
                    faritraComboBox.removeAllItems();
                    for(Faritra f : selected.getFaritra()) {
                        faritraComboBox.addItem(f);
                    }
                    
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
                    
                    bureauVoteComboBox.removeAllItems();
                    for(BureauVote b : selected.getBureaux()) {
                        bureauVoteComboBox.addItem(b);
                    }
                    
                }
            }
        );

        // setLayout(BorderLayout(3,3,10,10));
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
        nbVoteComboBox.setPreferredSize(new Dimension(50, 30));
        nbVoteComboBox.setMaximumSize(new Dimension(50,30));
        add(nbVoteComboBox);

        bouton.setPreferredSize(new Dimension(70, 40));
        bouton.setMaximumSize(new Dimension(70,40));
        bouton.addMouseListener(new Listener1(this));
        add(bouton);
        JButton submitButton = new JButton("Submit");

        setVisible(true);
    }
}
