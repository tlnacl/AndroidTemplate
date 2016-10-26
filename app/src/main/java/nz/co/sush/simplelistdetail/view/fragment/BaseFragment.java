package nz.co.sush.simplelistdetail.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by tomtang on 2/11/15.
 */
public abstract class BaseFragment extends Fragment {
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    /**
     * Shows a {@link android.widget.Toast} message.
     *
     * @param message An string representing a message to be shown.
     */
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
