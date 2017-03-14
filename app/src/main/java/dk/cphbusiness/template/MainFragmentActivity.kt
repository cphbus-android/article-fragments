package dk.cphbusiness.template

import android.os.Bundle
import android.support.v4.app.FragmentActivity

class MainFragmentActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)
        }
    }
