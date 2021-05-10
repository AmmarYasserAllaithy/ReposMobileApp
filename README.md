# ReposMobileApp

### Description
> *Create an Android app for modern devices that queries a web service and displays the results, where the user can search for repositories on GitHub.* 


### Key highlights

- A simple but challenging task, written in **Kotlin** and…
    - ConstraintLayout
    - RecyclerView
    - CardView
    - Binding
    - MVVM
    - LiveData, MutableLiveData
    - androidx.ViewModel
    - Coroutines
    - Retrofit
    - OkHTTP
    - Gson, Converters
    - Koin Dependency Injection
    - Glide
    - Git version control

- Fetch data from GitHub API v3

- Preserve data between two state (Portrait / landscape


### Summary

| Task                                    | Solution                                                                      |
| --------------------------------------- | ----------------------------------------------------------------------------- |
| Search Layout                           | ConstraintLayout, EditText, ImageButton                                       |
| Display repositories list               | ProgressBar, RecyclerView, RecyclerAdapter, `Implement Diffutil.Itemcallback` |
| Design item layout (Avatar, name, desc) | CardView Contains ConstraintLayout Has ImageView And 2 TextView               |
| DEPENDENCY INJECTION                    | Koin                                                                          |
|                                         |                                                                               |
| Preserve state                          | Save Data in Both Portrait / Landscape Mode.                                  |
|                                         |                                                                               |
| Assert internet access                  | Handle By NetworkHelper Class                                                 |
| If offline                              | Toast With Text Of “No Internet Connection”                                   |
| If empty search query                   | Toast With Text Of “Invalid Name”                                             |
| On item click                           | Browse For Github Repository Page.                                            |
| After populate data in list             | Hide Keyboard                                                                 |


### Preview

| Light mode                  | Night mode                  |
| --------------------------- | --------------------------- |
| ![Light](preview/light.jpg) | ![Night](preview/night.jpg) |
