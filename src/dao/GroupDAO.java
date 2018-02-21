package dao;

import com.sun.istack.internal.localization.NullLocalizable;
import entity.Group;
import entity.GroupName;
import entity.Student;
import entity.StudentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GroupDAO extends GeneralDAO<Group> {

    private static GroupDAO instance;


    public static GroupDAO getInstance() throws Exception {
        if (instance == null)
            instance = new GroupDAO();
        return instance;
    }

    public GroupDAO() throws Exception {
        add(new Group(1001, GroupName.GROUP_101));
        add(new Group(1002, GroupName.GROUP_102));
        add(new Group(1003, GroupName.GROUP_103));
    }


    public Student chooseGroupLeader(Group group) throws Exception {
        if (group == null) throw new NullPointerException("Input data is null");

        if (checkGroupLeader(group))
            throw new Exception("Group with name " + group.getGroupName() + " already have leader");

        List<Student> contenders = new ArrayList<>();

        for (Student student : StudentDAO.getInstance().getAll()) {
            if (student != null && student.isWantToBeLeader() && student.getAverageScore() > 4.0) {

            }
            contenders.add(student);
        }

        Random random = new Random();
        int index = random.nextInt(contenders.size());
        Student result = contenders.get(index);
        result.setStudentType(StudentType.GROUP_LEADER);

        return result;
    }


    public Group getGroupByName(GroupName groupName) throws Exception {
        if (groupName == null) throw new NullPointerException("Input data is null");
        for (Group group : getAll()) {
            if (group != null && group.getGroupName().equals(groupName)) {
                return group;
            }
        }
        throw new Exception("Group with name" + groupName + " not found");
    }

    private boolean checkGroupLeader(Group group) throws Exception {
        if (group == null) throw new NullPointerException("Input data is null");

        for (Student student : group.getStudents()) {
            if (student != null && student.getStudentType().equals(StudentType.GROUP_LEADER) ) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Group add(Group group) {
        return super.add(group);
    }

    @Override
    public void remove(Group group) {
        super.remove(group);
    }

    @Override
    public Set<Group> getAll() {
        return super.getAll();
    }
}
