package controller;

import dao.GroupDAO;
import dao.LessonDAO;
import dao.ProfessorDAO;
import dao.StudentDAO;
import entity.Group;
import entity.Lesson;
import entity.Professor;
import entity.Student;

public class Controller {

    private GroupDAO  groupDAO;
    private LessonDAO lessonDAO;
    private StudentDAO studentDAO;
    private ProfessorDAO professorDAO;


    public Controller(GroupDAO groupDAO, LessonDAO lessonDAO, StudentDAO studentDAO, ProfessorDAO professorDAO) {
        this.groupDAO = groupDAO;
        this.lessonDAO = lessonDAO;
        this.studentDAO = studentDAO;
        this.professorDAO = professorDAO;
    }

    public Student chooseGroupLeader(Group group) throws Exception {
        return groupDAO.chooseGroupLeader(group);
    }

    public void startLesson(Lesson lesson) throws Exception {
        lessonDAO.startLesson(lesson);
    }

    public void checkAbsentStudentOnLesson(Lesson lesson, long studentId) throws Exception {
        professorDAO.checkAbsentStudentOnLesson(lesson,studentId);
    }

    public int sumAvailableStudentOnLesson(Lesson lesson) throws Exception {
        return professorDAO.sumAvailableStudentOnLesson(lesson);
    }

}
