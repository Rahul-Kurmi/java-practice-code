public class _4_interface {

    interface Person {
        String profession();
    }

    // We use static because main() is static, so the nested Teacher and Engineer classes can be used directly without creating an object of the outer _4_interface class.

    public static class Teacher implements Person {

        @Override
        public String profession() {
            return "Teaching";
        }
    }

    public static class Engineer implements Person {

        @Override
        public String profession() {
            return "Software Engineer";
        }
    }

    public static void main(String[] args) {

        Person softwareEngineer = new Engineer();
        Person teacher = new Teacher();

        Teacher teacher2 = new Teacher();
        Engineer softwareEngineer2 = new Engineer();

        System.out.println(softwareEngineer.profession());
        System.out.println(teacher.profession());
        System.out.println(teacher2.profession());
        System.out.println(softwareEngineer2.profession());
    }
}