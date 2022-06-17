package atlassian;

import java.util.Comparator;

public class FileCollectionComparator implements Comparator<FileCollection> {
    @Override
    public int compare(FileCollection o1, FileCollection o2) {
        return Integer.compare(o1.getFileSize(), o2.getFileSize());
    }

    @Override
    public Comparator<FileCollection> reversed() {
        return Comparator.super.reversed();
    }
}
