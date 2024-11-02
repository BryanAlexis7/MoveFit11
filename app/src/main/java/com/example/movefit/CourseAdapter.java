package com.example.movefit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CourseModel> courseList;
    private OnItemClickListener listener;

    // Constructor
    public CourseAdapter(Context context, ArrayList<CourseModel> courseList, OnItemClickListener listener) {
        this.context = context;
        this.courseList = courseList;
        this.listener = listener;
    }

    // Interfaz para manejar los clics en los elementos
    public interface OnItemClickListener {
        void onItemClick(CourseModel course);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseModel course = courseList.get(position);
        holder.courseName.setText(course.getCourseName());
        holder.courseDescription.setText(course.getCourseDescription());
        holder.courseImage.setImageResource(course.getCourseImage());

        // Configurar el listener para cada ítem
        holder.itemView.setOnClickListener(v -> listener.onItemClick(course));
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView courseName, courseDescription;
        ImageView courseImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.course_name);
            courseDescription = itemView.findViewById(R.id.course_description);
            courseImage = itemView.findViewById(R.id.course_image);
        }
    }
}
