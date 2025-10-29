import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Fahrzeug {
    protected String owner;
    protected double kilometerstand;
    protected double averageSpeed;
    private static final DateTimeFormatter time_Format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public Fahrzeug(String owner , double kilometerstand , double averageSpeed) {
        this.averageSpeed = averageSpeed;
        this.kilometerstand = kilometerstand;
        this.owner = owner;
    }

    public abstract void Huppen();

    public void fahren(String from, String to, double distance) {
        LocalDateTime departure_Time = LocalDateTime.now();
        System.out.println("------------------------------------------------");
        System.out.println(this.getClass().getSimpleName() + " ( " + this.owner + ") fahrt los...");
        System.out.println("Abfahrt : " + from + " ||| Zeit ; " + departure_Time.format(time_Format));
        double permanent_Hours = distance / this.averageSpeed;

        long duration_In_Seconds = (long) (permanent_Hours * 3600);
        LocalDateTime arrival_Time = departure_Time.plusSeconds(duration_In_Seconds);
        this.kilometerstand += distance;
        System.out.printf("Diese Reisedauer . %.2f Stunden", permanent_Hours);
        System.out.println("Ankunftt : " + to + " ||| Zeit: " + arrival_Time.format(time_Format));
        System.out.printf("Neuer Kilometerstand ist :  %.2f km\n", this.kilometerstand);

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();


        sb.append(this.getClass().getSimpleName());
        sb.append(" { ");
        sb.append("eigentuemer='");
        sb.append(owner);
        sb.append("', km=");
        sb.append(kilometerstand);
        sb.append(",Geschwedigkeit .=");
        sb.append(averageSpeed);
        sb.append(" km/h");
        sb.append(" }");


        return sb.toString();
    }
}

