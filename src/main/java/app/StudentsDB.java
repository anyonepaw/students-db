package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



@Component
public class StudentsDB implements CommandLineRunner {


    private final JdbcTemplate jdbcTemplate;
    private final StudentsService studentsService;

    @Autowired
    public StudentsDB(JdbcTemplate jdbcTemplate, StudentsService studentsService) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentsService = studentsService;
    }

    @Override
    public void run(String... args) throws Exception {
        createStudentsDB();
        createStudents();
    }


    //имя, фамилия, отчество, дата рождения, группа, уникальный
    //номер
    private void createStudentsDB() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS students");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "middle_name VARCHAR(100) NOT NULL," +
                "surname VARCHAR(100) NOT NULL," +
                "date_of_birth VARCHAR(100)NOT NULL," +
                "group_name VARCHAR(100) NOT NULL" +
                ")");
    }

    // SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    private void createStudents() {
        studentsService.create("Василий", "Петрович", "Иванов", "1999/3/15", "МФ1601");
        studentsService.create("Александр", "Иванович", "Бибиков", "1998/5/25", "ИТ1501");
        studentsService.create("Татьяна", "Витальевна", "Деревянкова", "1997/8/9", "ИТ1401");
        studentsService.create("Даниил", "Валерьевич", "Волков", "1997/8/9", "ИТ1401");
        studentsService.create("Павел", "Павлович", "Павлов", "1997/4/10", "МФ1401");
        studentsService.create("Анна", "Петровна", "Свиридонова", "1997/8/9", "ИТ1601");
        studentsService.create("Екатерина", "Алексеевна", "Спиридонова", "1997/2/1", "ИТ1601");
        studentsService.create("Кирилл", "Витальевич", "Вятников", "1998/10/12", "ИТ1501");
        studentsService.create("Татьяна", "Павловна", "Румянцева", "1997/8/9", "Э1601");
        studentsService.create("Алексей", "Эдуардович", "Брагин", "1996/5/3", "МИТ1801");
        studentsService.create("Артем", "Витальевич", "Баталов", "1997/8/9", "ИТ1601");
        studentsService.create("Алексей", "Игоревич", "Белов", "1997/8/9", "Э1601");
        studentsService.create("Максим", "Викторович", "Черкашенко", "1996/8/9", "МИТ1801");
    }
}
