package frc.robot.util;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * A number that is published to NetworkTables under /Tuning/<key>.
 * Elastic (or any NT4 dashboard) can write back to change the value live.
 * Call hasChanged() in periodic() to detect and apply updates.
 */
public class LoggedTunableNumber {
    private static final String TABLE = "Tuning";

    private final NetworkTableEntry entry;
    private double lastValue;

    public LoggedTunableNumber(String key, double defaultValue) {
        entry = NetworkTableInstance.getDefault().getTable(TABLE).getEntry(key);
        entry.setDefaultDouble(defaultValue);
        lastValue = defaultValue;
    }

    public double get() {
        return entry.getDouble(lastValue);
    }

    /** Returns true (once) if any of the given numbers changed since last call. */
    public static boolean hasChanged(LoggedTunableNumber... numbers) {
        boolean changed = false;
        for (LoggedTunableNumber n : numbers) {
            double current = n.get();
            if (current != n.lastValue) {
                n.lastValue = current;
                changed = true;
            }
        }
        return changed;
    }
}
