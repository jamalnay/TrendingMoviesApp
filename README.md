Android Movies App. A multi-module project that uses MVVM clean architecture, Jetpack Compose for UI and themoviedb.org movies data.

## Table of Contents

- [Overview](#overview)
- [Screenshoots](#screenshoots)
- [Features](#features)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)

## Overview

A multi-module Android project to show the most trending movies from themoviedb.org. it combines the MVVM pattern with the clean architecture principals to create a scalable and maintainable app.

## Screenshoots

<img src="https://github.com/jamalnay/TrendingMoviesApp/blob/master/screenshoots/home.png" alt="Home Screenshoot" width="250"> <img src="https://github.com/jamalnay/TrendingMoviesApp/blob/master/screenshoots/movie_details.png" alt="Movie details Screenshot" width="250"> <img src="https://github.com/jamalnay/TrendingMoviesApp/blob/master/screenshoots/error.png" alt="Error loading Screenshot" width="250"> 


## Features

- **Trending Movies:** This is the home screen where the user can navigate through themoviedb.org trending movies.
- **Movie Details:** Show detailed information about each movie, including: title,release date, voting average, movie genres, and an overview of the movie.

## Architecture

**Project Modules**

    ├── app                   # Main app, it contains: `Application class`, `MainActivity` & the `NavigationGraph`
    ├── common                # Common project modules
    │   ├── network           # Network module: builds and configures an HTTP client 
    │   └── ui                # UI modules
    │   │   └── components    # UI components: composables used across the app screens
    │   │   └── theme         # theme: central app theme, for editing colors,typography and configuring dark/light theme.
    │   └── util              # util: constants and util functions or classes used across the project.
    └── feature
        ├── trending          # trending: trending movies feature
        └── moviedetails      # moviedetails: movie details feature




**Clean architecture**
Feature modules are seperated into layers: data,domain and presentation. usecases are used to encapsulate business logic


**MVVM**
The MVVM architecturel pattern is used to seperate ui from data, viewmodels are used to hold app states


## Technologies Used

- **Kotlin:** The primary programming language for Android.
- **Jetpack Compose:** A declarative UI framework for Android.
- **Dependency Injection:** Dagger's Hilt.
- **Networking:** Retrofit.
- **Moshi:** A JSON library for Android.
- **Coil:** Image loading library for Android.
- **Paging3:** Android library to load and display pages of data.
