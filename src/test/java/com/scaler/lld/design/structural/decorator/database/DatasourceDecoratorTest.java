package com.scaler.lld.design.structural.decorator.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DatasourceDecoratorTest {

    Datasource dataSource = null;

    @BeforeEach
    public void setUp() {
        dataSource = new FileDatasource();
    }

    @Test
    public void testBaseDataSource() {
        String value = dataSource.read();
        assertEquals("Base", value, "If base data source is used, it should return Base");
    }

    @Test
    public void testCompressionDecorator() {
        Datasource compressedDataSource = new CompressionDecorator(dataSource);
        assertEquals("Base - Decompressed",
                compressedDataSource.read(), "If compressed data source is used, it should return Decompress");

    }

    @Test
    public void testEncryptionDecorator() {
        Datasource encryptedDataSource = new EncryptionDecorator(dataSource);
        assertEquals("Base - Decrypted",
                encryptedDataSource.read(), "If encrypted data source is used, it should return Encrypted");
    }

    @Test
    public void testCompressionAndEncryptionDecorator() {
        Datasource compressedDataSource = new CompressionDecorator(dataSource);
        Datasource encryptedDataSource = new EncryptionDecorator(compressedDataSource);
        assertEquals(
                "Base - Decompressed - Decrypted", encryptedDataSource.read(), "If compressed and encrypted data source is used, it should return Encrypted - Decompress");
    }

}
