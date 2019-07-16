package sg.edu.rp.c346.mymovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMoviet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvMovie = findViewById(R.id.lvMovie);

        alMovieList = new ArrayList<>();


        Movie m1 = new Movie("The Avengers","2012","pg13","Action | Sci-Fi","15/11/2014", "Golden Village - Bishan","Description" );
        Movie m2 = new Movie("Planes","2013","pg","Animation | Comedy","15/5/2015", "Cathay - AMK Hub","Description" );


        alMovieList.add(m1);
        alMovieList.add(m2);

        caMoviet = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovie.setAdapter(caMoviet);


        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("Title");
        String year = intentReceived.getStringExtra("Year");
        String genre = intentReceived.getStringExtra("Genre");
        String rated = intentReceived.getStringExtra("Rated");
        String date = intentReceived.getStringExtra("Date");
        String theatre = intentReceived.getStringExtra("Theatre");
        String des = intentReceived.getStringExtra("Des");

        Movie m3 = new Movie(title, year,rated, genre, date, theatre, des);
        alMovieList.add(m3);

        caMoviet.notifyDataSetChanged();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.add_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()) {
            case R.id.add:
                startActivity(new Intent(MainActivity.this,AddMovie.class));
        }


        return super.onOptionsItemSelected(item);
    }

}
