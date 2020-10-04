package addressbook.package1.model;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class GroupData {
    @Expose
    private String groupName;
    private int id = Integer.MAX_VALUE;

//    public GroupData(int id, String groupName) {
//        this.groupName = groupName;
//        this.id = id;
//    }
//
//
//    public GroupData(String groupName) {
//        this.groupName = groupName;
//        this.id = Integer.MAX_VALUE;
//    }

    public String getGroupName() { return groupName; }

    public int getId() {
        return id;
    }

    public GroupData withId(int id)
    {
        this.id = id;
        return this;
    }

    public GroupData withName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, id);
    }



    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


}
