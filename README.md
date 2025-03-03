# Mobile Developer Coding Challenge
 Completed my coding challenge

## The Goal

Build a simple two-screen podcasts app. A Output is provided below:

![screen2](https://github.com/user-attachments/assets/b5c14af7-b6dd-4db5-9f5b-8bbc9a4f7914)
![screen1](https://github.com/user-attachments/assets/eba46fa7-f304-4a89-8a8c-cdebad6fbaf6)



#### Screen 1

- [ ✓] Show a list of podcasts using the endpoint provided below.
- [ ✓] Each list item should show the podcast thumbnail, title, and publisher name. There is <ins>**NO**</ins> need to show the Favourite text shown in the mock for screen 1.

#### Screen 2

- [✓ ] Tapping on a list item from Screen 1 should bring you to Screen 2.
- [✓ ] On Screen 2, show the podcast's title, publisher name, thumbnail, and description.
- [✓] Add a Favourite button.
- [✓ ] The Favourite button should have two states: Favourite and Favourited.
- [✓ ] When tapping the Favourite button, the label should change to Favourited, and vice-versa. There is <ins>**NO**</ins> need to handle the actual favourite action.

## Details

- [✓ ] Create a new repository to work in. Do <ins>**NOT**</ins> fork this repository.
- [ ✓] Please use the code from this repository as a starting point to complete the challenge. If you want to instead start from scratch, that is also an option, but is not required nor expected.
- [ ✓] Must be written in Kotlin and use Jetpack Compose for UI.
- [✓ ] The initial project was created using Android Studio Ladybug Feature Drop | 2024.2.2 Patch 1. Make sure to have an updated version of Android Studio before starting the challenge.
- [✓ ] For the API, fetch the data using the Repository instance in the PodcastListViewModel class. If needed, check the information provided by the API used:
	 - [ ] The following endpoint is used to fetch podcast data: https://www.listennotes.com/api/docs/?lang=kotlin&test=1#get-api-v2-best_podcasts
	 - [ ] No API key required, you can simply use the mock server to fetch test data. [More information here](https://www.listennotes.help/article/48-how-to-test-the-podcast-api-without-an-api-key "More information here").

## The Evaluation

Your code will be evaluated based on the following criteria:

- [ ] The code should compile.
- [ ] No crashes, bugs, or compiler warnings.
- [ ] App operates as outlined above.
- [ ] Conforms to modern development principles.
- [ ] Code is easy to understand. Bonus points for documentation.
- [ ] Commit history is consistent, easy to follow and understand.
