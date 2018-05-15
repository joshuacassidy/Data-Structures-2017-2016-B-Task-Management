package com.josh.Heap;

/**
 * Created by Josh on 15/05/2018.
 */
public class StudentRequest implements Comparable<StudentRequest> {
    private String studentID, desc;
    private int priority;

    public StudentRequest(String studentID, String desc, int priority) {
        this.studentID = studentID;
        this.desc = desc;
        this.priority = priority;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(StudentRequest o) {
        if (o.getPriority() > priority) {
            return -1;
        } else if(o.getPriority() < priority) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return

                "priority:" + priority;
    }
}
