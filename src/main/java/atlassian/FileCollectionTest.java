package atlassian;

import java.util.ArrayList;
import java.util.List;

public class FileCollectionTest {

    public static void main(String[] args) {
        FileCollection fileCollection = new FileCollection();
        fileCollection.setFileName("file1.txt");
        fileCollection.setFileSize(100);

        FileCollection fileCollection1 = new FileCollection();
        fileCollection1.setCollectionName("collection1");
        fileCollection1.setFileName("file2.txt");
        fileCollection1.setFileSize(200);

        FileCollection fileCollection2 = new FileCollection();
        fileCollection2.setCollectionName("collection1");
        fileCollection2.setFileName("file3.txt");
        fileCollection2.setFileSize(200);

        FileCollection fileCollection3 = new FileCollection();
        fileCollection3.setCollectionName("collection2");
        fileCollection3.setFileName("file4.txt");
        fileCollection3.setFileSize(300);

        FileCollection fileCollection4 = new FileCollection();
        fileCollection4.setFileName("file5.txt");
        fileCollection4.setFileSize(10);

        List<FileCollection> fileCollectionList = new ArrayList<>();
        fileCollectionList.add(fileCollection);
        fileCollectionList.add(fileCollection1);
        fileCollectionList.add(fileCollection2);
        fileCollectionList.add(fileCollection3);
        fileCollectionList.add(fileCollection4);

        FileCollectionUtil fileCollectionUtil = new FileCollectionUtil();
        Tuple tuple = fileCollectionUtil.getTotalFileSizeAndTopNRecords(fileCollectionList, 5);
        System.out.println(tuple.getTotalSize() + " - " + tuple.getFileCollections());
    }
}
