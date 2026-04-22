package com.example.proll;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    private List<MyItem> items;
    public SimpleAdapter(List<MyItem> items) {
        this.items = items;
    }
    @NonNull
    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull SimpleAdapter.ViewHolder holder, int position) {
        MyItem item = items.get(position);
        holder.textView.setText(item.getText());
        holder.imag.setImageResource(item.getImageResId());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imag;
        TextView textView;
        ViewHolder(View view) {
            super(view);
            imag = view.findViewById(R.id.imag);
            textView = view.findViewById(R.id.item_text);
        }
    }
}