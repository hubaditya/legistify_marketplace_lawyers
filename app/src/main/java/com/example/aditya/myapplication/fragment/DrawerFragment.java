package com.example.aditya.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aditya.myapplication.R;
import com.example.aditya.myapplication.adapter.NavigationDrawerAdapter;
import com.example.aditya.myapplication.adapter.NavigationDrawerAdapter2;
import com.example.aditya.myapplication.model.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;

public class DrawerFragment extends Fragment
{
    private static String TAG = DrawerFragment.class.getSimpleName();
    private RecyclerView recyclerView, recyclerView2;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationDrawerAdapter adapter;
    private NavigationDrawerAdapter2 adapter2;
    private View containerView;
    private static String[] titles = null;
    private static String[] titles2 = null;
    private static int[] imageFirst, imageSecond;
    private FragmentDrawerListener drawerListener;

    public DrawerFragment() {
    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    public static List<NavDrawerItem> getData1()
    {
        List<NavDrawerItem> data = new ArrayList<>();

        for (int i = 0; i < titles.length; i++)
        {
            NavDrawerItem navItem = new NavDrawerItem();
            navItem.setTitle(titles[i]);
            navItem.setImage(imageFirst[i]);
            data.add(navItem);
        }

        return data;
    }

    public static List<NavDrawerItem> getData2()
    {
        List<NavDrawerItem> data2 = new ArrayList<>();

        for (int i = 0; i < titles2.length; i++)
        {
            NavDrawerItem navItem2 = new NavDrawerItem();
            navItem2.setTitle(titles2[i]);
            navItem2.setImage(imageSecond[i]);
            data2.add(navItem2);
        }

        return data2;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        titles = getActivity().getResources().getStringArray(R.array.nav_drawer_labels);
        titles2 = getActivity().getResources().getStringArray(R.array.nav_drawer_labels2);
        imageFirst = new int[] { R.drawable.profile, R.drawable.bank, R.drawable.earnings, R.drawable.notification };
        imageSecond = new int[] { R.drawable.about, R.drawable.support, R.drawable.logout };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.navigation_drawer_fragment, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        recyclerView2 = (RecyclerView) layout.findViewById(R.id.drawerList2);

        adapter = new NavigationDrawerAdapter(getActivity(), getData1());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter2 = new NavigationDrawerAdapter2(getActivity(), getData2());
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }


    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset)
            {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    public interface FragmentDrawerListener {
        public void onDrawerItemSelected(View view, int position);
    }
}
