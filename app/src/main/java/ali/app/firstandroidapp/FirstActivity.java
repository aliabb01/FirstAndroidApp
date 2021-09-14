package ali.app.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private Button myButton;
    private TextView myTextView;
    private Button mySecondActivityButton;
    private Button sendButton;
    private Context context = this;

    List<ListItem> things = new ArrayList<>();

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.firstactivitydesign);

        myButton = (Button) findViewById(R.id.button);
        mySecondActivityButton = (Button) findViewById(R.id.secondActivityButton);
        sendButton = (Button) findViewById(R.id.sendBtn);
        myTextView = (TextView) findViewById(R.id.textView);

        myButton.setOnClickListener(myButtonClick);
        mySecondActivityButton.setOnClickListener(startSecondActivity);
        mySecondActivityButton.setOnLongClickListener(startSecondActivityLong);
        sendButton.setOnClickListener(sendListItemListener);
    }

    public void runSecondActivity(boolean flag) {
        Intent intent  = new Intent(context, SecondActivity.class);
        intent.putExtra("flag", flag);
        context.startActivity(intent);
    }

    View.OnClickListener myButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // String text = myTextView.getText() + "\n" + "Next line";
            count++;
            myTextView.setText("Count is : " + count);
        }
    };

    View.OnClickListener startSecondActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            runSecondActivity(true);
            //myTextView.append("");
        }
    };

    View.OnLongClickListener startSecondActivityLong = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            runSecondActivity(false);
            //myTextView.append("");
            return true;
        }
    };

    View.OnClickListener sendListItemListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.baseline_3d_rotation_black_48dp);
            things.add(new ListItem("First title", bitmap, "First description"));
            things.add(new ListItem("Second title", bitmap, "Second description"));
            Intent intent = new Intent(getBaseContext(), SecondActivity.class);
            if (things.size() != 0) {
                intent.putParcelableArrayListExtra("things", (ArrayList<? extends Parcelable>) things);
                startActivity(intent);
            }


        }
    };

}
