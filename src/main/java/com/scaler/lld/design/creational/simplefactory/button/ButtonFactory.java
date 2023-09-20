package com.scaler.lld.design.creational.simplefactory.button;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ButtonFactory {

    private ScreenSize screenSize;
    private Double border;
    private Double radius;
    private Double length;

    private ButtonFactory(){

    }
    public static Builder getBuilder(){
        return new Builder();
    }
    @Setter
    @Getter
    static class Builder{
        private ScreenSize screenSize;
        private Double border;
        private Double radius;
        private Double length;

        public Builder setScreenSize(ScreenSize screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public Builder setBorder(Double border) {
            this.border = border;
            return this;
        }

        public Builder setRadius(Double radius) {
            this.radius = radius;
            return this;
        }

        public Builder setLength(Double length) {
            this.length = length;
            return this;
        }

        public  Button build(){
           return createButton(this);
       }
    }

    // Step 3 - Create a static factory method
    public static Button createButton(Builder build) {
        switch (build.getScreenSize()) {
            case PHONE:
            case TABLET: return new RoundButton(build.getBorder(), build.getRadius());
            case DESKTOP: return new SquareButton(build.getBorder(), build.getLength());
        }

        throw new IllegalArgumentException("Invalid type: " + build.getScreenSize());

    }
}
