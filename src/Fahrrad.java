public class Fahrrad extends Fahrzeug {
    private int wheels = 2;
    private int seating;
    private boolean canHuppen;

    public Fahrrad(String owner ,  double averageSpeed , int seating , boolean canHuppen) {
        super(owner , 0 , averageSpeed);
      this.wheels = wheels;
        if (seating<1 || seating>2) {
            throw new IllegalArgumentException("FEHLER: Die Anzahl der Fahrrad-Sitze muss zwischen 1 und 2 liegen! Eingegebener Wert: " + seating );
        } else {
            this.seating = seating;
        }
        this.canHuppen = canHuppen;

    }
    public void Huppen() {
        if (this.canHuppen) {
            System.out.println("Ring,Ring!");
        } else {
            System.out.println("Achtung! Fahrzeug");
        }
    }
    public void werdeGeschoben() {
        System.out.println(this.owner + "'s Fahrrad wird gerade geschoben.");
    }


    public void werdeAngetrieben() {
        System.out.println("Das Fahrrad wird mit Muskelkraft angetrieben.");
    }
}



