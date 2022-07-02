package com.xiii.libertycity.roleplay.guis;

import com.xiii.libertycity.LibertyCity;
import com.xiii.libertycity.core.data.Data;
import com.xiii.libertycity.core.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ATMGUI implements Listener, CommandExecutor {

    Inventory gui;

    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public int itemCount(Player player, int i) {
        int count = 0;
        PlayerInventory inv = player.getInventory();

        if(i == 1) {
            for (ItemStack is : inv.all(Material.CLAY_BRICK).values()) {
                if (is != null && is.getType() == Material.CLAY_BRICK) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 2) {
            for (ItemStack is : inv.all(Material.COAL).values()) {
                if (is != null && is.getType() == Material.COAL) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 5) {
            for (ItemStack is : inv.all(Material.IRON_NUGGET).values()) {
                if (is != null && is.getType() == Material.IRON_NUGGET) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 10) {
            for (ItemStack is : inv.all(Material.GOLD_NUGGET).values()) {
                if (is != null && is.getType() == Material.GOLD_NUGGET) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 20) {
            for (ItemStack is : inv.all(Material.IRON_INGOT).values()) {
                if (is != null && is.getType() == Material.IRON_INGOT) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 50) {
            for (ItemStack is : inv.all(Material.GOLD_INGOT).values()) {
                if (is != null && is.getType() == Material.GOLD_INGOT) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 100) {
            for (ItemStack is : inv.all(Material.COAL_BLOCK).values()) {
                if (is != null && is.getType() == Material.COAL_BLOCK) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 200) {
            for (ItemStack is : inv.all(Material.IRON_BLOCK).values()) {
                if (is != null && is.getType() == Material.IRON_BLOCK) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 500) {
            for (ItemStack is : inv.all(Material.GOLD_BLOCK).values()) {
                if (is != null && is.getType() == Material.GOLD_BLOCK) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 1000) {
            for (ItemStack is : inv.all(Material.DIAMOND).values()) {
                if (is != null && is.getType() == Material.DIAMOND) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 2000) {
            for (ItemStack is : inv.all(Material.EMERALD).values()) {
                if (is != null && is.getType() == Material.EMERALD) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }
        if(i == 5000) {
            for (ItemStack is : inv.all(Material.NETHER_STAR).values()) {
                if (is != null && is.getType() == Material.NETHER_STAR) {
                    count = count + is.getAmount();
                }
            }
            return count;
        }

        return 0;
    }

    public void ATM(Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {

            PlayerData data = Data.data.getUserData(p);

            gui = Bukkit.createInventory(p.getPlayer(), 27, "                 §2§lATM");
            ItemStack glass = (createGuiItem(Material.STAINED_GLASS_PANE, " ", " "));
            ItemStack deposit = (createGuiItem(Material.GOLD_NUGGET, "§aDéposer de l'argent", "", "§7§oVotre §n§6§oargent§r§7§o sera ajouté de votre §n§6§obanque§r§7§o §7§o!", "§7Vous avez §6" + data.rpBank + "§6$ §7(Banque)"));
            ItemStack close = (createGuiItem(Material.BARRIER, "§cFermer le menu", " ", "§7Cliquer pour fermer le menu."));
            ItemStack withdraw = (createGuiItem(Material.IRON_NUGGET, "§cRetiré de l'argent", "", "§7§oL'§6§o§nargent§r§7§o sera retiré de votre §6§o§nbanque§r§7§o !", "§7Vous avez §6" + data.rpBank + "§6$ §7(Banque)"));

            for(int i = 0; i < 27; i++) {
                gui.setItem(i,glass);
            }

            gui.setItem(11, deposit);
            gui.setItem(13, close);
            gui.setItem(15, withdraw);

            p.getPlayer().openInventory(gui);

        });
    }

    public void ATMDeposit(Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {

            p.getPlayer().closeInventory();
            Inventory ATMDeposit = Bukkit.createInventory(p.getPlayer(), 36, "                 §a§lATM");
            ItemStack glass = (createGuiItem(Material.STAINED_GLASS_PANE, " ", " "));
            ItemStack close = (createGuiItem(Material.ARROW, "§cRetourner a l'ATM", " ", "§7Cliqué(e) pour retourner au menu de l'ATM."));
            ItemStack oneDollarBill = (createGuiItem(Material.CLAY_BRICK, "§aDéposer 1$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 1) + " §7billet(s) de §e1$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack twoDollarBill = (createGuiItem(Material.COAL, "§aDéposer 2$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 2) + " §7billet(s) de §e2$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack fiveDollarBill = (createGuiItem(Material.IRON_NUGGET, "§aDéposer 5$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 5) + " §7billet(s) de §e5$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack tenDollarBill = (createGuiItem(Material.GOLD_NUGGET, "§aDéposer 10$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 10) + " §7billet(s) de §e10$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack twentyDollarBill = (createGuiItem(Material.IRON_INGOT, "§aDéposer 20$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 20) + " §7billet(s) de §e20$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack fiftyDollarBill = (createGuiItem(Material.GOLD_INGOT, "§aDéposer 50$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 50) + " §7billet(s) de §e50$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack oneHundredDollarBill = (createGuiItem(Material.COAL_BLOCK, "§aDéposer 100$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 100) + " §7billet(s) de §e100$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack twoHundredDollarBill = (createGuiItem(Material.IRON_BLOCK, "§aDéposer 200$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 200) + " §7billet(s) de §e200$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack fiveHundredDollarBill = (createGuiItem(Material.GOLD_BLOCK, "§aDéposer 500$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 500) + " §7billet(s) de §e500$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack oneThousandDollarBill = (createGuiItem(Material.DIAMOND, "§aDéposer 1000$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 1000) + " §7billet(s) de §e1000$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack twoThousandDollarBill = (createGuiItem(Material.EMERALD, "§aDéposer 2000$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 2000) + " §7billet(s) de §e2000$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));
            ItemStack fiveThousandDollarBill = (createGuiItem(Material.NETHER_STAR, "§aDéposer 5000$", " ", "§7Vous avez §6" + itemCount(p.getPlayer(), 5000) + " §7billet(s) de §e5000$", " ", "§7Clique §e§ndroit§7 pour tous déposer.", "§7Clique §e§ngauche§7 pour déposer 1 par 1."));

            for(int i = 0; i < 36; i++) {
                ATMDeposit.setItem(i,glass);
            }
            ATMDeposit.setItem(35, close);

            ATMDeposit.setItem(10, oneDollarBill);
            ATMDeposit.setItem(11, twoDollarBill);
            ATMDeposit.setItem(12, fiveDollarBill);
            ATMDeposit.setItem(13, tenDollarBill);
            ATMDeposit.setItem(14, twentyDollarBill);
            ATMDeposit.setItem(15, fiftyDollarBill);
            ATMDeposit.setItem(16, oneHundredDollarBill);
            ATMDeposit.setItem(20, twoHundredDollarBill);
            ATMDeposit.setItem(21, fiveHundredDollarBill);
            ATMDeposit.setItem(22, oneThousandDollarBill);
            ATMDeposit.setItem(23, twoThousandDollarBill);
            ATMDeposit.setItem(24, fiveThousandDollarBill);

            p.getPlayer().openInventory(ATMDeposit);

        });

    }

    public void ATMWithdraw(Player p) {
        Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {

            PlayerData data = Data.data.getUserData(p);

            p.getPlayer().closeInventory();
            Inventory ATMWithdraw = Bukkit.createInventory(p.getPlayer(), 36, "                 §c§lATM");
            ItemStack glass = (createGuiItem(Material.STAINED_GLASS_PANE, " ", " "));
            ItemStack close = (createGuiItem(Material.ARROW, "§cRetourner a l'ATM", " ", "§7Cliqué(e) pour retourner au menu de l'ATM."));
            ItemStack oneDollarBill = (createGuiItem(Material.CLAY_BRICK, "§cRetirer 1$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack twoDollarBill = (createGuiItem(Material.COAL, "§cRetirer 2$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack fiveDollarBill = (createGuiItem(Material.IRON_NUGGET, "§cRetirer 5$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack tenDollarBill = (createGuiItem(Material.GOLD_NUGGET, "§cRetirer 10$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack twentyDollarBill = (createGuiItem(Material.IRON_INGOT, "§cRetirer 20$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack fiftyDollarBill = (createGuiItem(Material.GOLD_INGOT, "§cRetirer 50$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack oneHundredDollarBill = (createGuiItem(Material.COAL_BLOCK, "§cRetirer 100$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack twoHundredDollarBill = (createGuiItem(Material.IRON_BLOCK, "§cRetirer 200$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack fiveHundredDollarBill = (createGuiItem(Material.GOLD_BLOCK, "§cRetirer 500$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack oneThousandDollarBill = (createGuiItem(Material.DIAMOND, "§cRetirer 1000$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack twoThousandDollarBill = (createGuiItem(Material.EMERALD, "§cRetirer 2000$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));
            ItemStack fiveThousandDollarBill = (createGuiItem(Material.NETHER_STAR, "§cRetirer 5000$", " ", "§7Vous avez §6" + data.rpBank + "§6$ §7en banque", " ", "§7Clique §e§ndroit§7 pour tous retirer.", "§7Clique §e§ngauche§7 pour retirer 1 par 1."));

            for(int i = 0; i < 36; i++) {
                ATMWithdraw.setItem(i,glass);
            }
            ATMWithdraw.setItem(35, close);

            ATMWithdraw.setItem(10, oneDollarBill);
            ATMWithdraw.setItem(11, twoDollarBill);
            ATMWithdraw.setItem(12, fiveDollarBill);
            ATMWithdraw.setItem(13, tenDollarBill);
            ATMWithdraw.setItem(14, twentyDollarBill);
            ATMWithdraw.setItem(15, fiftyDollarBill);
            ATMWithdraw.setItem(16, oneHundredDollarBill);
            ATMWithdraw.setItem(20, twoHundredDollarBill);
            ATMWithdraw.setItem(21, fiveHundredDollarBill);
            ATMWithdraw.setItem(22, oneThousandDollarBill);
            ATMWithdraw.setItem(23, twoThousandDollarBill);
            ATMWithdraw.setItem(24, fiveThousandDollarBill);

            p.getPlayer().openInventory(ATMWithdraw);

        });
    }

    int depMoney = 0;
    int whdMoney = 0;
    int amount = 0;

    @EventHandler
    public void onATMClick(InventoryClickEvent e) {
        if(e.getClickedInventory().getName().contains("ATM")) e.setCancelled(true);
        Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {
            PlayerData data = Data.data.getUserData((Player) e.getWhoClicked());
            Player p = (Player) e.getWhoClicked();

            if(e.getClickedInventory().getName().equalsIgnoreCase("                 §2§lATM")) {
                if(e.getRawSlot() == 11) ATMDeposit(p);
                if(e.getRawSlot() == 13) p.closeInventory();
                if(e.getRawSlot() == 15) ATMWithdraw(p);
             }

            if(e.getClickedInventory().getName().equalsIgnoreCase("                 §a§lATM")) {
                Material item = e.getCurrentItem().getType();
                ItemStack im = e.getCurrentItem().getData().toItemStack();
                int freeSpace = 0;
                int money = Integer.parseInt(e.getCurrentItem().getItemMeta().getDisplayName().replaceAll("§cRetiré $", " "));
                if(e.getRawSlot() == 35) ATM(p);
                if(e.getRawSlot() == 10 || e.getRawSlot() == 11 || e.getRawSlot() == 12 || e.getRawSlot() == 13 || e.getRawSlot() == 14 || e.getRawSlot() == 15 || e.getRawSlot() == 16 || e.getRawSlot() == 20 || e.getRawSlot() == 21 || e.getRawSlot() == 22 || e.getRawSlot() == 23 || e.getRawSlot() == 24) {
                    if(e.getRawSlot() == 10) amount = itemCount((Player) e.getWhoClicked(), 1);
                    if(e.getRawSlot() == 11) amount = itemCount((Player) e.getWhoClicked(), 2);
                    if(e.getRawSlot() == 12) amount = itemCount((Player) e.getWhoClicked(), 5);
                    if(e.getRawSlot() == 13) amount = itemCount((Player) e.getWhoClicked(), 10);
                    if(e.getRawSlot() == 14) amount = itemCount((Player) e.getWhoClicked(), 20);
                    if(e.getRawSlot() == 15) amount = itemCount((Player) e.getWhoClicked(), 50);
                    if(e.getRawSlot() == 16) amount = itemCount((Player) e.getWhoClicked(), 100);
                    if(e.getRawSlot() == 20) amount = itemCount((Player) e.getWhoClicked(), 200);
                    if(e.getRawSlot() == 21) amount = itemCount((Player) e.getWhoClicked(), 500);
                    if(e.getRawSlot() == 22) amount = itemCount((Player) e.getWhoClicked(), 1000);
                    if(e.getRawSlot() == 23) amount = itemCount((Player) e.getWhoClicked(), 2000);
                    if(e.getRawSlot() == 24) amount = itemCount((Player) e.getWhoClicked(), 5000);
                    if(e.isRightClick()) {
                        if(amount > 0) {
                            e.getWhoClicked().getInventory().remove(item);
                            data.rpBank += (amount * money);
                            depMoney += (amount * money);
                        } e.getWhoClicked().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Vous n'avez pas assez de billets!");
                    } else if(e.isLeftClick()) {
                        if(amount > 0) {
                            int itemSlot = -1;
                            for(ItemStack it : e.getWhoClicked().getInventory().getContents()) {
                                if(it == im) {
                                } else itemSlot++;
                            }
                            if(amount == 1) {
                                e.getWhoClicked().getInventory().remove(item);
                            } else if(amount > 1) {
                                e.getWhoClicked().getInventory().setItem(itemSlot, new ItemStack(item, amount - 1));
                            }
                            data.rpBank += 1;
                            depMoney += 1;
                        } else e.getWhoClicked().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Vous n'avez pas assez de billets!");
                    }
                }
            }

            if(e.getClickedInventory().getName().equalsIgnoreCase("                 §c§lATM")) {
                Material item = e.getCurrentItem().getType();
                ItemStack im = e.getCurrentItem().getData().toItemStack();
                String mAmount = e.getCurrentItem().getItemMeta().getDisplayName();
                int freeSpace = 0;
                //mAmount.replace("§cRetiré $", " ");
                int money = Integer.parseInt(mAmount);
                if(e.getRawSlot() == 35) ATM(p);
                if(e.getRawSlot() == 10 || e.getRawSlot() == 11 || e.getRawSlot() == 12 || e.getRawSlot() == 13 || e.getRawSlot() == 14 || e.getRawSlot() == 15 || e.getRawSlot() == 16 || e.getRawSlot() == 20 || e.getRawSlot() == 21 || e.getRawSlot() == 22 || e.getRawSlot() == 23 || e.getRawSlot() == 24) {
                    if(e.isRightClick()) {
                        if(data.rpBank >= (money * 10)) {
                            for(ItemStack i : e.getWhoClicked().getInventory().getContents()) {
                                if(i.getType() == Material.AIR) {
                                    freeSpace++;
                                }
                            }
                            if(freeSpace >= 10) {
                                data.rpBank -= (money * 10);
                                whdMoney += (money * 10);
                                for (int i = 0; i < 10; i++) {
                                    e.getWhoClicked().getInventory().addItem(im);
                                }
                            } else e.getWhoClicked().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Vous n'avez pas assez de place dans votre inventaire!");
                        } else e.getWhoClicked().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Vous n'avez pas assez d'argent!");
                    } else if(e.isLeftClick()) {
                        if(data.rpBank >= money) {
                            data.rpBank -= money;
                            whdMoney += money;
                            e.getWhoClicked().getInventory().addItem(im);
                        } else e.getWhoClicked().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Vous n'avez pas assez d'argent!");
                    }
                }
            }

        });
    }

    @EventHandler
    public void onATMClose(InventoryCloseEvent e) {
        Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {
            if(depMoney > 0) e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous avez §a§ndéposé §6" + depMoney + "§6$");
            if(whdMoney > 0) e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous avez §c§nretiré §6" + whdMoney + "§6$");
            depMoney = 0;
            whdMoney = 0;
        });
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("atm")) {
            if(sender.hasPermission("LibertyCity.forceatm")) {
                ATM((Player) sender);
                sender.sendMessage("§2§lLiberty§a§lCity §7» §7§oOuvertue de l'ATM...");
                sender.sendMessage("§7§o(T=DG/TT | RESTR=Permission.node=LibertyCity.forceatm | RUN=Async | ID=7395)");
                return true;
            }
        }

        return false;
    }
}
