package css.cis3334.vogellasqldatabase;

/**
 * Created by echicheko on 3/31/2017.
 * This class contains data that will be saved in the database
 * The data will also show in the user interface
 */

public class Comment {
    private long id;
    private String comment;


    //gets comment id and returns it
    public long getId() {
        return id;
    }

    //sets the id
    public void setId(long id) {
        this.id = id;
    }

    //gets the comment and returns it
    public String getComment() {
        return comment;
    }

    //sets the comment to a string
    public void setComment(String comment) {
        this.comment = comment;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override

    //returns comment
    public String toString() {
        return comment;
    }
}
