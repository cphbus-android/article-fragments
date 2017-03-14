# Android Fragments

Fragments are light-weight activities, or sub activities.
Meaning that they have their own life cycle and event handling.

First create a new Activity, but let it extend `FragmentActivity` instead of just `Activity`.

```kotlin
package dk.cphbusiness.template

import android.os.Bundle
import android.support.v4.app.FragmentActivity

class MainFragmentActivity : FragmentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main_fragment)
    }
  }
```

Next create classes for the fragments. They extends the `Fragment` class.
Create it using the Java wizard:

![Using Java Wizard](https://rawgit.com/cphbus-android/article-fragments/master/image/fragment-wizard.png)
