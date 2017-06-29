package dev.mjangale;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    String TAG = "appsPage";

    private PopupWindow mPopupWindow;
    private LinearLayout mLinearLayout;
    private View popUpView;
    LayoutInflater popUpInflater;

    FirebaseRecyclerAdapter mAdapter;
    RecyclerView mAppGridView;

    //private static final String TAG ="MainActivityFragment" ;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);


        // Set up Layoutinflater for the popup windows
        popUpInflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        //TextView headerTitle = (TextView) v.findViewById(R.id.titleOfFragment);
        //headerTitle.setText(R.string.appTitle);

        mLinearLayout = (LinearLayout) v.findViewById(R.id.advPage_layout);

        // Setup firebase to get information about apps
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("classes");

        mAppGridView = (RecyclerView) v.findViewById(R.id.appDrawer);
        mAppGridView.setHasFixedSize(false);
        GridLayoutManager gm = new GridLayoutManager(getContext(), 3);
        mAppGridView.setLayoutManager(gm);
        mAdapter = new FirebaseRecyclerAdapter<Advices, AppViewHolder>(Advices.class, R.layout.app_icon, AppViewHolder.class, mDatabase) {

            @Override
            protected void populateViewHolder(AppViewHolder viewHolder, final Advices adv, int position) {

                Glide.with(getContext()).load(adv.getLogo()).into(viewHolder.logo);
                viewHolder.setAppName(adv.getClasse());


            }
        };

        mAppGridView.setAdapter(mAdapter);
        
        return fragmentView;
    }
}
