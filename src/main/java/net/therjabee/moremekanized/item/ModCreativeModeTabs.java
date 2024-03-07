package net.therjabee.moremekanized.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.therjabee.moremekanized.MoreMekanized;
import net.therjabee.moremekanized.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreMekanized.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MoreMekanized_TAB = CREATIVE_MODE_TABS.register("moremekanized_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Broken_Energy_Tablet.get()))
                    .title(Component.translatable("creativetab.moremekanized_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.Broken_Energy_Tablet.get());
                        pOutput.accept(ModItems.Unchargeable_Energy_Tablet.get());
                        pOutput.accept(ModItems.Alloy_Basic.get());
                        pOutput.accept(ModItems.Alloy_Light_Absorbing.get());
                        pOutput.accept(ModItems.Alloy_Photonic.get());
                        pOutput.accept(ModItems.Alloy_Singular.get());
                        pOutput.accept(ModItems.Alloy_Spectral.get());
                        pOutput.accept(ModItems.Andesite_Control_Circuit.get());
                        pOutput.accept(ModItems.Basic_Control_Circuit.get());
                        pOutput.accept(ModItems.Light_Absorbing_Control_Circuit.get());
                        pOutput.accept(ModItems.Photonic_Control_Circuit.get());
                        pOutput.accept(ModItems.Singular_Control_Circuit.get());
                        pOutput.accept(ModItems.Spectral_Control_Circuit.get());

                        pOutput.accept(ModBlocks.Spectral_Energy_Cube.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
