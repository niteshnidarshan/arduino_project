package in.sysventure.contactappwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import in.sysventure.contactappwithrecyclerview.adapter.CustomAdapter;
import in.sysventure.contactappwithrecyclerview.model.Contact;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    /*Contact[] contacts = {
            new Contact(1, "1234567890", "Ram G"),
            new Contact(2, "1234567891", "Sita G"),
            new Contact(3, "1234567892", "Laxman G"),
            new Contact(4, "1234567893", "Bharat G"),
            new Contact(5, "1234567894", "Shatrughan G"),
            new Contact(6, "1234567895", "Krishna G"),
            new Contact(7, "1234567896", "Radha G"),
            new Contact(8, "1234567897", "Rukkmini G"),
            new Contact(9, "1234567898", "Dau G")
    };*/

    Contact c1 = new Contact(1, "1234567890", "Ram G");
    Contact c2 = new Contact(2, "1234567891", "Sita G");
    Contact c3 = new Contact(3, "1234567892", "Laxman G");
    Contact c4 = new Contact(4, "1234567893", "Bharat G");
    Contact c5 = new Contact(5, "1234567894", "Shatrughan G");
    Contact c6 = new Contact(6, "1234567895", "Krishna G");
    Contact c7 = new Contact(7, "1234567896", "Radha G");
    Contact c8 = new Contact(8, "1234567897", "Rukkmini G");
    Contact c9 = new Contact(9, "1234567898", "Dau G");

    Contact[] contacts = {c1,c2,c3,c4,c5,c6,c7,c8,c9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CustomAdapter ca = new CustomAdapter(contacts);
        recyclerView.setAdapter(ca);
    }
}