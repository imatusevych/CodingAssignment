package org.reader;

public class DataReaderFactory {
    private static final String CSV = "csv";
    private static final String JSON = "json";

    private DataReaderFactory(){}

    public static DataReader getInstance(String fileExtension) throws Exception {
        if(fileExtension.equals(CSV)){
            return new CSVDataReader();
        }
        else if(fileExtension.equals(JSON)){
            return new JSONDataReader();
        }
        else {
            throw new Exception("file extension "+fileExtension+" do not suport");
        }
    }
}
