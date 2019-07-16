package sg.edu.rp.c346.mymovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class AddMovie extends AppCompatActivity {

    EditText titleET, yearET, genreET, ratedET, theatreET, desET;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        titleET = findViewById(R.id.titleET);
        yearET = findViewById(R.id.yearET);
        genreET = findViewById(R.id.genreET);
        ratedET = findViewById(R.id.ratedET);
        theatreET = findViewById(R.id.theatreET);
        desET = findViewById(R.id.desET);

        addBtn = findViewById(R.id.addBtn);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = titleET.getText().toString();
                String yearS = yearET.getText().toString();
                String genre = genreET.getText().toString();
                String rated = ratedET.getText().toString();
                String theatre = theatreET.getText().toString();
                String des = desET.getText().toString();

                int day = Calendar.DAY_OF_MONTH;
                int mth = Calendar.MONTH;
                int year = Calendar.YEAR;

                String date = day + "/" + mth + 1 + "/" + year;

                Intent intent = new Intent(AddMovie.this, MainActivity.class);
                intent.putExtra("Title", title)
                        .putExtra("Year", yearS)
                        .putExtra("Genre", genre)
                        .putExtra("Date",date)
                        .putExtra("Rated", rated)
                        .putExtra("Theatre", theatre)
                        .putExtra("Des", des);

                startActivity(intent);

            }
        });
    }
}
