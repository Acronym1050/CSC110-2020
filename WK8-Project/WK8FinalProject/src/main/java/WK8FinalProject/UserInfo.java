package WK8FinalProject;

public class UserInfo implements Comparable{
    public String serialNumber;
    public String companyName;
    public String name;
    public String description;
    public String leave;
    public String phone;
    public String address;
    public String time;

    @Override
    public int compareTo(Object o) {
        if(o instanceof UserInfo){
            return ((UserInfo) o).name.compareTo(this.name);
        }
        return 0;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof UserInfo){
            return ((UserInfo) o).name.equals(this.name);
        }
        return false;
        
    }
}