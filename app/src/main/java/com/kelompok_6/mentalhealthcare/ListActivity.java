package com.kelompok_6.mentalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] datadescription;
    private TypedArray dataPhoto;
    private ExAdapter adapter;
    private ArrayList<Exercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Context context = getApplicationContext();
        adapter = new ExAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                if (i==0){
                    Toast.makeText(ListActivity.this, exercises.get(i).getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        datadescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        exercises = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Exercise exercise= new Exercise ();
            exercise.setPhoto(dataPhoto.getResourceId(i, -1));
            exercise.setName(dataName[i]);
            exercise.setDescription(datadescription[i]);
            exercises.add(exercise);
        }
        adapter.setExercises(exercises);
    }
}
