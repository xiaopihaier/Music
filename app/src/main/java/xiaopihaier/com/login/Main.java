package xiaopihaier.com.login;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends AppCompatActivity implements View.OnClickListener{

    LinearLayout one,two,three,four;
    ViewPager viewPager;
    View view_1,view_2,view_3,view_4;
    ArrayList<View> arrayList;

    //创建适配器
    PagerAdapter pagerAdapter=new PagerAdapter() {
        //获取viewpager的页数
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
        //销毁
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(arrayList.get(position));
        }
        //创建
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(arrayList.get(position));
            return arrayList.get(position);
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentView();
        //将布局文件加载成view视图
        view_1=getLayoutInflater().inflate(R.layout.bttom_table1,null);
        view_2=getLayoutInflater().inflate(R.layout.bttom_lable2,null);
        view_3=getLayoutInflater().inflate(R.layout.bttom_lable3,null);
        view_4=getLayoutInflater().inflate(R.layout.bttom_lable4,null);

        arrayList=new ArrayList();
        arrayList.add(view_1);
        arrayList.add(view_2);
        arrayList.add(view_3);
        arrayList.add(view_4);

        viewPager.setAdapter(pagerAdapter);
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
        viewPager= (ViewPager) findViewById(R.id.vp_tabs);
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
