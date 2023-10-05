package dao;

public abstract class DaoFactory {

    static {
        try {

            System.out.println("Loading driver...");
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded!");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ManagerDao getManagerSQL(){
        return new ManagerDaoImpl();
    }

    public static StudentDao getStudentSQL(){
        return new StudentDaoImpl();
    }

    public static MentorDao getMentorSQL(){
        return new MentorDaoImpl();
    }

    public static AddressDao getAddressSQL(){
        return new AddressDaoImpl();
    }

}
