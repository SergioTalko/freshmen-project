package demo;

import controller.Controller;
import dao.GroupDAO;
import dao.LessonDAO;
import dao.ProfessorDAO;
import dao.StudentDAO;
import entity.*;

public class Demo {
    public static void main(String[] args) throws Exception {
        GroupDAO groupDAO = GroupDAO.getInstance();
        StudentDAO studentDAO = StudentDAO.getInstance();
        ProfessorDAO professorDAO = ProfessorDAO.getInstance();
        LessonDAO lessonDAO = LessonDAO.getInstance();
        Controller controller = new Controller(groupDAO, lessonDAO, studentDAO, professorDAO);

        //можливість додавати обєкти
        Group group = new Group(1, GroupName.GROUP_101);
        groupDAO.add(group);

        Student student = new Student(1002, "John", "Smith", 4.8, true, StudentType.ORDINARY_STUDENT);
        studentDAO.add(student);

        //обрання старости групи з виводом його в консоль
//        System.out.println(controller.chooseGroupLeader(groupDAO.getGroupByName(GroupName.GROUP_101)));

        //старт лекції
        lessonDAO.startLesson(lessonDAO.getLessonById(1));

        //відмічення відсутнього студента
        controller.checkAbsentStudentOnLesson(lessonDAO.getLessonById(1),2);
        //виведення кількості присутніх на лекції студентів
        System.out.println(controller.sumAvailableStudentOnLesson(lessonDAO.getLessonById(1)));








//        System.out.println(studentDAO.add(student1));
//        System.out.println(studentDAO.getAll());

//        System.out.println(studentDAO.getAll());


//        System.out.println(StudentDAO.getInstance().getAll());
//        System.out.println(controller.chooseGroupLeader(groupDAO.getGroupByName(GroupName.GROUP_101)));
//        System.out.println(controller.chooseGroupLeader(groupDAO.getGroupByName(GroupName.GROUP_102)));
//        System.out.println(controller.chooseGroupLeader(groupDAO.getGroupByName(GroupName.GROUP_103)));
//        System.out.println(StudentDAO.getInstance().getAll());
//        System.out.println("");
//        System.out.println(controller.chooseGroupLeader(groupDAO.getGroupByName(GroupName.GROUP_101)));

//        System.out.println(StudentDAO.getInstance().getAll());
//        System.out.println(GroupDAO.getInstance().getGroupByName(GroupName.GROUP_101).getStudents());
//        System.out.println(LessonDAO.getInstance().getAll());
//        System.out.println(controller.chooseGroupLeader(groupDAO.getGroupByName(GroupName.GROUP_101)));


    }
}
