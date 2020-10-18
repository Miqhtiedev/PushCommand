package miqhtie.push;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Objects;

public class PushItem {
    public ItemStack item(){

        ArrayList<String> lore = new ArrayList<>();
        lore.add("If you wish to die, this is a good method");
        lore.add("Note: Miqhtie Development does not take responsibility");
        lore.add("for any injuries that occur while using this.");
        ItemStack item = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.MENDING, 1,true);
        meta.setDisplayName(String.format("%sPush Stick", ChatColor.GOLD));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public boolean isItem(ItemStack i){
        if(i == null || !i.hasItemMeta()){
            return false;
        }

        ItemMeta meta = i.getItemMeta();

        assert meta != null;
        if(!meta.hasDisplayName()){
            return false;
        }

        return meta.getDisplayName().equals(Objects.requireNonNull(item().getItemMeta()).getDisplayName());
    }
}
