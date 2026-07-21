/*Represents a dentist*/
public class Dentist extends HealthProfessional {

    private String clinicName;

    /*Creates a dentist.*/
    public Dentist(int id, String name,
                   String[] availableDays,
                   String clinicName) {

        super(id, name, availableDays);
        this.clinicName = clinicName;
    }

    /**
     * Returns the clinic name.*/
    public String getClinicName() {
        return clinicName;
    }

    /*Returns the dentist details.*/
    @Override
    public String toString() {
        return "Type: Dentist"
                + "\n" + super.toString()
                + "\nClinic: " + clinicName;
    }
}