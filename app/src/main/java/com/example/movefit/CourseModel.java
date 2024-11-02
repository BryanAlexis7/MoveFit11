package com.example.movefit;

public class CourseModel {
    private String courseName;
    private String courseDescription;
    private int courseImage;  // Puedes usar un int para almacenar el recurso de la imagen

    public CourseModel(String courseName, String courseDescription, int courseImage) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseImage = courseImage;
    }

    // Getters
    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public int getCourseImage() {
        return courseImage;
    }
}
