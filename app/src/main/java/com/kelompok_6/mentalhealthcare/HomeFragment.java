package com.kelompok_6.mentalhealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<String> data = new ArrayList<>();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        CardView cardView = (CardView) v.findViewById(R.id.conseling);
        CardView call = (CardView) v.findViewById(R.id.call);
        CardView clinic = (CardView) v.findViewById(R.id.clinic);
        CardView daily = (CardView) v.findViewById(R.id.daily);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Buat intent yang mengarah ke kelas DetailActivity
                Intent intent = new Intent(getActivity(), ConselingActivity.class);
                // Mulai activity yang dituju
                startActivity(intent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Buat intent yang mengarah ke kelas DetailActivity
                Intent intent = new Intent(getActivity(), callActivity.class);
                // Mulai activity yang dituju
                startActivity(intent);
            }
        });
        clinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Buat intent yang mengarah ke kelas DetailActivity
                Intent intent = new Intent(getActivity(), ClinicActivity.class);
                // Mulai activity yang dituju
                startActivity(intent);
            }
        });
        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Buat intent yang mengarah ke kelas DetailActivity
                Intent intent = new Intent(getActivity(), ListActivity.class);
                // Mulai activity yang dituju
                startActivity(intent);
            }
        });
        return v;
    }
}