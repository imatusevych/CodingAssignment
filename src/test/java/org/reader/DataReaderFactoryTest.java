package org.reader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.service.DataService;

import static org.junit.Assert.*;

public class DataReaderFactoryTest {
    @Test
    public void getInstance() throws Exception {
        DataReader expectedResult = new JSONDataReader();
        DataReader actualResult = DataReaderFactory.getInstance("csv");
        Assert.assertNotEquals(expectedResult.getClass(),actualResult.getClass());
    }

    @Test(expected = Exception.class)
    public void getInstanceForNotAvailableType() throws Exception {
        DataReader actualResult = DataReaderFactory.getInstance("csv1");
    }

}