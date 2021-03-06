package com.example.dipendelvadiya.tempconverter2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;  //declare seekbar object
    TextView textView;
    TextView titleView;
    View view;
    Button btn;
    //declare member variables for SeekBar
    int discrete=0;
    int start=50;
    int start_position=50; //progress tracker
    int temp=0;
    //declare objects for ViewStub
    ViewStub stub;
    CheckBox checkBox;
    //declare Listview object
    ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare viewstub object
        stub = (ViewStub) findViewById(R.id.viewStub1);
        @SuppressWarnings("unused")
        View inflated = stub.inflate();
        stub.setVisibility(View.INVISIBLE);

        //ViewStub logic

        checkBox=(CheckBox) findViewById(R.id.checkBox1);

        //handle checkbox click event
        checkBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked)
            {
                if ( isChecked )
                {
                    //remove objects from parent view to allow for child view
                    checkBox.setVisibility(View.GONE);
                    seekBar.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);

                    stub.setVisibility(View.VISIBLE);
                }
            }
        });


        //seekbar logic

        textView = (TextView) findViewById(R.id.textview);
        textView.setText("     Celsius at 0 degrees"); //set default view
        seekBar=(SeekBar) findViewById(R.id.seekbar);
        seekBar.setProgress(start_position);

        //create event handler for SeekBar
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                if(temp==0)  //for initial view result
                    //Toast.makeText(getBaseContext(), "Fahrenheit result 32 degrees",
                            //Toast.LENGTH_SHORT).show();
                    textView.setText(" Celsius at "+temp+ " degrees" + "\n" + "Fahrenheit result 32 degrees"  );
                else
                    //Toast.makeText(getBaseContext(), "Fahrenheit result "
                                    //+String.valueOf(discrete) + " degrees",
                            //Toast.LENGTH_SHORT).show();
                    textView.setText(" Celsius at "+temp+ " degrees" + "\n" + "Fahrenheit result " + String.valueOf(discrete) + " degrees"  );
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean
                    fromUser) {

                // TODO Auto-generated method stub
                // To convert progress passed as discrete (Fahrenheit) value
                temp=progress-start;
                discrete=(int) Math.round((((temp * 9.0) / 5.0) + 32)); //convert C to F temp
                //textView.setText("     Celsius at "+temp + " degrees");
            }
        });

        //Listview logic
        titleView = (TextView) findViewById(R.id.title);
        titleView.setText("5 Day Chicago Forecast");
        titleView.setBackgroundColor(Color.parseColor("#add8e6"));
        titleView.setTextColor(Color.parseColor("#ffffff"));

        String[] wkTemps = new String[] { "Sat -> 6", "Sun -> 7", "Mon -> 7", "Tue -> 9", "Wed -> 0"};
        lv=(ListView) findViewById(R.id.listView);
        @SuppressWarnings({ "unchecked", "rawtypes" })
   /*
   * To use a basic ArrayAdapter, you just need to initialize the adapter and
 * attach the adapter to the ListView. First, initialize the adapter...:
 *
 */
                ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, wkTemps);

        // Assign adapter to ListView
        lv.setAdapter(adapter);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stub.setVisibility(View.GONE);

                checkBox.setVisibility(View.VISIBLE);
                seekBar.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                checkBox.setChecked(false);
            }
        });


    }//end onCreate method

}
