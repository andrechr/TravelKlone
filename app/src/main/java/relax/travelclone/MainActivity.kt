package relax.travelclone

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.widget.Toast
import relax.travelclone.dummy.DummyContent

class MainActivity : AppCompatActivity() ,
        HomeFragment.OnFragmentInteractionListener,
        PromoFragment.OnFragmentInteractionListener,
        MyTicketFragment.OnFragmentInteractionListener,
        AccountFragment.OnFragmentInteractionListener,
        FlightFragment.OnListFragmentInteractionListener,
        HotelFragment.OnListFragmentInteractionListener
{
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }

    override fun onFragmentInteraction(uri: Uri) {

        if(uri.equals(Uri.parse("Flight"))) {
            Toast.makeText(this,"Flight",Toast.LENGTH_SHORT).show()
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, FlightFragment(), null).addToBackStack(null).commit()
        }

        if(uri.equals(Uri.parse("Hotel"))) {
            Toast.makeText(this,"Hotel",Toast.LENGTH_SHORT).show()
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HotelFragment(), null).addToBackStack(null).commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        init()
    }
    fun init()
    {
        callHomeFragment()
        var bottomNavBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavBar.setOnNavigationItemSelectedListener { item ->
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            when(item.itemId)
            {
                R.id.nav_home -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment(),null).commit()
                R.id.nav_promo -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, PromoFragment(),null).commit()
                R.id.nav_ticket -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, MyTicketFragment(),null).commit()
                R.id.nav_account -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout, AccountFragment(),null).commit()
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
    fun callHomeFragment()
    {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment(),null).commit()
    }
}
