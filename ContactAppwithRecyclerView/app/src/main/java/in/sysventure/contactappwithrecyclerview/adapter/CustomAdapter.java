package in.sysventure.contactappwithrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import in.sysventure.contactappwithrecyclerview.R;
import in.sysventure.contactappwithrecyclerview.model.Contact;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Contact[] contacts;
    private TextView textView;
    private TextView textView2;

    /*
    * Provide a reference to the type of views that you are using
    * (Custom ViewHolder)
    * */

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        //private final TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
            //textView2 = (TextView)itemView.findViewById(R.id.textView2);
        }

        public TextView getTextView() {
            return textView;
        }
    }


    // Step_1
    public CustomAdapter(Contact[] dataSet){
        contacts = dataSet;
    }

    // Step_2 Create new view (Invked by the Layout Manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //Create a new view which defines the UI of the list item

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_layout, viewGroup, false);

        textView = view.findViewById(R.id.textView);
        textView2 = view.findViewById(R.id.textView2);

        return new ViewHolder(view);
    }

    // Step_3 Relpcae the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        //Get element from your dataset at this position and
        //replace the contents of the view with that element
        textView.setText(contacts[position].getPhoneNumber());
        textView2.setText(contacts[position].getName());
    }

    //Return the size of your dataset (invoked by the Layout Manager)
    @Override
    public int getItemCount() {
        return contacts.length;
    }
}
