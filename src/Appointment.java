/**Represents an appointment between a patient and a health professional.
 */
public class Appointment {

    private String patientName;
    private String patientMobile;
    private String appointmentTime;
    private HealthProfessional healthProfessional;

    /**Creates an appointment.*/
    public Appointment(
                String patientName,
                String patientMobile,
                String appointmentTime,
                HealthProfessional healthProfessional) {

            this.patientName = patientName;
            this.patientMobile = patientMobile;
            this.appointmentTime = appointmentTime;
            this.healthProfessional = healthProfessional;
        }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientMobile() {
        return patientMobile;
    }
    
    public String getAppointmentTime() {
        return appointmentTime;
    }

    public HealthProfessional getHealthProfessional() {
        return healthProfessional;
    }

    //**Returns the appointment details as readable text. 
    @Override
    public String toString() {
        return "Appointment Time: " + appointmentTime
                + "\nPatient Name: " + patientName
                + "\nPatient Mobile: " + patientMobile
                + "\nHealth Professional:\n"
                + healthProfessional;
    }
}