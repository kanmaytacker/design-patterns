package com.scaler.lld.design.assignments.prototype;

public class Configuration implements ClonableObject{
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

    public Configuration(Configuration reference) {
        this.themeColor = reference.themeColor;
        this.autoSave = reference.autoSave;
        this.language = reference.language;
        this.darkMode = reference.darkMode;
        this.fontSize = reference.fontSize;
        this.fontFamily = reference.fontFamily;
        this.type = reference.type;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public void setAutoSave(Boolean autoSave) {
        this.autoSave = autoSave;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDarkMode(Boolean darkMode) {
        this.darkMode = darkMode;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public void setType(ConfigurationType type) {
        this.type = type;
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