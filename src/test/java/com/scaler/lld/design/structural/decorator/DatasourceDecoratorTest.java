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
        DataSource compressedDataSource = new CompressionDecorator(dataSource);
        assertEquals("If compressed data source is used, it should return Decompress", "Base - Decompress",
                compressedDataSource.read());

    }

    @Test
    public void testEncryptionDecorator() {
        DataSource encryptedDataSource = new EncryptionDecorator(dataSource);
        assertEquals("If encrypted data source is used, it should return Encrypted", "Base - Encrypted",
                encryptedDataSource.read());
    }

    @Test
    public void testCompressionAndEncryptionDecorator() {
        DataSource compressedDataSource = new CompressionDecorator(dataSource);
        DataSource encryptedDataSource = new EncryptionDecorator(compressedDataSource);
        assertEquals("If compressed and encrypted data source is used, it should return Encrypted - Decompress",
                "Base - Encrypted - Decompress", encryptedDataSource.read());
    }

}
