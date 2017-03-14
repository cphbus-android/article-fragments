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

Use Code -> Convert Java file to Kotlin, and clean up a little:

```kotlin
class MainFragment : Fragment() {

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_main, container, false)
    }

  }
```
Update the layout of the fragments layout xml file:
```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="dk.cphbusiness.template.MainFragment">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="Hello Main Fragment"
        android:textAlignment="center"
        android:textSize="30dp"
        android:background="#ffffcc"
        />
</FrameLayout>
```
And the layout of the frame activitys xml file:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent">

    <fragment android:name="dk.cphbusiness.template.MainFragment"
        android:id="@+id/main_fragment"
        android:layout_weight="1"
        android:layout_width="0dp"
        android:layout_height="match_parent" />

</LinearLayout>
```
Run the app, the result should look like this:

![App with main fragment](https://rawgit.com/cphbus-android/article-fragments/master/image/main-fragment.png)

Create a copy of the `MainFragment` class and layout, call it `SubFragment`
Change the frame activitys xml:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent">

    <fragment android:name="dk.cphbusiness.template.MainFragment"
        android:id="@+id/main_fragment"
        android:layout_weight="1"
        android:layout_width="0dp"
        android:layout_height="match_parent" />

    <fragment android:name="dk.cphbusiness.template.SubFragment"
        android:id="@+id/sub_fragment"
        android:layout_weight="1"
        android:layout_width="0dp"
        android:layout_height="match_parent" />

</LinearLayout>
```
Run the app, the result with two fragments:

![App with main fragment](https://rawgit.com/cphbus-android/article-fragments/master/image/main-sub-fragment.png)

## Dynamic fragment

Fragments can also be changed during runtime. Create a new `FragmentActivity`, call it `DynamicFragmentActivity`

The layout shall look like this:

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/fragment_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

</FrameLayout>
```
Change the Kotlin code in `DynamicFragmentActivity` to:
```kotlin
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
    }

  }
```

