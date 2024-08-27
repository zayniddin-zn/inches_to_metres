package y.com.ukkuuu.inchestometers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import javax.sound.sampled.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesEditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by ID
        inchesEditText = findViewById(R.id.inches);
        resultTextView = findViewById(R.id.result);
        calculateButton = findViewById(R.id.calculate); // Assuming the button's ID is "calculate"

        // Set up button click listener
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToMeters();
            }
        });
    }

    private void convertToMeters() {
        String inchesString = inchesEditText.getText().toString().trim();  // Handle empty input
        if (inchesString.isEmpty()) {
            resultTextView.setText("You did not enter any data.");
            return;  // Exit early if there's no input
        }

        try {
            float inches = Float.parseFloat(inchesString);
            float meters = inches * 0.0254f;
            resultTextView.setText(String.format("%.2f inches is %.4f meters", inches, meters));
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input. Please enter a number.");
        }
    }
}