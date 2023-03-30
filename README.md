# :rocket: Spacex :rocket:

Spacex is Android App for showing SpaceX Rockets & their details. The objective of the repository is to demonstrate the:

* MVVM Android App architecture 
* Offline Supoort Using Room DataBase
* UI Implementation using Material Components
* Standard Coding rules  
* Coroutines and Livedata
* Dependency injection using Hilt

# Links for Demo

https://drive.google.com/file/d/1ILzpTQecNiWxuGMnJF1Khfqva_t88hWp/view?usp=share_link



# Things used while making this application

* Recycler View
* Retrofit Library
* MVVM
* Dagger-Hilt
* Room DB
* Coroutines
* Navigation graph
* [Spacex API]("https://github.com/r-spacex/SpaceX-API")

# Tech Stack ✨

* [Android Studio](https://developer.android.com/studio)
* [Kotlin](https://kotlinlang.org/)

# Architecture

This app uses [MVVM (Model View View-Model)](https://developer.android.com/jetpack/guide#recommended-app-arch) architecture.

<img src="https://camo.githubusercontent.com/be9b0e8eb62e13a031031fb16e99f33c647da47908a21f451cb00d2c99fb9b31/68747470733a2f2f646576656c6f7065722e616e64726f69642e636f6d2f746f7069632f6c69627261726965732f6172636869746563747572652f696d616765732f66696e616c2d6172636869746563747572652e706e67">


# Clone this Repo To Your System Using Android Studio✨

* Step 1: Open your Android Studio then go to the File > New > Project from Version Control as shown in the below image.
* Step 2: After clicking on the Project from Version Control a pop-up screen will arise like below. In the Version control choose Git from the drop-down menu.
* Step 3: Then at last paste the link in the URL and choose your Directory. Click on the Clone button and you are done.

# Clone this Repo To Your System Using GitBash✨

* Open Git Bash

* If Git is not already installed, it is super simple. Just go to the Git Download Folder and follow the instructions.

* Go to the current directory where you want the cloned directory to be added.

* To do this, input cd and add your folder location. You can add the folder location by dragging the folder to Git bash.

* Go to the page of the repository that you want to clone

* Click on “Clone or download” and copy the URL.

* Use the git clone command along with the copied URL from earlier. $ git clone https://github.com/AmolPardeshi99/SpaceXRockets.git

* Press Enter. $ git clone https://github.com/AmolPardeshi99/SpaceXRockets.git

Congratulations, you have created your local clone from your remote Github repository.

Open Android Studio. Go to File > New > Project From Version Control. Copy the link of this repositary. Paste the link in Url Box of Android Studio window and click on "Clone" button.

# Let's See
 
 <img src="https://github.com/AmolPardeshi99/SpaceXRockets/blob/master/Assets/spacex_demo_amol_pardeshi.gif" width="300" height="750">

 
 ## Home - Rocket Listing Page:
 
 <img src="https://github.com/AmolPardeshi99/SpaceXRockets/blob/master/Assets/home_page_1.png" width="300" height="750">
 
 ## Specific Rocket Detail Screens:
 
 <img src="https://github.com/AmolPardeshi99/SpaceXRockets/blob/master/Assets/rocket_detail_screen_1.png" width="300" height="750">
 
  <img src="https://github.com/AmolPardeshi99/SpaceXRockets/blob/master/Assets/rocket_detail_screen_2.png" width="300" height="750">

 <img src="https://github.com/AmolPardeshi99/SpaceXRockets/blob/master/Assets/rocket_detail_screen_3.png" width="300" height="750">

 <img src="https://github.com/AmolPardeshi99/SpaceXRockets/blob/master/Assets/rocket_detail_screen_4.png" width="300" height="750">

 <img src="https://github.com/AmolPardeshi99/SpaceXRockets/blob/master/Assets/rocket_detail_screen_5.png" width="300" height="750">



# Dependencies 

    dependencies {

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.test:core-ktx:1.5.0'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.4'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    def hilt_version="2.44"
    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-compiler:$hilt_version"

    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"

    def retrofit_version = "2.9.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation("com.google.code.gson:gson:2.9.0")


    def room_version = "2.4.3"
    implementation "androidx.room:room-runtime:$room_version"
    implementation "androidx.room:room-ktx:$room_version"
    kapt "androidx.room:room-compiler:$room_version"

    def coroutines_version = "1.6.4"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"

    // testing
    testImplementation "androidx.arch.core:core-testing:2.1.0"
    androidTestImplementation "androidx.arch.core:core-testing:2.1.0"
    testImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4'
    androidTestImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4'
    testImplementation 'androidx.test:runner:1.5.1'
    androidTestImplementation 'androidx.test:runner:1.5.1'
    androidTestImplementation 'androidx.test:core:1.5.0'


    //hilt
    androidTestImplementation 'com.google.dagger:hilt-android-testing:2.44'
    kaptAndroidTest 'com.google.dagger:hilt-android-compiler:2.44'
    
    // glide
    implementation 'com.github.bumptech.glide:glide:4.14.2'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.14.2'
    
    // swiperefreshlayout
    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'
    
    // fragment navigation
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.3'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.3'

}

    


Hard work beats the talent, when talent doesn't do the hardwork.
I am new person in open source of Android Development, so please feel free to correct and make changes. #LookingForward 
