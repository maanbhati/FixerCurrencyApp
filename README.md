# FixerCurrencyApp
Android Application using http://fixer.io/ API compatibility, will get the and filter result of GBP,USD,JPY,AUD,CAD,CHF,CNY,SEK,NZD
different currencies and will show the result of first four GBP,USD,JPY,AUD currencies as an result of the item,
for getting the result base currency is defined as EUR, and user can enter any value in terms of EUR and can see the above
four currency conversion on screen, comparison is displayed in form of chart keeping EUR as base currency once user performed the
search after entering valid EUR amount.

# Clean Architecture
App is designed using clean architecture pattern which contains presentation layer, data layer and usecase layer seperately, and 
view binding is done via ViewModel.
The app uses Retrofit2 for Api, Koin for DI, MVVM for data binding, OkHttp for http connection, GsonConvertor for Json parsing, Coroutines for Threading, 

# Introduction and Running the app
This project uses the Gradle system. To build this project, use the gradlew build command or use "Import Project" in Android Studio.
For running the you need to first get your key from here https://fixer.io/documentation and once you got the key replace that with
<YOUR_API_KEY> inside Constants.kt file within the app.

# Tools and Technology
This app using Architecture Components:
Room
ViewModels
LiveData
Coroutines

# Third party libraries
Retrofit for Api call
Android Support Design for advanced ui
Koin for dependency injection
Calligraphy for custom font styles
MPAndroidChart for charts showing comparision 
Mockito/MockK for Junit test
Glide for image loading
View Pump for custom fonts styles
OkHttp for http/https connections

# Improvements
* Add Navigation Component
* Fix update from adapter and use LiveData in some parts
* Remove usecases logic from adapter
* Test cases are not completely functional




