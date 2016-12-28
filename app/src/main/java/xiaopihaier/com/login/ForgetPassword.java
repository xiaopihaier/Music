package xiaopihaier.com.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity implements View.OnClickListener{
    EditText username;
    Button Next;
    String username_db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        IntentView();
    }

    private void IntentView() {
        username= (EditText) findViewById(R.id.username);
        Next= (Button) findViewById(R.id.next);
        Next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next:
                MySQLHelper dbhelper=new MySQLHelper(this,"UserInfo.db",null,1);
                SQLiteDatabase db=dbhelper.getReadableDatabase();
                Cursor cursor=db.query("user",null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do {
                        username_db=cursor.getString(cursor.getColumnIndex("username"));
                    }while (cursor.moveToNext());
                }
                String Username=username.getText().toString().trim();
                if (!TextUtils.isEmpty(Username)&&Username.equals(username_db)) {
                    String name=username.getText().toString().trim();
                    Intent End = new Intent(this, End.class);
                    End.putExtra("username",name);
                    startActivity(End);
                } else {
                    Toast.makeText(this,"用户名或手机号有误!",Toast.LENGTH_SHORT).show();
                }
                cursor.close();
                break;
        }
    }
}
