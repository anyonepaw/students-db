package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentsController {

    private final StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping({"/", "/students"})
    public String show(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        model.addAttribute("allPages", studentsService.countPages());
        model.addAttribute("students", studentsService.list(page));
        model.addAttribute("page", page);
        return "students";
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        studentsService.delete(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/students/create")
    public String create(Model model, HttpServletRequest request) {
        model.addAttribute("actionUrl", "/students/create");
        return "create";
    }

    @PostMapping("/students/create")
    public String create(HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("Name");
        String middle_name = httpServletRequest.getParameter("Middle_name");
        String surname = httpServletRequest.getParameter("Surname");
        String date_of_birth = httpServletRequest.getParameter("Date_of_birth");
        String group = httpServletRequest.getParameter("Group");
        studentsService.create(name, middle_name, surname, date_of_birth, group);
        return "redirect:/students";
    }

}
