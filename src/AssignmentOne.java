import java.util.ArrayList;
//Generative AI Declaration
//ChatGPT was used to help me learn Java concepts and assist with debugging.All code was written, tested, and submitted by me.

//Runs the health service appointment system.
public class AssignmentOne {

    private static ArrayList<Appointment> appointments =
            new ArrayList<>();

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

   // main method
    public static void main(String[] args) {

        System.out.println("PROG2004 Assessment 1");
        System.out.println("Health Service Appointment System");
        System.out.println();

        // Create available-day arrays
        String[] days1 = {
            "Monday", "Wednesday", "Friday"
        };

        String[] days2 = {
            "Tuesday", "Thursday"
        };

        String[] days3 = {
            "Monday", "Tuesday", "Friday"
        };

        String[] days4 = {
            "Wednesday", "Thursday"
        };

        // Create health professionals
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

        // Display health professional details
        System.out.println(gp1);
        System.out.println();

        System.out.println(gp2);
        System.out.println();

        System.out.println(pharmacist1);
        System.out.println();

        System.out.println(dentist1);
        System.out.println();

        System.out.println(physiotherapist1);
        System.out.println();

        // Test appointment booking
        bookAppointment(
                "Sarah Brown",
                "0423456789",
                "11:00",
                dentist1);

        bookAppointment(
                "Daniel White",
                "0412345678",
                "09:30",
                gp1);

        // Invalid time-slot test
        bookAppointment(
                "Test Patient",
                "0400000000",
                "10:15",
                gp2);

        bookAppointment(
                "Michael Lee",
                "0434567890",
                "14:30",
                pharmacist1);

        // Sort and display appointments
        sortAppointmentsByTime(appointments);

        System.out.println("\nAPPOINTMENT DETAILS");

        for (Appointment appointment : appointments) {
            System.out.println(appointment);
            System.out.println();
        }

        // Test filtering by professional ID
        viewAppointmentsByProfessionalId(1001);
        viewAppointmentsByProfessionalId(4001);

        // Test filtering by patient phone
        viewAppointmentsByPatientPhone("0412345678");
        viewAppointmentsByPatientPhone("0499999999");

        // Test cancellation by professional ID and time
        cancelAppointmentByProfessional(1001, "09:30");

        // Test cancellation by patient phone
        cancelAppointmentByPatientPhone("0423456789");
        cancelAppointmentByPatientPhone("0499999999");

        // Display remaining appointments
        System.out.println("\nAPPOINTMENTS AFTER CANCELLATION");

        for (Appointment appointment : appointments) {
            System.out.println(appointment);
            System.out.println();
        }
    }

    // Books an appointment after validating its information.
    public static void bookAppointment(
            String patientName,
            String patientMobile,
            String appointmentTime,
            HealthProfessional healthProfessional) {

        if (patientName == null || patientName.isEmpty()
                || patientMobile == null || patientMobile.isEmpty()
                || appointmentTime == null || appointmentTime.isEmpty()
                || healthProfessional == null) {

            System.out.println(
                    "Warning: Appointment could not be booked. "
                            + "All required information must be provided.");

            return;
        }

        if (!isValidTimeSlot(appointmentTime)) {
            System.out.println(
                    "Warning: " + appointmentTime
                            + " is not a valid appointment time.");

            return;
        }

        for (Appointment appointment : appointments) {

            boolean sameProfessional =
                    appointment.getHealthProfessional()
                            .equals(healthProfessional);

            boolean sameTime =
                    appointment.getAppointmentTime()
                            .equals(appointmentTime);

            if (sameProfessional && sameTime) {
                System.out.println(
                        "Warning: This health professional "
                                + "is already booked at "
                                + appointmentTime
                                + ".");

                return;
            }
        }

        Appointment newAppointment =
                new Appointment(
                        patientName,
                        patientMobile,
                        appointmentTime,
                        healthProfessional);

        appointments.add(newAppointment);

        System.out.println(
                "Appointment successfully booked for "
                        + patientName
                        + ".");
    }

    //Displays appointments matching a patient mobile number.
    public static void viewAppointmentsByPatientPhone(
            String patientMobile) {

        boolean appointmentFound = false;

        System.out.println(
                "\nAPPOINTMENTS FOR PATIENT PHONE "
                        + patientMobile);

        for (Appointment appointment : appointments) {

            if (appointment.getPatientMobile()
                    .equals(patientMobile)) {

                System.out.println(appointment);
                System.out.println();

                appointmentFound = true;
            }
        }

        if (!appointmentFound) {
            System.out.println(
                    "Warning: No appointments were found "
                            + "for patient phone "
                            + patientMobile
                            + ".");
        }
    }

    //Displays appointments matching a professional ID.
    public static void viewAppointmentsByProfessionalId(
            int professionalId) {

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
                    "Warning: No appointments were found "
                            + "for health professional ID "
                            + professionalId
                            + ".");
        }
    }

// AI Declaration:
// ChatGPT helped me understand Java sorting.
// The final code is my own.
    //Sorts appointments from earliest to latest time.
    public static void sortAppointmentsByTime(
            ArrayList<Appointment> appointmentList) {

        for (int i = 0;
                i < appointmentList.size() - 1;
                i++) {

            for (int j = 0;
                    j < appointmentList.size() - 1 - i;
                    j++) {

                Appointment currentAppointment =
                        appointmentList.get(j);

                Appointment nextAppointment =
                        appointmentList.get(j + 1);

                if (currentAppointment.getAppointmentTime()
                        .compareTo(
                                nextAppointment
                                        .getAppointmentTime()) > 0) {

                    appointmentList.set(
                            j,
                            nextAppointment);

                    appointmentList.set(
                            j + 1,
                            currentAppointment);
                }
            }
        }
    }

    //Cancels an appointment matching a professional ID and time.
    public static void cancelAppointmentByProfessional(
            int professionalId,
            String appointmentTime) {

        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment =
                    appointments.get(i);

            boolean sameProfessional =
                    appointment.getHealthProfessional().getId()
                            == professionalId;

            boolean sameTime =
                    appointment.getAppointmentTime()
                            .equals(appointmentTime);

            if (sameProfessional && sameTime) {
                appointments.remove(i);

                System.out.println(
                        "Appointment successfully cancelled "
                                + "for health professional ID "
                                + professionalId
                                + " at "
                                + appointmentTime
                                + ".");

                return;
            }
        }

        System.out.println(
                "Warning: No appointment was found "
                        + "for health professional ID "
                        + professionalId
                        + " at "
                        + appointmentTime
                        + ".");
    }

     // AI Declaration:
     // ChatGPT helped me understand the search logic.
    // The final code is my own.
    //Cancels an appointment matching a patient mobile number.
    public static void cancelAppointmentByPatientPhone(
            String patientMobile) {

        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment =
                    appointments.get(i);

            if (appointment.getPatientMobile()
                    .equals(patientMobile)) {

                appointments.remove(i);

                System.out.println(
                        "Appointment successfully cancelled "
                                + "for patient phone "
                                + patientMobile
                                + ".");

                return;
            }
        }

        System.out.println(
                "Warning: No appointment was found "
                        + "for patient phone "
                        + patientMobile
                        + ".");
    }

    // AI Declaration:
    // ChatGPT helped me understand the validation logic.
    // The final code is my own.
    //Checks whether a requested time is a valid appointment slot.
    public static boolean isValidTimeSlot(
            String appointmentTime) {

        for (String timeSlot : validTimeSlots) {

            if (timeSlot.equals(appointmentTime)) {
                return true;
            }
        }

        return false;
    }
}