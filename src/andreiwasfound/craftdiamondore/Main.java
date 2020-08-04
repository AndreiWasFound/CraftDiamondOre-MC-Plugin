package andreiwasfound.craftdiamondore;

import andreiwasfound.craftdiamondore.Utilities.MetricsLite;
import andreiwasfound.craftdiamondore.Utilities.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        printToConsole("Recipes are trying to register");
        Bukkit.addRecipe(getDiamondOre1DiamondRecipe());
        Bukkit.addRecipe(getDiamondOre5DiamondRecipe());
        printToConsole("Recipes have been registered successfully");
        printToConsole("bStats is trying to register");
        int pluginId = 8417;
        MetricsLite metrics = new MetricsLite(this, pluginId);
        printToConsole("bStats has been registered successfully");
    }

    @Override
    public void onDisable() {

    }

    public ShapedRecipe getDiamondOre1DiamondRecipe() {
        ItemStack item = new ItemStack(Material.DIAMOND_ORE);
        NamespacedKey key = new NamespacedKey(this, "diamond_ore_1_diamond");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("SSS", "SDS", "SSS");
        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('S', Material.STONE);
        return recipe;
    }

    public ShapedRecipe getDiamondOre5DiamondRecipe() {
        ItemStack item = new ItemStack(Material.DIAMOND_ORE);
        NamespacedKey key = new NamespacedKey(this, "diamond_ore_5_diamond");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("SDS", "DDD", "SDS");
        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('S', Material.STONE);
        return recipe;
    }

    public void printToConsole(String msg) {
        this.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "DiamondBrokeMessage" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET + " " + msg);
    }

    public void updateChecker() {
        new UpdateChecker(this, 80958).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                printToConsole("DiamondBrokeMessage is up to date!");
            } else {
                printToConsole("DiamondBrokeMessage is outdated!");
                printToConsole("Newest version: " + version);
                printToConsole("Your version: " + pluginymlVersion);
                printToConsole("Please Update Here: " + pluginymlWebsite);
            }
        });
    }

    PluginDescriptionFile pluginyml = this.getDescription();
    String pluginymlVersion = pluginyml.getVersion();
    String pluginymlWebsite = pluginyml.getWebsite();
}