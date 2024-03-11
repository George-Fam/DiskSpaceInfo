import java.io.File;

public class DiskSpaceInfo {
    public static void main(String[] args){
        long totalFreeSpace = 0;
        long totalSpace = 0;
        long totalUsedSpace = 0;

        File[] roots = File.listRoots(); // Get all root directories (drives)

        for (File root : roots) {
            totalFreeSpace += root.getFreeSpace();
            totalSpace += root.getTotalSpace();
            totalUsedSpace += root.getTotalSpace()-root.getFreeSpace();
        }

        System.out.println("Total Free Disk Space: " + formatDiskSpace(totalFreeSpace));
        System.out.println("Total Used Disk Space: " + formatDiskSpace(totalUsedSpace));
        System.out.println("     Total Disk Space: " + formatDiskSpace(totalSpace));
    }

    private static String formatDiskSpace(long bytes) {
        double gigabytes = bytes / (1024.0 * 1024 * 1024);
        if (gigabytes < 1024) {
            return String.format("%.2f GB", gigabytes);
        } else {
            double terabytes = gigabytes / 1024;
            return String.format("%.2f TB", terabytes);
        }
    }
}
