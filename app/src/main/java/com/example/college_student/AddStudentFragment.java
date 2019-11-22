package com.example.college_student;


import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudentFragment extends Fragment  {

    public static List<StudentActivity> studentsList;

    private EditText etfullname, etage,etaddress;
    private RadioGroup Gender;
    private RadioButton rbtn;
    private Button Save;

    private int imageId, age;
    private String fullname, address, gender;


    public AddStudentFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_add_student, container, false);
        etfullname = view.findViewById(R.id.fullName);
        etage = view.findViewById(R.id.age);
        etaddress = view. findViewById(R.id.address);
        Gender = view.findViewById(R.id.rdgGender);

       Save = view.findViewById(R.id.btnSave);

       final int[] image = {R.drawable.male,R.drawable.female,R.drawable.others};
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectGender = Gender.getCheckedRadioButtonId();
                rbtn = view.findViewById(selectGender);
                if (rbtn.getText().toString().equals("Male")) {
                    imageId = image[0];

                } else if (rbtn.getText().toString().equals("Female")) {
                    imageId = image[1];
                } else {
                    imageId = image[2];
                }

                StudentActivity students = new StudentActivity(Integer.parseInt(etage.getText().toString()), imageId, etfullname.getText().toString(),
                                                                    etaddress.getText().toString(), rbtn.getText().toString());
                studentsList = MainActivity.studentsList;
                studentsList.add(students);
                Toast.makeText(getActivity(), "Registration Successful", Toast.LENGTH_LONG).show();
                etfullname.getText().clear();
                etage.getText().clear();
                etaddress.getText().clear();
                Gender.clearCheck();
            }
    });
        return view;
}
    }


