package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


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


    private void createStudentsDB() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS students");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "middle_name VARCHAR(100) NOT NULL," +
                "surname VARCHAR(100) NOT NULL," +
                "date_of_birth VARCHAR(100) NOT NULL," +
                "group_name VARCHAR(100) NOT NULL" +
                ")");
    }


    private void createStudents() {
        studentsService.create("Василий", "Петрович", "Иванов", randomDate(), "МФ1601");
        studentsService.create("Александр", "Иванович", "Бибиков", randomDate(), "ИТ1501");
        studentsService.create("Татьяна", "Витальевна", "Деревянкова", randomDate(), "ИТ1401");
        studentsService.create("Даниил", "Валерьевич", "Волков", randomDate(), "ИТ1401");
        studentsService.create("Павел", "Павлович", "Павлов", randomDate(), "МФ1401");
        studentsService.create("Анна", "Петровна", "Свиридонова", randomDate(), "ИТ1601");
        studentsService.create("Екатерина", "Алексеевна", "Спиридонова", randomDate(), "ИТ1601");
        studentsService.create("Кирилл", "Витальевич", "Вятников", randomDate(), "ИТ1501");
        studentsService.create("Татьяна", "Павловна", "Румянцева", randomDate(), "Э1601");
        studentsService.create("Алексей", "Эдуардович", "Брагин", randomDate(), "МИТ1801");
        studentsService.create("Артем", "Витальевич", "Баталов", randomDate(), "ИТ1601");
        studentsService.create("Алексей", "Игоревич", "Белов", randomDate(), "Э1601");
        studentsService.create("Максим", "Викторович", "Черкашенко", randomDate(), "МИТ1801");
    }


    private String randomDate() {

        Random random;
        long ms;

        // Get a new random instance, seeded from the clock
        random = new Random();

        // Get an Epoch value roughly between 1995 and 2000
        // 788918400L = January 1, 1995
        // Add up to 5 years to it (using modulus on the next long)

        ms = 788918400000L + (Math.abs(random.nextLong()) % (5L * 365 * 24 * 60 * 60 * 1000));
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        return formatter.format(new Date(ms));
    }

}