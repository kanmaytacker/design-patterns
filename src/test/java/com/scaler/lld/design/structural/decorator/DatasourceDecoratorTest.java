package com.scaler.lld.design.structural.decorator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DatasourceDecoratorTest {
    
    DataSource dataSource = null;

    @Before
    public void setUp() {
        dataSource = new FileDataSource();
    }

    @Test
    public void testBaseDataSource() {
        String value = dataSource.read();
        assertEquals("If base data source is used, it should return Base", "Base", value);
    }

    @Test
    public void testCompressionDecorator() {
        DataSource compressedDataSource = new CompressionDataSource(dataSource);
        DataSource encryptedDataSource = new EncryptionDataSource(dataSource);
        assertEquals("If compressed data source is used, it should return Decompress", "Decrypted", encryptedDataSource.read());

    }


}
