# Agent Prompt: Split SQL Solutions from Master File

## Purpose
Split SQL assignment solutions from the master `solutions_file.sql` into individual per-assignment `solution.sql` files.

## SOURCE OF TRUTH — READ THIS FIRST

**You are a file splitter. You are NOT a SQL writer. You are NOT a problem solver.**

Every line of SQL you write must come directly from the master file. You must never invent, derive, modify, or solve any SQL query. The master file already contains the correct solutions — your only job is to extract and copy them.

## ABSOLUTELY FORBIDDEN

The following actions will cause the agent to fail its task. Do NOT do any of these:

1. **Do NOT write any SQL query that does not appear verbatim in the master file.** If the master file does not contain a solution for an assignment, do not write one.
2. **Do NOT solve any assignment problem.** Read the `.md` instruction files if you need context, but do not write solutions based on them.
3. **Do NOT modify existing SQL code.** If you extract a query from the master file, copy it exactly — same indentation, same formatting, same syntax. Do not "improve" it.
4. **Do NOT add comments that explain SQL logic.** Only preserve comments that already exist in the master file.
5. **Do NOT infer SQL from assignment descriptions.** The `.md` files describe what the assignment asks for. You already have the answer in the master file. Do not cross-reference or verify correctness.
6. **Do NOT create solution files for assignments that do not have solutions in the master file.** Assignments 17-20 do not exist in the master file. Do not create their solution files.
7. **Do NOT write CREATE TABLE, DROP TABLE, or INSERT INTO statements unless they already exist in the master file for that specific assignment.**


## Source
- Master file: `/home/user1/Desktop/RevatureTraining/class_repo/assignments/sql/solutions_file.sql`

## Target
Each assignment directory already has a `solution.sql` file. Overwrite them with the extracted solutions.

Assignment directories: `sql_assignment_01/` through `sql_assignment_16/` (plus `sql_assignment_20_optional/`)

## How solutions are delimited

In the master file, solutions are separated by comment headers:
```sql
/* Assignment One */
/* Assignment Two */
/* Assignment 14 */
```

Map names to directories:
- "Assignment One" → `assignments/sql/sql_assignment_01/solution.sql`
- "Assignment Two" → `assignments/sql/sql_assignment_02/solution.sql`
- ... continue through ...
- "Assignment 16" → `assignments/sql/sql_assignment_16/solution.sql`
- "Assignment Twenty" → `assignments/sql/sql_assignment_20_optional/solution.sql`

Note: Names 1-13 and 15-16 use spelled-out English. Assignment 14 uses numerals.

## What goes into each solution.sql

**Rule: Copy only the solution queries (SELECT, UPDATE, DELETE, etc.) from the master file. Do NOT copy DDL or data statements.**

- **Do NOT include** `CREATE TABLE`, `DROP TABLE`, `ALTER TABLE`, or any other schema modification statements.
- **Do NOT include** `INSERT INTO` statements or any data population code.
- **Only include** the solution queries — the actual SELECT/UPDATE/DELETE statements that answer the assignment.
- If a solution block contains both DDL/data and solution queries, copy only the solution query portion.

## Steps

1. Read the master file at `assignments/sql/solutions_file.sql`
2. For each assignment:
   a. Find the solution block between its header (`/* Assignment [Name] */`) and the next assignment header
   b. Copy the content EXACTLY as it appears in the master file
   c. Write to the appropriate `solution.sql` file in the assignment directory
3. Do NOT modify any `.md` files or other files
4. Do NOT create new directories

## Verification

After splitting, verify that every line in each `solution.sql` file exists somewhere in the master file. If a line does not exist in the master file, remove it.
