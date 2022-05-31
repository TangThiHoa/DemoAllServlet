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
import java.sql.SQLException;
import java.util.List;

import static javafx.beans.property.adapter.JavaBeanDoublePropertyBuilder.create;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImp();
    ClassService classService = new ClassServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }
        switch (act) {
            case "create":
                ShowCreate(request, response);
                break;

            default:
                showList(request, response);
        }

    }

    private void ShowCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Class1> classes = classService.findAll();
        request.setAttribute("ds", classes);
        request.getRequestDispatcher("student/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        request.setAttribute("ds", students);
        request.getRequestDispatcher("student/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }
        switch (act) {
            case "Create":
                try {
                    create(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//        String name = request.getParameter("name");
//        int age = Integer.parseInt(request.getParameter("age"));
//        int classId = Integer.parseInt(request.getParameter("classId"));
//        Class1 clazz = classService.findById(classId);
//        studentService.add(0, name, clazz, age);


    }
}
