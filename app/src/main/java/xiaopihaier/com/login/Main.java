package xiaopihaier.com.login;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

public class Main extends AppCompatActivity {
    FragmentManager fragmentManager;
    Shouye f_shouye;
    Faxian f_faxian;
    Fragment fragment;
    Wo f_wo;
    FragmentTransaction ft;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f_shouye = new Shouye();
        f_faxian = new Faxian();
        f_wo = new Wo();
        IntentView();
        fragmentManager = getFragmentManager();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_sy:
                        ft = fragmentManager.beginTransaction();
                       ft.replace(R.id.linear,fragment);
                        ft.commit();
                        break;
                    case R.id.btn_fx:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.linear, f_shouye);
                        ft.commit();
                        break;
                    case R.id.btn_wd:
                        ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.linear, f_wo);
                        ft.commit();
                        break;
                }
            }
        });

    }

    private void IntentView() {

    }
}