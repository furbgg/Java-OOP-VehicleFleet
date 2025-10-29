public class LKW  extends  Fahrzeug implements ITransportieren {
private int wheels = 6;
private int ps;
private int seating;
    private boolean trailers;
    private  double tonnen2;
    private static final double MAX_LADUNG_IN_TONNEN = 10.0;
    private static final double MIN_LADUNG_IN_TONNEN = 0;

public LKW (String owner , double kilometerstand , double averageSpeed , int ps , int seating ,int wheels, boolean trailers ) {
    super(owner,kilometerstand,averageSpeed);
    this.ps = ps;
    this.trailers = trailers;
    this.tonnen2 =0;
    if (seating<1 || seating>3) {
        throw new IllegalArgumentException("FEHLER: Die Anzahl der LKW-Sitze muss zwischen 1 und 3 liegen! Eingegebener Wert: " + seating );
    } else {
        this.seating = seating;
    }

    if (wheels<6) {
        throw new IllegalArgumentException("FEHLER: DER LKW hat mindest 6 Räder");
    } else {
        this.wheels = wheels;
    }
}
public void  Huppen() {
    System.out.println("TRÖÖÖÖT! LKW, FAHR VON DER STRASSE runter!");
}
public void transport_Cargo (double tonnen) {
    if (tonnen<= 0 ) {
        System.out.println("Ungültige Lastmenge. Geben Sie einen positiven Wert ein.");
    } if (this.tonnen2 + tonnen > MAX_LADUNG_IN_TONNEN ) {
        System.out.println("LADUNG FEHLGESCHLAGEN! Die maximale Kapazität von " + MAX_LADUNG_IN_TONNEN + " Tonnen darf nicht überschritten werden.");
        System.out.printf("Aktuelle Ladung: %.2f Tonnen | Maximal zulässige Ladung: %.2f Tonnen\n",
                this.tonnen2, (MAX_LADUNG_IN_TONNEN - this.tonnen2));
    } else {
        this.tonnen2 += tonnen;
        System.out.printf("LADUNG ERFOLGREICH! %.2f Tonnen hinzugefügt.\n " , tonnen);
        System.out.printf("Neue Gesamtladung des LKWs: %.2f Tonnen\n ", this.tonnen2);
    }


}


}

