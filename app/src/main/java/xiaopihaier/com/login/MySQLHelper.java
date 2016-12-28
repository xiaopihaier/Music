package xiaopihaier.com.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 背书包的小屁孩儿 on 2016/12/19.
 */

public class MySQLHelper extends SQLiteOpenHelper {
    public static final String UserInfo="create table user("
            +"id integer primary key autoincrement,"
            +"username text,"
            +"password text)";

    private Context mContext;

    public MySQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(UserInfo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
