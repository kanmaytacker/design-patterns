package com.scaler.lld.design.structural.decorator.database;

// Step 4 - Create concrete decorators
public class EncryptionDecorator extends BaseDecorator {
    public EncryptionDecorator(Datasource nextLayer) {
        super(nextLayer);
    }

    @Override
    public String read() {
        String value = nextLayer.read();
        return decrypt(value);
    }

    private String decrypt(String value) {
        return value + " - Decrypted";
    }

    @Override
    public void write(String value) {
        String encrypted = encrypt(value);
        nextLayer.write(encrypted);
    }

    private String encrypt(String value) {
        return value + " - Encrypted";
    }
}
