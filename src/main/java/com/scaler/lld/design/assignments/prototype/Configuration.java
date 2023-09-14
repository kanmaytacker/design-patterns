package com.scaler.lld.design.assignments.prototype;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Setter
public class Configuration implements ConfigurationPrototypeRegistry, ClonableObject<Configuration> {
    private String themeColor;
    private Boolean autoSave;
    private String language;
    private Boolean darkMode;
    private Integer fontSize;
    private String fontFamily;
    private ConfigurationType type;

    private Map<ConfigurationType,Configuration> hm = new HashMap<>();

    public Configuration(String themeColor, Boolean autoSave, String language, Boolean darkMode, Integer fontSize, String fontFamily, ConfigurationType type) {
        this.themeColor = themeColor;
        this.autoSave = autoSave;
        this.language = language;
        this.darkMode = darkMode;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.type = type;

        hm.put(type, this);
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
        return new Configuration(themeColor, autoSave, language, darkMode, fontSize, fontFamily, type);
    }

    @Override
    public void addPrototype(Configuration user) {

        hm.put(user.getType(),user);

    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return hm.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {

        Configuration prototype = getPrototype(type);
        if (prototype != null) {
            return prototype.cloneObject();
        } else {
            throw new IllegalArgumentException("Prototype not found for type: " + type);
        }
    }
}