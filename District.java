package data;
import java.util.Vector;
public class District{
    String name;
    Vector<Depute> deputes;
    public District(String name) {
        this.name = name;
        this.deputes = new Vector<>();
    }
    public String getName() {
        return name;
    }
    public Vector<Depute> getDeputes() {
        return deputes;
    }
    public void addDepute(Depute depute) {
        deputes.add(depute);
    }
    public void setDeputes(Vector<Depute> deputes) {
        this.deputes = deputes;
    }
}