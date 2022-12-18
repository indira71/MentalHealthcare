package com.kelompok_6.mentalhealthcare;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Exercise> exercises;

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public ExAdapter(Context context) {
        this.context = context;
        exercises = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return exercises.size();
    }

    @Override
    public Object getItem(int i) {
        return exercises.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_ex, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Exercise exercise = (Exercise) getItem(i);
        viewHolder.bind(exercise);
        return view;
    }
    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder (View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Exercise exercise) {
            txtName.setText(exercise.getName());
            txtDescription.setText(exercise.getDescription());
            imgPhoto.setImageResource(exercise.getPhoto());
        }
    }
}
