package cc.aznc.utdojo.kata_1;

import android.widget.TextView;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class AverageTest extends TestCase
{
    @Mock
    TextView mMockTextView;

    @Test
    public void computeCorrectAverage() throws Exception
    {
        Average avg = new Average(getSamplePersonListAVG_4(), mMockTextView);

        avg.notifyDataSetChanged();

        Mockito.verify(mMockTextView).setText("4");
    }

    @Test
    public void displayZeroForEmptyList() throws Exception
    {
        Average avg = new Average(new ArrayList<Person>(), mMockTextView);

        avg.notifyDataSetChanged();

        Mockito.verify(mMockTextView).setText("0");
    }

    @Test
    public void formatWithThreeFractionDigits() throws Exception
    {
        Average avg = new Average(getSamplePersonListAVG_3_333_Recurring(), mMockTextView);

        avg.notifyDataSetChanged();

        Mockito.verify(mMockTextView).setText("3.333");
    }

    @Test
    public void onlyAcceptPersonArrayList() throws Exception
    {
        Average avg = new Average(new ArrayList<String>(), mMockTextView);
        fail("this should not compile");
    }

    protected ArrayList getSamplePersonListAVG_4()
    {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(2));
        list.add(new Person(4));
        list.add(new Person(6));

        return list;
    }

    protected ArrayList getSamplePersonListAVG_3_333_Recurring()
    {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person(10));
        list.add(new Person(0));
        list.add(new Person(0));

        return list;
    }
}