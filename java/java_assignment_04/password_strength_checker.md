# Password Strength Checker

## Objective

Practice iterating through a string, tracking multiple independent boolean conditions, and combining several pass/fail checks into an overall evaluation.

## Instructions

- Write a method that accepts a single parameter: a password `String`.
- Evaluate the password against the following four rules:
  - At least 8 characters long
  - Contains at least one digit (`0`–`9`)
  - Contains at least one uppercase letter
  - Contains at least one special character (use the set `!@#$%^&*`)
- Your method should report which of the four rules passed and which failed, clearly identifying the result of each rule individually — not just a single overall pass/fail.
- Based on how many of the four rules passed, assign an overall strength label using the following scale:
  - **4 rules passed** → Strong
  - **2–3 rules passed** → Medium
  - **0–1 rules passed** → Weak
- Your method should handle an empty string, or a `null` input, without crashing. Decide what strength label and per-rule results make sense to report in that case.
- How you check each rule (manually iterating character by character, or using built-in `String`/`Character` methods) is left up to you — there is no required approach, but be prepared to explain the trade-offs of whichever approach you choose.

## Example Interactions

**Example 1 — Fails all rules but length**
```
Input: "password"
Output: "Length: Pass | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak"
```

**Example 2 — Passes three of four rules**
```
Input: "Password1"
Output: "Length: Pass | Digit: Pass | Uppercase: Pass | Special Character: Fail -- Strength: Medium"
```

**Example 3 — Passes all four rules**
```
Input: "P@ssw0rd"
Output: "Length: Pass | Digit: Pass | Uppercase: Pass | Special Character: Pass -- Strength: Strong"
```

**Example 4 — Empty input**
```
Input: ""
Output: "Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak"
```

## Requirements Checklist

- [ ] Method accepts the password as a parameter (not hardcoded)
- [ ] Length rule (8+ characters) is evaluated correctly
- [ ] Digit rule is evaluated correctly
- [ ] Uppercase letter rule is evaluated correctly
- [ ] Special character rule (`!@#$%^&*`) is evaluated correctly
- [ ] Each rule's pass/fail result is reported individually, not just an overall result
- [ ] Overall strength label is correctly assigned based on the number of rules passed (4 = Strong, 2-3 = Medium, 0-1 = Weak)
- [ ] Empty string input is handled without crashing
- [ ] `null` input is handled without crashing
- [ ] Code is organized into at least one clearly named method (avoid putting all logic directly in `main`)

## Stretch Goals

Each stretch goal should be implemented as its own separate method — do not modify your original method to accommodate these. Your original solution should remain intact and callable on its own.

- **Custom Rule Weighting** — Instead of counting rules equally, assign each rule a point value (for example: length = 1 point, digit = 1 point, uppercase = 1 point, special character = 2 points), and calculate strength based on total points earned out of the total possible points, rather than a simple count of rules passed. You'll need to decide new cutoffs for Weak/Medium/Strong based on this point system.
- **Common Password Blacklist Check** — Given a small, hardcoded list of common weak passwords (e.g., "password", "123456", "qwerty"), check the input against this list first. If it matches an entry in the list (case-insensitive), the password should automatically be reported as Weak, regardless of how many of the four rules it would have otherwise passed. Note: your solution should provide the list of common weak passwords, and the list should consist of at least 5 values.
