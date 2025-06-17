package data;

import java.util.Vector;
import affichage.*;

public class Main {
    public static void main(String[] args) {
        
// < --------- Declaration des bureaux et les mettre dans un groupe -------------->
        BureauVote bureau1 = new BureauVote("Bureau 1");
        BureauVote bureau2 = new BureauVote("Bureau 2");
        BureauVote bureau3 = new BureauVote("Bureau 3");
        BureauVote bureau4 = new BureauVote("Bureau 4");
        BureauVote bureau5 = new BureauVote("Bureau 5");

        Vector<BureauVote> bureauxG1 = new Vector<>();
        bureauxG1.add(bureau1);
        bureauxG1.add(bureau2);

        Vector<BureauVote> bureauxG2 = new Vector<>();
        bureauxG2.add(bureau3);

        Vector<BureauVote> bureauxG3 = new Vector<>();
        bureauxG3.add(bureau4);

        Vector<BureauVote> bureauxG4 = new Vector<>();
        bureauxG4.add(bureau5);
    
// < --------- Declaration des deputes et les mettre dans un groupe -------------->
        Depute depute1 = new Depute("John Doe");
        Depute depute2 = new Depute("Jane Smith");
        Depute depute3 = new Depute("Alice Johnson");
        Depute depute4 = new Depute("Bob Brown");
        Depute depute5 = new Depute("Charlie Davis");
        Depute depute6 = new Depute("Diana Evans");
        Depute depute7 = new Depute("Ethan Green");
        Depute depute8 = new Depute("Fiona Harris");

        Vector<Depute> deputesG1 = new Vector<>();
        deputesG1.add(depute1);
        deputesG1.add(depute2);

        Vector<Depute> deputesG2 = new Vector<>();
        deputesG2.add(depute3);
        deputesG2.add(depute4);

        Vector<Depute> deputesG3 = new Vector<>();
        deputesG3.add(depute5);
        deputesG3.add(depute6);

        Vector<Depute> deputesG4 = new Vector<>();
        deputesG4.add(depute7);
        deputesG4.add(depute8);

        //  < --------- Declaration des districts et les mettre dans un groupe -------------->

        District district1 = new District(deputesG1, bureauxG1, "District 1", 1);
        District district2 = new District(deputesG2, bureauxG2, "District 2", 1);
        District district3 = new District(deputesG3, bureauxG3, "District 3", 1);
        District district4 = new District(deputesG4, bureauxG4, "District 4", 1);

        Vector<District> districtsG1 = new Vector<>();
        districtsG1.add(district1);
        districtsG1.add(district2);
        Vector<District> districtsG2 = new Vector<>();
        districtsG2.add(district3);
        Vector<District> districtsG3 = new Vector<>();
        districtsG3.add(district4);

        // < --------- Declaration des faritra et les mettre dans un groupe -------------->

        Faritra faritra1 = new Faritra("Faritra 1", districtsG1);
        Faritra faritra2 = new Faritra("Faritra 2", districtsG2);
        Faritra faritra3 = new Faritra("Faritra 3", districtsG3);
        Vector<Faritra> faritras = new Vector<>();
        faritras.add(faritra1);
        faritras.add(faritra2);
        faritras.add(faritra3);

        // < --------- Declaration des faritany et les mettre dans un groupe -------------->
        Faritany faritany1 = new Faritany("Faritany 1", faritras);
        Vector<Faritany> faritanys = new Vector<>();
        faritanys.add(faritany1);
        Fenetre f = new Fenetre(faritanys);
        f.setVisible(true);

    }
}
