Android Pre-work: Todo App
The pre-work incorporates a few steps:

Setup your Android environment
Build initial todo app
Submit todo app for review via Github
Add edit functionality to todo app
Extend your todo app, improve UI, add features
SimpleTodo Walkthrough
Today's assignment will take you through a complete local setup and building your first app, a simple todo list. The guide material for this assignment is divided into two main sections:

Setup of your local workstation with Android Studio and all necessary tools
SimpleTodo app design, development, and submission via Github
These two sections are further broken down into several chapters, each of which is covered in a video with accompanying slides. Proceed through all chapters in the order presented, making sure you understand the concepts and have completed the objectives presented in each chapter before moving on to the next.

Running into issues with your app, such as crashes? Check out our solving problems in Android apps guide to learn about how to debug and correct issues as they come up. You can also reference this list of common issues specific to this assignment.
1. Setup Android
In the first section, you will install and configure your local workstation for Android development, including all necessary tools such as Android Studio and Git, including configuring the emulator, setting up your first Android project, and using Git. You can follow the whole setup playlist here. Completing the setup can often take ~90 minutes. The steps for setup are outlined in more detail below:

1.1 - Install Android Studio
MacOS

🎬 Install Android Studio (7:42)
Slides
Download and install Android Studio.
Windows

🎬 Windows - Android Studio Setup (8:22)
Slides
Download and install Android Studio.
1.2 - Git & First Android Project
🎬 Git & First Android Project (7:58)
Slides
Introduction to Git and GitHub and basic Git commands. Cloning a sample project from GitHub and opening and running it in Android Studio.

1.3 Emulator
🎬 Emulator (7:07)

Slides
Running Apps on Your Device

Set up the Android emulator and learn how to run apps on it. Learn about running and testing apps on a physical device. Change the default layout template in Android Studio.

2. Build the SimpleTodo App
In this section, you will design, develop, and submit your first app: a simple todo list manager. You'll understand how to turn requirements into a design, wireframe a UI, and devise a strategy for systematically implementing features step-by-step. At the end, you'll learn how to publish your code to Github and submit your project via the CodePath course portal. The steps you learn in these videos will be used throughout the rest of the course.

Completing and then submitting the initial todo app will likely take a few hours. You can build the app by coding along with this video playlist. The steps are outlined in more detail below:

2.1 - Setup
🎬 SimpleTodo Setup (6:55)
Since all submissions will be done in Java, make sure to not select Kotlin as the language. 
If you project starts up with Kotlin files (i.e. MainActivity.kt), you should start over and create a new project with Java as the chosen language.
Here are some helpful CodePath guides for file organization in Android:
Android Directory Structure
Organizing your Source Files
Begin by creating a new project for the SimpleTodo app, understanding the which minimum API version to use and how projects in Android Studio are organized.

Objectives
New, runnable project set up from scratch
Understand minimum API version
Understand project layout and key files
2.2 - Design
🎬 SimpleTodo Design (15:51)
Constructing View Layouts
Defining Views and their Attributes
In this step, you'll review the required features for your app and translate them into a strategy for implementation, including how to think about different areas of functionality using the Model-View-Controller. You'll see how to wireframe the app and turn that into a user interface using the Android XML layout designer.

Objectives
Understand required features / stories
MVC pattern
Wireframe user interface
Build user interface via layout
Understand layout Design vs. Text views
2.3 - Render the list of items
🎬 SimpleTodo Rendering Items (17:13)
Understanding App Resources
Understanding Activity Lifecycle
In this step, we'll write Java code which manages the data model and adapter, and wires the list of todo items in a list using a RecyclerView.

Objectives
Understand basics of Java coding
Extending onCreate()
Adding new methods to activity class
Defining a data model
Defining an adapter and viewholder
Using Android layouts
Binding the adapter to the data source
2.4 - Implement add and remove functionality
🎬 SimpleTodo Adding/Removing Items (17:35)
View Event Listeners
In this step, complete the implementation of the app by setting up event listeners and handlers, and implementing persistence of the data to the device file system. You'll learn how to use other features such as Toasts and logging as well.

Objectives
Wiring code and design
Using onClick() handlers
Setting up event listeners
Understand functional areas
Persistence
Toasts and Logging
(Optional) 2.5 Adding the Editing Feature
🎬 SimpleTodo Stretch Goals (23:44)
Using Intents to Launch Activities
In this optional step, we will implement a new feature to allow users to edit the text of an item added to the list. For this task, the user should be able to tap a todo item in the list and bring up an edit screen for the todo item and then have any changes to the text reflected in the todo list.

Objectives:

Adding a new feature
Additional Activity
Using Intents and Extras
3. Submitting your App
3.1 - Submitting via GitHub
Congratulations 🙌, you've completed all the required user stories for this project! Check out the following walkthrough videos in order to push your project to GitHub and prepare it for submission.


⚠️ IMPORTANT: You will now have to re-open your XCode project in the new repository folder location your moved it to to continue working on it!
If you prefer using terminal, feel free to check out our guide on using Git + Terminal
Update your README.md using the Prework README template
Resource: Collaborating with Git
Create GIF of your project and add it to your README.md
Creating a Gif using Recordit 2:15
Creating a Gif using QuickTime 6:00 – does not require downloading tools
GIF Recording Tools

Recordit
Kap
Feeling Stuck? Watch this exemplar submission video :)

🎬 Example Video Submitting a project via GitHub (27:38)
After making your first commit/push, double check that your repository is public

Go to your github.com dashboard, click on your prework project, select the settings tab and scroll all the way down
It should look something like this
Public Repo
All submissions happen via Github and we require each submission to follow a particular format, including a clearly documented README with a list of completed stories and a GIF app walkthrough. Once you have completed the ToDo application, pushed your code to GitHub with the README and GIF walkthrough included, you'll submit the project.

3.2 Updating Your Application
Once you have completed all required user stories and added a README as described above then you are ready to notify us that you are ready for a pre-work review. To do this, go to the application status dashboard and then press the "SUBMIT" button in the pre-work section:

