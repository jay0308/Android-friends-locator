package menu.fragment;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jaykarn.ourproject.R;

/**
 * Created by JayKarn on 3/6/2016.
 */
public class Home extends Fragment implements View.OnClickListener{
    Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        Intent openTest = new Intent("com.example.jaykarn.MYGEOLOCATION");
//        startActivity(openTest);
        View myvView=inflater.inflate(R.layout.home_fragment,container,false);
        btn=(Button)myvView.findViewById(R.id.h_btn);
        btn.setOnClickListener(this);
        return myvView;
    }

    @Override
    public void onClick(View v) {
        Intent openTest = new Intent("com.example.jaykarn.MYGEOLOCATION");
       startActivity(openTest);
    }
}
