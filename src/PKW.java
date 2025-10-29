public class PKW  extends  Fahrzeug {
    private int wheeks = 4;
    private double ps;
    private int seating;

    public PKW(String owner , double kilometerstand , double averageSpeed , int ps , int seating ) {
        super(owner, kilometerstand, averageSpeed);
        this.ps = ps;


        if (seating > 7 ) {
            throw new IllegalArgumentException("Ein PKW hat maximale 7 Sitzplatze");
        } else  {
            this.seating = seating;
        }
    }
    public void  Huppen() {
        System.out.println("DÜÜÜÜÜTÜÜDÜÜÜTÜÜTÜDÜÜÜTÜTÜÜÜDÜÜÜTTT");
    }

    public void vollgasFahren() {
        System.out.println("Der PKW mit " + this.ps + " PS fährt jetzt mit Vollgas!");
    }
}
