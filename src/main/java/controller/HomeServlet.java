package controller;

import model.Class1;
import model.Student;
import service.ClassService;
import service.ClassServiceImpl;
import service.StudentService;
import service.StudentServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/homes")

public class HomeServlet extends HttpServlet {
    ClassService classService = new ClassServiceImpl();
    StudentService studentService = new StudentServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classId = request.getParameter("classId");
        String findName = request.getParameter("findName");
        List<Class1> class1s = classService.findAll();
        request.setAttribute("classes",class1s);
        List<Student> students= studentService.findAll();
        if (classId != null){
            students = studentService.findAllByClass(Integer.parseInt(classId));
        }
        if (findName != null){
            students = studentService.findAllByNameContains(findName);
        }
        request.setAttribute("students",students);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
