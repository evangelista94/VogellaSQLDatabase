package css.cis3334.vogellasqldatabase;

/**
 * Created by echicheko on 3/31/2017.
 * This class is responsible for creating the database
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    //database fields
    public static final String TABLE_COMMENTS = "comments"; //string for comments
    public static final String COLUMN_ID = "_id"; //column id
    public static final String COLUMN_COMMENT = "comment"; //comment for corresponding column
    public static final String COLUMN_RATING = "rating"; // rating of a comment

    private static final String DATABASE_NAME = "commments.db";  //database name
    private static final int DATABASE_VERSION = 2;  //database version incremented from 1 to 2

    // Database creation sql statement
    //creates database table
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null, " + COLUMN_RATING + "text);";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

}
