import java.util.ArrayList;

public class AssignmentOne {

    private static ArrayList<Appointment> appointments = new ArrayList<>();

    private static String[] validTimeSlots = {
        "08:00", "08:30",
        "09:00", "09:30",
        "10:00", "10:30",
        "11:00", "11:30",
        "12:00", "12:30",
        "13:00", "13:30",
        "14:00", "14:30",
        "15:00", "15:30",
        "16:00"
};

    public static void main(String[] args) {

        System.out.println("PROG2004 Assessment 1");
        System.out.println("Health Service Appointment System");

    

    String[] days1 = {"Monday", "Wednesday", "Friday"};
    String[] days2 = {"Tuesday", "Thursday"};
    String[] days3 = {"Monday", "Tuesday", "Friday"};
    String[] days4 = {"Wednesday", "Thursday"};

    
        GeneralPractitioner gp1 =
    new GeneralPractitioner(
        1001,
        "Ebube Williams",
            days1,
         "Broadbeach Medical Centre");

        GeneralPractitioner gp2 =
new GeneralPractitioner(
     1002,
         "John Smith",
                days2,
                "Gold Coast Family Clinic");

Pharmacist pharmacist1 =
        new Pharmacist(
                2001,
                "Emily Brown",
                days3,
                "Robina Pharmacy");

Dentist dentist1 =
        new Dentist(
                3001,
                "Jane Eze",
                days4,
                "Southport Dental Clinic");

Physiotherapist physiotherapist1 =
        new Physiotherapist(
                4001,
                "Michael Green",
                days1,
                "Sports Injury Rehabilitation");
                System.out.println();

Appointment appointment1 =
        new Appointment(
                "Daniel White",
                "0412345678",
                "09:30",
                gp1);


Appointment appointment3 =
        new Appointment(
                "Michael Lee",
                "0434567890",
                "14:30",
                pharmacist1);     
                
                Appointment appointment2 =
        new Appointment(
                "Sarah Brown",
                "0423456789",
                "11:00",
                dentist1);

System.out.println(gp1);
System.out.println();
System.out.println(gp2);
System.out.println();

System.out.println(pharmacist1);
System.out.println();

System.out.println(dentist1);
System.out.println();

System.out.println(physiotherapist1);

// Test booking appointments & booking appointments setting *//
bookAppointment("Sarah Brown", "0423456789", "11:00", dentist1);

bookAppointment("Daniel White", "0412345678", "09:30", gp1);

bookAppointment("Test Patient","0400000000","10:15",gp2);

bookAppointment("Michael Lee", "0434567890", "14:30", pharmacist1);

sortAppointmentsByTime(appointments);

System.out.println("\nAPPOINTMENT DETAILS");

for (Appointment appointment : appointments) {
    System.out.println(appointment);
    System.out.println();
}

// Test viewing appointments by professional ID and patient phone*//
viewAppointmentsByProfessionalId(1001);

viewAppointmentsByProfessionalId(4001);

viewAppointmentsByPatientPhone("0412345678");

viewAppointmentsByPatientPhone("0499999999");

// Test cancelling appointments by professional ID and appointment time*//
cancelAppointmentByProfessional(1001, "09:30");

// Test cancelling appointments by patient phone*//
cancelAppointmentByPatientPhone("0423456789");
cancelAppointmentByPatientPhone("0499999999");

    }
 public static void bookAppointment(
        String patientName,
        String patientMobile,
        String appointmentTime,
        HealthProfessional healthProfessional) {

    if (patientName == null || patientName.isEmpty()
            || patientMobile == null || patientMobile.isEmpty()
            || appointmentTime == null || appointmentTime.isEmpty()
            || healthProfessional == null) {

        System.out.println("Warning: Appointment could not be booked. "
                + "All required information must be provided.");
        return;
        
    }  

    if (!isValidTimeSlot(appointmentTime)) {
    System.out.println("Warning: " + appointmentTime
            + " is not a valid appointment time.");
    return;
}

for (Appointment appointment : appointments) {

    boolean sameProfessional =
            appointment.getHealthProfessional().equals(healthProfessional);

    boolean sameTime =
            appointment.getAppointmentTime().equals(appointmentTime);

    if (sameProfessional && sameTime) {

        System.out.println(
                "Warning: This health professional is already booked at "
                        + appointmentTime + ".");

        return;
    }

}

    Appointment newAppointment = new Appointment(
            patientName,
            patientMobile,
            appointmentTime,
            healthProfessional);

    appointments.add(newAppointment);

    System.out.println("Appointment successfully booked for "
            + patientName + ".");
}

public static void viewAppointmentsByPatientPhone(
        String patientMobile) {

    boolean appointmentFound = false;

    System.out.println(
            "\nAPPOINTMENTS FOR PATIENT PHONE "
                    + patientMobile);

    for (Appointment appointment : appointments) {

        if (appointment.getPatientMobile().equals(patientMobile)) {

            System.out.println(appointment);
            System.out.println();

            appointmentFound = true;
        }
    }

    if (!appointmentFound) {
        System.out.println(
                "Warning: No appointments were found for patient phone "
                        + patientMobile + ".");
    }
}

public static void viewAppointmentsByProfessionalId(int professionalId) {

    boolean appointmentFound = false;

    System.out.println(
            "\nAPPOINTMENTS FOR HEALTH PROFESSIONAL ID "
                    + professionalId);

    for (Appointment appointment : appointments) {

        int appointmentProfessionalId =
                appointment.getHealthProfessional().getId();

        if (appointmentProfessionalId == professionalId) {
            System.out.println(appointment);
            System.out.println();
            appointmentFound = true;
        }
    }

    if (!appointmentFound) {
        System.out.println(
                "Warning: No appointments were found for health professional ID "
                        + professionalId + ".");
    }
}

public static void sortAppointmentsByTime(
        ArrayList<Appointment> appointmentList) {

    for (int i = 0; i < appointmentList.size() - 1; i++) {

        for (int j = 0; j < appointmentList.size() - 1 - i; j++) {

            Appointment currentAppointment = appointmentList.get(j);
            Appointment nextAppointment = appointmentList.get(j + 1);

            if (currentAppointment.getAppointmentTime()
                    .compareTo(nextAppointment.getAppointmentTime()) > 0) {

                appointmentList.set(j, nextAppointment);
                appointmentList.set(j + 1, currentAppointment);
            }
        }
    }
}

public static void cancelAppointmentByProfessional(
        int professionalId,
        String appointmentTime) {

    for (int i = 0; i < appointments.size(); i++) {

        Appointment appointment = appointments.get(i);

        boolean sameProfessional =
                appointment.getHealthProfessional().getId()
                        == professionalId;

        boolean sameTime =
                appointment.getAppointmentTime()
                        .equals(appointmentTime);

        if (sameProfessional && sameTime) {

            appointments.remove(i);

            System.out.println(
                    "Appointment successfully cancelled for health professional ID "
                            + professionalId
                            + " at "
                            + appointmentTime
                            + ".");

            return;
        }
    }

System.out.println("\nAPPOINTMENTS AFTER CANCELLATION");

for (Appointment appointment : appointments) {
    System.out.println(appointment);
    System.out.println();
}

    System.out.println(
            "Warning: No appointment was found for health professional ID "
                    + professionalId
                    + " at "
                    + appointmentTime
                    + ".");
}

public static void cancelAppointmentByPatientPhone(
        String patientMobile) {

    for (int i = 0; i < appointments.size(); i++) {

        Appointment appointment = appointments.get(i);

        if (appointment.getPatientMobile().equals(patientMobile)) {

            appointments.remove(i);

            System.out.println(
                    "Appointment successfully cancelled for patient phone "
                            + patientMobile
                            + ".");

            return;
        }
    }

    System.out.println(
            "Warning: No appointment was found for patient phone "
                    + patientMobile
                    + ".");
}

public static boolean isValidTimeSlot(String appointmentTime) {

    for (String timeSlot : validTimeSlots) {
        if (timeSlot.equals(appointmentTime)) {
            return true;
        }
    }

    return false;
}

}