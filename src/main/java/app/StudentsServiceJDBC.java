package app;


import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Primary
public class StudentsServiceJDBC implements StudentsService{

    private static final BeanPropertyRowMapper<Student> STUDENT_MAPPER = new BeanPropertyRowMapper<>(Student.class);
    private final JdbcTemplate jdbcTemplate;

    public StudentsServiceJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(String name, String middle_name, String surname, String date_of_birth, String group_name) {
        String sql = "INSERT INTO students (id, name, middle_name, surname, date_of_birth, group_name" +
                " ) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, null, name, middle_name, surname, date_of_birth, group_name);
    }


    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM students WHERE id = ?", id);
    }



    @Override public List<Student> list(int page) {
        return jdbcTemplate.query("SELECT * FROM students order by id LIMIT 10 OFFSET ?", STUDENT_MAPPER, page * 10);
    }

    @Override
    public int countPages() {
        String sql = "SELECT count(1) FROM students";
        int allStudents = jdbcTemplate.queryForObject(sql, Integer.class);
        return (int) Math.ceil(allStudents / 10.0);
    }


}
