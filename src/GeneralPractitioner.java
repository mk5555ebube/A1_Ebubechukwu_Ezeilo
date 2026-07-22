/*Represents a general practitioner.*/
 class GeneralPractitioner extends HealthProfessional {

    private String clinicName;

    /**Creates a general practitioner.
     * @param id the professional's numeric ID
     * @param name the professional's name
     * @param availableDays the days the professional is available
     * @param clinicName the name of the GP's clinic
     */
    public GeneralPractitioner(
            int id,
            String name,
            String[] availableDays,
            String clinicName) {

        super(id, name, availableDays);
        this.clinicName = clinicName;
    }

    /** Returns the clinic name.
     * @return the clinic name
     */
    public String getClinicName() {
        return clinicName;
    }

    /**Returns the GP's details as readable text.
     * @return the GP's details
     */
    @Override
    public String toString() {
        return "Type: General Practitioner"
                + "\n" + super.toString()
                + "\nClinic: " + clinicName;
    }
}