package org.reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.entity.InputDataEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader implements DataReader {

    private static final String [] FILE_HEADER = {"id","name","is mobile","score"};

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String IS_MOBILE = "is mobile";
    private static final String SCORE = "score";

    public List<InputDataEntity> read(String fileNamePath) throws Exception{
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER);
        FileReader fileReader = null;
        CSVParser csvFileParser = null;
        List<InputDataEntity> inputDataEntities = new ArrayList<InputDataEntity>();
        try {
            fileReader = new FileReader(fileNamePath);
            csvFileParser = new CSVParser(fileReader, csvFileFormat);
            List<CSVRecord> csvRecords = csvFileParser.getRecords();

            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord csvRecord = csvRecords.get(i);
                InputDataEntity inputDataEntity = new InputDataEntity();
                inputDataEntity.setId(Integer.parseInt(csvRecord.get(ID)));
                inputDataEntity.setMobile(Boolean.parseBoolean(csvRecord.get(IS_MOBILE)));
                inputDataEntity.setName(csvRecord.get(NAME));
                inputDataEntity.setScore(Integer.parseInt(csvRecord.get(SCORE)));
                inputDataEntities.add(inputDataEntity);
            }

            return inputDataEntities;

        } catch (Exception e) {
            throw new Exception("Error in parsing file" + fileNamePath);
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
                throw new Exception("Error while closing fileReader/csvFileParser for file" + fileNamePath);
            }
        }
    }
}
