package com.scaler.lld.design.assignments.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Step 2: implement clone method
@Getter
public class Configuration implements ClonableObject<Configuration>{
    private String themeColor;
    private Boolean autoSave;
    private String language;
    private Boolean darkMode;
    private Integer fontSize;
    private String fontFamily;
    private ConfigurationType type;

    public Configuration(String themeColor, Boolean autoSave, String language, Boolean darkMode, Integer fontSize, String fontFamily, ConfigurationType type) {
        this.themeColor = themeColor;
        this.autoSave = autoSave;
        this.language = language;
        this.darkMode = darkMode;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.type = type;
    }

    @Override
    public Configuration cloneObject() {
        return new Configuration(this.themeColor, this.autoSave, this.language, this.darkMode, this.fontSize, this.fontFamily, this.type);
    }
}