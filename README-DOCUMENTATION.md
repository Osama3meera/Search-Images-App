# Unsplash-PenguinIN project

this is the Documentation of the project Development.

Let's Start, 

1- Essential informations about the project :

- The app was developed using Kotlin 
- The app is targeted for Android 11+
- Supports light mode only


2- Code structure and Tools : 

- Libraries used are Retrofit + Glide
- Navigation component was used to navigate and pass data between fragments
- Design pattern used is MVVM


3- Testing conditions : 

- Null pointer exceptions cases were handled
- Search button won't function if the field was empty
- added above back button to go back to previous fragment
- "Description not Available!" will show if description was null
- "Name not Available!" will show if name was null
- "Portfolio not Available!" will show if name was clicked and the portfolio was null

4- Error handling

- Null pointer exceptions are handled 
- Failed responses case is handled - Toast will be shown
- Http request case is handled (onFailure) - Toast will be shown


5- UI/UX

- The layout is easy to use
- If anything failed to function, the user will know about it using Toasts
- Matching colors were used ( Orange + Black + White )
- Smooth list scrolling
- Pretty list item layout is built
- User can go back easily using the back arrow above or hardware back button
- Edit text will be cleared when user go back the search screen
