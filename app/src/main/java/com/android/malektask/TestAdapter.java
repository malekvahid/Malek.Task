package com.android.malektask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.malektask.Imdb.Search;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    List <Search> searchTitle ;
    TestAdapter(List<Search> list) {
        searchTitle = list;
    }
     @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_item,parent,false);
        TestViewHolder holder = new TestViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {

        switch (position){
            case 0:
            holder.txtTitle.setText("test1");
            break;



        }
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    class TestViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }
}
