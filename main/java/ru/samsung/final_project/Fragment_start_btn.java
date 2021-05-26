package ru.samsung.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment_start_btn extends Fragment {
    Button start;
    Button exit;
    Button userChoice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.start_btn_fragment, container, false);

        Button exit = (Button) view.findViewById(R.id.buttonexit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Выход...", Toast.LENGTH_SHORT).show();
                getActivity().finish();
                System.exit(0);
            }
        });

        return view;
    }
}
