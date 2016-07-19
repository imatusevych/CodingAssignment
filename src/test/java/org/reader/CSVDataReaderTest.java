package org.reader;

import org.entity.InputDataEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CSVDataReaderTest {

    private DataReader target;

    @Before
    public void init(){
        target = new CSVDataReader();
    }
    @Test
    public void read() throws Exception {
        List<InputDataEntity> expectedResult = new ArrayList<InputDataEntity>();
        expectedResult.add(new InputDataEntity(12000,"example.com/csv1", true, 454));

        List<InputDataEntity> actualResult = target.read("src/test/resources/input/input1.csv");

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test(expected = Exception.class)
    public void readFileThatIsNotExists() throws Exception {
        List<InputDataEntity> actualResult = target.read("src/test/resources/inpu1t1.csv");
    }

    @Test(expected = Exception.class)
    public void readBadFormat() throws Exception {
        List<InputDataEntity> actualResult = target.read("src/test/resources/input1_bad_format.csv");
    }
}