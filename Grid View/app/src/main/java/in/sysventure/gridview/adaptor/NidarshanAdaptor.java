package in.sysventure.gridview.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import in.sysventure.gridview.R;

public class NidarshanAdaptor extends ArrayAdapter<String> {

    private Context context;
    private String[] arr;

    public NidarshanAdaptor(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
        this.arr = objects;
        this.context = context;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arr[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /*
            Need to inflate custom layout with LayoutInflater. Here from returns View.
            After that we can access components from custom layout.
         */

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.nidarshan_layout, parent, false);

        //Now we can access layout's component by id
        TextView tv = convertView.findViewById(R.id.textView);
        tv.setText(getItem(position));

        //button click
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked on ##############= "+position, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
