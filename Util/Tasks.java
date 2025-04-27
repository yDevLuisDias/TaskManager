package Util;

public class Tasks {

    private final String name;
    private final String valid;
    private final String des;

    public Tasks(String name, String des, String valid) {
        this.name = name;
        this.des = des;
        this.valid = valid;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public String getValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "Name : " + getName() + "\n" + "Description : " + getDes() + "\n" + "Validation : " + getValid();
    }
}