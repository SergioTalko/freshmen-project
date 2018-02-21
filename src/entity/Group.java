package entity;

import dao.StudentDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Group {
    private long id;
    private GroupName groupName;
    private Set<Student> students = new HashSet<>();

    public Group(long id, GroupName groupName) throws Exception {
        this.id = id;
        this.groupName = groupName;

    }


    public GroupName getGroupName() {
        return groupName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName=" + groupName +
                ", students=" + students +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
