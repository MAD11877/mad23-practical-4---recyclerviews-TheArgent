package sg.edu.np.mad.practical4;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Retrieve the random number from the intent
        Intent intent = getIntent();
        String Username_text = getIntent().getStringExtra("username");
        String Description_text = getIntent().getStringExtra("description");
        boolean isFollowed = getIntent().getBooleanExtra("followed", false);

        TextView username = findViewById(R.id.username);
        TextView description = findViewById(R.id.description);
        Button followButton = findViewById(R.id.follow);


        // Initialize the User object with the retrieved values
        User user = new User();

        user.followed = isFollowed;
        user.Name = Username_text;
        user.Description = Description_text;

        username.setText(Username_text);
        description.setText(Description_text);
        followButton.setText(isFollowed ? "Unfollow" : "Follow");


        // Add click listener to the follow button
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //reverse the variable of followed
                user.setFollowed(!user.isFollowed());
                // Update the text of the follow button

                followButton.setText(user.isFollowed() ? "Unfollow" : "Follow");

                // Show toast message
                Toast.makeText(getApplicationContext(), user.isFollowed() ? "Followed" : "Unfollowed", Toast.LENGTH_SHORT).show();

                }
        });
    }
}