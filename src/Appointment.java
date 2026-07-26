//Appointment class.
public class Appointment {

    private String patientName;
    private String patientMobile;
    private String appointmentTime;
    private HealthProfessional healthProfessional;

    //Constructor for an appointment.
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

    // Gets the patient's name.
    public String getPatientName() {
        return patientName;
    }

    // Gets the patient's mobile number.
    public String getPatientMobile() {
        return patientMobile;
    }

    // Gets the appointment time.
    public String getAppointmentTime() {
        return appointmentTime;
    }

    // Gets the health professional.
    public HealthProfessional getHealthProfessional() {
        return healthProfessional;
    }

    //Displays appointment details.
    @Override
    public String toString() {
        return "Appointment Time: " + appointmentTime
                + "\nPatient Name: " + patientName
                + "\nPatient Mobile: " + patientMobile
                + "\nHealth Professional:\n"
                + healthProfessional;
    }
}