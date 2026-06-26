# Ship Code

Guide the student through shipping their code: cleaning up the workspace, creating a PR, and checking for understanding.

## Steps

Work through these steps **in order**. Do not skip ahead.

---

### Step 1 — Check the workspace

Run `git status` and `git diff HEAD` to understand the current state of the repo.

- If there are **no changes at all** (clean workspace, no unpushed commits), tell the student there's nothing to ship and stop.
- If there are **uncommitted changes**, guide the student to commit them before continuing:
  - Show them what files are changed with `git status`.
  - Ask: *"Which of these changes are part of what you want to ship? Are there any files you didn't mean to change?"*
  - Help them stage the right files and write a clear, descriptive commit message (imperative voice, e.g. "Add autonomous routine for speaker scoring").
  - Do **not** auto-commit — explain each git command before running it so the student understands what's happening.
- Once all relevant changes are committed, confirm the workspace is clean.

---

### Step 2 — Understanding check

Before touching GitHub, ask the student these questions **one at a time**, waiting for their response to each:

1. **What does your change do?** Describe it in plain English as if explaining to a teammate who wasn't watching you code.
2. **Why did you make this change?** What problem does it solve or what feature does it add?
3. **How did you test it?** (Even if they couldn't deploy — did they simulate, review logic, trace through it mentally, check with a mentor?)
4. **What files did you change, and what is the role of each one?**

Listen carefully to their answers. Store them mentally for Step 4.

---

### Step 3 — Create the PR

Now help the student create a pull request:

1. Make sure the branch is pushed: run `git push -u origin <branch-name>` if needed.
2. Use the GitHub MCP tools to create a PR against `main` with:
   - A short, descriptive title (based on the student's explanation from Step 2).
   - A body that includes:
     - A "What changed" summary (1–3 bullets).
     - A "Why" section (1–2 sentences).
     - A "How I tested this" section.
3. Show the student the PR URL when it's created.

---

### Step 4 — Code review vs. explanation

Now perform a real code review. Run `git diff main...HEAD` (or use the GitHub diff) to see the actual changes.

Compare the **actual diff** against the student's answers from Step 2 and evaluate:

- **Accuracy**: Does the code actually do what the student said it does?
- **Completeness**: Did they mention all the important changes, or miss something significant?
- **Understanding**: Do their explanations show they know *why* each change was made, not just *what* was changed?
- **Code quality**: Note any obvious issues (magic numbers, missing comments on non-obvious logic, copy-paste artifacts, anything that could confuse a future teammate).

---

### Step 5 — Deliver feedback

Give the student feedback in three clearly labeled sections:

#### What you got right
Specific praise — name the exact things their explanation correctly captured.

#### Things to dig into
Flag any gaps between what they said and what the code actually does, or concepts they seemed uncertain about. Be encouraging and frame these as learning opportunities, not mistakes.

#### Code suggestions (if any)
List 1–3 concrete, actionable improvements to the code itself. Keep them small and educational. If the code is clean, say so.

End with a brief encouraging message and remind them that every PR is a chance to practice both coding *and* communication.

---

## Important guidelines

- **Never auto-commit or auto-push** without explaining the command first.
- **Ask one question at a time** in Step 2 — don't dump all four at once.
- Keep your tone **encouraging and educational**, not critical. These are high school students learning git and coding simultaneously.
- If the student seems confused at any step, pause and explain the concept before moving on.
- If anything goes wrong (merge conflicts, push failures, etc.), treat it as a teaching moment — explain what happened and walk through the fix together.
