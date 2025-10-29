public class LastenFahrrad extends Fahrrad implements  ITransportieren {
    private  double aktuell_Kilogram;
    private static final double MAX_LADUNG_IN_KILOGRAM = 20.0;
    private static final double MIN_LADUNG_IN_KILOGRAM = 0;
    private int wheels;
    public LastenFahrrad(String owner , double averageSpeed , int wheels) {
        super(owner,averageSpeed,1, true);
        if (wheels<2 ) {
            throw new IllegalArgumentException("Der LastenFahrrad hat mindest 2 Räder!");
        } else {
            this.wheels = wheels;
        }
        this.aktuell_Kilogram = 0;
    }
    public void  transport_Cargo(double mengeTonnen) {
        if (mengeTonnen<= 0) {
            System.out.println("FEHLER!");
            return;
        }
        double mengeInKilogram = mengeTonnen* 1000;
        if (this.aktuell_Kilogram + mengeInKilogram > MAX_LADUNG_IN_KILOGRAM) {
            System.out.println("FEhler! Maximum Kilogram " + MAX_LADUNG_IN_KILOGRAM  );
        } else {
            this.aktuell_Kilogram += mengeInKilogram;
        }
        System.out.printf("%.2f kg Last hinzugefügt. Neue Gesamtlast: %.2f kg\n",
        mengeTonnen , this.aktuell_Kilogram) ;
    }
}





