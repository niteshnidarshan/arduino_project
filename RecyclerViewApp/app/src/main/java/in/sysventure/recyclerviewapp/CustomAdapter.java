package in.sysventure.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] localDataSet;

    /*
    * Provide a reference to the type of views that you are using
    * (Custom ViewHolder)
    * */

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }


    // Step_1
    public CustomAdapter(String[] dataSet){
        localDataSet = dataSet;
    }

    // Step_2 Create new view (Invked by the Layout Manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //Create a new view which defines the UI of the list item

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Step_3 Relpcae the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        //Get element from your dataset at this position and
        //replace the contents of the view with that element
        viewHolder.getTextView().setText(localDataSet[position]);
    }

    //Return the size of your dataset (invoked by the Layout Manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
