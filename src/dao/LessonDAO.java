package dao;

import entity.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class LessonDAO extends GeneralDAO<Lesson> {


    private static LessonDAO instance;


    public static LessonDAO getInstance() throws Exception {
        if (instance == null)
            instance = new LessonDAO();
        return instance;
    }

    public LessonDAO() throws Exception {
        add(new Lesson(1, LessonType.LAW, new Date(), ProfessorDAO.getInstance().findProfessorByName("Bill", "Green"), GroupDAO.getInstance().getGroupByName(GroupName.GROUP_101)));
    }


    public Lesson getLessonById(long id) throws Exception {

        for (Lesson lesson : getAll()) {
            if (lesson != null && lesson.getId() == id) {
                return lesson;
            }
        }
        throw new Exception("Lesson with id" + id + " not found ");
    }

    public void startLesson(Lesson lesson) throws Exception {

        for (Student student : StudentDAO.getInstance().getStudentsByGroupName(lesson.getGroup().getGroupName())){
            if (student != null ){
                student.addLesson(lesson);
            }
        }
    }


    @Override
    public Lesson add(Lesson lesson) {
        return super.add(lesson);
    }

    @Override
    public void remove(Lesson lesson) {
        super.remove(lesson);
    }

    @Override
    public Set<Lesson> getAll() {
        return super.getAll();
    }
}
