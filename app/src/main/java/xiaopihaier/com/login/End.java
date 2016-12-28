package xiaopihaier.com.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.health.TimerStat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class End extends AppCompatActivity implements View.OnClickListener{
    EditText Change_Password,Confirm_Password;
    Button End;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        IntentView();
    }

    private void IntentView() {
        End= (Button) findViewById(R.id.end);
        End.setOnClickListener(this);
        Change_Password= (EditText) findViewById(R.id.Change_Password);
        Confirm_Password= (EditText) findViewById(R.id.Confirm_Password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.end:
                Intent intent=getIntent();
                String username_intent=intent.getStringExtra("username");
                MySQLHelper dbhelper=new MySQLHelper(this,"UserInfo.db",null,1);
                SQLiteDatabase db=dbhelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                String chang_password=Change_Password.getText().toString().trim();
                String confirm_password=Confirm_Password.getText().toString().trim();
                if (!TextUtils.isEmpty(chang_password) && !TextUtils.isEmpty(confirm_password)) {
                    if (!(chang_password.equals(confirm_password))) {
                        Toast.makeText(this,"密码有误！请确认",Toast.LENGTH_SHORT).show();
                    } else {

                        values.put("password", confirm_password);
                        db.update("user", values, "username=" + username_intent, new String[]{});
                        Intent Login = new Intent(this, xiaopihaier.com.login.Login.class);
                        startActivity(Login);
                    }
                } else {
                    Toast.makeText(this,"密码不能为空！",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
