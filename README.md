# FragmentNavigatorCrash
Minimal project to reproduce crash when navigating with a custom FragmentNavigator

Reproduces a crash triggered by [this change](https://android-review.googlesource.com/c/platform/frameworks/support/+/2496344)
```
java.lang.IllegalArgumentException: The fragment ... is unknown to the FragmentNavigator.
Please use the navigate() function to add fragments to the FragmentNavigator managed FragmentManager.
```

Other reports of people running into this crash, although they don't mention the use of custom subclasses of FragmentNavigator which may be a unique issue
https://issuetracker.google.com/issues/279644470
https://issuetracker.google.com/issues/279306628