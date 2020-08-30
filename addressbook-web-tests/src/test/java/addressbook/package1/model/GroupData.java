package addressbook.package1.model;

import java.util.Objects;
import java.util.Optional;

public class GroupData {
    private final String groupName;

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    @Override
    public String toString() {
        return "GroupData{" +
                "groupName='" + groupName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    public GroupData(int id, String groupName) {
        this.groupName = groupName;
        this.id = id;
    }


    public GroupData(String groupName) {
        this.groupName = groupName;
        this.id = Integer.MAX_VALUE;
    }

    public String getGroupName() {
        return groupName;
    }

//    public void setId(Optional<GroupData> max) {
//    }
}
