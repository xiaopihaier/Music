package xiaopihaier.com.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button Login;
    TextView NewUser,forgetPassword,looking;
    EditText username,password;
    String name_db,password_db;
    CheckBox RememberPassword,AutomaticLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        IntentView();
    }

    private void IntentView() {
        Login= (Button) findViewById(R.id.login);
        Login.setOnClickListener(this);
        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        NewUser= (TextView) findViewById(R.id.newUser);
        NewUser.setOnClickListener(this);
        forgetPassword= (TextView) findViewById(R.id.forgetPassword);
        forgetPassword.setOnClickListener(this);
        looking= (TextView) findViewById(R.id.looking);
        looking.setOnClickListener(this);
        RememberPassword= (CheckBox) findViewById(R.id.RememberPassword);
        AutomaticLogin= (CheckBox) findViewById(R.id.AutomaticLogin);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                MySQLHelper dbhelper=new MySQLHelper(this,"UserInfo.db",null,1);
                SQLiteDatabase db=dbhelper.getReadableDatabase();
                Cursor cursor=db.query("user",null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do {
                        name_db=cursor.getString(cursor.getColumnIndex("username"));
                        password_db=cursor.getString(cursor.getColumnIndex("password"));
                    }while (cursor.moveToNext());
                }
                String Username=username.getText().toString().trim();
                String Password=password.getText().toString().trim();
                if (!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Password)) {
                    if (Username.equals(name_db) && Password.equals(password_db)) {
                        Intent login = new Intent(Login.this, Main.class);
                        startActivity(login);
                    } else {
                        Toast.makeText(this,"用户名或密码错误！",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this,"用户名或密码错误！",Toast.LENGTH_SHORT).show();
                }
                cursor.close();
                break;
            case R.id.looking:
                Intent login = new Intent(Login.this, Main.class);
                startActivity(login);
                break;
            case R.id.newUser:
                Intent newuser=new Intent(Login.this,NewUser.class);
                startActivity(newuser);
                break;
            case R.id.forgetPassword:
                Intent forgetpassword=new Intent(Login.this,ForgetPassword.class);
                startActivity(forgetpassword);
                break;
        }
    }
}
