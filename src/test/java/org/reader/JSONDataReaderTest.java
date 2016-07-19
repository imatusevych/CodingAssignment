package org.reader;

import org.entity.InputDataEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JSONDataReaderTest {

    private DataReader target;

    @Before
    public void init(){
        target = new JSONDataReader();
    }
    @Test
    public void read() throws Exception {
        List<InputDataEntity> expectedResult = new ArrayList<InputDataEntity>();
        expectedResult.add(new InputDataEntity(13000,"example.com/json1", true, 21));
        List<InputDataEntity> actualResult = target.read("src/test/resources/input/input2.json");
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test(expected = Exception.class)
    public void readFileThatIsNotExists() throws Exception {
        List<InputDataEntity> actualResult = target.read("src/test/resources/inpu1t1.json");
    }

    @Test(expected = Exception.class)
    public void readBadFormat() throws Exception {
        List<InputDataEntity> actualResult = target.read("src/test/resources/input2_bad_format.json");
    }

}