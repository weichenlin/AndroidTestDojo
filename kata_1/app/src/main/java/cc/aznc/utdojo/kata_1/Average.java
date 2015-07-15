package cc.aznc.utdojo.kata_1;

import android.widget.TextView;
import java.text.NumberFormat;
import java.util.ArrayList;

/**

 * Created by Chris on 2015/7/12.

 */

public class Average {

    private ArrayList<Person> persons;

    private TextView view;

    private NumberFormat nf = NumberFormat.getInstance();



    public Average(ArrayList data, TextView view) {

        this.persons = data;

        this.view = view;

        nf.setMaximumFractionDigits(3);

    }



    public void notifyDataSetChanged() {

        view.setText(nf.format(getAVG()));

    }



    private float getAVG() {

        int counts = 0;

        int total = 0;

        for(Person person : persons) {

            total += person.getPay();

            counts++;

        }

        return total / counts;

    }

}