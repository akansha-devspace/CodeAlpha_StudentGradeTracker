# Student Grade Tracker

A beginner-friendly, console-based Java application for entering student marks and viewing a summary report with the average, highest, and lowest scores.

Built as part of my internship (Task 1).

## Features

- Add any number of students during a single run
- Marks are validated: only numbers from **0 to 100** are accepted
- Empty names and non-numeric input are rejected with a clear message
- Summary report table showing every student's name and marks
- Statistics: **average**, **highest**, and **lowest** score (with the student's name)
- Simple menu-driven interface

## Concepts Used

- `Scanner` for console input
- `ArrayList` to store student names and marks
- Loops (`while`, `for`) and `switch`
- Methods to keep code organised
- Input validation with `try/catch`
- Formatted output with `printf`

## Project Structure

```
StudentGradeTracker/
├── src/
│   └── StudentGradeTracker.java
├── .gitignore
└── README.md
```

## Requirements

- Java Development Kit (JDK) 8 or higher

## How to Run

```bash
# 1. Clone the repository
git clone https://github.com/<your-username>/student-grade-tracker.git
cd student-grade-tracker

# 2. Compile
javac -d out src/StudentGradeTracker.java

# 3. Run
java -cp out StudentGradeTracker
```

## Sample Run

```
=================================
      STUDENT GRADE TRACKER
=================================

--------- MAIN MENU ---------
1. Add a student
2. View summary report
3. View statistics
4. Exit
Enter your choice: 1

--- Add Student ---
Enter student name: Aarav Sharma
Enter marks for Aarav Sharma (0-100): 85.5
Student added successfully!

--------- MAIN MENU ---------
Enter your choice: 1

--- Add Student ---
Enter student name: Priya Verma
Enter marks for Priya Verma (0-100): 105
Invalid marks. Please enter a value between 0 and 100.
Enter marks for Priya Verma (0-100): 92
Student added successfully!

--------- MAIN MENU ---------
Enter your choice: 2

========== STUDENT SUMMARY REPORT ==========
No.   Name                           Marks
--------------------------------------------
1     Aarav Sharma                   85.50
2     Priya Verma                    92.00
--------------------------------------------
Total students: 2
Class average : 88.75
============================================

--------- MAIN MENU ---------
Enter your choice: 3

------------- STATISTICS -------------
Total students : 2
Average score  : 88.75
Highest score  : 92.00 (Priya Verma)
Lowest score   : 85.50 (Aarav Sharma)
--------------------------------------
```

## How It Works

1. Student names and marks are stored in two `ArrayList`s. The student at position `i` in one list matches position `i` in the other.
2. The menu runs in a loop until the user chooses **Exit**.
3. Input is read as text and converted to numbers, so wrong input shows a message instead of crashing the program.
4. The average is the sum of all marks divided by the number of students. The highest and lowest scores are found by looping through the list and keeping track of the best and worst so far.

## Possible Improvements

- Remove or edit a student's record
- Assign letter grades (A, B, C, ...)
- Save and load data from a file
- Sort the report by marks

## Author

Akansha | B-Tech CSE Student 