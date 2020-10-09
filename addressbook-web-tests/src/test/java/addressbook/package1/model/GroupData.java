package addressbook.package1.model;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="group_list")
public class GroupData {
    @Expose

    @Column(name="group_name")
    private String groupName;

    @Id
    @Column(name="group_id")
    private int id = Integer.MAX_VALUE;

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
