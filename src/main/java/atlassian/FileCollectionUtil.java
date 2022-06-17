package atlassian;

import java.util.*;
import java.util.stream.Collectors;

public class FileCollectionUtil {
    public Tuple getTotalFileSizeAndTopNRecords(List<FileCollection> fileCollections, int numberOfRecords){
        List<FileCollection> fileCollectionList = sortByCollectionSize(fileCollections);
        fileCollectionList = fileCollectionList.stream().limit(numberOfRecords).collect(Collectors.toList());

        Tuple tuple = new Tuple();
        tuple.setTotalSize(getTotalSize(fileCollections));
        tuple.setFileCollections(fileCollectionList);
        return tuple;
    }

    private int getTotalSize(List<FileCollection> fileCollections){
        int totalSize = 0;
        for(FileCollection fileCollection : fileCollections){
            totalSize = totalSize + fileCollection.getFileSize();
        }

        return totalSize;
    }

    private List<FileCollection> sortByCollectionSize(List<FileCollection> fileCollections){
        Map<String, Integer> fileCollectionMapBySize = new HashMap<>();
        for (FileCollection fileCollection : fileCollections){
            if(fileCollection.getCollectionName() != null){
                fileCollectionMapBySize.put(fileCollection.getCollectionName(),
                        fileCollectionMapBySize.getOrDefault(fileCollection.getCollectionName(),0)
                                + fileCollection.getFileSize());
            }
        }

        List<FileCollection> fileCollectionList = new ArrayList<>();
        for(Map.Entry entry : fileCollectionMapBySize.entrySet()){
            String name = (String) entry.getKey();
            int value = (int) entry.getValue();
            FileCollection fileCollection = new FileCollection();
            fileCollection.setCollectionName(name);
            fileCollection.setFileSize(value);
            fileCollectionList.add(fileCollection);
        }

        // Reverse list
        Collections.sort(fileCollectionList, new FileCollectionComparator().reversed());

        return fileCollectionList;
    }
}
