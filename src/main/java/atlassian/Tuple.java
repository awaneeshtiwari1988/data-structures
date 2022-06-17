package atlassian;

import java.util.List;

public class Tuple {

    private int totalSize;
    private List<FileCollection> fileCollections;

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<FileCollection> getFileCollections() {
        return fileCollections;
    }

    public void setFileCollections(List<FileCollection> fileCollections) {
        this.fileCollections = fileCollections;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "totalSize=" + totalSize +
                ", fileCollections=" + fileCollections +
                '}';
    }
}
