package sg.edu.rp.c346.mymovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;


    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);
        TextView name = rowView.findViewById(R.id.title);
        TextView dec = rowView.findViewById(R.id.des);
        ImageView image = rowView.findViewById(R.id.image);

        Movie current = movieList.get(position);

        name.setText(current.getTitle());
        dec.setText(current.getYear()+" - "+current.getGenre());


        if(current.getRated().equalsIgnoreCase("g")){
            image.setImageResource(R.drawable.rating_g);

        }else if(current.getRated().equalsIgnoreCase("pg")){

            image.setImageResource(R.drawable.rating_pg);

        }else if(current.getRated().equalsIgnoreCase("pg13")){

            image.setImageResource(R.drawable.rating_pg13);

        }else if(current.getRated().equalsIgnoreCase("nc16")){

            image.setImageResource(R.drawable.rating_nc16);

        }else if(current.getRated().equalsIgnoreCase("m18")){

            image.setImageResource(R.drawable.rating_m18);

        }else if(current.getRated().equalsIgnoreCase("r21")){

            image.setImageResource(R.drawable.rating_r21);

        }

        return rowView;
    }
}
