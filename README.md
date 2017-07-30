# kotlinandroidnullability
A simple Android App Exercise which allows fixing some nullability errors to learn Kotlin programming.

## OBJECTIVE
- This app has one screen (MainActivity) which shows a random US address (Selected address)
- There is a list of 100 addresses and app updates Selected address. That's it.

## Installation/Setup
- Gradle build environments changed between Android Studio v2.3 (unofficial Kotlin Support) and v3.0 Preview (Canary 8 is latest as of
July 2017)
- You can build on either version.
- Android Studio 2.3
    - You may have to download Kotlin plugin
    - Change to **feature/develop_android_studio_v2_3** branch

OR

- Android Studio 3.0 Preview - Canary 8
    - Download if needed [Android Studio 3.0 Preview - Canary 8](https://developer.android.com/studio/preview/index.html)
    - Change to **develop** branch

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
- Both **feature/solution** or **feature/solution_android_studio_v2_3** branches have solution (which may not be the best one. I am also learning and some of the situations are not ideal, but just for learning!).
