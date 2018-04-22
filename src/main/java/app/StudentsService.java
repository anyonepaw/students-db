package app;

import java.util.Date;
import java.util.List;

public interface StudentsService {

    void create(String name, String middle_name, String surname, String date_of_birth, String group_name);

    void delete(Long id);

    List<Student> list(int page);

    int countPages();


}
