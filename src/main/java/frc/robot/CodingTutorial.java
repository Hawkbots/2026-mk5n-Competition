package frc.robot;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CODING TUTORIAL - Standalone walkthrough for new programmers.
 *
 * RECOMMENDED ORDER:
 *   1. Variables & Assignment  → milestone1_variablesAndAssignment()
 *   2. Arithmetic & Strings    → milestone2_arithmeticAndStrings()
 *   3. Booleans & Conditionals → milestone3_booleansAndConditionals()
 *   4. Loops                   → milestone4_loops()
 *   5. Methods / Functions     → milestone5_methods()
 *   6. ArrayList               → milestone6_arrayList()
 *   7. HashMap                 → milestone7_hashMap()
 *
 * HOW TO USE:
 *   - Run this file's main() in the debugger.
 *   - Set a breakpoint at the first line of main() and step through line by line.
 *   - Watch the Variables panel to see values change in real time.
 */
public class CodingTutorial {

    public static void main(String[] args) {
        milestone1_variablesAndAssignment();
        milestone2_arithmeticAndStrings();
        milestone3_booleansAndConditionals();
        milestone4_loops();
        milestone5_methods();
        milestone6_arrayList();
        milestone7_hashMap();
    }


    // ------------------------------------------------------------------ //
    // MILESTONE 1: Variables & Assignment
    //   A variable is a named box that holds a value.
    //   The type (int, double, boolean, String) describes what fits in the box.
    // ------------------------------------------------------------------ //
    static void milestone1_variablesAndAssignment() {
        int teamNumber = 5;           // whole number (integer)
        double targetRPM = 3000.5;    // decimal number
        boolean isAutonomous = true;  // true or false only
        String robotName = "Hawkbot"; // text (always in double quotes)

        // Re-assignment: the box gets a new value, the old one is gone.
        teamNumber = 5000;
        targetRPM = 3500.0;

        System.out.println("Team: " + teamNumber);
        System.out.println("Target RPM: " + targetRPM);
        System.out.println("Robot name: " + robotName);
    }


    // ------------------------------------------------------------------ //
    // MILESTONE 2: Arithmetic & String Concatenation
    //   Java follows standard math order of operations.
    //   The + operator joins Strings together ("concatenation").
    // ------------------------------------------------------------------ //
    static void milestone2_arithmeticAndStrings() {
        String robotName = "Hawkbot";
        double targetRPM = 3500.0;

        int scored = 10;
        int penalties = 2;
        int finalScore = scored - penalties;        // subtraction
        double halfSpeed = targetRPM / 2;           // division
        int squared = scored * scored;              // multiplication
        int remainder = scored % 3;                 // modulo: leftover after dividing by 3

        System.out.println("Final score: " + finalScore);
        System.out.println("Half speed: " + halfSpeed);
        System.out.println("10 squared: " + squared);
        System.out.println("10 mod 3: " + remainder);  // expected: 1

        // String concatenation builds a sentence from parts.
        String announcement = robotName + " scored " + finalScore + " points!";
        System.out.println(announcement);
    }


    // ------------------------------------------------------------------ //
    // MILESTONE 3: Booleans & Conditionals (if / else if / else)
    //   A boolean is the result of a comparison: true or false.
    //   Conditionals let the program choose different paths.
    // ------------------------------------------------------------------ //
    static void milestone3_booleansAndConditionals() {
        double targetRPM = 3500.0;

        int ballsLoaded = 3;
        boolean readyToShoot = ballsLoaded > 0;   // comparison produces a boolean
        boolean atTargetRPM = targetRPM >= 3000.0;

        System.out.println("Ready to shoot: " + readyToShoot);

        if (readyToShoot && atTargetRPM) {
            // && means "AND" — both conditions must be true
            System.out.println("Firing!");
        } else if (readyToShoot) {
            // reaches here only when readyToShoot is true but atTargetRPM is false
            System.out.println("Balls loaded but RPM too low, spinning up...");
        } else {
            // reaches here when readyToShoot is false
            System.out.println("No balls loaded.");
        }

        // || means "OR" — at least one condition must be true
        boolean emergencyStop = false;
        boolean disabled = false;
        if (emergencyStop || disabled) {
            System.out.println("Robot halted.");
        } else {
            System.out.println("Robot running normally.");
        }
    }


    // ------------------------------------------------------------------ //
    // MILESTONE 4: Loops
    //   A loop repeats a block of code.
    //   for-loop: ideal when you know how many repetitions ahead of time.
    //   while-loop: ideal when you repeat until a condition changes.
    // ------------------------------------------------------------------ //
    static void milestone4_loops() {
        // for-loop: counts from 5 down to 1 (inclusive)
        System.out.println("Countdown to launch:");
        for (int i = 5; i >= 1; i--) {
            System.out.println("  " + i);
        }
        System.out.println("  Launch!");

        // while-loop: charge up until RPM reaches target
        double currentRPM = 0.0;
        int chargeSteps = 0;
        while (currentRPM < 3000.0) {
            currentRPM += 500.0;  // += is shorthand for: currentRPM = currentRPM + 500.0
            chargeSteps++;         // ++ adds 1; same as chargeSteps = chargeSteps + 1
        }
        System.out.println("Reached " + currentRPM + " RPM in " + chargeSteps + " steps.");
    }


    // ------------------------------------------------------------------ //
    // MILESTONE 5: Methods (Functions)
    //   A method is a named, reusable block of code.
    //   You define it once (see helpers below), then call it by name.
    //   Methods can take inputs (parameters) and return an output.
    // ------------------------------------------------------------------ //
    static void milestone5_methods() {
        int scored = 10;
        int penalties = 2;

        int total = add(scored, penalties);          // calling a method with two arguments
        System.out.println("add(10, 2) = " + total);

        double speed = clamp(1.5, 0.0, 1.0);        // clamp: keep a value within a range
        System.out.println("clamp(1.5, 0, 1) = " + speed);  // expected: 1.0

        printSeparator();                            // method with no parameters or return value
    }


    // ------------------------------------------------------------------ //
    // MILESTONE 6: ArrayList (Dynamic List)
    //   An ArrayList stores an ordered collection of items.
    //   Unlike a plain array, it can grow and shrink at runtime.
    // ------------------------------------------------------------------ //
    static void milestone6_arrayList() {
        ArrayList<String> targets = new ArrayList<>(); // empty list of Strings

        // add() appends an item to the end of the list
        targets.add("Speaker");
        targets.add("Amp");
        targets.add("Trap");

        System.out.println("Targets: " + targets);
        System.out.println("Count: " + targets.size());         // .size() = number of items
        System.out.println("First target: " + targets.get(0)); // .get(index) — index starts at 0!

        // Loop over every item in the list with a "for-each" loop
        System.out.println("All targets:");
        for (String target : targets) {
            System.out.println("  -> " + target);
        }

        // remove() deletes an item by value
        targets.remove("Amp");
        System.out.println("After removing Amp: " + targets);

        // contains() checks whether an item is in the list
        boolean hasTrap = targets.contains("Trap");
        System.out.println("Has Trap: " + hasTrap);

        // ArrayList of integers works the same way
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            scores.add(i * 10);  // adds 10, 20, 30, 40, 50
        }
        System.out.println("Scores: " + scores);

        printSeparator();
    }


    // ------------------------------------------------------------------ //
    // MILESTONE 7: HashMap (Key-Value Lookup Table)
    //   A HashMap stores pairs of keys and values — like a dictionary.
    //   You look up a value by its key instead of by a numbered index.
    //   Keys must be unique; values do not have to be.
    // ------------------------------------------------------------------ //
    static void milestone7_hashMap() {
        HashMap<String, Integer> scoringZones = new HashMap<>(); // key=String, value=Integer

        // put(key, value) adds or updates an entry
        scoringZones.put("Speaker", 2);
        scoringZones.put("Amp",     1);
        scoringZones.put("Trap",    5);

        System.out.println("Scoring zones: " + scoringZones);
        System.out.println("Size: " + scoringZones.size());

        // get(key) retrieves the value for that key
        int trapPoints = scoringZones.get("Trap");
        System.out.println("Trap is worth: " + trapPoints + " points");

        // containsKey() checks whether a key exists before using it
        if (scoringZones.containsKey("Speaker")) {
            System.out.println("Speaker entry found: " + scoringZones.get("Speaker") + " pts");
        }

        // put() on an existing key replaces the old value
        scoringZones.put("Amp", 2);  // rule change: Amp now worth 2
        System.out.println("Updated Amp value: " + scoringZones.get("Amp"));

        // remove(key) deletes the entry entirely
        scoringZones.remove("Trap");
        System.out.println("After removing Trap: " + scoringZones);

        // Loop over all entries with a for-each on entrySet()
        System.out.println("All scoring zones:");
        for (HashMap.Entry<String, Integer> entry : scoringZones.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue() + " pts");
        }

        // HashMap with different types: String keys, String values
        HashMap<String, String> subsystemStatus = new HashMap<>();
        subsystemStatus.put("Shooter", "Ready");
        subsystemStatus.put("Intake",  "Disabled");
        subsystemStatus.put("Drive",   "Ready");
        System.out.println("Subsystem status: " + subsystemStatus);

        printSeparator();
        System.out.println("Tutorial complete!");
    }


    // ------------------------------------------------------------------ //
    // HELPER METHODS  (defined outside main, but inside the class)
    // ------------------------------------------------------------------ //

    // Returns the sum of two integers.
    // 'static' means we can call it without creating an object first.
    static int add(int a, int b) {
        int result = a + b;
        return result;  // 'return' sends the value back to wherever the method was called
    }

    // Returns value clamped between min and max.
    // Step through this to see how nested if/else works inside a method.
    static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }

    // Prints a visual divider line. No parameters, no return value (void).
    static void printSeparator() {
        System.out.println("------------------------------------------");
    }
}
