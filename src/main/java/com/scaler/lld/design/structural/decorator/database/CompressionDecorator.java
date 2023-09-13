package com.scaler.lld.design.structural.decorator.database;

public class CompressionDecorator extends BaseDecorator {

    public CompressionDecorator(Datasource datasource) {
        super(datasource);
    }

    @Override
    public String read() {
        String compressed = nextLayer.read();
        return decompress(compressed);
    }

    private String decompress(String compressed) {
        return compressed + " - Decompressed";
    }

    @Override
    public void write(String value) {
        String compressed = compress(value);
        nextLayer.write(compressed);
    }

    private String compress(String value) {
        return value + " - Compressed";
    }
}
