import java.util.Objects;

// AI Declaration:
// ChatGPT helped me understand encapsulation.
// The final code is my own.
//Represents a general health professional working at the health service.
public abstract class HealthProfessional {

    // Information shared by every health professional
    private int id;
    private String name;
    private String[] availableDays;

    // Creates a health professional with an ID, name and available days.
    public HealthProfessional(
            int id,
            String name,
            String[] availableDays) {

        this.id = id;
        this.name = name;
        this.availableDays = availableDays;
    }

    //Creates a health professional who is available from Monday to Friday.
    public HealthProfessional(int id, String name) {
        this(
                id,
                name,
                new String[] {
                    "Monday",
                    "Tuesday",
                    "Wednesday",
                    "Thursday",
                    "Friday"
                });
    }

    //Returns the professional's ID.
    public int getId() {
        return id;
    }

    //Returns the professional's name.
    public String getName() {
        return name;
    }

    // Returns the professional's available days.
    public String[] getAvailableDays() {
        return availableDays;
    }

    //Displays the health professional's information.
    public void displayDetails() {
        System.out.println("Health Professional ID: " + id);
        System.out.println("Name: " + name);
        System.out.print("Available days: ");

        for (int i = 0; i < availableDays.length; i++) {
            System.out.print(availableDays[i]);

            if (i < availableDays.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    //Returns the health professional's information as readable text.
    @Override
    public String toString() {
        String days = "";

        for (int i = 0; i < availableDays.length; i++) {
            days += availableDays[i];

            if (i < availableDays.length - 1) {
                days += ", ";
            }
        }

        return "Health Professional ID: " + id
                + "\nName: " + name
                + "\nAvailable days: " + days;
    }

    // checks whether two health professionals have the same ID.
    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        HealthProfessional other =
                (HealthProfessional) object;

        return id == other.id;
    }

    // Returns aa hash code based on the professional's ID.
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}