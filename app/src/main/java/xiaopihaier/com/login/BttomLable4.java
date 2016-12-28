package xiaopihaier.com.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by 背书包的小屁孩儿 on 16-12-28.
 */

public class BttomLable4 extends AppCompatActivity implements View.OnClickListener{
    private String[] data={"1","2","3","4","5","6","7","8","9"};
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bttom_lable4);
        arrayAdapter=new ArrayAdapter<String>(BttomLable4.this,android.R.layout.simple_list_item_1,data);
        IntentView();
    }

    private void IntentView() {
        listView= (ListView) findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View v) {

    }
}
