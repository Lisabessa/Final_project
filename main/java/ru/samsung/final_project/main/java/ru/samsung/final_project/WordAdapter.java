package ru.samsung.final_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> implements Filterable {
    private List<Word> words;
    private List<Word> filteredWords;
    private LayoutInflater inflater;
    private int layout;
    private WordFilter filter;


    public WordAdapter(Context context, int resource, List<Word> obj) {
        super(context, resource, obj);
        this.layout = resource;
        this.words = new ArrayList<>();
        this.words.addAll(obj);

        this.filteredWords = new ArrayList<>();
        this.filteredWords.addAll(obj);

        this.inflater = LayoutInflater.from(context);
        getFilter();
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new WordFilter();
        }
        return filter;
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
        Word word = filteredWords.get(position);
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

    private class WordFilter extends Filter
    {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if(constraint.toString().length() > 0)
            {
                ArrayList<Word> filteredItems = new ArrayList<Word>();

                for(int i = 0, l = words.size(); i < l; i++)
                {
                    Word m = words.get(i);
                    if(m.getName().toLowerCase().contains(constraint))
                        filteredItems.add(m);
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }
            else
            {
                result.values = words;
                result.count = words.size();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            filteredWords = (ArrayList<Word>)results.values;
            notifyDataSetChanged();
            clear();
            for(int i = 0, l = filteredWords.size(); i < l; i++)
                add(filteredWords.get(i));
            notifyDataSetInvalidated();
        }
    }
}
