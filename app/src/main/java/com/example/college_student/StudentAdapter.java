package com.example.college_student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context mContext;
    List<StudentActivity> studentsList;

    public StudentAdapter(Context mContext,List<StudentActivity> studentsList){
        this.mContext = mContext;
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_student,parent,false);
        return new StudentViewHolder(view, mContext, studentsList);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, final int i) {
        final StudentActivity students = studentsList.get(i);
        holder.name.setText(students.getFullname());
        holder.age.setText(String.format("%d", students.getAge()));
        holder.gender.setText(students.getGender());
        holder.address.setText(students.getAddress());
        holder.image.setImageResource(students.getImageId());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentsList.remove(i);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView name, age, address,gender;
        ImageView image;
        Button btnDelete;
        List<StudentActivity> list;
        Context context;

        public StudentViewHolder(View itemView, final Context context, final List<StudentActivity> list ) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            address = itemView.findViewById(R.id.address);
            gender = itemView.findViewById(R.id.gender);
            image = itemView.findViewById(R.id.imageView);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            this.context = context;
            this.list = list;

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StudentActivity stud = list.get(getAdapterPosition());
                    Toast.makeText(context, stud.getFullname(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
