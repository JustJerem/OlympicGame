# Paris 2024
Application for Paris 2024 Olympic Game.

* Splashscreen with animated Olympic rings
* Access to all dates and Olympic Games
* Top athletes in descending order
* Access to athlete details: height, weight, date of birth
* Listing of all medals by type: gold, silver, bronze
* Internationalized for English, Spanish and French
* Dark & Light mode
  


## Screen Shots
[<img src="https://raw.githubusercontent.com/JustJerem/OlympicGame/master/documentation/Screenshot_20230607_184212.png" width=250 />](https://raw.githubusercontent.com/JustJerem/OlympicGame/master/documentation/Screenshot_20230607_184212.png)
[<img src="https://raw.githubusercontent.com/JustJerem/OlympicGame/master/documentation/Screenshot_20230607_183939.png" width= 250 />](https://raw.githubusercontent.com/JustJerem/OlympicGame/master/documentation/Screenshot_20230607_183939.png)
[<img src="https://raw.githubusercontent.com/JustJerem/OlympicGame/master/documentation/Screenshot_20230607_184044.png" width= 250 />](https://raw.githubusercontent.com/JustJerem/OlympicGame/master/documentation/Screenshot_20230607_184044.png)

## 🛠 Built With

- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android
  development.
	- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - A coroutine is a
  concurrency design pattern that you can use on Android to simplify code that executes
  asynchronously.
	- [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - A flow is an asynchronous
  version of a Sequence, a type of collection whose values are lazily produced.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java that simplifies the process of consuming RESTful APIs.
- [Moshi](https://github.com/square/moshi) - A modern JSON library for Kotlin and Java that makes it easy to parse JSON into Kotlin objects and vice versa.
- [Hilt](https://dagger.dev/hilt/) - Hilt is a dependency injection library for Android that builds on top of Dagger to simplify the implementation of dependency injection in your app.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) -
  Collection of libraries that help you design robust, testable, and maintainable apps.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores
      UI-related data that isn't destroyed on UI changes.
    - [Compose Destinations](https://github.com/raamcosta/compose-destinations) - 
      Simplified and type-safe navigation for Compose.
- [Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s
  modern toolkit for building native UI.
	- [Coil](https://coil-kt.github.io/coil/compose/) -  Image loading library for Compose.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Material 3]() - New design principles and components for creating modern and expressive user interfaces.
- [Lottie](https://airbnb.design/lottie/) - A library that allows you to render animations in your
Android app using After Effects animation files.
- [Mockito](https://site.mockito.org/) - A mocking framework for Java that allows you to create and configure mock objects for testing.
- [Espresso](https://developer.android.com/training/testing/espresso) - A testing framework for Android that provides a fluent API for writing UI tests. It allows you to interact with and assert the behavior of UI components.

## Screen Flow
![](https://raw.githubusercontent.com/JustJerem/OlympicGame/master/documentation/App%20Flow.png)

## Architecture Overview
![](https://raw.githubusercontent.com/JustJerem/OlympicGame/master/documentation/archi.png)
<!-- original document
https://excalidraw.com/#json=XRhY4HYn5rx3vldB1J4oo,3yGmcP4YsL8lNDN_XUO9gA
-->

## Architecture Data Flow
<!--
Code for chart:
https://mermaid.live/edit#pako:eNptkkFrxCAQhf9KEEKgJBR69FAo7aWHhaWFHlrLMhtnd2WjBjPZJYT89xrd1gbiSd_7fKOOI6utRMZZno_KKOLZWNAJNRa8kODOxTTluTAdAeGLgqMDXV0ehMn8eKpJXRQN989Wt7aDfYNZVT1mHwqvG5_aROxvGcw39Kgi64Y1dyUyYmnbskQmTATCCf9jY9TnkWZfd9-xzvY1iX4RRIN0te68tu9mBewIGndyn8ybkEw0pEhht3OoLeF6DNCpQVomJW2BrOZNrGQanQYlffvCbQULrROM-6nEA_QNCSbMjEJP9n0wNePkeixZ38rUUsYP0HReRTk_3iZ-ifAzStaC-bT2l5l-AATCsoA

%%{init: {'theme':'dark'}}%%
stateDiagram-v2
    Activity/Composable - -> ViewModel
    ViewModel - -> Repository
    ViewModel - -> Activity/Composable
    Repository - -> ViewModel 

    state Repository {
        
        [*] - -> API
        API - -> network
        
        network - -> game_db
        game_db - -> game_entities_remote
        network - -> athlete_db
        athlete_db - -> athlete_entities_remote
    }
-->

[![](https://mermaid.ink/img/pako:eNptkkFrxCAQhf9KEEKgJBR69FAo7aWHhaWFHlrLMhtnd2WjBjPZJYT89xrd1gbiSd_7fKOOI6utRMZZno_KKOLZWNAJNRa8kODOxTTluTAdAeGLgqMDXV0ehMn8eKpJXRQN989Wt7aDfYNZVT1mHwqvG5_aROxvGcw39Kgi64Y1dyUyYmnbskQmTATCCf9jY9TnkWZfd9-xzvY1iX4RRIN0te68tu9mBewIGndyn8ybkEw0pEhht3OoLeF6DNCpQVomJW2BrOZNrGQanQYlffvCbQULrROM-6nEA_QNCSbMjEJP9n0wNePkeixZ38rUUsYP0HReRTk_3iZ-ifAzStaC-bT2l5l-AATCsoA?type=png)](https://mermaid.live/edit#pako:eNptkkFrxCAQhf9KEEKgJBR69FAo7aWHhaWFHlrLMhtnd2WjBjPZJYT89xrd1gbiSd_7fKOOI6utRMZZno_KKOLZWNAJNRa8kODOxTTluTAdAeGLgqMDXV0ehMn8eKpJXRQN989Wt7aDfYNZVT1mHwqvG5_aROxvGcw39Kgi64Y1dyUyYmnbskQmTATCCf9jY9TnkWZfd9-xzvY1iX4RRIN0te68tu9mBewIGndyn8ybkEw0pEhht3OoLeF6DNCpQVomJW2BrOZNrGQanQYlffvCbQULrROM-6nEA_QNCSbMjEJP9n0wNePkeixZ38rUUsYP0HReRTk_3iZ-ifAzStaC-bT2l5l-AATCsoA)

## Entity Relationship

<!--
Code for chart:
https://mermaid.live/edit#pako:eNptks9qwzAMxl_FGEIOa1_A7LJRGDuMwUoPG4ahxmpi5tjFVgZdlnefY6d_M53s3ydL-pB7XjmFXPCi6LXVJFhfUoMtlqJU4L_KYSgKaSsDIaw01B5aaVmMJ2iR3f8ul-yBGoOEIfPjLWtvGDpD4eKJYHebzfOK1fHyqdVZicKavLY1qzQdrri2xN4RvLQZp2lOnfoMx0iVIfNT8TGOpW0sOKeh8_8LCghfd4_aUzMXt9plOFxONTnu5_lnW4mOpg7J1BWqnVE3KGjzjbd5W-_szzTywBe8Rd-CVnGTqbXkaYuSi3hUuIM4lOTSjqnQkVsfbMUF-Q4XvNuPPqftcrEDEyJFpcn5l_w70idZ8D3YD-eOOcMfFdixgw

%%{init: {'theme':'dark'}}%%
classDiagram
    Game <|-- Athlete
    Athlete <|-- Result
    Game : +UUID game_id
    Game: +String city
    Game: +int Year

    class Athlete{
        UUID athlete_id
        +String name
        +String surname
        +String dateOfBirth
        +String bio
    }
    class Result{
        +String city
        +int year
        +int gold
        +int silver
        +int bronze
    }
-->

[![](https://mermaid.ink/img/pako:eNptkt1KxDAQhV8lBEov7L5A8EZZEC9EcNkLJSCzzbQN2yZLOhVq7bubJq37U-cq-c5hMofJwHOrkAueJIM2mgQbUqqwwVSkCtwxHcckkSavoW23GkoHjTTM1xM0yO5_Nhv2QFWNhBHPl6i8YdvVdOEX7G6_f96y0l8-tTorXtiR06Zkuab-imtD7B3BSRNxGGV5Z4hsqtAYIv7rPdXS2fh-a9p27n9BAeFr8agdVWvxoG2E4-VQMe-wtp9DBTpF6kOkK1TaWt2gVtdfeOs7OGu-54lHnvEGXQNa-SWGpyUPC5Rc-KPCAqYdcGkmK3Rkd73JuSDXYca70xRzXiwXBdStp6g0WfcSP0b4Hxk_gfmwdvGMv3wkr0Q?type=png)](https://mermaid.live/edit#pako:eNptkt1KxDAQhV8lBEov7L5A8EZZEC9EcNkLJSCzzbQN2yZLOhVq7bubJq37U-cq-c5hMofJwHOrkAueJIM2mgQbUqqwwVSkCtwxHcckkSavoW23GkoHjTTM1xM0yO5_Nhv2QFWNhBHPl6i8YdvVdOEX7G6_f96y0l8-tTorXtiR06Zkuab-imtD7B3BSRNxGGV5Z4hsqtAYIv7rPdXS2fh-a9p27n9BAeFr8agdVWvxoG2E4-VQMe-wtp9DBTpF6kOkK1TaWt2gVtdfeOs7OGu-54lHnvEGXQNa-SWGpyUPC5Rc-KPCAqYdcGkmK3Rkd73JuSDXYca70xRzXiwXBdStp6g0WfcSP0b4Hxk_gfmwdvGMv3wkr0Q)


