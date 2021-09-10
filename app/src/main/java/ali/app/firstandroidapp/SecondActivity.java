package ali.app.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends AppCompatActivity {
    private ListView myListView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivitydesign);
        myListView = (ListView) findViewById(R.id.listView);

        List<ListItem> items = new ArrayList<>();

        Intent intent = getIntent();
        if(intent.getBooleanExtra("flag", true)) {
            /*
             * Case 1
             */

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_3d_rotation_black_48dp);
            items.add(new ListItem("Jack", bitmap, "Mathematics, Chemistry"));
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_announcement_black_48dp);
            items.add(new ListItem("Jane", bitmap, "Physics, Information"));
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_account_box_black_48dp);
            items.add(new ListItem("Bob", bitmap, "Geography, Chemistry"));
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_alarm_black_48dp);
            items.add(new ListItem("Clara", bitmap, "Geography, Chemistry"));
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_accessibility_black_48dp);
            items.add(new ListItem("Sam", bitmap, "Mathematics, Physics"));
        } else {
            /*
             * Case 2
             */

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_3d_rotation_black_48dp);

            items.add(new ListItem(
                    "Mathematics",
                    bitmap,
                    "Mathematics is the study of topics such as quantity, structure, space and change."
            ));

            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_announcement_black_48dp);

            items.add(new ListItem(
                    "Physics",
                    bitmap,
                    "Physics is the natural science that involves the study of matter and its notion through space and time," +
                            " along with related concepts such as energy and force."
            ));

            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_alarm_black_48dp);

            items.add(new ListItem(
                    "Chemistry",
                    bitmap,
                    "Chemistry is a branch of physical science that studies the composition, structure, properties and change of matter."
            ));

            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_account_box_black_48dp);

            items.add(new ListItem(
                    "Informatics",
                    bitmap,
                    "Informatics is the science of information and computer information systems."
            ));

            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_accessibility_black_48dp);

            items.add(new ListItem(
                    "Geography",
                    bitmap,
                    "Geography is a field of science devoted to the study of lands, the features, the inhabitants, and the phenomena of Earth."
            ));
        }

        adapter = new ListAdapter(this, items);
        myListView.setAdapter(adapter);
    }
}
