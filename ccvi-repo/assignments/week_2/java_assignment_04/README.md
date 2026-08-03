# Software Engineering Project: Password Strength Evaluator

## Objective

The objective of this project is to design and implement a robust password strength evaluation algorithm. This exercise requires parsing character sequences, maintaining state across multiple independent boolean conditions, and synthesizing these discrete validation checks into a comprehensive security classification.

## System Prerequisites
- **Java Development Kit (JDK):** Version 21 or higher is explicitly required to execute this application and leverage modern Java features.

## Implementation Instructions

- Develop a primary subroutine that accepts a single parameter: a password `String`.
- Evaluate the provided character sequence against the following four cryptographic criteria:
  - **Length:** Contains a minimum of 8 characters.
  - **Numeric:** Contains at least one digit (`0`–`9`).
  - **Uppercase:** Contains at least one uppercase alphabetical character.
  - **Special Character:** Contains at least one non-alphanumeric symbol from the following authorized set: `!@#$%^&*`.
- The system must output a detailed diagnostic report identifying the discrete pass/fail status of each individual rule, rather than solely providing a binary overall validation.
- Based on the aggregate number of validation rules passed, assign an overarching security classification using the following matrix:
  - **4 rules passed** → Strong
  - **2–3 rules passed** → Medium
  - **0–1 rules passed** → Weak
- **Exception Handling:** The method must elegantly handle edge cases, including empty strings and `null` object references, without throwing runtime exceptions or crashing. The developer must determine and document the most logically sound security classification and rule outputs for these scenarios.
- **Architectural Freedom:** The specific mechanism for validation (e.g., manual character iteration vs. utilizing standard `String` or `Character` APIs) is left to the developer's discretion. However, developers must be prepared to defend the computational and algorithmic trade-offs of their chosen approach.

## Example Execution Logs

**Execution 1 — Fails all rules except Length**
```text
Input: "password"
Output: "Length: Pass | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak"
```

**Execution 2 — Passes three of four rules**
```text
Input: "Password1"
Output: "Length: Pass | Digit: Pass | Uppercase: Pass | Special Character: Fail -- Strength: Medium"
```

**Execution 3 — Passes all criteria**
```text
Input: "P@ssw0rd"
Output: "Length: Pass | Digit: Pass | Uppercase: Pass | Special Character: Pass -- Strength: Strong"
```

**Execution 4 — Empty Input Handling**
```text
Input: ""
Output: "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak"
```
