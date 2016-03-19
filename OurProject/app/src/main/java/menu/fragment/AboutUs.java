package menu.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jaykarn.ourproject.R;

/**
 * Created by JayKarn on 3/6/2016.
 */
public class AboutUs extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myvView=inflater.inflate(R.layout.aboutus_fragment,container,false);
        return myvView;
    }
}
