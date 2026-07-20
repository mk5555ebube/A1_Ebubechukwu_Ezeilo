public class AssignmentOne {

    public static void main(String[] args) {

        System.out.println("PROG2004 Assessment 1");
        System.out.println("Health Service Appointment System");

    

        String[] days1 = {"Monday", "Wednesday", "Friday"};
        String[] days2 = {"Tuesday", "Thursday"};
        String[] days3 = {"Monday", "Tuesday", "Friday"};

        HealthProfessional hp1 =
                new HealthProfessional(1001, "Ebube Williams", days1);

        HealthProfessional hp2 =
                new HealthProfessional(1002, "John Smith", days2);

        HealthProfessional hp3 =
                new HealthProfessional(1003, "Emily Brown", days3);

        System.out.println(hp1);
        System.out.println();

        System.out.println(hp2);
        System.out.println();

        System.out.println(hp3);


    }

}