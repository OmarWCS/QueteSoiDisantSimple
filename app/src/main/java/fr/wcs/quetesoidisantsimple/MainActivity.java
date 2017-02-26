package fr.wcs.quetesoidisantsimple;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    EditText firstName;
    EditText name;
    Button validateButton;
    TextView congrats;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        firstName = (EditText) findViewById(R.id.firstName);
        name = (EditText) findViewById(R.id.name);
        validateButton = (Button) findViewById(R.id.validateButton);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                firstName.setEnabled(checkBox.isChecked());
                name.setEnabled(checkBox.isChecked());
                validateButton.setEnabled(checkBox.isChecked());

                if (!isChecked) {
                    validateButton.setVisibility(View.INVISIBLE);
                    firstName.setText(null);
                    name.setText(null);
                }
            }
        });

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstName.length() != 0 && name.length() != 0) {
                    congrats.setVisibility(View.VISIBLE);
                    congrats.setText(getString(R.string.congrats)+ " "+firstName.getText()+" "+name.getText());
                }

                else {
                    Toast.makeText(MainActivity.this, getString(R.string.toast), Toast.LENGTH_LONG).show();
                    congrats.setVisibility(View.INVISIBLE);
                }
            }
        });
    }


}
