/**
 * Created by echicheko on 3/31/2017.
 * This class uses a ListActivity for displaying the data
 */

package css.cis3334.vogellasqldatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import java.util.Random;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class MainActivity extends ListActivity {

    private CommentsDataSource datasource;
    EditText rating;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        datasource = new CommentsDataSource(this);
        datasource.open();

        List<Comment> values = datasource.getAllComments();

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Will be called via the onClick attribute
    // of the buttons in activity_main.xml

    //method either adds or deletes a comment on button click
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
        Comment comment = null;
        rating = (EditText) findViewById(R.id.editTextRating);
        //This option adds the comments
        switch (view.getId()) {
            case R.id.add:
                String[] comments = new String[] { "Cool", "Very nice", "Hate it" };
                int nextInt = new Random().nextInt(3);

                // save the new comment to the database
                comment = datasource.createComment(comments[nextInt], rating.getText().toString());
                adapter.add(comment);
                break;

            //This option deletes the comments
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    comment = (Comment) getListAdapter().getItem(0);
                    datasource.deleteComment(comment);
                    adapter.remove(comment);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    //method opens the database
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    //method closes the database
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}
