package in.sysventure.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import in.sysventure.gridview.adaptor.NidarshanAdaptor;

public class MainActivity extends AppCompatActivity {

    /**
     * ListView is used to show list on screen
     * It requires RecycleViewLayout.
     */
    private ListView listView;
    private String items[] = {"Jai Ram G ki", "Ram G", "Sita G", "Laxman G", "Bharat G", "Shatrughan G", "Nitesh", "Nidarshan", "A", "B", "C"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //ListView requires an Adaptor to show data

        //Inbuilt Adaptor
        //ArrayAdapter adaptor = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        //listView.setAdapter(adaptor);

        /*
         Custom Adaptor
            1) Create custom adaptor class by extending Adaptor as NidarshanAdaptor.java
            2) Create an AndroidLayout in layout directory as nidarshan_layout.xml
                right click on layout -> new -> Layout Resource Layout
         */

        NidarshanAdaptor adaptor = new NidarshanAdaptor(this, R.layout.nidarshan_layout, items);
        listView.setAdapter(adaptor);

    }
}