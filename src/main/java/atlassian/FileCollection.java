package atlassian;

public class FileCollection {

    private String fileName;
    private int fileSize;
    private String collectionName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    @Override
    public String toString() {
        return "FileCollection{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", collectionName='" + collectionName + '\'' +
                '}';
    }
}
