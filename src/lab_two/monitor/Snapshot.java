package lab_two.monitor;

import java.time.LocalDateTime;

public class Snapshot {
    private LocalDateTime snapshotTime;

    public void updateSnapshotTime() {
        snapshotTime = LocalDateTime.now();
    }

    public LocalDateTime getSnapshotTime() {
        return snapshotTime;
    }
}

