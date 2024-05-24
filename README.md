A demo Android Project! using MVVM clean architecture, Jetpack Compose for UI and themoviedb.org movies data.

## Table of Contents

- [Overview](#overview)
- [Screenshoots](#screenshoots)
- [Features](#features)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)

## Overview

This project is for demonstration purposes. It combines the MVVM pattern with the clean architecture principales to create a scalable and maintanable app.

## Screenshoots

<img src="https://github.com/jamalnay/TrendingMoviesApp/blob/main/screenshoots/home.png" alt="Home Screenshoot" width="250"> <img src="https://github.com/jamalnay/TrendingMoviesApp/blob/main/screenshoots/movie_details.png" alt="Movie details Screenshot" width="250"> <img src="https://github.com/jamalnay/TrendingMoviesApp/blob/main/screenshoots/error.png" alt="Error loading Screenshot" width="250"> 


## Features

- **Trending Movies:** This is the home screen where the user can navigate through themoviedb.org trending movies.
- **Movie Details:** Show detailed information about each movie, including: title,release date, voting average, movie genres, and an overview of the movie.

## Architecture

This Android project follows an MVVM-Clean Architecture for the maintainability, and code re-usability, making it highly adaptable for complex app development.
The architecture enforces a clear separation of concerns, allowing the focus on building individual features while maintaining a well-structured codebase.

## Technologies Used

In this project, I have leveraged various Android & Wordpress technologies.

- **Kotlin:** The primary programming language for Android.
- **Jetpack Compose:** A declarative UI framework for Android.
- **Dependency Injection:** Dagger's Hilt.
- **Networking:** Retrofit.
- **Moshi:** A JSON library for Android.
- **Coil:** Image loading library for Android.
- **Paging 3** Android library to load and display pages of data.