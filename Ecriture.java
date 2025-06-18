package wr;
import java.io.*;
import java.util.*;
import data.*;
public class Ecriture {
    public static void ecrirefichier(String nomFichier, Faritany fat, Faritra f, District ds, BureauVote b, Depute d, Integer nB) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier, true))) {
            writer.write(fat.getName() + ";;"+f.getName()+";;" + ds.getName() + ";;" + b.getName() + ";;"+ d.getName() + ";;" + nB.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}