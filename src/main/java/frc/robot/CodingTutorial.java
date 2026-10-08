package frc.robot;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CODING TUTORIAL - Standalone walkthrough for brand-new programmers.
 *
 * Each lesson introduces ONE new idea and only uses ideas from earlier lessons.
 * Do them in order. Each lesson ends with a "TRY IT" exercise - do it before moving on!
 *
 * PART A - The basics
 *    1. Printing & comments
 *    2. Your first variable (int)
 *    3. Other types (double, boolean, String)
 *    4. Changing a variable (re-assignment)
 *
 * PART B - Doing math and building text
 *    5. Arithmetic (+ - * /)
 *    6. Integer division & remainder (%)
 *    7. Joining text together (concatenation)
 *    8. Shortcuts (+=, ++, --)
 *
 * PART C - Making decisions
 *    9. Comparisons produce booleans
 *   10. Combining booleans (&&, ||, !)
 *   11. if
 *   12. if / else
 *   13. if / else if / else
 *
 * PART D - Repeating things
 *   14. while loop
 *   15. for loop
 *
 * PART E - Methods (named, reusable blocks of code)
 *   16. A method with no inputs
 *   17. A method with inputs (parameters)
 *   18. A method that gives back an answer (return)
 *
 * PART F - Lists
 *   19. ArrayList: create, add, size, get
 *   20. ArrayList: set, remove, contains
 *   21. Looping over an ArrayList
 *
 * PART G - Lookup tables
 *   22. HashMap: put, get, size
 *   23. HashMap: update, containsKey, remove
 *   24. Looping over a HashMap
 *
 * HOW TO USE:
 *   - Run this file's main() in the debugger.
 *   - Set a breakpoint at the first line of main() and use "Step Into" to enter each lesson.
 *   - Inside a lesson, use "Step Over" to run one line at a time.
 *   - Watch the Variables panel to see values change in real time.
 *   - Comment out lessons in main() you have already finished so you can skip straight ahead.
 */
public class CodingTutorial {

    // main() is where the program starts. Each line below runs one lesson, top to bottom.
    // (You will learn exactly how this works in Lesson 16. For now, just follow along.)
    public static void main(String[] args) {
        lesson01_printingAndComments();
        lesson02_firstVariable();
        lesson03_otherTypes();
        lesson04_reassignment();

        lesson05_arithmetic();
        lesson06_integerDivisionAndRemainder();
        lesson07_concatenation();
        lesson08_shortcuts();

        lesson09_comparisons();
        lesson10_combiningBooleans();
        lesson11_if();
        lesson12_ifElse();
        lesson13_elseIf();

        lesson14_whileLoop();
        lesson15_forLoop();

        lesson16_methodNoInputs();
        lesson17_methodWithParameters();
        lesson18_methodWithReturn();

        lesson19_arrayListBasics();
        lesson20_arrayListChanges();
        lesson21_arrayListLoops();

        lesson22_hashMapBasics();
        lesson23_hashMapChanges();
        lesson24_hashMapLoops();

        System.out.println("Tutorial complete!");
    }


    // ================================================================== //
    // PART A - THE BASICS
    // ================================================================== //

    // ------------------------------------------------------------------ //
    // LESSON 1: Printing & Comments
    //   - System.out.println(...) prints a line of text to the console.
    //   - Text goes inside double quotes: "like this"
    //   - Every instruction (a "statement") ends with a semicolon ;
    //   - Anything after // is a COMMENT. Java ignores it; it's a note for humans.
    //
    //   TRY IT: Add a line that prints your own name.
    // ------------------------------------------------------------------ //
    static void lesson01_printingAndComments() {
        System.out.println("Hello, robot!");
        System.out.println("Statements run one at a time, top to bottom.");
        // System.out.println("This line is commented out, so it never runs.");
    }


    // ------------------------------------------------------------------ //
    // LESSON 2: Your First Variable
    //   A variable is a named box that holds a value.
    //
    //       int  teamNumber  =  5000;
    //       ^^^  ^^^^^^^^^^  ^  ^^^^
    //       type    name     |  value
    //                        "put this value into the box"
    //
    //   - "int" means the box holds a whole number (an integer).
    //   - To print a variable, use its name WITHOUT quotes.
    //
    //   TRY IT: Make a variable called "year" holding 2026 and print it.
    // ------------------------------------------------------------------ //
    static void lesson02_firstVariable() {
        int teamNumber = 5000;

        System.out.println(teamNumber);    // prints the VALUE in the box: 5000
        System.out.println("teamNumber");  // with quotes, it's just text: teamNumber
    }


    // ------------------------------------------------------------------ //
    // LESSON 3: Other Types
    //   The type describes what kind of value fits in the box.
    //     int     - whole numbers:   5, -12, 3000
    //     double  - decimal numbers: 3.14, 0.5, 3000.0
    //     boolean - only true or false
    //     String  - text, in double quotes (note the capital S!)
    //
    //   TRY IT: Make a double called "batteryVoltage" holding 12.6 and print it.
    // ------------------------------------------------------------------ //
    static void lesson03_otherTypes() {
        int ballsLoaded = 3;
        double targetRPM = 3000.5;
        boolean isAutonomous = true;
        String robotName = "Hawkbot";

        System.out.println(ballsLoaded);
        System.out.println(targetRPM);
        System.out.println(isAutonomous);
        System.out.println(robotName);
    }


    // ------------------------------------------------------------------ //
    // LESSON 4: Changing a Variable (Re-assignment)
    //   You can put a new value in an existing box. The old value is gone.
    //   Only write the type the FIRST time (when you create the variable).
    //
    //   TRY IT: Change robotName to a different name and print it again.
    // ------------------------------------------------------------------ //
    static void lesson04_reassignment() {
        int ballsLoaded = 3;
        System.out.println(ballsLoaded);  // 3

        ballsLoaded = 1;                  // no "int" here - the box already exists
        System.out.println(ballsLoaded);  // 1

        String robotName = "Hawkbot";
        System.out.println(robotName);
    }


    // ================================================================== //
    // PART B - DOING MATH AND BUILDING TEXT
    // ================================================================== //

    // ------------------------------------------------------------------ //
    // LESSON 5: Arithmetic
    //   +  add      -  subtract      *  multiply      /  divide
    //   Java follows normal math order: * and / happen before + and -.
    //   Use parentheses ( ) to control the order, just like in math class.
    //
    //   TRY IT: Compute the average of 3 match scores: 40, 55, 61.
    // ------------------------------------------------------------------ //
    static void lesson05_arithmetic() {
        int scored = 10;
        int penalties = 2;

        int finalScore = scored - penalties;
        System.out.println(finalScore);   // 8

        int doubled = scored * 2;
        System.out.println(doubled);      // 20

        double targetRPM = 3500.0;
        double halfSpeed = targetRPM / 2;
        System.out.println(halfSpeed);    // 1750.0

        int noParens = 2 + 3 * 4;         // multiply first: 2 + 12
        int withParens = (2 + 3) * 4;     // parentheses first: 5 * 4
        System.out.println(noParens);     // 14
        System.out.println(withParens);   // 20
    }


    // ------------------------------------------------------------------ //
    // LESSON 6: Integer Division & Remainder
    //   GOTCHA: when you divide an int by an int, Java throws away the decimal part.
    //       7 / 2   gives 3    (not 3.5!)
    //       7.0 / 2 gives 3.5  (a double is involved, so the decimal is kept)
    //
    //   %  ("modulo") gives the REMAINDER left over after dividing.
    //       7 % 2   gives 1    (7 = 2*3 + 1)
    //
    //   TRY IT: What is 17 / 5? What is 17 % 5? Guess first, then add lines to check.
    // ------------------------------------------------------------------ //
    static void lesson06_integerDivisionAndRemainder() {
        int intResult = 7 / 2;
        System.out.println(intResult);       // 3

        double doubleResult = 7.0 / 2;
        System.out.println(doubleResult);    // 3.5

        int remainder = 7 % 2;
        System.out.println(remainder);       // 1
    }


    // ------------------------------------------------------------------ //
    // LESSON 7: Joining Text Together (Concatenation)
    //   When + has a String on either side, it GLUES text together instead of adding.
    //   Numbers and booleans get turned into text automatically.
    //   Remember to include spaces inside the quotes!
    //
    //   TRY IT: Print "Hawkbot has 3 balls" using the two variables below.
    // ------------------------------------------------------------------ //
    static void lesson07_concatenation() {
        String robotName = "Hawkbot";
        int ballsLoaded = 3;

        String greeting = "Hello, " + robotName;
        System.out.println(greeting);                       // Hello, Hawkbot

        System.out.println("Balls loaded: " + ballsLoaded); // Balls loaded: 3

        System.out.println("No" + "space");                 // Nospace  (oops!)

        // GOTCHA: once Java sees a String, the rest of the +'s become gluing.
        System.out.println("Sum: " + 2 + 3);                // Sum: 23
        System.out.println("Sum: " + (2 + 3));              // Sum: 5   (parentheses do math first)
    }


    // ------------------------------------------------------------------ //
    // LESSON 8: Shortcuts
    //   Programmers update variables so often that Java has shortcuts:
    //     x += 5;   is the same as   x = x + 5;
    //     x -= 5;   is the same as   x = x - 5;
    //     x++;      is the same as   x = x + 1;
    //     x--;      is the same as   x = x - 1;
    //   You'll see these constantly in loops (Part D).
    //
    //   TRY IT: Start a variable at 100, subtract 30 with -=, then print it.
    // ------------------------------------------------------------------ //
    static void lesson08_shortcuts() {
        int score = 0;

        score = score + 5;                       // the long way
        System.out.println("Score: " + score);   // 5

        score += 5;                              // the shortcut
        System.out.println("Score: " + score);   // 10

        score++;
        System.out.println("Score: " + score);   // 11

        score--;
        System.out.println("Score: " + score);   // 10
    }


    // ================================================================== //
    // PART C - MAKING DECISIONS
    // ================================================================== //

    // ------------------------------------------------------------------ //
    // LESSON 9: Comparisons Produce Booleans
    //   A comparison asks a yes/no question. The answer is a boolean.
    //     >   greater than            <   less than
    //     >=  greater than or equal   <=  less than or equal
    //     ==  equal to                !=  not equal to
    //
    //   GOTCHA:  =  means "put a value in a box"
    //           ==  means "are these equal?"
    //
    //   TRY IT: Make a boolean that is true when batteryVoltage is below 11.5.
    // ------------------------------------------------------------------ //
    static void lesson09_comparisons() {
        int ballsLoaded = 3;

        boolean hasBalls = ballsLoaded > 0;
        System.out.println("Has balls: " + hasBalls);      // true

        boolean isFull = ballsLoaded == 5;
        System.out.println("Is full: " + isFull);          // false

        boolean notEmpty = ballsLoaded != 0;
        System.out.println("Not empty: " + notEmpty);      // true
    }


    // ------------------------------------------------------------------ //
    // LESSON 10: Combining Booleans
    //   &&  AND - true only if BOTH sides are true
    //   ||  OR  - true if AT LEAST ONE side is true
    //   !   NOT - flips true to false, and false to true
    //
    //   TRY IT: Change the values of hasBalls and atTargetRPM and predict each result.
    // ------------------------------------------------------------------ //
    static void lesson10_combiningBooleans() {
        boolean hasBalls = true;
        boolean atTargetRPM = false;

        boolean canShoot = hasBalls && atTargetRPM;
        System.out.println("Can shoot: " + canShoot);          // false (RPM not ready)

        boolean doingSomething = hasBalls || atTargetRPM;
        System.out.println("Doing something: " + doingSomething); // true (one is enough)

        boolean needsToSpinUp = !atTargetRPM;
        System.out.println("Needs to spin up: " + needsToSpinUp); // true
    }


    // ------------------------------------------------------------------ //
    // LESSON 11: if
    //   An if statement runs a block of code ONLY when its condition is true.
    //   The block is everything between the curly braces { }.
    //
    //       if (condition) {
    //           // runs only when condition is true
    //       }
    //
    //   TRY IT: Change ballsLoaded to 0. Step through and watch the print get skipped.
    // ------------------------------------------------------------------ //
    static void lesson11_if() {
        int ballsLoaded = 3;

        if (ballsLoaded > 0) {
            System.out.println("We have balls to shoot!");
        }

        System.out.println("This line always runs.");
    }


    // ------------------------------------------------------------------ //
    // LESSON 12: if / else
    //   else gives a second path that runs when the condition is FALSE.
    //   Exactly one of the two blocks will run - never both, never neither.
    //
    //   TRY IT: Set isEnabled to false and step through again.
    // ------------------------------------------------------------------ //
    static void lesson12_ifElse() {
        boolean isEnabled = true;

        if (isEnabled) {
            System.out.println("Robot running.");
        } else {
            System.out.println("Robot disabled.");
        }
    }


    // ------------------------------------------------------------------ //
    // LESSON 13: if / else if / else
    //   Checks conditions in order, top to bottom.
    //   The FIRST one that is true wins; the rest are skipped.
    //   The final else catches everything that didn't match.
    //
    //   TRY IT: Find values for the two variables that reach each of the 3 messages.
    // ------------------------------------------------------------------ //
    static void lesson13_elseIf() {
        int ballsLoaded = 3;
        double currentRPM = 2500.0;

        if (ballsLoaded > 0 && currentRPM >= 3000.0) {
            System.out.println("Firing!");
        } else if (ballsLoaded > 0) {
            // only reached when the first condition was false
            System.out.println("Balls loaded but RPM too low, spinning up...");
        } else {
            System.out.println("No balls loaded.");
        }
    }


    // ================================================================== //
    // PART D - REPEATING THINGS
    // ================================================================== //

    // ------------------------------------------------------------------ //
    // LESSON 14: while Loop
    //   A while loop is like an if that keeps repeating:
    //   it checks the condition, runs the block, then checks again...
    //   until the condition becomes false.
    //
    //       while (condition) {
    //           // repeats while condition is true
    //       }
    //
    //   GOTCHA: if nothing inside the loop ever makes the condition false,
    //           it loops forever!
    //
    //   TRY IT: Change the step size from 500.0 to 700.0. How many steps now? Why is
    //           the final RPM above 3000?
    // ------------------------------------------------------------------ //
    static void lesson14_whileLoop() {
        double currentRPM = 0.0;
        int steps = 0;

        while (currentRPM < 3000.0) {
            currentRPM += 500.0;
            steps++;
            System.out.println("  Spinning up: " + currentRPM);
        }

        System.out.println("Reached " + currentRPM + " RPM in " + steps + " steps.");
    }


    // ------------------------------------------------------------------ //
    // LESSON 15: for Loop
    //   A for loop is a while loop with the counter built in.
    //   It's ideal when you know how many times to repeat.
    //
    //       for (int i = 1;   i <= 5;    i++) {
    //            ^^^^^^^^^    ^^^^^^     ^^^
    //            1. start     2. keep    3. after each
    //            (runs once)  going if   pass, do this
    //                         true
    //
    //   TRY IT: Write a for loop that prints 0, 10, 20, 30, 40, 50.
    // ------------------------------------------------------------------ //
    static void lesson15_forLoop() {
        // Counting up
        for (int i = 1; i <= 5; i++) {
            System.out.println("  Pass number " + i);
        }

        // The same thing written as a while loop, for comparison:
        int j = 1;
        while (j <= 5) {
            System.out.println("  Pass number " + j);
            j++;
        }

        // Counting down
        System.out.println("Countdown to launch:");
        for (int i = 5; i >= 1; i--) {
            System.out.println("  " + i);
        }
        System.out.println("  Launch!");
    }


    // ================================================================== //
    // PART E - METHODS
    //   A method is a named block of code. You DEFINE it once, then CALL it
    //   by name as many times as you want. Every lessonXX above is a method,
    //   and main() calls them!
    //
    //   For now, write "static" in front of every method. (It means the method
    //   belongs to the class itself - you'll learn more when we cover objects.)
    // ================================================================== //

    // ------------------------------------------------------------------ //
    // LESSON 16: A Method With No Inputs
    //
    //       static void printSeparator() { ... }
    //              ^^^^ ^^^^^^^^^^^^^^ ^^
    //              |    name           no inputs
    //              "void" = gives nothing back
    //
    //   Calling it:  printSeparator();
    //
    //   TRY IT: Write a method printTeamBanner() that prints your team name,
    //           and call it below.
    // ------------------------------------------------------------------ //
    static void lesson16_methodNoInputs() {
        printSeparator();   // use "Step Into" here to jump inside the method!
        System.out.println("Between the separators");
        printSeparator();   // same code, reused - no copy/paste needed
    }

    static void printSeparator() {
        System.out.println("------------------------------------------");
    }


    // ------------------------------------------------------------------ //
    // LESSON 17: A Method With Inputs (Parameters)
    //   Parameters are variables listed in the parentheses.
    //   When you call the method, the values you pass in ("arguments")
    //   get copied into those parameter variables.
    //
    //       static void printScore(String team, int points) { ... }
    //
    //       printScore("Hawkbots", 42);   // team = "Hawkbots", points = 42
    //
    //   TRY IT: Add a third call to printScore with your own team and score.
    // ------------------------------------------------------------------ //
    static void lesson17_methodWithParameters() {
        printScore("Hawkbots", 42);
        printScore("Rivals", 38);
    }

    static void printScore(String team, int points) {
        System.out.println(team + " scored " + points + " points");
    }


    // ------------------------------------------------------------------ //
    // LESSON 18: A Method That Gives Back an Answer (return)
    //   Replace "void" with a type to say what kind of answer comes back.
    //   "return" sends that answer back to the line that called the method,
    //   and the method stops right there.
    //
    //       static int add(int a, int b) { return a + b; }
    //              ^^^
    //              gives back an int
    //
    //       int total = add(10, 2);   // total = 12
    //
    //   TRY IT: Write a method "isLowBattery(double volts)" that returns a boolean.
    // ------------------------------------------------------------------ //
    static void lesson18_methodWithReturn() {
        int total = add(10, 2);
        System.out.println("add(10, 2) = " + total);           // 12

        double speed = clamp(1.5, 0.0, 1.0);
        System.out.println("clamp(1.5, 0, 1) = " + speed);     // 1.0

        // You can use a returned value directly, without a variable:
        System.out.println("clamp(-3, 0, 1) = " + clamp(-3.0, 0.0, 1.0)); // 0.0
    }

    static int add(int a, int b) {
        int result = a + b;
        return result;
    }

    // Keeps a value between min and max. Motor speeds must stay between -1.0 and 1.0,
    // so this kind of method is common in robot code.
    static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }


    // ================================================================== //
    // PART F - LISTS
    //   A variable holds ONE value. An ArrayList holds MANY values, in order.
    // ================================================================== //

    // ------------------------------------------------------------------ //
    // LESSON 19: ArrayList - create, add, size, get
    //
    //       ArrayList<String> targets = new ArrayList<>();
    //                 ^^^^^^
    //                 type of the items inside, in angle brackets
    //
    //   - .add(item)    puts an item at the end
    //   - .size()       how many items are in the list
    //   - .get(index)   the item at that position
    //
    //   GOTCHA: positions ("indexes") start at 0, not 1!
    //           A list of 3 items has indexes 0, 1, 2.
    //
    //   TRY IT: What happens if you call targets.get(3)? Try it and read the error.
    // ------------------------------------------------------------------ //
    static void lesson19_arrayListBasics() {
        ArrayList<String> targets = new ArrayList<>();   // starts empty
        System.out.println("Size: " + targets.size());   // 0

        targets.add("Speaker");
        targets.add("Amp");
        targets.add("Trap");

        System.out.println("Targets: " + targets);       // [Speaker, Amp, Trap]
        System.out.println("Size: " + targets.size());   // 3
        System.out.println("Index 0: " + targets.get(0)); // Speaker
        System.out.println("Index 2: " + targets.get(2)); // Trap
    }


    // ------------------------------------------------------------------ //
    // LESSON 20: ArrayList - set, remove, contains
    //   - .set(index, item)  replaces the item at that position
    //   - .remove(item)      deletes that item; everything after slides down
    //   - .contains(item)    true if the item is in the list
    //
    //   TRY IT: After removing "Amp", what is at index 1 now? Print it to check.
    // ------------------------------------------------------------------ //
    static void lesson20_arrayListChanges() {
        ArrayList<String> targets = new ArrayList<>();
        targets.add("Speaker");
        targets.add("Amp");
        targets.add("Trap");

        targets.set(0, "Source");
        System.out.println("After set: " + targets);         // [Source, Amp, Trap]

        targets.remove("Amp");
        System.out.println("After remove: " + targets);      // [Source, Trap]

        boolean hasTrap = targets.contains("Trap");
        System.out.println("Has Trap: " + hasTrap);          // true
    }


    // ------------------------------------------------------------------ //
    // LESSON 21: Looping Over an ArrayList
    //   Two ways to visit every item:
    //   1. A normal for loop using indexes 0 .. size()-1  (you know this already!)
    //   2. A "for-each" loop - shorter, when you don't need the index:
    //
    //       for (String target : targets) { ... }
    //       read as: "for each String target IN targets"
    //
    //   GOTCHA: lists of numbers use Integer / Double (capital letter), not int / double.
    //           ArrayList<Integer> works.  ArrayList<int> does not.
    //
    //   TRY IT: Use a for-each loop to add up all the scores and print the total.
    // ------------------------------------------------------------------ //
    static void lesson21_arrayListLoops() {
        ArrayList<String> targets = new ArrayList<>();
        targets.add("Speaker");
        targets.add("Amp");
        targets.add("Trap");

        // Way 1: index-based for loop
        for (int i = 0; i < targets.size(); i++) {
            System.out.println("  Target " + i + ": " + targets.get(i));
        }

        // Way 2: for-each loop
        for (String target : targets) {
            System.out.println("  -> " + target);
        }

        // Filling a list with a loop
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            scores.add(i * 10);
        }
        System.out.println("Scores: " + scores);   // [10, 20, 30, 40, 50]
    }


    // ================================================================== //
    // PART G - LOOKUP TABLES
    //   An ArrayList finds items by NUMBER (index).
    //   A HashMap finds items by NAME (key) - like looking up a word in a dictionary.
    // ================================================================== //

    // ------------------------------------------------------------------ //
    // LESSON 22: HashMap - put, get, size
    //
    //       HashMap<String, Integer> points = new HashMap<>();
    //               ^^^^^^  ^^^^^^^
    //               key     value
    //               type    type
    //
    //   - .put(key, value)  stores a value under that key
    //   - .get(key)         looks up the value for that key
    //   - .size()           how many key-value pairs there are
    //
    //   NOTE: a HashMap does NOT keep things in the order you added them.
    //
    //   TRY IT: Add a "Park" zone worth 3 points and print its value.
    // ------------------------------------------------------------------ //
    static void lesson22_hashMapBasics() {
        HashMap<String, Integer> points = new HashMap<>();

        points.put("Speaker", 2);
        points.put("Amp", 1);
        points.put("Trap", 5);

        System.out.println("Points table: " + points);
        System.out.println("Size: " + points.size());          // 3

        int trapPoints = points.get("Trap");
        System.out.println("Trap is worth " + trapPoints);     // 5
    }


    // ------------------------------------------------------------------ //
    // LESSON 23: HashMap - update, containsKey, remove
    //   - .put() on a key that already exists REPLACES the old value
    //     (keys are unique - one key can only have one value)
    //   - .containsKey(key)  true if that key is in the map
    //   - .remove(key)       deletes the key and its value
    //
    //   TRY IT: Remove the "if" check and get a key that doesn't exist.
    //           What happens? This is why we check first!
    // ------------------------------------------------------------------ //
    static void lesson23_hashMapChanges() {
        HashMap<String, Integer> points = new HashMap<>();
        points.put("Speaker", 2);
        points.put("Amp", 1);
        points.put("Trap", 5);

        points.put("Amp", 2);   // rule change: Amp is now worth 2
        System.out.println("Amp is now worth " + points.get("Amp"));  // 2

        points.remove("Trap");
        System.out.println("After remove: " + points);

        if (points.containsKey("Trap")) {
            System.out.println("Trap is worth " + points.get("Trap"));
        } else {
            System.out.println("No Trap entry.");
        }
    }


    // ------------------------------------------------------------------ //
    // LESSON 24: Looping Over a HashMap
    //   .keySet() gives you all the keys. Loop over them with for-each,
    //   then use .get(key) to look up each value.
    //
    //   TRY IT: Make a HashMap<String, String> of subsystem -> status
    //           ("Shooter" -> "Ready", "Intake" -> "Disabled") and print every entry.
    // ------------------------------------------------------------------ //
    static void lesson24_hashMapLoops() {
        HashMap<String, Integer> points = new HashMap<>();
        points.put("Speaker", 2);
        points.put("Amp", 1);
        points.put("Trap", 5);

        for (String zone : points.keySet()) {
            int value = points.get(zone);
            System.out.println("  " + zone + " -> " + value + " pts");
        }
    }
}
