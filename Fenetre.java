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
    private JComboBox<Depute> deputeComboBox;

    Fenetre(Vector<Faritany> faritanyList) {
        setTitle("Election Results");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        faritanyComboBox = new JComboBox<>(faritanyList);
        faritraComboBox = new JComboBox<>();
        districtComboBox = new JComboBox<>();
        deputeComboBox = new JComboBox<>();

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
                }
            }
        );

        add(new JLabel("Select Faritany:"));
        add(faritanyComboBox);
        add(new JLabel("Select Faritra:"));
        add(faritraComboBox);
        add(new JLabel("Select District:"));
        add(districtComboBox);
        add(new JLabel("Select Depute:"));
        add(deputeComboBox);

        setVisible(true);
    }
}
