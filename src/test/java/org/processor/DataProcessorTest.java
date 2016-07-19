package org.processor;

import org.entity.InputDataEntity;
import org.entity.OutputDataEntity;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DataProcessorTest {
    @Test
    public void read() throws Exception {
        List<InputDataEntity> expectedResult = new ArrayList<InputDataEntity>();
        expectedResult.add(new InputDataEntity(12000,"example.com/csv1", true, 454));
        expectedResult.add(new InputDataEntity(13000,"example.com/json1", true, 21));

        List<InputDataEntity> actualResult = DataProcessor.read("src/test/resources/input");

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test(expected = Exception.class)
    public void readIsNotDir() throws Exception {
        List<InputDataEntity> actualResult = DataProcessor.read("src/test/resources/inpu1t1.csv");
    }

    @Test(expected = Exception.class)
    public void readIsNotValidDir() throws Exception {
        List<InputDataEntity> actualResult = DataProcessor.read("src/test/resources/input1");
    }

    @Test
    public void write() throws Exception {
        List<OutputDataEntity> inputData = new ArrayList<OutputDataEntity>();
        inputData.add(new OutputDataEntity(13000, "example.com/csv1", 1, "13000_key1,13000_key2", 454));
        inputData.add(new OutputDataEntity(13001, "example.com/csv2", 0, "EMPTY_KEY_WORDS", 455));

        DataProcessor.write("src/test/resources/output.txt",inputData);
        File outfile = new File("src/test/resources/output.txt");
        Assert.assertNotEquals(outfile.length(), 0);
        outfile.delete();
    }

    @Test(expected = Exception.class)
    public void writeToIncorectPath() throws Exception {
        List<OutputDataEntity> inputData = new ArrayList<OutputDataEntity>();
        inputData.add(new OutputDataEntity(13000, "example.com/csv1", 1, "13000_key1,13000_key2", 454));
        inputData.add(new OutputDataEntity(13001, "example.com/csv2", 0, "EMPTY_KEY_WORDS", 455));

        DataProcessor.write("src/test/resources/output1/output.txt",inputData);
    }

}
