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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.start_btn_fragment, container, false);

        Button start = (Button) view.findViewById(R.id.buttonstart);
        Button exit = (Button) view.findViewById(R.id.buttonexit);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListActivity.class);
                startActivity(intent);
                //Toast.makeText(getActivity(), "Нажата кнопка!!!", Toast.LENGTH_SHORT).show();
            }
        });

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
