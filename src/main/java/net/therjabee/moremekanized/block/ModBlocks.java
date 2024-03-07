package net.therjabee.moremekanized.block;


import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import mekanism.api.tier.ITier;
import mekanism.common.Mekanism;
import mekanism.common.block.BlockBounding;
import mekanism.common.block.BlockCardboardBox;
import mekanism.common.block.BlockEnergyCube;
import mekanism.common.block.BlockIndustrialAlarm;
import mekanism.common.block.BlockOre;
import mekanism.common.block.BlockPersonalBarrel;
import mekanism.common.block.BlockPersonalChest;
import mekanism.common.block.BlockRadioactiveWasteBarrel;
import mekanism.common.block.attribute.AttributeTier;
import mekanism.common.block.basic.BlockBin;
import mekanism.common.block.basic.BlockChargepad;
import mekanism.common.block.basic.BlockFluidTank;
import mekanism.common.block.basic.BlockLogisticalSorter;
import mekanism.common.block.basic.BlockResource;
import mekanism.common.block.basic.BlockStructuralGlass;
import mekanism.common.block.interfaces.IHasDescription;
import mekanism.common.block.prefab.BlockBase;
import mekanism.common.block.prefab.BlockBasicMultiblock;
import mekanism.common.block.prefab.BlockFactoryMachine;
import mekanism.common.block.prefab.BlockFactoryMachine.BlockFactory;
import mekanism.common.block.prefab.BlockFactoryMachine.BlockFactoryMachineModel;
import mekanism.common.block.prefab.BlockTile;
import mekanism.common.block.prefab.BlockTile.BlockTileModel;
import mekanism.common.block.transmitter.BlockDiversionTransporter;
import mekanism.common.block.transmitter.BlockLogisticalTransporter;
import mekanism.common.block.transmitter.BlockMechanicalPipe;
import mekanism.common.block.transmitter.BlockPressurizedTube;
import mekanism.common.block.transmitter.BlockRestrictiveTransporter;
import mekanism.common.block.transmitter.BlockThermodynamicConductor;
import mekanism.common.block.transmitter.BlockUniversalCable;
import mekanism.common.content.blocktype.BlockType;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.content.blocktype.Factory;
import mekanism.common.content.blocktype.FactoryType;
import mekanism.common.content.blocktype.Machine;
import mekanism.common.content.blocktype.Machine.FactoryMachine;
import mekanism.common.item.block.ItemBlockBin;
import mekanism.common.item.block.ItemBlockCardboardBox;
import mekanism.common.item.block.ItemBlockChemicalTank;
import mekanism.common.item.block.ItemBlockEnergyCube;
import mekanism.common.item.block.ItemBlockInductionCell;
import mekanism.common.item.block.ItemBlockInductionProvider;
import mekanism.common.item.block.ItemBlockLaserAmplifier;
import mekanism.common.item.block.ItemBlockPersonalStorage;
import mekanism.common.item.block.ItemBlockRadioactiveWasteBarrel;
import mekanism.common.item.block.ItemBlockResource;
import mekanism.common.item.block.ItemBlockSecurityDesk;
import mekanism.common.item.block.ItemBlockTooltip;
import mekanism.common.item.block.machine.ItemBlockFactory;
import mekanism.common.item.block.machine.ItemBlockFluidTank;
import mekanism.common.item.block.machine.ItemBlockLaserTractorBeam;
import mekanism.common.item.block.machine.ItemBlockMachine;
import mekanism.common.item.block.machine.ItemBlockQIOComponent;
import mekanism.common.item.block.machine.ItemBlockQIOComponent.ItemBlockQIOInventoryComponent;
import mekanism.common.item.block.machine.ItemBlockQuantumEntangloporter;
import mekanism.common.item.block.machine.ItemBlockTeleporter;
import mekanism.common.item.block.transmitter.ItemBlockDiversionTransporter;
import mekanism.common.item.block.transmitter.ItemBlockLogisticalTransporter;
import mekanism.common.item.block.transmitter.ItemBlockMechanicalPipe;
import mekanism.common.item.block.transmitter.ItemBlockPressurizedTube;
import mekanism.common.item.block.transmitter.ItemBlockRestrictiveTransporter;
import mekanism.common.item.block.transmitter.ItemBlockThermodynamicConductor;
import mekanism.common.item.block.transmitter.ItemBlockUniversalCable;
import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import mekanism.common.resource.BlockResourceInfo;
import mekanism.common.resource.IResource;
import mekanism.common.resource.PrimaryResource;
import mekanism.common.resource.ore.OreBlockType;
import mekanism.common.resource.ore.OreType;
import mekanism.common.tier.CableTier;
import mekanism.common.tier.ConductorTier;
import mekanism.common.tier.FactoryTier;
import mekanism.common.tier.PipeTier;
import mekanism.common.tier.TransporterTier;
import mekanism.common.tier.TubeTier;
import mekanism.common.tile.TileEntityBin;
import mekanism.common.tile.TileEntityChemicalTank;
import mekanism.common.tile.TileEntityEnergyCube;
import mekanism.common.tile.TileEntityFluidTank;
import mekanism.common.tile.TileEntityModificationStation;
import mekanism.common.tile.TileEntityPressureDisperser;
import mekanism.common.tile.TileEntityQuantumEntangloporter;
import mekanism.common.tile.TileEntitySecurityDesk;
import mekanism.common.tile.TileEntityTeleporter;
import mekanism.common.tile.factory.TileEntityFactory;
import mekanism.common.tile.laser.TileEntityLaser;
import mekanism.common.tile.laser.TileEntityLaserAmplifier;
import mekanism.common.tile.laser.TileEntityLaserTractorBeam;
import mekanism.common.tile.machine.TileEntityAntiprotonicNucleosynthesizer;
import mekanism.common.tile.machine.TileEntityChemicalCrystallizer;
import mekanism.common.tile.machine.TileEntityChemicalDissolutionChamber;
import mekanism.common.tile.machine.TileEntityChemicalInfuser;
import mekanism.common.tile.machine.TileEntityChemicalInjectionChamber;
import mekanism.common.tile.machine.TileEntityChemicalOxidizer;
import mekanism.common.tile.machine.TileEntityChemicalWasher;
import mekanism.common.tile.machine.TileEntityCombiner;
import mekanism.common.tile.machine.TileEntityCrusher;
import mekanism.common.tile.machine.TileEntityDigitalMiner;
import mekanism.common.tile.machine.TileEntityDimensionalStabilizer;
import mekanism.common.tile.machine.TileEntityElectricPump;
import mekanism.common.tile.machine.TileEntityElectrolyticSeparator;
import mekanism.common.tile.machine.TileEntityEnergizedSmelter;
import mekanism.common.tile.machine.TileEntityEnrichmentChamber;
import mekanism.common.tile.machine.TileEntityFluidicPlenisher;
import mekanism.common.tile.machine.TileEntityFormulaicAssemblicator;
import mekanism.common.tile.machine.TileEntityFuelwoodHeater;
import mekanism.common.tile.machine.TileEntityIsotopicCentrifuge;
import mekanism.common.tile.machine.TileEntityMetallurgicInfuser;
import mekanism.common.tile.machine.TileEntityNutritionalLiquifier;
import mekanism.common.tile.machine.TileEntityOredictionificator;
import mekanism.common.tile.machine.TileEntityOsmiumCompressor;
import mekanism.common.tile.machine.TileEntityPaintingMachine;
import mekanism.common.tile.machine.TileEntityPigmentExtractor;
import mekanism.common.tile.machine.TileEntityPigmentMixer;
import mekanism.common.tile.machine.TileEntityPrecisionSawmill;
import mekanism.common.tile.machine.TileEntityPressurizedReactionChamber;
import mekanism.common.tile.machine.TileEntityPurificationChamber;
import mekanism.common.tile.machine.TileEntityResistiveHeater;
import mekanism.common.tile.machine.TileEntityRotaryCondensentrator;
import mekanism.common.tile.machine.TileEntitySeismicVibrator;
import mekanism.common.tile.machine.TileEntitySolarNeutronActivator;
import mekanism.common.tile.multiblock.TileEntityBoilerCasing;
import mekanism.common.tile.multiblock.TileEntityBoilerValve;
import mekanism.common.tile.multiblock.TileEntityDynamicTank;
import mekanism.common.tile.multiblock.TileEntityDynamicValve;
import mekanism.common.tile.multiblock.TileEntityInductionCasing;
import mekanism.common.tile.multiblock.TileEntityInductionCell;
import mekanism.common.tile.multiblock.TileEntityInductionPort;
import mekanism.common.tile.multiblock.TileEntityInductionProvider;
import mekanism.common.tile.multiblock.TileEntitySPSCasing;
import mekanism.common.tile.multiblock.TileEntitySPSPort;
import mekanism.common.tile.multiblock.TileEntityStructuralGlass;
import mekanism.common.tile.multiblock.TileEntitySuperchargedCoil;
import mekanism.common.tile.multiblock.TileEntitySuperheatingElement;
import mekanism.common.tile.multiblock.TileEntityThermalEvaporationBlock;
import mekanism.common.tile.multiblock.TileEntityThermalEvaporationController;
import mekanism.common.tile.multiblock.TileEntityThermalEvaporationValve;
import mekanism.common.tile.qio.TileEntityQIODashboard;
import mekanism.common.tile.qio.TileEntityQIODriveArray;
import mekanism.common.tile.qio.TileEntityQIOExporter;
import mekanism.common.tile.qio.TileEntityQIOImporter;
import mekanism.common.tile.qio.TileEntityQIORedstoneAdapter;
import mekanism.common.util.EnumUtils;
import net.minecraft.stats.Stats;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.therjabee.moremekanized.MoreMekanized;
import org.jetbrains.annotations.NotNull;
import su.gamepoint.pocky.mekaevolution.MekanismEvolutionMod;
import su.gamepoint.pocky.mekaevolution.common.block.storages.energycube.EvoBlockEnergyCube;
import su.gamepoint.pocky.mekaevolution.common.block.storages.energycube.EvoItemBlockEnergyCube;
import su.gamepoint.pocky.mekaevolution.common.block.storages.energycube.EvoTileEntityEnergyCube;
import su.gamepoint.pocky.mekaevolution.common.block.transmitter.cable.EvoBlockUniversalCable;
import su.gamepoint.pocky.mekaevolution.common.block.transmitter.cable.EvoItemBlockUniversalCable;
import su.gamepoint.pocky.mekaevolution.common.block.transmitter.logisticaltransporter.EvoBlockLogisticalTransporter;
import su.gamepoint.pocky.mekaevolution.common.block.transmitter.logisticaltransporter.EvoItemBlockLogisticalTransporter;
import su.gamepoint.pocky.mekaevolution.common.block.transmitter.pipe.EvoBlockMechanicalPipe;
import su.gamepoint.pocky.mekaevolution.common.block.transmitter.pipe.EvoItemBlockMechanicalPipe;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockRegister {

    public static final BlockDeferredRegister REGISTRY_BLOCK = new BlockDeferredRegister(MoreMekanized.MOD_ID);

    private static <BLOCK extends Block, ITEM extends BlockItem> BlockRegistryObject<BLOCK, ITEM> registerTieredBlock(String tierName, String suffix, Supplier<? extends BLOCK> blockSupplier, Function<BLOCK, ITEM> itemCreator) {
        return REGISTRY_BLOCK.register(tierName + suffix, blockSupplier, itemCreator);
    }

    /*
    public static final BlockRegistryObject<EvoBlockUniversalCable, EvoItemBlockUniversalCable> ABSOLUTE_UNIVERSAL_CABLE = registerUniversalCable("absolute", CableTier.BASIC);;
    public static final BlockRegistryObject<EvoBlockUniversalCable, EvoItemBlockUniversalCable> SUPREME_UNIVERSAL_CABLE = registerUniversalCable("supreme", CableTier.ADVANCED, BlockBehaviour.Properties.of(Material.PISTON).strength(1.0F, 6.0F).lightLevel((l) -> 10));
    public static final BlockRegistryObject<EvoBlockUniversalCable, EvoItemBlockUniversalCable> COSMIC_UNIVERSAL_CABLE = registerUniversalCable("cosmic", CableTier.ELITE, BlockBehaviour.Properties.of(Material.PISTON).strength(1.0F, 6.0F).lightLevel((l) -> 13));
    public static final BlockRegistryObject<EvoBlockUniversalCable, EvoItemBlockUniversalCable> INFINITE_UNIVERSAL_CABLE = registerUniversalCable("infinite", CableTier.ULTIMATE, BlockBehaviour.Properties.of(Material.PISTON).strength(1.0F, 6.0F).lightLevel((l) -> 16));
     */

    /*
    public static final BlockRegistryObject<EvoBlockLogisticalTransporter, EvoItemBlockLogisticalTransporter> ABSOLUTE_LOGISTICAL_TRANSPORTER = registerLogisticalTransporter("absolute", TransporterTier.BASIC);
    public static final BlockRegistryObject<EvoBlockLogisticalTransporter, EvoItemBlockLogisticalTransporter> SUPREME_LOGISTICAL_TRANSPORTER = registerLogisticalTransporter("supreme", TransporterTier.ADVANCED);
    public static final BlockRegistryObject<EvoBlockLogisticalTransporter, EvoItemBlockLogisticalTransporter> COSMIC_LOGISTICAL_TRANSPORTER = registerLogisticalTransporter("cosmic", TransporterTier.ELITE);
    public static final BlockRegistryObject<EvoBlockLogisticalTransporter, EvoItemBlockLogisticalTransporter> INFINITE_LOGISTICAL_TRANSPORTER = registerLogisticalTransporter("infinite", TransporterTier.ULTIMATE);
     */

    /*
    public static final BlockRegistryObject<EvoBlockMechanicalPipe, EvoItemBlockMechanicalPipe> ABSOLUTE_MECHANICAL_PIPE = registerMechanicalPipe("absolute", PipeTier.BASIC);
    public static final BlockRegistryObject<EvoBlockMechanicalPipe, EvoItemBlockMechanicalPipe> SUPREME_MECHANICAL_PIPE = registerMechanicalPipe("supreme", PipeTier.ADVANCED);
    public static final BlockRegistryObject<EvoBlockMechanicalPipe, EvoItemBlockMechanicalPipe> COSMIC_MECHANICAL_PIPE = registerMechanicalPipe("cosmic", PipeTier.ELITE);
    public static final BlockRegistryObject<EvoBlockMechanicalPipe, EvoItemBlockMechanicalPipe> INFINITE_MECHANICAL_PIPE = registerMechanicalPipe("infinite", PipeTier.ULTIMATE);
     */


    public static final BlockRegistryObject<EvoBlockEnergyCube, EvoItemBlockEnergyCube> ABSOLUTE_ENERGY_CUBE = registerEnergyCube("absolute", BlockTypes.ABSOLUTE_ENERGY_CUBE);
    public static final BlockRegistryObject<EvoBlockEnergyCube, EvoItemBlockEnergyCube> SUPREME_ENERGY_CUBE = registerEnergyCube("supreme", BlockTypes.SUPREME_ENERGY_CUBE);
    public static final BlockRegistryObject<EvoBlockEnergyCube, EvoItemBlockEnergyCube> COSMIC_ENERGY_CUBE = registerEnergyCube("cosmic", BlockTypes.COSMIC_ENERGY_CUBE);
    public static final BlockRegistryObject<EvoBlockEnergyCube, EvoItemBlockEnergyCube> INFINITE_ENERGY_CUBE = registerEnergyCube("infinite", BlockTypes.INFINITE_ENERGY_CUBE);

    private static BlockRegistryObject<EvoBlockEnergyCube, EvoItemBlockEnergyCube> registerEnergyCube(String tileName, Machine<EvoTileEntityEnergyCube> type) {
        return registerTieredBlock(tileName, "_energy_cube", () -> new EvoBlockEnergyCube(type), EvoItemBlockEnergyCube::new);
    }

    /*
    private static BlockRegistryObject<EvoBlockMechanicalPipe, EvoItemBlockMechanicalPipe> registerMechanicalPipe(String tierName, PipeTier tier) {
        return registerTieredBlock(tierName, "_mechanical_pipe", () -> new EvoBlockMechanicalPipe(tier), EvoItemBlockMechanicalPipe::new);
    }
    */

    /*
    private static BlockRegistryObject<EvoBlockLogisticalTransporter, EvoItemBlockLogisticalTransporter> registerLogisticalTransporter(String tierName, TransporterTier tier) {
        return registerTieredBlock(tierName, "_logistical_transporter", () -> new EvoBlockLogisticalTransporter(tier), EvoItemBlockLogisticalTransporter::new);
    }
    */

    /*
    private static BlockRegistryObject<EvoBlockUniversalCable, EvoItemBlockUniversalCable> registerUniversalCable(String tierName, CableTier tier) {
        return registerTieredBlock(tierName, "_universal_cable", () -> new EvoBlockUniversalCable(tier), EvoItemBlockUniversalCable::new);
    }
    */

    /*
    private static BlockRegistryObject<EvoBlockUniversalCable, EvoItemBlockUniversalCable> registerUniversalCable(String tierName, CableTier tier, BlockBehaviour.Properties properties) {
        return registerTieredBlock(tierName, "_universal_cable", () -> new EvoBlockUniversalCable(tier, properties), EvoItemBlockUniversalCable::new);
    }
     */

}