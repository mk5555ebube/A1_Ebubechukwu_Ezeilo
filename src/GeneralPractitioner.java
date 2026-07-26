//Represents a general practitioner.
 class GeneralPractitioner extends HealthProfessional {

    private String clinicName;

   // creates a general practioner.
    public GeneralPractitioner(
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

    //Returns the GP's details as readable text.
    @Override
    public String toString() {
        return "Type: General Practitioner"
                + "\n" + super.toString()
                + "\nClinic: " + clinicName;
    }
}