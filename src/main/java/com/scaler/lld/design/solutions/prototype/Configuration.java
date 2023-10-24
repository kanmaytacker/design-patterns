package com.scaler.lld.design.solutions.prototype;

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

    public Configuration(Configuration configuration) {
        this.themeColor = configuration.themeColor;
        this.autoSave = configuration.autoSave;
        this.language = configuration.language;
        this.darkMode = configuration.darkMode;
        this.fontSize = configuration.fontSize;
        this.fontFamily = configuration.fontFamily;
        this.type = configuration.type;
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