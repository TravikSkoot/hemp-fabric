package de.travikskoot.hemp.screen.custom;

import de.travikskoot.hemp.screen.HempScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class RollingTrayScreenHandler extends ScreenHandler {

    private final Inventory inventory;

    public RollingTrayScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(19));
    }

    public RollingTrayScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(HempScreenHandlers.ROLLING_TRAY_SCREEN_HANDLER, syncId);
        checkSize(inventory, 19);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        this.addSlot(new Slot(inventory, 0, 8, 17));
        this.addSlot(new Slot(inventory, 1, 26, 17));
        this.addSlot(new Slot(inventory, 2, 44, 17));
        this.addSlot(new Slot(inventory, 3, 62, 17));
        this.addSlot(new Slot(inventory, 4, 80, 17));
        this.addSlot(new Slot(inventory, 5, 98, 17));
        this.addSlot(new Slot(inventory, 6, 8, 35));
        this.addSlot(new Slot(inventory, 7, 26, 35));
        this.addSlot(new Slot(inventory, 8, 44, 35));
        this.addSlot(new Slot(inventory, 9, 62, 35));
        this.addSlot(new Slot(inventory, 10, 80, 35));
        this.addSlot(new Slot(inventory, 11, 98, 35));
        this.addSlot(new Slot(inventory, 12, 8, 53));
        this.addSlot(new Slot(inventory, 13, 26, 53));
        this.addSlot(new Slot(inventory, 14, 44, 53));
        this.addSlot(new Slot(inventory, 15, 62, 53));
        this.addSlot(new Slot(inventory, 16, 80, 53));
        this.addSlot(new Slot(inventory, 17, 98, 53));

        this.addSlot(new Slot(inventory, 18, 148, 35));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int m = 0; m < 3; ++m) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
