# SimpleRegApp

A simple Android app that demonstrates a registration and login flow with a shared `ViewModel` and the Navigation Component.

## Features

- **Welcome** screen with "Register" and "Log in" buttons
- **Registration** with login, password and password confirmation
  - checks for empty fields, mismatched passwords and existing logins
- **Login** that checks the entered credentials
- **Main** screen that greets the logged-in user by name, with a log-out button

Users are kept in memory only. For testing, five accounts are created on start: `User1` … `User5`, all with the password `qwerty`.

## Tech stack

- **Kotlin**
- **ViewModel** + **LiveData** shared between fragments (`activityViewModels()`)
- **Navigation Component** with Safe Args
- View Binding
- Min SDK 28, target SDK 34

## Project structure

```
app/src/main/java/com/example/simpleregapp/
├── MainActivity.kt
├── WelcomeWindow.kt           # Start screen
├── Registration.kt            # Registration form
├── LoginFragment.kt           # Login form
├── MainWindow.kt              # Screen after login
├── RegistrationViewModel.kt   # User list, registration and login logic
└── User.kt                    # User model
```

## Getting started

1. Clone the repository:
   ```bash
   git clone https://github.com/ViktorUw/SimpleRegApp.git
   ```
2. Open the project in **Android Studio** and let Gradle sync.
3. Run the app on an emulator or a device with Android 9.0 (API 28) or newer.

> The interface is in Polish. This is a learning project: passwords are stored in plain text and only in memory.
