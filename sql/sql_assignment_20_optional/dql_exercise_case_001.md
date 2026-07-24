# Exercise — Student Score Report

Given the following tables, provide an SQL statement that returns each student's ID, name, and test score for the **Introductory SQL** test — with one condition: any student who scored below the pass mark for that test should have their name replaced with `NULL` in the result. The results should be ordered from highest score to lowest.

*Note: the student ID and score should always be visible regardless of whether the student passed. All rows must appear in the result — do not filter out any students.*

*You can solve this task using a concept we have not yet covered in lecture — the `CASE` statement. Please do some independent research on this concept before attempting this activity.*

Student
| student_id | student_name |
|-|-|
| 1001 | Alice Morrow |
| 1002 | Ben Okafor |
| 1003 | Cara Singh |
| 1004 | Dana Reeves |
| 1005 | Ellis Park |
| 1006 | Faye Lunden |
| 1007 | George Tam |
| 1008 | Hannah Cruz |
| 1009 | Ivan Petrov |
| 1010 | Julia Marsh |

TestConfig
| test_id | test_name | pass_mark |
|-|-|-|
| 1 | Introductory SQL | 60 |
| 2 | Intermediate SQL | 70 |
| 3 | Advanced SQL | 75 |

TestEvent
| event_id | test_id | student_id | test_score |
|-|-|-|-|
| 1  | 1 | 1001 | 92 |
| 2  | 1 | 1002 | 65 |
| 3  | 1 | 1003 | 55 |
| 4  | 1 | 1004 | 48 |
| 5  | 1 | 1005 | 88 |
| 6  | 1 | 1006 | 43 |
| 7  | 1 | 1007 | 71 |
| 8  | 1 | 1008 | 60 |
| 9  | 1 | 1009 | 95 |
| 10 | 1 | 1010 | 58 |
| 11 | 2 | 1001 | 88 |
| 12 | 2 | 1002 | 55 |
| 13 | 2 | 1003 | 78 |
| 14 | 2 | 1004 | 63 |
| 15 | 2 | 1005 | 91 |
| 16 | 2 | 1006 | 40 |
| 17 | 2 | 1007 | 74 |
| 18 | 2 | 1008 | 69 |
| 19 | 2 | 1009 | 82 |
| 20 | 2 | 1010 | 70 |
| 21 | 3 | 1001 | 80 |
| 22 | 3 | 1002 | 74 |
| 23 | 3 | 1003 | 91 |
| 24 | 3 | 1004 | 60 |
| 25 | 3 | 1005 | 77 |
| 26 | 3 | 1006 | 55 |
| 27 | 3 | 1007 | 83 |
| 28 | 3 | 1008 | 75 |
| 29 | 3 | 1009 | 88 |
| 30 | 3 | 1010 | 72 |

---

**Stretch Goal:** Provide a second query that returns a report for **all tests and all attempts** — not just Introductory SQL. Each row should include the student's ID, name, the test name, and their score. A student's name should be masked with `NULL` if their score falls below the `pass_mark` for that specific test.

*Note: your `CASE` condition will need to compare against a column value from a joined table rather than a hardcoded literal. The result set should contain one row per student per test (30 rows total), ordered by test name then score descending.*
