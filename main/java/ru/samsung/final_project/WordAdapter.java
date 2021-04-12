package ru.samsung.final_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private List<Word> words;
    private LayoutInflater inflater;
    private int layout;


    public WordAdapter(Context context, int resource, List<Word> obj) {
        super(context, resource, obj);
        this.layout = resource;
        this.words = obj;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Word word = words.get(position);
        viewHolder.nameView.setText(word.getName());
        viewHolder.trancriptionView.setText(word.getTranscription());
        viewHolder.translationView.setText(word.getTranslation());

        return convertView;
    }

    private class ViewHolder{
        final TextView nameView;
        final TextView trancriptionView;
        final TextView translationView;
        ViewHolder(View view){
            nameView = view.findViewById(R.id.wordName);
            trancriptionView = view.findViewById(R.id.wordTranscriprion);
            translationView = view.findViewById(R.id.wordTranslation);
        }
    }
}
