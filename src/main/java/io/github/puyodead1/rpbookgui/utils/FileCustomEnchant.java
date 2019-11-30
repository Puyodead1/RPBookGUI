package io.github.puyodead1.rpbookgui.utils;

import me.randomhashtags.randompackage.RandomPackageAPI;
import me.randomhashtags.randompackage.addon.CustomEnchant;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class FileCustomEnchant implements CustomEnchant {
	protected static RandomPackageAPI api = RandomPackageAPI.api;
    private List<String> lore;
    private List<String> appliesto;
    private List<String> attributes;
    private BigDecimal[] alchemist;
    private BigDecimal[] tinkerer;
    protected YamlConfiguration yml;
    private File f;

    public FileCustomEnchant(File f) {
    	this.yml = YamlConfiguration.loadConfiguration(f);
    	this.f = f;
    }
    public String getIdentifier() { return f.getName().split("\\.yml")[0]; }

    public boolean isEnabled() { return yml.getBoolean("enabled"); }
    public String getName() { return yml.getString("name"); }
    public List<String> getLore() {
        if(lore == null) lore = api.colorizeListString(yml.getStringList("lore"));
        return lore;
    }
    public int getMaxLevel() { return yml.getInt("max level"); }
    public List<String> getAppliesTo() {
        if(appliesto == null) appliesto = Arrays.asList(yml.getString("applies to").split(";"));
        return appliesto;
    }
    public String getRequiredEnchant() { return yml.getString("requires"); }
    public BigDecimal[] getAlchemist() {
        if(alchemist == null) {
            final String[] a = yml.getString("alchemist").split(":");
            final BigDecimal[] alchemist = new BigDecimal[a.length];
            int i = 0;
            for(String s : a) {
                alchemist[i] = BigDecimal.valueOf(Integer.parseInt(s));
                i++;
            }
            this.alchemist = alchemist;
        }
        return alchemist;
    }
    public BigDecimal[] getTinkerer() {
        if(tinkerer == null) {
            final String[] t = yml.getString("tinkerer").split(":");
            final BigDecimal[] tinkerer = new BigDecimal[t.length];
            int i = 0;
            for(String s : t) {
                tinkerer[i] = BigDecimal.valueOf(Integer.parseInt(s));
                i++;
            }
            this.tinkerer = tinkerer;
        }
        return tinkerer;
    }
    public String getEnchantProcValue() {
        return yml.getString("enchant proc value", "0");
    }
    public List<String> getAttributes() {
        if(attributes == null) attributes = yml.getStringList("attributes");
        return attributes;
    }
}