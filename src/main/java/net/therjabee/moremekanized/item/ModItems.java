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

    public static final RegistryObject<Item> Alloy_Basic = ITEMS.register("alloy_basic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Alloy_Light_Absorbing = ITEMS.register("alloy_light_absorbing",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Alloy_Photonic = ITEMS.register("alloy_photonic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Alloy_Singular = ITEMS.register("alloy_singular",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Alloy_Spectral = ITEMS.register("alloy_spectral",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Andesite_Control_Circuit = ITEMS.register("andesite_control_circuit",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Basic_Control_Circuit = ITEMS.register("basic_control_circuit",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Light_Absorbing_Control_Circuit = ITEMS.register("light_absorbing_control_circuit",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Photonic_Control_Circuit = ITEMS.register("photonic_control_circuit",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Singular_Control_Circuit = ITEMS.register("singular_control_circuit",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Spectral_Control_Circuit = ITEMS.register("spectral_control_circuit",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
