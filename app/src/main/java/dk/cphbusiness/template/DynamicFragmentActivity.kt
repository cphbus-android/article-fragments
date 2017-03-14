package dk.cphbusiness.template

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_dynamic_fragment.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

class DynamicFragmentActivity : FragmentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_dynamic_fragment)

    if (savedInstanceState != null) return // already instantiated
    val mainFragment = MainFragment()
    mainFragment.arguments = intent.extras // arguments exist

    supportFragmentManager
        .beginTransaction()
        .add(R.id.fragment_container, mainFragment)
        .commit()

    goOtherFragmentButton.onClick {
      toast("Pressed")
      val subFragment = SubFragment()
      supportFragmentManager
          .beginTransaction()
          .replace(R.id.fragment_container, subFragment)
          .addToBackStack(null)
          .commit()
      }

    }

  }
