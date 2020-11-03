---
layout: page
title: User Guide
---

Welcome to FitEgo! This document will serve as an user guide to the all-in-one scheduling application.

Made for **fitness instructors** in mind, **FitEgo** is a **desktop program** that helps them **manage their clients and schedules**, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, **FitEgo** can get your client management tasks done faster than traditional GUI apps.

Table of Contents
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

# 1 Quick start

If this is your first time, here are some quick tips to get started.

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `fitego.jar` from [here](https://github.com/AY2021S1-CS2103T-T13-3/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your **FitEgo** program.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)
   <center>Figure 1 - Sample screenshot of our Ui</center>

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
  Some example commands you can try:

   * **[`clist`](#321-listing-all-clients--clist)** : Lists all clients stored in **FitEgo**.

   * **[`cadd n/Jane Doe p/91234567 e/jane@gmail.com`](#322-adding-a-client--cadd)** : Adds a client named `Jane Doe` to the Client List.

   * **[`cdel 3`](#325-deleting-a-client--cdel)** : Deletes the third client shown in the Client List.

   * **[`exit`](#315-exiting-the-program--exit)** : Exits the app.

1. Read [How to use](#12-how-to-use-fitego) for a quick understanding of commands in FitEgo.

1. Refer to the [Keyword](#31-main-keywords) below for more details of each command.


### 1.1 How to interpret notations

Below are a few examples of the common notations in this document in which the different backgrounds and icons represents different meanings.

[comment]: <> (Copy the blocks below and edit your message)

<div markdown="block" class="alert alert-info"> 

:information_source: **Note:**

Explains the rationale behind our design. 

</div>

<div markdown="block" class="alert alert-primary">

[comment]: <> (This only appears in Github CSS)

:bulb: **Tip:**

Good to learn, but not necessary to know to use FitEgo. 
</div>


<div markdown="block" class="alert alert-warning">

:star: **Feature:**

Important to know.
</div>

<div markdown="block" class="alert alert-success">

:heavy_check_mark: **Example:**

An example to follow. 

</div>

<div markdown="block" class="alert alert-danger">

:warning: **Warning:**

May have irreversible effect when used. Backup and caution is recommended.
</div>


### 1.2 Overview

You're a fitness instructor.

Your clients' details, clients' progress, clients' payment status, and your own schedules are spread across 3 or 4 different applications. 

You struggle to keep it updated.

You struggle even more to get insights out of them.

FitEgo can help you with that. Here's how:

FitEgo lets you record crucial information that you want to keep track of using three types of items:

Item | Prefix | What it represents
-----|-------| -------------------
Client | c | Your client
Session | s | Timeslot for a fitness session
Schedule | sch | A schedule you made with your client

And here's what you can do:
1. When you find a client that is interested in your fitness training services, add it to your list of clients with the: <br />
[`cadd` command](#322-adding-a-client--cadd)
2. Next, create a fitness session on any free timeslot that you have with the: <br />
[`sadd` command](#331-adding-a-session--sadd)
3. And, schedule your client to the fitness session with the: <br />
[`schadd` command](#341-adding-a-schedule--schadd)

Simple? Well that's how simple it is to use FitEgo.

Now, you will probably need to edit, delete and look through your clients and sessions along the way - 
FitEgo supports all those features and more.

Ready to begin? Let's start exploring!

#### Schedules

Once you have created a session, you can schedule your clients to sessions. 


    
### 1.3 General Note

The program will automatically save after every command execution to guarantee that your data will never be lost.


--------------------------------------------------------------------------------------------------------------------

# 2 UI-orientation

You can refer to the table and the figure below to familiarize yourself with the user interface of FitEgo.

[comment]: <> (Why cant you figure out yourself?)

![AnnotatedUi](images/AnnotatedUi.png)
<center> Figure 2 - Callouts of the various UI components</center><br/>
<center> Table 2 - Functions of UI Components </center>
From the figure above, the GUI is made up of several components. 

| Component | Description |
| --------------- | ---------------------------------------- | 
| Toolbar         | Displays the toolbar for this program. You can access the `exit` and `help` command from here.  | 
| Command Box     | Displays a text box for your input. You can type your command here.          | 
| Result Display  | Displays the result of your command. If the execution is successful, it will display a success message. Otherwise, it will prompt you an error message | 
| Client List     | Displays the list of clients in a list view. You can modify this list using [client-related commands](#32-client-related-keywords) |
| Main Window     | Displays the main window of this program. It consist of the statistics of this program, today's schedule and quote of the day | 
| Session List    | Displays the list of your sessions in a list view. You can modify this list using [session-related commands](#33-session-related-keywords) | 
| Status Bar Footer | Displays the current date and time of the program. If you notice this is incorrect, your PC might be using a different timezone| 


<div markdown="block" class="alert alert-primary">

:bulb: **Tip:**

You can type input into the Command Box and it will display the command starting with the input. <br/>
<br>
<center><img src="images/autocomplete_sample.png" alt="autocomplete"/>
<br>
Figure 3 - Sample of autocomplete command</center>
For example, in the above figure, if you enter `c` and commands that starts with "c" is displayed. <br>
For advanced users, you can use the "TAB" key and FitEgo will auto-complete the first suggestion into the command box, thus increasing your typing speed!   
</div>

--------------------------------------------------------------------------------------------------------------------

# 3 Keyword

In this section, you can find all the keywords that will help you fully utilize FitEgo.

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/injured-thigh` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/injured-thigh`, `t/injured-thigh t/allergy-dairy` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

This program has separated the keywords into 4 different categories - [Main](#31-main-keywords),
[Client](#32-client-related-keywords), [Session](#33-session-related-keywords) and [Schedule](#34-schedule-related-keywords).

## 3.1 Main Keywords
All main keywords are described in this section.

### 3.1.1 Viewing home : `home`

You can return to the home page by using this command. 

<center><img src="images/homepage.png" alt="homepage"/></center>
<center> Figure 4 - Homepage View </center>

The homepage will display the statistics of your program, today's schedule and quote of the day as shown in the figure above. 
If you do not have any planned schedules for the day, it will display `There is no schedules assigned today!`.  

<div markdown="block" class="alert alert-warning">

:star: **Feature:**

If your session spreads over more than 1 day, the schedule will still be displayed if it intersects with today's date. 

</div>

### 3.1.2 Viewing help : `help`

You can ask FitEgo to open a window with a link to the help page as shown in the figure below.

<center><img src="images/helpMessage.png" alt="helpMessage"/></center>
<center> Figure 5 - Help Window </center>

Format: `help`

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:**
By default, you can press "ENTER" key and a browser will open the User Guide. This pop-up window will close after you clicked on the link. 
Alternatively, you may press the "ESC" key to close this window. 
</div>

### 3.1.3 Viewing settings: `settings`

You can ask FitEgo to open a window to change user settings.

<center><img src="images/settingsWindow.png" alt="settingsWindow"/></center>
<center> Figure - Settings Window </center>

Format: `settings`

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:**
Once the settings window is open, you can use arrow key to toggle the options.
You may press "ESC" key to save your changes and close this window. You can press "F2" key anytime in the 
program to open the settings window too. <br/>

The current settings available are:
 * preferred weight unit for graphs <br/>
 *more to come!
</div>

### 3.1.4 Clearing all data in the program : `clear` 

You can delete all data (client, session, schedule) using the `clear` keyword. All of your existing data will be removed. 

<div markdown="span" class="alert alert-danger"> 

:warning: **Warning:**

By using this command, you will delete all of your data, and by design of the system, it will be automatically saved. 
You will not be able to retrieve your previous data unless you have backed up the data file into an external location. 
</div>

### 3.1.5 Exiting the program : `exit`

You can exit the program using the `exit` command. Your data is saved automatically. 

Format: `exit`


### 3.1.6 Saving the data

Your data in FitEgo are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

---

## 3.2 Client-related Keywords
All client-related keywords are described in this section. All of the commands here will interact with the Client List which is located at the [left of the UI](#2-ui-orientation). 

<center><img src="images/ClientPanel.png" alt="client_panel" width="250" height="400" />
<br/>Figure 6 - Sample of Client List</center>

### 3.2.1 Listing all clients : `clist`

You can view the list of all clients in FitEgo. The list of clients will be shown at the Client List. 

By default, Client List will display all the clients. In case you used [`cfind`](#324-locating-clients-by-name--cfind) or any filter-typed commands, 
you can use `clist` to view the entire list of clients.  

Format: `clist`

### 3.2.2 Adding a Client : `cadd`

You can add a client to the Client List including their details. This allows you to easily refer to their information when needed. 

Format: `cadd n/NAME p/PHONE_NUMBER e/EMAIL [t/TAG]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A client can have any number of tags (including 0). Each tag can include
alphanumeric characters or dash (`-`), but you are not allowed to start or end
a tag with a dash. 
</div>

<div markdown="block" class="alert alert-warning">

:star: **Feature:**

You can add profile picture to your client by storing their photo in `data/images` folder. You should name the photo 
as `profile-<client's full name in lowercase and separated by dash>.jpg`. <br/> For example, if your client's name is Alex Yeoh, 
store his photo as `data/images/profile-alex-yeoh.jpg`
</div>

Examples:
* `cadd n/Jane Doe p/91234567 e/jane@gmail.com`
* `cadd n/John Doe p/91231367 e/jojo@gmail.com t/injured-thigh`

### 3.2.3 Editing a Client : `cedit`

If your client has any changes made to his details, then you can edit a client in the Client List. This helps you to reflect the latest information.

Format: `cedit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]`

Points to take note when editing a client's information:
* Edits the client at the specified `INDEX`. The index refers to the index number shown in the displayed Client List. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the client will be removed, i.e. adding of tags is not cumulative.
* You can remove all of the client’s tags by typing `t/` without specifying any tags after it.
* After performing a `cedit` command, you will see the updated client information page.

Examples:
*  `cedit 1 n/Janie Doe` Edits the name of the first client to be `Janie Doe`
*  `cedit 1 t/` Removes all of the tags of the first client

### 3.2.4 Locating Clients by Name : `cfind`

You can find clients whose name contain any of the given keywords, and see the result in the Client List.

Format: `cfind KEYWORD [MORE_KEYWORDS]`

Points to take note when finding clients by name:
* The search is case-insensitive, e.g. `hans` will match `Hans`.
* The order of the keywords does not matter, e.g. `Hans Bo` will match `Bo Hans`.
* Only the name is searched.
* Partial names will be matched, e.g. `Han` will match `Hans`.
* Clients matching any substring will be returned (i.e. `OR` search),
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`.

Examples:
* `cfind John` returns `john` and `John Doe`
* `cfind alex david` returns `Alex Yeoh`, `David Li` as shown in the image below <br>

<center><img src="images/findAlexDavidResult.png" alt="result for 'find alex david'" width="400" height="400" /></center>
<center> Figure 7 - Result of finding clients by name </center>


### 3.2.5 Deleting a Client : `cdel`

If you are no longer taking up a client, you can delete the client which can be found in the Client List. This helps in reducing obsolete information.

Format: `cdel INDEX`

Points to take note when deleting a client from the Client List:
* Deletes the client at the specified `INDEX`.
* The index refers to the index number shown in the displayed Client List.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `clist` followed by `cdel 2` deletes the second client in the resulting Client List
* `cfind Bernice` followed by `cdel 1` deletes the first client with the name 'Bernice' in the resulting Client List
    * If Bernice is not associated with any schedule, Bernice's client information is immediately deleted
    * If Bernice is associated with one or more schedules, you will see a warning message about the conflict and how to force delete

<div markdown="block" class="alert alert-warning">

:star: **Feature:**

- To force delete a client (and his associated schedules), pass in the optional force flag after the `INDEX`. 
Any string after the force flag (`f/`) will be ignored.

- If you perform [`cdel`](#325-deleting-a-client--cdel), you will be returned to the homepage.
</div>

* If there are one or more associated schedules associated with Bernice, `cfind Bernice` followed by `cdel 1 f/` will:
        1. Delete all schedules associated with Bernice
        2. Then, delete Bernice's client information.

### 3.2.6 Viewing a Client : `cview`

You can view the full details of a client from the Client List. 

You can easily look up the following information about the client in the central panel:
* Your client's name, email, address, phone, tags
* Your client's weight history in line graph form
* A list of schedules associated with your client, together with the interval, exercise type and remark

Format: `cview INDEX`

Points to take note when viewing clients from the Client List:
* Views the client at the specified `INDEX`. The selected client will be displayed in the main window. 
* The index refers to the index number shown in the displayed Client List.
* The index **must be a positive integer** 1, 2, 3, ...
* You can use `F3` to view your client's list of schedules, and `F4` to view your client's weight progression.
* You can sort the list of schedules by the interval or exercise type.

Examples:
* `cview 2` opens the second client in FitEgo
* `cfind Bernice` followed by `cview 1` opens the first client (Bernice) in the resulting Client List

<br>

The result of these commands is shown in the image below

<center><img src="images/cview_sample.png" alt="result for 'cview 1'" width="100%"/></center>

<center>Figure 8 - Client View with Schedules </center>

---

## 3.3 Session-related Keywords 

All session-related keywords are described in this section. All of the commands here will interact with the Session List which is located at the [right of the UI](#2-ui-orientation). The figure below shows how it looks like.

<center><img src="images/SessionPanel.png" alt="session_panel" width="250" height="450" /><br/>
Figure 9 - Sample of Session List</center><br/>
The `ALL` at the top of this Session List panel represents the current period of session view. 

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The default period of session view is 'WEEK'. You can change the period 
of session view using [`sview`](#viewing-sessions-within-period--sview) command. 
</div>


### 3.3.1 Adding a Session : `sadd`

If you have planned a session in your timetable, you can create a session with its relevant details. This provides you with an easy reference to the periods where you are not available and the location of the session.

Format: `sadd g/GYM_NAME ex/EXERCISE_TYPE at/START_TIME t/DURATION`

Points to take note when adding a session to the Session List:
* Start time should be of format "dd/MM/yyyy HHmm".
* Duration is in minutes.
* Duration should be a positive integer (larger than 0).

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
    The session's time should not overlap with previously created sessions. 
</div>

Examples:
* `sadd g/Machoman Gym ex/Endurance at/29/09/2020 1600 t/120` - Adds a session at gym `Machoman` with exercise type `Endurance` at `29/09/2020 1600hrs` that lasts for `120` minutes


### 3.3.2 Editing a Session : `sedit`

You can edit the details of the session identified by the index number used in the displayed Session List. This ensures that you can always record the latest changes.

Format: `sedit INDEX [g/GYM_NAME] [ex/EXERCISE_TYPE] [at/START_TIME t/DURATION]`

Points to take note when editing a session's details from the Session List:
* Edits the session at the specified `INDEX`. The index refers to the index number shown in the displayed Session List. The index **must be a positive integer** 1, 2, 3, …​
* `GYM_NAME` and `EXERCISE_TYPE` can be any words.
* `START_TIME` and `DURATION` convention follows the command `sadd`.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
*  `sedit 1 g/Machoman at/29/09/2020 1600 t/120 ` - Edits the gym of the first session to be `Machoman`
*  `sedit 2 at/29/09/2020 1600 t/120 ` - Edits the start time and duration of the second session to be `29/09/2020 1600 with a duration of 120 minutes`


### 3.3.3 Deleting a Session : `sdel`

You can delete the session specified by the index number used in the displayed Session List and all schedules associated with
the specified session. This helps you keep track of only sessions that are still relevant to you.

Format: `sdel INDEX [f/]`

Points to take note when deleting a session from the Session List:
* Deletes the session at the specified `INDEX`.
* The index refers to the index number shown in the displayed Session List.
* The index **must be a positive integer** 1, 2, 3, ...

Examples:
* If there are no schedules associated with the second session in the Session List, `sview p/all` followed by `sdel 2` deletes the second session
* If there are one or more associated schedules associated with the second session in the Session List, `sview p/all` followed by `sdel 2`, you will see an error message

<div markdown="block" class="alert alert-warning">

:star: **Feature:**

To force deletion of session (and all associated schedules), pass in the optional force flag after the `INDEX`. 
    Any string after the force flag (`f/`) will be ignored.
</div>

* If there are one or more schedules associated with the second session, 
  `list` followed by `sdel 2 f/` will delete all schedules associated with the second session, then delete the session itself
  
  
### 3.3.4 Viewing Sessions within Period : `sview`
You can filter the Session List to view sessions within requested period. This helps you to prioritise your sessions as needed.

Format: `sview p/PERIOD`

Points to take note when viewing session from the Session List:
 * Filters the Session List to display sessions within the specified period.
 * On top of the Session List, you can find the type of the period you are viewing.
 * The recognized periods are as follows:
 
 <center>Table 3 - List of recognised periods </center>
 
 | Period | Sessions displayed |
 | -------- | -------- |
 | all| All sessions (including past ones)|
 | future | All sessions that have not started|
 | past | All sessions that have already ended|
 | week | All sessions within the next 7 days (inclusive of today)|
 | `+[x][unit]` | Sessions within next x time units|
 | `-[x][unit]` | Sessions within past x time units|
 
 
 * The recognised units are as follows:
 <center>Table 4 - List of recognised time units </center>
 
 | Unit | Time unit parsed |
 | -------- | -------- |
 | d / D | day |
 | w / W | week |
 | m / M | month |
 | y / Y| year |
  
<center><img src="images/sview_sample.png" alt="result for 'sview p/+2w'"/><br>
Figure 10 - Result of running 'sview p/+2w' </center>

Examples:
 
* `sview p/all` - Display all sessions stored in FitEgo
* `sview p/+0D` - Display all sessions today
* `sview p/-1d` - Display all sessions from the past 1 day to today (yesterday and today)
* `sview p/+2w` - Display all sessions from today to 2 weeks later. (e.g. If today is Friday, display from today to the Friday that falls 2 weeks later)

---

## 3.4 Schedule-related Keywords 
All schedule-related keywords are described in this section. All of the commands here will interact with the various parts of [Ui](#2-ui-orientation). 

To check if you have scheduled a session with a client, you can check if the session in the Session List contains the client's name. 

<center> <img src="images/SchedulePanel.png" alt="schedule_panel" width="250" height="450" /><br>
Figure 11 - Alternate sample of Session List</center><br/>

The figure above shows the Session List, in which for each session, there is a list of clients attending the session. Clients who have paid for a session will have their name shown in <span style="color:green; font-weight: bold;">green</span>, while those who have not  will have their name shown in <span style="color:red; font-weight: bold;">red</span>.

### 3.4.1 Adding a Schedule : `schadd`

You can schedule your client for a session. You can use this command to indicate that a client will attend one of your session.

Format: `schadd c/CLIENT_INDEX s/SESSION_INDEX`

Points to take note when adding a schedule:
* This will create a schedule associated with the specified client and session.
* The client is specified by `CLIENT_INDEX`, and the session is specified by `SESSION_INDEX`.
* `CLIENT_INDEX` refers to the index number shown in the Client List, and **must be a positive integer** 1, 2, 3, …
* `SESSION_INDEX` refers to the index number shown in the Session List, and **must be a positive integer** 1, 2, 3, …

Example:

* `schadd c/1 s/1` - Schedules the first client in the Client List with the first session in the Session List

### 3.4.2 Editing a Schedule : `schedit`

If you want to change your client's session, payment status or remarks, you can edit the details of this schedule identified by the client index and session index.

Format: `schedit c/CLIENT_INDEX s/SESSION_INDEX [us/UPDATED_SESSION_INDEX] [pd/PAYMENT_STATUS] [r/REMARK] [w/WEIGHT]`

Points to take note when editing a schedule's details:
* Edits the schedule that consists of the client and session indicated by `CLIENT_INDEX` and `SESSION_INDEX`.
* `CLIENT_INDEX` refers to the index number shown in the Client List. The index **must be a positive integer** 1, 2, 3, …
* `SESSION_INDEX` and `UPDATED_SESSION_INDEX` refers to the index number shown in the Session List. The index **must be a positive integer** 1, 2, 3, …
* `PAYMENT_STATUS` can either be `paid` or `unpaid`.
* `REMARK` can be any words, phrases or sentences.
* `WEIGHT` must be **positive numbers**. By default, units will be set to kilogram. You can also add either `kg` or `lb` to the back to specify the units.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:

*  `schedit c/1 s/1 us/2` - Reschedules the first client in the Client List to the second session in the Session List
*  `schedit c/1 s/1 pd/paid` - Indicates that the first client in the Client List has paid for the second session in the Session List
*  `schedit c/1 s/1 r/did 5 pushups` - Edits the schedule containing client index 1 and session index 1 to have remark of doing 5 pushups
*  `schedit c/1 s/1 w/70` - Edits the schedule containing client index 1 and session index 1 to a weight of 70kg
* `schedit c/1 s/1 r/` - Clears the schedule containing client index 1 and session index 1 remarks

### 3.4.3 Deleting a Schedule : `schdel`

You can delete a schedule associated with a client and session. You might want to use this command when a client decided to cancel attending a particular session.

Format: `schdel c/CLIENT_INDEX s/SESSION_INDEX`

Some points to take note when deleting a schedule:
* This will delete the schedule associated with the specified client and session.
* The client is identified by `CLIENT_INDEX`, and the Session is identified by `SCHEDULE_INDEX`.
* `CLIENT_INDEX` refers to the index number shown in the Client List. The index **must be a positive integer** 1, 2, 3, …
* `SESSION_INDEX` refers to the index number shown in the Session List. The index **must be a positive integer** 1, 2, 3, …

Examples:

* `schdel c/1 s/1` - Deletes the schedule associated with the first client in the Client List and first session in the Session List

--------------------------------------------------------------------------------------------------------------------

# 4 FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous FitEgo home folder.

**Q**: I would like to contribute to this project. May I know who do I reach out to?  
**A**: You may reach our PR Department email [here](https://www.youtube.com/watch?v=dQw4w9WgXcQ).


--------------------------------------------------------------------------------------------------------------------


# 5 Command Summary

You can find the comprehensive list of commands in the table below. 

<center>Table 5 - Command Summary</center>

| Common Commands | Action | Format | Example |
| ------ | ---------| -------- | --------- |
| General Commands | Open Home Page | `home` | `home`| 
|  | Open Help Window | `help` | `help`|
|  | Open Settings Window | `settings` | `settings`|
|  | Clear all data | `clear` | `clear` |
|  | Exit this program | `exit` | `exit`|
| Add | Add Client Info | `cadd n/NAME p/PHONE_NUMBER e/EMAIL [t/TAG]`| `cadd n/Jane Doe p/91234567 e/jane@gmail.com`|
|  | Add a Session | `sadd g/GYM_NAME ex/EXERCISE_TYPE at/START_TIME t/DURATION` | `sadd g/Machoman Gym ex/Endurance at/29/09/2020 1600 t/120` |
|  | Create a Schedule |`schadd c/CLIENT_INDEX s/SESSION_INDEX`| `schadd c/1 s/3`|
| Edit | Edit Client Info | `cedit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]`| `cedit 1 n/Janie Doe`|
|  | Edit Session Info |`sedit INDEX [g/GYM_NAME] [ex/EXERCISE_TYPE] [at/START_TIME t/DURATION]` | `sedit 1 g/Machoman at/29/09/2020 1600 t/120`|
|  | Edit a Schedule |`schedit c/CLIENT_INDEX s/SESSION_INDEX [us/UPDATED_SESSION_INDEX] [pd/PAYMENT_STATUS] [r/REMARK] [w/WEIGHT]`| `schedit c/1 s/1 us/1 pd/paid r/did 5 pushups w/70kg` |
| Delete | Delete Client Info |`cdel INDEX [f/]` |`cdel 1`|
|  | Delete a Session |`sdel INDEX [f/]` | `sdel 1` |
|  | Delete a Schedule |`schdel c/CLIENT_INDEX s/SESSION_INDEX`  | `schdel c/2 s/3` |
| List/View | List All Clients | `clist`  |  `clist`  |
|   | View a Client's Full Profile | `cview INDEX` | `cview 1`|
|  | View Sessions within Period|`sview p/PERIOD ` | `sview p/all`|
| Find | Find Client by Name | `cfind KEYWORD [MORE_KEYWORDS]`| `cfind John Doe`|

# 6 Acknowledgement
* This project uses libraries from [ControlsFX](https://github.com/controlsfx/controlsfx)
