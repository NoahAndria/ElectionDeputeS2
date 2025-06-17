package data;

public class Depute {
    private String name;
    private int nombreVotes;
    private Depute second;
    Depute(String name, int nombreVotes) {
        this.name = name;
        this.nombreVotes = nombreVotes;
        this.second = null; 
    }
    
    public String getName() {
        return name;
    }
    public int getNombreVotes() {
        return nombreVotes;
    }
    public Depute getSecond() {
        return second;
    }
    public void setSecond(Depute second) {
        this.second = second;
    }
    
    // public String toString() {
    //     return "Depute{" +
    //             "name='" + name + '\'' +
    //             ", nombreVotes=" + nombreVotes +
    //             ", second=" + (second != null ? second.getName() : "null") +
    //             '}';
    // }
}
