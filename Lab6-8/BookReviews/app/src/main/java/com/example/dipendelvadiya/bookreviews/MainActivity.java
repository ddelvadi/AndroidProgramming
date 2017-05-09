package com.example.dipendelvadiya.bookreviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    SqlHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        db = new SqlHelper(this);
        setContentView(R.layout.activity_main);

       // SqlHelper db = new SqlHelper(this);
       // SqlHelper db = new SqlHelper(this);
        /** CRUD Operations **/
        // add Books
        //Log.d("Name", "Dipen Delvadiya");
        //db.addBook(new Book("Android Studio Development Essentials", "Neil Smyth"));
        //db.addBook(new Book("Beginning Android Application Development", "Wei-Meng Lee"));
        //db.addBook(new Book("Programming Android", "Wallace Jackson"));
        //db.addBook(new Book("Hello, Android", "Wallace Jackson"));

        // get all books
        //List<Book> list = db.getAllBooks();

        // update one book
        //int j = db.updateBook(list.get(3), "Hello, Android",  "Ben Jackson");

        // delete one book
        //db.deleteBook(list.get(3));

        // get all books
        //db.getAllBooks();
        //ListView listContent = (ListView) findViewById(R.id.list);
        //list = new ArrayList<Book>();
        //list=db.getAllBooks();

//get data from the table by the ListAdapter
        //ListAdapter customAdapter = new ListAdapter(this, R.layout.itemlistrow,list);
        //listContent.setAdapter(customAdapter);
        // Spinner element
        Spinner spinner;
        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);

        //Create spinner item listing
        List<String> blist = new ArrayList<String>();
        blist.add("Get Highest Rated Title(s)");
        blist.add("Get Lowest Rated Title(s)");
        blist.add("Retrieve Title(s) with Android");
        blist.add("Get Record Count");

        //Sort list in Alphabetical order
        Collections.sort(blist, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        });
        blist.add(0, "Select Analytics...");

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, blist);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setWillNotDraw(false);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
                               long arg3) {

        switch (position) {
            case 1:
                //get query result for Highest rated title(s)
                // display query result(s) in a Toast message
                Toast.makeText(this, "Title :: " + db.getRatingMax(),
                        Toast.LENGTH_LONG).show();
                break;
            case 2:
                //get query result for lowest rated title(s)
                // display query result(s) in a Toast message
                Toast.makeText(this, "Title :: " + db.getRatingMin(),
                        Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(this, "Record Count :: " + db.getTotal(),
                        Toast.LENGTH_LONG).show();
                break;
            case 4:
                Toast.makeText(this, "Title :: " + db.getBooks(),
                        Toast.LENGTH_LONG).show();
                break;
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

}
