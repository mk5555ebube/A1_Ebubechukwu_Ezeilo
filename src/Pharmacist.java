//Represents a pharmacist.
public class Pharmacist extends HealthProfessional {

    private String pharmacyName;

    //Creates a pharmacist.
    public Pharmacist(
            int id,
            String name,
            String[] availableDays,
            String pharmacyName) {

        super(id, name, availableDays);
        this.pharmacyName = pharmacyName;
    }

    //Returns the pharmacy name.
    public String getPharmacyName() {
        return pharmacyName;
    }

    // the pharmacist's details as readable text.
    @Override
    public String toString() {
        return "Type: Pharmacist" + "\n"
                + super.toString() + "\nPharmacy: "
                + pharmacyName;
    }
}