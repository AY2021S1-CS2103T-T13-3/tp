---
layout: page
title: Tan Wei Jie's Project Portfolio Page
---

## Project: FitEgo

FitEgo is a desktop scheduling application catered for personal, recreational, sports and competitive instructors.
They may use this software to ease the hassle of managing clients and their schedule. The user interacts with it mainly using CLI,
and it has a GUI created with JavaFX.

Given below are my contributions to the project.

* **New Feature**: Added the ability to auto-complete commands while the user is typing. (Pull requests [\#99](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/99))
  * What it does: allows the user to view the commands available in FitEgo during mid-typing, so that forgetful users can reference to it. Advanced users can also use the "TAB" key to lessen the typing. 
  * Justification: This feature make it user-friendly because new users are guided to available commands, and advanced users can type lesser. 
  * Credits: ControlsFX library was used to display the available commands in a table-list format. 

* **New Feature**: Added the ability to warn users if their data file is not in correct format (Pull requests [\#251](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/251))
  * What it does: warns the user if FitEgo is unable to parse the data from the data file. Allows user to exit immediately to prevent data file being overwritten. 
  * Justification: This feature protects the user's important data file and prevents unrecoverable damages. 

* **New Feature**: Added the feature to track weight for every schedule (Pull requests [\#159](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/159))
  * What it does: allows the user to store weight for every schedule. Then, the user is able to view the weight over time using a line-chart. 

* **New Feature**: Added the feature to view client's full information (Pull requests [\#60](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/60), [\#77](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/77), [\#159](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/159))
  * What it does: allows the user to view the client's profile, schedules, and weight over time. 
  * Justification: This feature allows the user to track the client's progress, so that he does not have to utilise another software or perform calculations manually. 
  * Credits: With the help of Kelvin (adding different weight units) and Bennett (displaying all schedule related to the clients in a table), I had managed to integrate both of their work into a tab pane. 

[comments]: <> (Added a history command that allows the user to navigate to previous commands using up/down keys. - PR#99)

* **Enhancements to existing features**:
  * Updated the Help Window, so that user do not have to manually open the browser (Pull requests [\#99](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/99))
  * Updated the Mainpage of the GUI (Pull requests [\#77](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/77), [\#94](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/94))
  * Changed the `AddressBookParser` class to use hashmap and functions (Pull requests [\#84](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/84))
  * Changed `UniqueClientList` into generics (Pull requests [\#75](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/75))
  * Modify `find` to include partial substring (Pull requests [\#54](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/54))
  * Modify saving to storage to include `Session` objects (Pull requests [\#70](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/70), [\#71](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/71), [\#73](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/73))

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=T13-3&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=functional-code&tabOpen=true&tabType=authorship&tabAuthor=tanweijie123&tabRepo=AY2021S1-CS2103T-T13-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other)

* **Project management**:
  * Added user stories into project issue trackers
  * Changed FitEgo icon

* **Documentation**:
  * User Guide:
    * Added documentation for the features `home`, `clist`,  `cview` : [\#60](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/60)
    * Made modifications to existing documentation of features `help`, `clear` and `cfind` : [\#151](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/151)
    * Added documentation for "How to interpret notations" and "UI-orientation", and preface for client-, session- and schedule-related keywords :  [\#151](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/151)
    
  * Developer Guide:
    * Updated the UI class diagram 
    * Added user stories 

* **Community**:
  * Assisted Kelvin with `sview` to provide flexible view range for users. 
  * With the help of Kelvin and Bennett, we integrated the weight and schedule related to clients into a tab pane. 
  * Reported bugs and suggestions for other team members during weekly team meetings. 

* **Tools**:
  * Integrated a third party library (ControlsFX) to the project ([\#99](https://github.com/AY2021S1-CS2103T-T13-3/tp/pull/99))
