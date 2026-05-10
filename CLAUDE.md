# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build and Run

This project uses VS Code's built-in Java support (no Maven/Gradle). Compile and run from the repo root:

```bash
javac -d bin src/App.java   # compile
java -cp bin App            # run
```

There is no test framework. The `main()` method in `App` serves as the manual test harness — add print statements and run to verify behavior.

## Architecture

All code lives in a single file: `src/App.java`. Each learning exercise replaces the previous content of this file rather than adding new files. The commit history is the record of completed exercises.

The typical class structure for each exercise:
- **Domain class(es)** (e.g. `Task`, `BankAccount`) — private fields, getters/setters, a `printInfo()` method for display
- **Manager/System class** (e.g. `TaskManager`) — holds an `ArrayList` of domain objects, provides operations (add, search, filter, file I/O)
- **Custom exception** (e.g. `InvalidPriorityException extends Exception`) — checked exception for invalid input at construction or mutation
- **`App`** — `public class` with `main()` that wires everything together and exercises all features

## Conventions

- Multiple non-public top-level classes are defined in the same file (Java allows this as long as only `App` is `public`)
- File I/O always uses `try-with-resources` (`BufferedReader`/`BufferedWriter`)
- Data saved to `.txt` files uses comma-separated values; field order matches the class fields
- Display formatting uses `System.out.printf` with `%-10s` left-aligned padding
- Runtime-generated data files (`tasks.txt`, `accounts.txt`, etc.) are not committed — they appear in the working directory after a run
