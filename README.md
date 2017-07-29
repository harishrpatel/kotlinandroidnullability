# kotlinandroidnullability
A simple Android App Exercise which allows fixing some nullability errors to learn Kotlin programming.

## OBJECTIVE
- This app has one screen (MainActivity) which shows a random US address (Selected address)
- There is a list of 100 addresses and app updates Selected address. That's it.

## Instructions
- There are some *.kt (Kotlin source) files with intentional compiler errors and lint warnings
- In Android Studio, use **Find in Path (Shift-Cmd-F)** to look for **FIXME** and look for contextual instructions there.
- After fixing all the errors, run the app on device or emulator and see if selecting one of the addresses in list shows up at top as
**Selected Address**
- If you get time, run lint in Android Studio (Analyze->Inspect Code) and fix any lint errors (especially Kotlin specific).
- Note that lint checks such as **Unused Resources** are broken because Studio expects to reference these resources in Java files. So,
you can ignore some of these checks.

## Here is a list of files with errors
- MainActivity.kt
- AddressAdapter.kt

## NOTES
- For now Gradle build environment is setup for [Android Studio 3.0 Preview - Canary 8](https://developer.android.com/studio/preview/index.html)
- **feature/solution** branch has a solution (which may not be the best one. I am also learning and some of the situations are not ideal, but just for learning!).
