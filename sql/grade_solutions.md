# Agent Prompt: Grade SQL Assignments

## Purpose
Read each assignment's `.md` instruction file and its corresponding `solution.sql`, evaluate correctness, and produce a single grading report markdown file.

## SOURCE OF TRUTH — READ THIS FIRST

**You are a grader, not a solver. You are evaluating whether each solution answers the assignment prompt correctly — not finding the "best" or "only" correct answer.**

Multiple SQL queries can solve the same problem. If a solution produces the correct result and follows the assignment instructions, it is correct — even if it differs from how you would write it.

## What to Grade

For each assignment directory that contains a `solution.sql` file:

1. **Read the `.md` instruction file** — understand what the assignment asks for
2. **Read the `solution.sql`** — see what the student submitted
3. **Evaluate correctness** — does the solution answer the prompt?
4. **Record PASS or FAIL** for each assignment

## Grading Rules

### What constitutes PASS:
- The solution addresses all requirements in the `.md` prompt
- The SQL syntax is valid
- The query logic matches the assignment intent (correct tables, correct joins, correct filters, correct aggregates)
- Column names, table names, and aliases are reasonable and consistent with the schema provided in the `.md` or schema file

### What constitutes FAIL:
- The solution is missing entirely (no `solution.sql` file)
- The solution does not address the prompt at all
- The SQL has syntax errors that would prevent execution
- The logic is fundamentally wrong (e.g., wrong join condition, missing required filter, incorrect aggregate)
- The solution answers a different question than what was asked

### Partial credit considerations:
- For multi-query assignments (e.g., 4 numbered queries), if 3 of 4 are correct, mark as **PASS** but note which query was incorrect
- For DDL assignments, if the table structure matches the schema but column types differ slightly, mark as **PASS** with a note
- For assignments with "Stretch Goal" sections, do NOT fail the assignment if the stretch goal is missing — those are bonus

## What NOT to Do

1. **Do NOT penalize for stylistic differences.** `INNER JOIN` vs `JOIN`, table aliases vs full names, indentation style — these are fine.
2. **Do NOT require exact column ordering** unless the prompt specifies it.
3. **Do NOT require exact column aliases** unless the prompt specifies them.
4. **Do NOT penalize for using a different but equivalent approach.** A subquery solution and a JOIN solution can both be correct.
5. **Do NOT add or modify solution files.** You are grading only — never write SQL.
6. **Do NOT grade assignments that don't have a `solution.sql` file.** Skip them entirely and note them in the report.

## Input
- Assignment directories: `sql_assignment_01/` through `sql_assignment_20_optional/`
- Each directory contains: `<type>_exercise_XXX.md` (instruction file) and optionally `solution.sql`
- Some assignments have a separate schema file (e.g., `<type>_exercise_XXX_schema.sql`) — read it to understand the schema

## Output

Create a file named `grading_report.md` in the same directory as the assignment files (`sql/`).

### Format

```markdown
# SQL Assignments — Grading Report

## Summary

| Assignment | Status | Score |
|------------|--------|-------|
| Assignment 01 | PASS | 100% |
| Assignment 02 | PASS | 100% |
| ... | ... | ... |
| **Total** | **X/Y passed** | **Z%** |

## Detailed Feedback

### Assignment 01 — [Exercise Name from .md]
**Status:** PASS / FAIL
**Solution:** `sql_assignment_01/solution.sql`

[Your feedback here. Be specific about what was correct or incorrect. If PASS, note what the student did well. If FAIL, explain what went wrong and what the correct approach should be. Write feedback like a college professor grading a take-home exam — constructive, specific, and encouraging but honest.]

---

### Assignment 02 — [Exercise Name from .md]
**Status:** PASS / FAIL
**Solution:** `sql_assignment_02/solution.sql`

[Feedback...]

---

... (repeat for each assignment with a solution.sql) ...

## Assignments Without Solutions

The following assignments did not have a `solution.sql` file and were not graded:
- Assignment XX — [Exercise Name]
- ...

---

*Graded by [YOUR MODEL NAME]*
```

## Grading Tone

Write feedback like a college professor grading a take-home exam:
- **Be specific.** Don't say "good job" or "incorrect." Say exactly what was right or wrong.
- **Be constructive.** If the answer is wrong, explain the concept and what the student should review.
- **Be encouraging but honest.** A student who tried and made a common mistake deserves a different note than one who gave up.
- **Use concrete examples.** If a JOIN condition is wrong, show the correct one. If an aggregate is missing, explain why it matters.
- **Keep it concise.** Be thorough but don't ramble. 3-5 sentences per assignment is usually right.

## Steps

1. List all `sql_assignment_XX/` directories
2. For each directory:
   a. Find the `.md` instruction file and read it
   b. Check if `solution.sql` exists
   c. If it exists, read it and evaluate against the prompt
   d. Record PASS/FAIL and write feedback
3. Compile all results into `grading_report.md`
4. Sign the report with your model name at the bottom

## Verification

Before finalizing the report:
- Ensure every assignment with a `solution.sql` file has an entry in the detailed feedback
- Ensure the summary table counts match the detailed entries
- Ensure no assignment is listed as both "graded" and "without solution"
