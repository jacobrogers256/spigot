package net.minecraft.data.worldgen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.MinecraftKey;
import net.minecraft.world.level.levelgen.structure.pools.WorldGenFeatureDefinedStructurePoolStructure;
import net.minecraft.world.level.levelgen.structure.pools.WorldGenFeatureDefinedStructurePoolTemplate;

public class WorldGenFeatureBastionBridge {

    public WorldGenFeatureBastionBridge() {}

    public static void bootstrap() {}

    static {
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/bridge/starting_pieces"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/starting_pieces/entrance", ProcessorLists.ENTRANCE_REPLACEMENT), 1), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/starting_pieces/entrance_face", ProcessorLists.BASTION_GENERIC_DEGRADATION), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/bridge/bridge_pieces"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/bridge_pieces/bridge", ProcessorLists.BRIDGE), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/bridge/legs"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/legs/leg_0", ProcessorLists.BASTION_GENERIC_DEGRADATION), 1), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/legs/leg_1", ProcessorLists.BASTION_GENERIC_DEGRADATION), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/bridge/walls"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/walls/wall_base_0", ProcessorLists.RAMPART_DEGRADATION), 1), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/walls/wall_base_1", ProcessorLists.RAMPART_DEGRADATION), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/bridge/ramparts"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/ramparts/rampart_0", ProcessorLists.RAMPART_DEGRADATION), 1), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/ramparts/rampart_1", ProcessorLists.RAMPART_DEGRADATION), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/bridge/rampart_plates"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/rampart_plates/plate_0", ProcessorLists.RAMPART_DEGRADATION), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeaturePieces.register(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("bastion/bridge/connectors"), new MinecraftKey("empty"), ImmutableList.of(Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/connectors/back_bridge_top", ProcessorLists.BASTION_GENERIC_DEGRADATION), 1), Pair.of(WorldGenFeatureDefinedStructurePoolStructure.single("bastion/bridge/connectors/back_bridge_bottom", ProcessorLists.BASTION_GENERIC_DEGRADATION), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
    }
}
