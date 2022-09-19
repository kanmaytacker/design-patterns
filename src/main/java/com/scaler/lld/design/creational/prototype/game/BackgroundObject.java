package com.scaler.lld.design.creational.prototype.game;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Step 2 - Create a concrete class
@Getter
@Setter
@NoArgsConstructor
public class BackgroundObject implements GraphicalObject {
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private BackgroundObjectType type;
    
    @Getter(AccessLevel.NONE) // Hide field from getter
    @Setter(AccessLevel.NONE) // Hide field from setter
    private List<Integer> pixels = new ArrayList<>();

    public BackgroundObject(Integer x, Integer y, Integer width, Integer height, BackgroundObjectType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public BackgroundObject(Integer x, Integer y, Integer width, Integer height, BackgroundObjectType type, List<Integer> pixels) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.pixels = pixels;
    }

    @Override
    public BackgroundObject clone() {
        return new BackgroundObject(x, y, width, height, type, pixels);
    }
}
