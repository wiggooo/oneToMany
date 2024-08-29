
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class ManyToManyTest {
    private static SessionFactory sessionfactory = null;
    private static SessionFactory getSessionFactory(){
        if(sessionfactory == null){
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionfactory = configuration.buildSessionFactory();
        }
        return sessionfactory;
    }

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student student1 = new Student("Erik", "201");
        Student student2 = new Student("Lars", "455");
        Student student3 = new Student("Anders", "134");
        Tutor tutor1 = new Tutor("2387", "Fredrik", 35000);

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(tutor1);

        tutor1.addStudentToStudents(student1);
        tutor1.addStudentToStudents(student2);
        tutor1.addStudentToStudents(student3);

        tx.commit();

        Tutor tutorFromDatabase = session.get(Tutor.class, 1);
        System.out.println("Students from this tutor: " + tutorFromDatabase.getStudents());


        session.close();
    }
}
