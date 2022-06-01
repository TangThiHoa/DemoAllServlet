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

import static java.nio.file.Files.delete;
import static javafx.beans.property.adapter.JavaBeanDoublePropertyBuilder.create;
import static jdk.nashorn.internal.objects.NativeString.search;

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
            case "edit":
                ShowEdit(request, response);
                break;
            case "delete":
                try {
                    showDelete(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "view":
                showView(request, response);
                break;
            default:
                showList(request, response);
        }

    }


    private void showView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher = null;
        if (student != null) {
            request.setAttribute("st", student);
            dispatcher = request.getRequestDispatcher("student/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("xoa", student);
        studentService.delete(id);
        response.sendRedirect("/students");
    }

    private void ShowEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Class1> classes = classService.findAll();
        request.setAttribute("ds", classes);
        Student student = studentService.findById(id);
        request.setAttribute("sua", student);
        request.getRequestDispatcher("student/edit.jsp").forward(request, response);
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
            case "create":
                try {
                    create(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    edit(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
//            case "delete":
//                try {
//                    delete(request,response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
        }
    }


    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        int id = Integer.parseInt(request.getParameter("id"));
        Class1 clazz = classService.findById(classId);
        Student student = new Student(id, name, clazz, age);
        studentService.update(student);
        response.sendRedirect("/students");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        Class1 clazz = classService.findById(classId);
        Student student = new Student(name, age, clazz);
        studentService.add(student);
        response.sendRedirect("/students");
    }
}
