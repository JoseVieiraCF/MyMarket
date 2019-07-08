package br.com.compilando.mymarket;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView myBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBottomNavigationView = findViewById(R.id.navigationView);
        myBottomNavigationView.setOnNavigationItemSelectedListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Fragment marcketFragment = MarketsFragment.newInstance();
        openFragment(marcketFragment);




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.navigation_markete: {
                Fragment marcketFragment = MarketsFragment.newInstance();
                openFragment(marcketFragment);
                break;
            }
            case R.id.navigation_user: {
                Fragment userFragment = UserFragment.newInstance();
                openFragment(userFragment);
                break;

            }
            case R.id.navigation_informations: {
                break;
            }
        }


        return true;
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
