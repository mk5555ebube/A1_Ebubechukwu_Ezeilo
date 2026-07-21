public class AssignmentOne {

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

System.out.println(gp1);
System.out.println();

System.out.println(gp2);
System.out.println();

System.out.println(pharmacist1);
System.out.println();

System.out.println(dentist1);
System.out.println();

System.out.println(physiotherapist1);

    }


}