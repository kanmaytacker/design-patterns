package com.scaler.lld.design.assignments.prototype;
import java.io.ObjectInputFilter;

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
    private Configuration(Configuration obj){
        this.themeColor=obj.themeColor;
        this.autoSave=obj.autoSave;
        this.language=obj.language;
        this.darkMode=obj.darkMode;
        this.fontSize= obj.fontSize;
        this.type=obj.type;
        this.fontFamily=obj.fontFamily;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public Boolean getAutoSave() {
        return autoSave;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean getDarkMode() {
        return darkMode;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public ConfigurationType getType() {
        return type;
    }

    @Override
    public Configuration cloneObject() {
        return new Configuration(this);
    }
}