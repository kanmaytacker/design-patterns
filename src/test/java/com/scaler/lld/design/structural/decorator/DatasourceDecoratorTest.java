package com.scaler.lld.design.structural.decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DatasourceDecoratorTest {

    DataSource dataSource = null;

    @BeforeEach
    public void setUp() {
        dataSource = new FileDataSource();
    }

    @Test
    public void testBaseDataSource() {
        String value = dataSource.read();
        assertEquals("Base", value, "If base data source is used, it should return Base");
    }

    @Test
    public void testCompressionDecorator() {
        DataSource compressedDataSource = new CompressionDecorator(dataSource);
        assertEquals("Base - Decompress",
                compressedDataSource.read(), "If compressed data source is used, it should return Decompress");

    }

    @Test
    public void testEncryptionDecorator() {
        DataSource encryptedDataSource = new EncryptionDecorator(dataSource);
        assertEquals( "Base - Decrypted",
                encryptedDataSource.read(), "If encrypted data source is used, it should return Encrypted");
    }

    @Test
    public void testCompressionAndEncryptionDecorator() {
        DataSource compressedDataSource = new CompressionDecorator(dataSource);
        DataSource encryptedDataSource = new EncryptionDecorator(compressedDataSource);
        assertEquals(
                "Base - Decompress - Decrypted", encryptedDataSource.read(), "If compressed and encrypted data source is used, it should return Encrypted - Decompress");
    }

}
