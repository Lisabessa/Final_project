package ru.samsung.final_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment_start_image extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.start_image_fragment, container, false);

        ImageView imageView = (ImageView)  view.findViewById(R.id.startpic);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Добро пожаловать в приложение!", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
