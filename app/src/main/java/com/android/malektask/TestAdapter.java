package com.android.malektask;
import android.content.Intent;
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
        String Title = searchTitle.get(position).getTitle();
        holder.txtTitle.setText("Title: " + Title);
    }
    @Override
    public int getItemCount() {
        return searchTitle.size();
    }
    class TestViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        public TestViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Search search = searchTitle.get(getAdapterPosition());
                    Intent intent = new Intent(itemView.getContext(), AsyncHttpTitleActivity.class);
                    intent.putExtra("id", search.getImdbID());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}