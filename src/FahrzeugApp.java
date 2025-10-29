import java.util.ArrayList;
import java.util.List;

public class FahrzeugApp {

    public static void main(String[] args) {


        List<Fahrzeug> vehicleFleet = new ArrayList<>();

        System.out.println("Fahrzeugflotte wird erstellt...");
        vehicleFleet.add(new PKW("Familie Huber", 85000, 110, 150, 5));
        vehicleFleet.add(new LKW("Spedition Maier", 450000, 85, 420, 2, 8, true));
        vehicleFleet.add(new Fahrrad("Studentin Lisa", 22, 1, true));
        vehicleFleet.add(new LastenFahrrad("Bäckerei Schmidt", 18, 3));

        try {
            System.out.println("\nVersuche, einen ungültigen LKW mit 5 Sitzen zu erstellen...");
            vehicleFleet.add(new LKW("Testfirma GmbH", 10, 90, 500, 5, 12, false));
        } catch (IllegalArgumentException e) {
            System.out.println("ERWARTETER FEHLER ABGEFANGEN: Fahrzeug konnte nicht erstellt werden.");
            System.out.println("Grund: " + e.getMessage());
        }
        System.out.println("\nErstellung der Fahrzeugflotte abgeschlossen. Aktuelle Flottengröße: " + vehicleFleet.size());



        String cityLinz = "Linz";
        String cityGraz = "Graz";
        String cityVienna = "Wien";

        double distanceLinzGraz = 220;
        double distanceLinzVienna = 180;
        double distanceViennaGraz = 200;





        System.out.println("\n\n======================================================");
        System.out.println("           NEUE ROUTE: " + cityLinz.toUpperCase() + " <-> " + cityGraz.toUpperCase() + " (" + distanceLinzGraz + "km)");
        System.out.println("======================================================");
        for (Fahrzeug vehicle : vehicleFleet) {
            vehicle.fahren(cityLinz, cityGraz, distanceLinzGraz);
            vehicle.Huppen();
            if (vehicle instanceof PKW) {
                ((PKW) vehicle).vollgasFahren();
            } else if (vehicle instanceof ITransportieren) {
                if(vehicle instanceof LKW){
                    ((ITransportieren) vehicle).transport_Cargo(5.0);
                } else if (vehicle instanceof LastenFahrrad) {
                    ((ITransportieren) vehicle).transport_Cargo(0.015);
                }
            }
            System.out.println("\n*** Rückfahrt wird angetreten... ***");
            vehicle.fahren(cityGraz, cityLinz, distanceLinzGraz);
        }


        System.out.println("\n\n======================================================");
        System.out.println("           NEUE ROUTE: " + cityLinz.toUpperCase() + " <-> " + cityVienna.toUpperCase() + " (" + distanceLinzVienna + "km)");
        System.out.println("======================================================");
        for (Fahrzeug vehicle : vehicleFleet) {
            vehicle.fahren(cityLinz, cityVienna, distanceLinzVienna); // Hinfahrt
            vehicle.Huppen();
            if (vehicle instanceof PKW) {
                ((PKW) vehicle).vollgasFahren();
            } else if (vehicle instanceof ITransportieren) {
                if(vehicle instanceof LKW){
                    ((ITransportieren) vehicle).transport_Cargo(3.5);
                } else if (vehicle instanceof LastenFahrrad ) {
                    ((ITransportieren) vehicle).transport_Cargo(0.010);
                }
            }
            System.out.println("\n*** Rückfahrt wird angetreten... ***");
            vehicle.fahren(cityVienna, cityLinz, distanceLinzVienna); // Rückfahrt
        }


        System.out.println("\n\n======================================================");
        System.out.println("           NEUE ROUTE: " + cityVienna.toUpperCase() + " <-> " + cityGraz.toUpperCase() + " (" + distanceViennaGraz + "km)");
        System.out.println("======================================================");
        for (Fahrzeug vehicle : vehicleFleet) {
            vehicle.fahren(cityVienna, cityGraz, distanceViennaGraz); // Hinfahrt
            vehicle.Huppen();
            if (vehicle instanceof PKW) {
                ((PKW) vehicle).vollgasFahren();
            } else if (vehicle instanceof ITransportieren) {
                if(vehicle instanceof LKW){
                    ((ITransportieren) vehicle).transport_Cargo(8.0);
                } else if (vehicle instanceof LastenFahrrad) {
                    ((ITransportieren) vehicle).transport_Cargo(0.020);
                }
            }
            System.out.println("\n*** Rückfahrt wird angetreten... ***");
            vehicle.fahren(cityGraz, cityVienna, distanceViennaGraz);
        }

        System.out.println("\n\n===== ALLE FAHRTEN ABGESCHLOSSEN! =====");
    }
}