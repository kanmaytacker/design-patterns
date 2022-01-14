package com.scaler.lld.design.structural.decorator;

// Step 1
public class CompressionDataSource implements DataSource {

    private DataSource dataSource;

    public CompressionDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String read() {
        String value = dataSource.read();
        return decompress(value);
    }

    private String decompress(String value) {
        return "Decompress";
    }

    @Override
    public void write(String value) {
        String compressedValue = compress(value);
        dataSource.write(compressedValue);
    }

    private String compress(String value) {
        return "Compressed";
    }

}
