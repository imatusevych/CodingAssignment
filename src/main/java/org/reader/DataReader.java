package org.reader;

import org.entity.InputDataEntity;

import java.util.List;

public interface DataReader {
    public List<InputDataEntity> read(String fileNamePath) throws Exception;
}
