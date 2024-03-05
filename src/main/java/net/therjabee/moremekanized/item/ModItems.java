package net.therjabee.moremekanized.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.therjabee.moremekanized.MoreMekanized;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoreMekanized.MOD_ID);

    public static final RegistryObject<Item> Broken_Energy_Tablet = ITEMS.register("broken_energy_tablet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Unchargeable_Energy_Tablet = ITEMS.register("unchargeable_energy_tablet",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
