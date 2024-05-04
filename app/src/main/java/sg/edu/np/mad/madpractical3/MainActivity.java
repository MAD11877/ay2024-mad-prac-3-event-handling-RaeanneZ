package sg.edu.np.mad.madpractical3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Header), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent receiveIntent = getIntent();
        String randomNumber = receiveIntent.getStringExtra("randomNumber");
        User userObj = new User("MAD " + randomNumber,"MAD Developer",1, false);

        //display user info (name and desc) in labels
        TextView headerTextView = findViewById(R.id.Header);
        headerTextView.setText(userObj.name);

        TextView bodyTextView = findViewById(R.id.BodyText);
        bodyTextView.setText(userObj.description);

        //get buttons and define listeners
        Button followBtn = findViewById(R.id.FollowBtn);
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userObj.followed = (!userObj.followed);

                if (userObj.followed){
                    followBtn.setText("UNFOLLOW");
                    // Toast.LENGTH_SHORT means the pop up will only show for short period of time
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                else {
                    followBtn.setText("FOLLOW");
                    // Toast.LENGTH_SHORT means the pop up will only show for short period of time
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}