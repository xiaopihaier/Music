package xiaopihaier.com.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main extends AppCompatActivity implements View.OnClickListener{

    LinearLayout one,two,three,four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentView();
    }

    private void IntentView() {
        one= (LinearLayout) findViewById(R.id.One);
        one.setOnClickListener(this);
        two= (LinearLayout) findViewById(R.id.Two);
        two.setOnClickListener(this);
        three= (LinearLayout) findViewById(R.id.three);
        three.setOnClickListener(this);
        four= (LinearLayout) findViewById(R.id.four);
        four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.One:
                Toast.makeText(this,"one",Toast.LENGTH_SHORT);
                break;
            case R.id.Two:
                Toast.makeText(this,"Two",Toast.LENGTH_SHORT);
                break;
            case R.id.three:
                Toast.makeText(this,"three",Toast.LENGTH_SHORT);
                break;
            case R.id.four:
                Toast.makeText(this,"four",Toast.LENGTH_SHORT);
                break;
        }
    }
}
