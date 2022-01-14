package com.scaler.lld.design.structural.decorator;

public class EncryptionDataSource implements DataSource {

    private DataSource dataSource;

    public EncryptionDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String read() {
        String value = dataSource.read();
        return decrypt(value);
    }

    private String decrypt(String value) {
        return "Decrypted";
    }

    @Override
    public void write(String value) {
        String encryptedValue = encrypt(value);
        dataSource.write(encryptedValue);
    }

    private String encrypt(String value) {
        return "Encrypted";
    }

}
