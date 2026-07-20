/**
 * Represents a general health professional working at the health service.
 */
public class HealthProfessional {

    // Information shared by every health professional
    private int id;
    private String name;
    private String[] availableDays;

    /**
     * Creates a health professional with an ID, name and working days.
     *
     * @param id the professional's numeric ID
     * @param name the professional's name
     * @param availableDays the days the professional is available
     */
    public HealthProfessional(int id, String name, String[] availableDays) {
        this.id = id;
        this.name = name;
        this.availableDays = availableDays;
    }

    /**
     * Returns the professional's ID.
     *
     * @return the professional ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the professional's name.
     *
     * @return the professional name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the professional's available days.
     *
     * @return the available days
     */
    public String[] getAvailableDays() {
        return availableDays;
    }

    /**
     * Displays the health professional's information.
     */
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
}