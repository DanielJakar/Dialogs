package android.course.dialogs;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnClickListener {

    private String list = "You have selected the following toppings: " ;
    private ArrayList<String> selected = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pickTheTime(View view) {
        TimePickerDialog dialog = new TimePickerDialog(this, this, 10, 22, true);
        dialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }


    public void ShowStandard(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("The App requires Internet to proceed")
       .setMessage("Do you want to quit?")
        .setPositiveButton("Quit", this)
        .setNegativeButton("Stay", this);

//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();


        AlertDialog dialog = builder.show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case AlertDialog.BUTTON_POSITIVE:
               // Toast.makeText(this, "quitting...", Toast.LENGTH_SHORT).show();
                System.exit(0);
                break;
            case AlertDialog.BUTTON_NEGATIVE:
                Toast.makeText(this, "Staying....", Toast.LENGTH_SHORT).show();
                list = "You have selected the following toppings: " ;
                break;
            case AlertDialog.BUTTON_NEUTRAL:
                Toast.makeText(this, list, Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void showlistDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final String [] colors = {"Extra Large", "Large", "Personal (single portion)"};

        builder.setTitle("Select Pizza Size:");
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setItems(colors, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectColor = colors[which];
                Toast.makeText(MainActivity.this, selectColor,Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();

    }

    public void toppings(View view) {



        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        final String[] toppings = getResources().getStringArray(R.array.toppings);


        builder.setTitle("Choose your toppings");
        builder.setMultiChoiceItems(R.array.toppings, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String top = toppings[which];
                if (isChecked){
                    selected.add(top);

                }
                else {
                    selected.remove(top);
                }



            }
        });






        builder.setNegativeButton("Cancel", this);
        builder.setNeutralButton("Save", this);



        builder.show();


    }
}
