/**
 * Represents a pharmacist.
 */
public class Pharmacist extends HealthProfessional {

    private String storeName;

    /*Creates a pharmacist*/
    public Pharmacist(int id, String name,
                      String[] availableDays,
                      String storeName) {

        super(id, name, availableDays);
        this.storeName = storeName;
    }

    /*Returns the pharmacy name.*/
    public String getStoreName() {
        return storeName;
    }

    /*Returns the pharmacist details.*/
    @Override
    public String toString() {
        return "Type: Pharmacist"
                + "\n" + super.toString()
                + "\nStore: " + storeName;
    }
}