package xiaopihaier.com.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewUser extends AppCompatActivity implements View.OnClickListener{
    Button registered;
    EditText Username,First_Password,Second_Password;
    String name_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        IntentView();
    }

    private void IntentView() {
        registered= (Button) findViewById(R.id.registered);
        registered.setOnClickListener(this);
        Username= (EditText) findViewById(R.id.UserName);
        First_Password= (EditText) findViewById(R.id.first_password);
        Second_Password= (EditText) findViewById(R.id.second_password);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.registered:
                MySQLHelper sqlHelper=new MySQLHelper(this,"UserInfo.db",null,1);
                SQLiteDatabase db= sqlHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                String username=Username.getText().toString().trim();
                String first_password=First_Password.getText().toString().trim();
                String second_password=Second_Password.getText().toString().trim();

                Cursor cursor=db.query("user",null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do {
                        name_db=cursor.getString(cursor.getColumnIndex("username"));
                    }while (cursor.moveToNext());
                }

                if (!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(first_password)&&!TextUtils.isEmpty(second_password))
                {
                    if (username.equals(name_db)) {
                        Toast.makeText(this, "此用户名已被使用!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (first_password.equals(second_password)) {
                            values.put("username", username);
                            values.put("password", second_password);
                            db.insert("user", null, values);
                            Intent Login = new Intent(NewUser.this, Login.class);
                            startActivity(Login);
                        } else {
                            Toast.makeText(this,"密码不同,请确认！",Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else {
                    Toast.makeText(this,"用户名或密码错误!",Toast.LENGTH_SHORT).show();
                }
                cursor.close();
                break;
        }
    }
}
