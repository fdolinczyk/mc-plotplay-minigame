package pl.warchamer12.minigame.Utils;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Inventory {

    public static void inventoryClear(Player player) {
        PlayerInventory inv = player.getInventory();

        inv.clear();
        inv.setHelmet(new ItemStack(Material.AIR));
        inv.setChestplate(new ItemStack(Material.AIR));
        inv.setLeggings(new ItemStack(Material.AIR));
        inv.setBoots(new ItemStack(Material.AIR));
    }

    public static void setAlphaPlayerInventory(Player player) {
        PlayerInventory inv = player.getInventory();

        inv.clear();
        inv.setHelmet(new ItemStack(Material.AIR));
        inv.setChestplate(new ItemStack(Material.AIR));
        inv.setLeggings(new ItemStack(Material.AIR));
        inv.setBoots(new ItemStack(Material.AIR));

        ItemStack helm = new ItemBuilder(Material.LEATHER_HELMET).setDyeColor(DyeColor.BLUE).setName(Util.fixColor("&c&lHelm")).toItemStack();
        inv.setHelmet(helm);
        ItemStack klata = new ItemBuilder(Material.LEATHER_CHESTPLATE).setDyeColor(DyeColor.BLUE).setName(Util.fixColor("&c&lKlata")).toItemStack();
        inv.setChestplate(klata);
        ItemStack spodnie = new ItemBuilder(Material.LEATHER_LEGGINGS).setDyeColor(DyeColor.BLUE).setName(Util.fixColor("&c&lSpodnie")).toItemStack();
        inv.setLeggings(spodnie);
        ItemStack buty = new ItemBuilder(Material.LEATHER_BOOTS).setDyeColor(DyeColor.BLUE).setName(Util.fixColor("&c&lButy")).toItemStack();
        inv.setBoots(buty);
        ItemStack SNOWBALLBLUE = new ItemBuilder(Material.SNOWBALL).setName(Util.fixColor("&c&lSniezka")).toItemStack();
        inv.addItem(new ItemStack[] { SNOWBALLBLUE });
    }

    public static void setBravoPlayerInventory(Player player) {
        PlayerInventory inv = player.getInventory();

        inv.clear();
        inv.setHelmet(new ItemStack(Material.AIR));
        inv.setChestplate(new ItemStack(Material.AIR));
        inv.setLeggings(new ItemStack(Material.AIR));
        inv.setBoots(new ItemStack(Material.AIR));

        ItemStack helm = new ItemBuilder(Material.LEATHER_HELMET).setDyeColor(DyeColor.RED).setName(Util.fixColor("&c&lHelm")).toItemStack();
        inv.setHelmet(helm);
        ItemStack klata = new ItemBuilder(Material.LEATHER_CHESTPLATE).setDyeColor(DyeColor.RED).setName(Util.fixColor("&c&lKlata")).toItemStack();
        inv.setChestplate(klata);
        ItemStack spodnie = new ItemBuilder(Material.LEATHER_LEGGINGS).setDyeColor(DyeColor.RED).setName(Util.fixColor("&c&lSpodnie")).toItemStack();
        inv.setLeggings(spodnie);
        ItemStack buty = new ItemBuilder(Material.LEATHER_BOOTS).setDyeColor(DyeColor.RED).setName(Util.fixColor("&c&lButy")).toItemStack();
        inv.setBoots(buty);
        ItemStack SNOWBALLRED = new ItemBuilder(Material.SNOWBALL).setName(Util.fixColor("&c&lSniezka")).toItemStack();
        inv.addItem(new ItemStack[] { SNOWBALLRED });
    }
}
