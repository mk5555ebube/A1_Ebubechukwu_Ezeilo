public class AssignmentOne {

    public static void main(String[] args) {

        System.out.println("PROG2004 Assessment 1");
        System.out.println("Health Service Appointment System");

    

        String[] days1 = {"Monday", "Wednesday", "Friday"};
String[] days2 = {"Tuesday", "Thursday"};
String[] days3 = {"Monday", "Tuesday", "Friday"};

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

GeneralPractitioner gp3 =
        new GeneralPractitioner(
                1003,
                "Emily Brown",
                days3,
                "Robina Health Centre");

System.out.println(gp1);
System.out.println();

System.out.println(gp2);
System.out.println();

System.out.println(gp3);

    }

}