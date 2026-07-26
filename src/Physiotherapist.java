//Represents a physiotherapist.
public class Physiotherapist extends HealthProfessional {

    private String clinicName;

    //Creates a physiotherapist.
    public Physiotherapist(
            int id,
            String name,
            String[] availableDays,
            String clinicName) {

        super(id, name, availableDays);
        this.clinicName = clinicName;
    }

    //Returns the clinic name.
    public String getClinicName() {
        return clinicName;
    }

    //Returns the physiotherapist's details as readable text.
    @Override
    public String toString() {
        return "Type: Physiotherapist" + "\n"
                + super.toString() + "\nClinic: "
                + clinicName;
    }
}