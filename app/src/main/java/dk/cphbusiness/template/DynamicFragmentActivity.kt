package dk.cphbusiness.template

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_dynamic_fragment.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

class DynamicFragmentActivity : FragmentActivity() {
  val mainFragment = MainFragment()
  val subFragment = SubFragment()
  var main = true;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_dynamic_fragment)

    if (savedInstanceState != null) return // already instantiated
    mainFragment.arguments = intent.extras // arguments exist

    supportFragmentManager
        .beginTransaction()
        .add(R.id.fragment_container, mainFragment)
        .add(R.id.fragment_container, subFragment)
        .hide(subFragment)
        .commit()

    goOtherFragmentButton.onClick {
      if (main)
        supportFragmentManager
            .beginTransaction()
            .show(subFragment)
            .hide(mainFragment)
            .commit()
      else
        supportFragmentManager
            .beginTransaction()
            .show(mainFragment)
            .hide(subFragment)
            .commit()
      main = !main
      }

    }

  }
