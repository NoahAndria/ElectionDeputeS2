package affichage;
import data.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Classement extends JFrame{
    private Vector<Faritany> faritany;
    private JComboBox<Faritany> faritanyComboBox;
    private JComboBox<Faritra> faritraComboBox;
    private JComboBox<District> districtComboBox;
    private JComboBox<BureauVote> bureauVoteComboBox;
    private Dessin panel;
    JButton bouton ;

    public Faritany getSelectedFaritany() {
        return (Faritany) faritanyComboBox.getSelectedItem();
    }
    public Dessin getPanelDessin()
    {
        return this.panel;
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
    public Vector<Faritany> getFaritany() {
        return this.faritany;
    }
    public Classement(Vector<Faritany> faritanyList) {
        this.faritany = faritanyList;
        setTitle("Election Results");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        panel = new Dessin(this);

        faritanyComboBox = new JComboBox<>(faritanyList);
        faritanyComboBox.addItem(null);
        faritraComboBox = new JComboBox<>();
        faritraComboBox.addItem(null);
        districtComboBox = new JComboBox<>();
        districtComboBox.addItem(null);
        bureauVoteComboBox = new JComboBox<>();
        bureauVoteComboBox.addItem(null);

        bouton = new JButton("Send");

        faritanyComboBox.addActionListener(
            e -> {
                Faritany selected = (Faritany) faritanyComboBox.getSelectedItem();
                if(selected != null){
                    faritraComboBox.removeAllItems();
                    faritraComboBox.addItem(null);
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
                    districtComboBox.addItem(null);
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

                    
                    bureauVoteComboBox.removeAllItems();
                    bureauVoteComboBox.addItem(null);
                    for(BureauVote b : selected.getBureaux()) {
                        bureauVoteComboBox.addItem(b);
                    }
                    
                }
            }
        );

        // setLayout(BorderLayout(3,3,10,10));
        JPanel head = new JPanel();
        add(new JLabel("Select Faritany:"));
        head.add(faritanyComboBox);
        add(new JLabel("Select Faritra:"));
        head.add(faritraComboBox);
        add(new JLabel("Select District:"));
        head.add(districtComboBox);
        add(new JLabel("Select Bureau:"));
        head.add(bureauVoteComboBox);

        bouton.setPreferredSize(new Dimension(70, 40));
        bouton.setMaximumSize(new Dimension(70,40));
        bouton.addMouseListener(new Listener2(this));
        head.add(bouton);
        JButton submitButton = new JButton("Submit");

        setLayout(new BorderLayout());
        add(head, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
}
