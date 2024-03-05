package net.therjabee.moremekanized.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.therjabee.moremekanized.MoreMekanized;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreMekanized.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MoreMekanized_TAB = CREATIVE_MODE_TABS.register("moremekanized_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Broken_Energy_Tablet.get()))
                    .title(Component.translatable("creativetab.moremekanized_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.Broken_Energy_Tablet.get());
                        pOutput.accept(ModItems.Unchargeable_Energy_Tablet.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}