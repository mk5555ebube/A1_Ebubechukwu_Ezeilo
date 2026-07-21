/*Represents a physiotherapist.*/
public class Physiotherapist extends HealthProfessional {

    private String treatmentType;

    /**
     * Creates a physiotherapist.
     */
    public Physiotherapist(int id, String name,
                           String[] availableDays,
                           String treatmentType) {

        super(id, name, availableDays);
        this.treatmentType = treatmentType;
    }

    /*Returns the treatment type.*/
    public String getTreatmentType() {
        return treatmentType;
    }

    /*Returns the physiotherapist details.*/
    @Override
    public String toString() {
        return "Type: Physiotherapist"
                + "\n" + super.toString()
                + "\nTreatment Type: " + treatmentType;
    }
}