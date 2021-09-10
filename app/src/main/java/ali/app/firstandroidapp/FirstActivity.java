package ali.app.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    private Button myButton;
    private TextView myTextView;
    private Button mySecondActivityButton;
    private Context context = this;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.firstactivitydesign);

        myButton = (Button) findViewById(R.id.button);
        mySecondActivityButton = (Button) findViewById(R.id.secondActivityButton);
        myTextView = (TextView) findViewById(R.id.textView);

        myButton.setOnClickListener(myButtonClick);
        mySecondActivityButton.setOnClickListener(startSecondActivity);
        mySecondActivityButton.setOnLongClickListener(startSecondActivityLong);
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

}
