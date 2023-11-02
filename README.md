# FragmentNavigatorCrash
Minimal project to reproduce crash when navigating with a custom FragmentNavigator

Reproduces a crash triggered by [this change](https://android-review.googlesource.com/c/platform/frameworks/support/+/2496344)
```
java.lang.IllegalArgumentException: The fragment ... is unknown to the FragmentNavigator.
Please use the navigate() function to add fragments to the FragmentNavigator managed FragmentManager.
```

The crash was introduced with `androidx.navigation:navigation-fragment-ktx` version `2.6.0`. If you change the library version in `libs.versions.toml` you can see that the crash does not occur with `2.5.3` but does starting with `2.6.0` up to the latest version of as of Nov 5 2023 `2.7.5`

You can see that the crash does not occur if you remove the custom navigator added in `MainActivity` and use the `fragment` tag in `main_nav_graph.xml` instead of `custom-destination`

Other reports of people running into this crash, although they don't mention the use of custom subclasses of FragmentNavigator which may be a unique issue

https://issuetracker.google.com/issues/279644470

https://issuetracker.google.com/issues/279306628