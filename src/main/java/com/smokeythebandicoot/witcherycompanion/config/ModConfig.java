package com.smokeythebandicoot.witcherycompanion.config;

import com.smokeythebandicoot.witcherycompanion.WitcheryCompanion;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.HashSet;

@Config(modid = WitcheryCompanion.MODID, name = "witchery_patches")
@Mod.EventBusSubscriber(modid = WitcheryCompanion.MODID)
public class ModConfig {

    @Config.Comment("Patches configuration.\n" +
            "Bugfixes fix bugs and crashes, and are enabled by default.\n" +
            "Tweaks alter the behaviour of Witchery, and are disabled by default")
    @Config.Name("Patches Configuration")
    public static PatchesConfiguration mixins;

    @Config.Name("Integration Configuration")
    public static IntegrationConfigurations integrations;


    public static class PatchesConfiguration {

        @Config.Comment("Configuration for common bugs")
        @Config.Name("Common Tweaks")
        public static CommonTweaks common;

        @Config.Comment("Configuration for patches related to brews and brew effects")
        @Config.Name("Brews Tweaks")
        public static BrewsTweaks brews;

        @Config.Comment("Configuration for patches related to infusions")
        @Config.Name("Infusion Tweaks")
        public static InfusionTweaks infusions;

        @Config.Comment("Configuration for patches related to Blocks")
        @Config.Name("Block Tweaks")
        public static BlockTweaks blocks;

        @Config.Comment("Configuration for patches related to Items")
        @Config.Name("Item Tweaks")
        public static ItemTweaks items;

        @Config.Comment("Configuration for patches related to Rites")
        @Config.Name("Rites Tweaks")
        public static RitesTweaks rites;

        @Config.Comment("Configuration for patches related to Potions")
        @Config.Name("Potion Tweaks")
        public static PotionTweaks potions;

        @Config.Comment("Configuration for patches related to Books")
        @Config.Name("Book Tweaks")
        public static BookTweaks books;

        @Config.Comment("Configuration for patches related to Entities")
        @Config.Name("Entity Tweaks")
        public static EntityTweaks entities;

        @Config.Comment("Configuration for patches related to Loot")
        @Config.Name("Loot Tweaks")
        public static LootTweaks loot;

        @Config.Comment("Configuration for patches related to Dimensions")
        @Config.Name("Dimension Tweaks")
        public static DimensionTweaks dimensions;

        @Config.Comment("Configuration for patches related to World Generation")
        @Config.Name("Worldgen Tweaks")
        public static WorldGenTweaks worldgen;


        public static class BrewsTweaks {

            @Config.Comment("Configuration for patches related to Triggered Dispersal")
            @Config.Name("Triggered Dispersal Tweaks")
            public static TriggeredDispersalTweaks triggeredDispersal;

            @Config.Comment("Needs to be enabled for some Brew Patches to work. Enabled for extended flexibility on when certain" +
                    "brews should be applied")
            @Config.Name("Common - Extend Flexibility")
            public static boolean common_tweakBrewApplications = true;

            @Config.Comment("Disables Strength Ceiling. Fixes some 'non-bugs' related to Potion Brews not scaling their " +
                    "effects despite their power increasing (Harm I deals same damage as Harm III)")
            @Config.Name("Common - Disable Strength Ceiling")
            public static boolean common_tweakDisableStrengthCeiling = true;

            @Config.Comment("If true, fixes Cauldron rituals with Liquid Dispersal not having any effect. Also" +
                    " should improve performance and memory usage by 0.00000001%")
            @Config.Name("Liquid Dispersal - Fix Cauldron Ritual No Effect")
            public static boolean common_fixCauldronRitualLiquidDispersalNoEffect = true;

            @Config.Comment("If true, fixes the brew from breaking blocks even if the 'ignore blocks' modifier has been added")
            @Config.Name("Brew of Blast - Fix Terrain Damage")
            public static boolean blast_fixExplosionBreakingBlocks = true;

            @Config.Comment("Fixes brew of erosion crash while attempting to generate a random int with a negative bound")
            @Config.Name("Brew of Erosion - Fix Random Integer Bound Crash")
            public static boolean erosion_fixRandomIntegerCrash = true;

            @Config.Comment("If true, it adds more blocks to the unbreakable blocks list (Torment floor and portal, Mirror walls, etc.)")
            @Config.Name("Brew of Erosion - Fix Breaking Unbreakable Blocks")
            public static boolean erosion_fixUnbreakables = true;

            @Config.Comment("If true, gives CraftTweaker integration total control about which blocks can be mined or destroyed, " +
                    "enabling a much more in-depth customizability. If set to True, but no script changes it, behaviour is default Witchery")
            @Config.Name("Brew of Erosion - Tweak Effect With Crafttweaker")
            public static boolean erosion_tweakEnableCrafttweaker = true;

            @Config.Comment("Fixes crash if players accidentally drink the potion instead of throwing it")
            @Config.Name("Brew of Frogs Tongue - Fix Pull Null Entity Crash")
            public static boolean frogsTongue_fixPullNullEntity = true;

            @Config.Comment("Fixes entities suffocating while traversing blocks removed by Tidal Hold brew")
            @Config.Name("Brew of Tidal Hold - Fix Entity Suffocation")
            public static boolean tidalHold_fixEntitySuffocation = true;

            @Config.Comment("Fixes some dispersal methods of the brew of raising causing a crash")
            @Config.Name("Brew of Raising - Fix Null Player Name Crash")
            public static boolean raising_fixNullPlayerName = true;

            public static class TriggeredDispersalTweaks {

                @Config.Comment("If true, Companion will replace the entire logic and inner workings of the Triggered " +
                        "Dispersal. This will make this dispersal work in the first place and improves several aspects")
                @Config.Name("Common - Enable Trigger Dispersal Rework")
                public static boolean enable_dispersalRework = true;

                @Config.Comment("If true, Doors will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Door")
                public static boolean enable_door = true;

                @Config.Comment("If true, Trap Doors will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Trap Door")
                public static boolean enable_trapdoor = true;

                @Config.Comment("If true, Levers will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Lever")
                public static boolean enable_lever = true;

                @Config.Comment("If true, Buttons will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Button")
                public static boolean enable_button = true;

                @Config.Comment("If true, Pressure Plates will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Pressure Plate")
                public static boolean enable_pressurePlate = true;

                @Config.Comment("If true, Fence Gates will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Fence Gate")
                public static boolean enable_fenceGate = true;

                @Config.Comment("If true, Tripwires will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Tripwire")
                public static boolean enable_tripwireHook = true;

                @Config.Comment("If true, Chests will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Chest")
                public static boolean enable_chest = true;

                @Config.Comment("If true, Ender Chests will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Ender Chest")
                public static boolean enable_enderChest = true;

                @Config.Comment("If true, Crafting Tables will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Crafting Table")
                public static boolean enable_craftingTable = true;

                @Config.Comment("If true, Beds will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Bed")
                public static boolean enable_beds = true;

                @Config.Comment("If true, Grasspers will be able to be cursed with Triggered Dispersal brews")
                @Config.Name("Triggered Dispersal - Grassper")
                public static boolean enable_grasspers = true;

            }
        }

        public static class InfusionTweaks {

            @Config.Comment("Fixes weird behaviour when Alohomora is used on Rowan Doors")
            @Config.Name("Alohomora Symbol Effect - Fix Effect On Rowan Doors")
            @Config.RequiresMcRestart
            public static boolean alohomora_fixOnRowanDoors = true;

            @Config.Comment("Fixes doors having different hinge position and facing on transformation")
            @Config.Name("Colloportus Symbol Effect - Fix Preserve Door Properties")
            @Config.RequiresMcRestart
            public static boolean colloportus_fixPreserveDoorProperties = true;

            @Config.Comment("Fix Soul Infusions progress reset when player dies")
            @Config.Name("Soul Brews - Fix Persistency After Death")
            @Config.RequiresMcRestart
            public static boolean soulBrews_fixPersistency = true;

            @Config.Comment("Fixes crashes due to bosses using disabled spells")
            @Config.Name("Symbol Effects - Fix Bosses Using Disabled Spells")
            @Config.RequiresMcRestart
            public static boolean symbolEffects_fixBossesUsingDisabledSpells = true;

            @Config.Comment("Sets the amount of ticks between Sentinel effect activations")
            @Config.Name("Sentinel Effect - Tweak Cooldown")
            public static int infusedSpiritSentinel_tweakCooldown = 600;

            @Config.Comment("Sets the amount of ticks between Twister effect activations")
            @Config.Name("Twister Effect - Tweak Cooldown")
            public static int infusedSpiritTwister_tweakCooldown = 10;

        }

        public static class CommonTweaks {

            @Config.Comment("Custom Recipes in Mods' data folder is fundamentally broken in W:R. If true, this fixes " +
                    "resource loading and allows Mod Authors to define custom .jsons and override custom ones in " +
                    "resources/data/<modid>/brewing|mutations|... folders, creating custom recipes. This does not " +
                    "touch data folders inside of the World save folder" )
            @Config.Name("Custom Recipes - Fix Resource Loading")
            public static boolean customRecipes_fixResourceLoading = true;

            @Config.Comment("Fix crash when trying to pull a null entity. Overshadows Frogs Tongue brew fix")
            @Config.Name("Entity Utils - Fix Null Pointer On Pull Entity")
            public static boolean entityUtils_fixNullPointer = true;

            @Config.Comment("Fix crash when loot function is applied and a Null Random is passed to it (JER does this)")
            @Config.Name("Loot Utils - Fix NPE on JER Integration")
            public static boolean levelledRandomEnchant_fixCrashNullRandom = true;

            @Config.Comment("If true, Witchery:Resurrected won't disable flight when the player is not in a Creature " +
                    "form  that is capable to fly (eg. Vampire in bat form) but is still capable to fly due to other " +
                    "mods (Avaritia infinity armor, Morph flying mobs, etc) when certain events happen (dimension " +
                    "change), player change form, etc")
            @Config.Name("Flight - Preserve Flight Capability")
            public static boolean flight_preserveFlightCapability = true;

            @Config.Comment("Fix crash an Entity (such as Lord of Torment, or Lilith) uses a Spell that has been disabled. " +
                    "As a side effect of enabling this, spell projectiles will have a default size and a random color.")
            @Config.Name("Spell Effect Render - Fix Crash On Disabled Spell Cast")
            public static boolean renderSpellEffect_fixCrashOnDisabledSpell = true;

            @Config.Comment("If true, reduces to a single line an exception logging occuring because a Spell Effect " +
                    "has been disabled in config. As the log spam only happens at load-time, this option requires a MC restart")
            @Config.Name("Spell Effect - Tweak Reduce Logging On Disabled Effects")
            @Config.RequiresMcRestart
            public static boolean spellEffect_tweakMuteLogSpamOnDisable = true;

            @Config.Comment("Fix 'ghost entities' being rendered in world when player changes dimension")
            @Config.Name("Shape Shifting - Fix Floating Entities")
            public static boolean shapeShift_fixFloatingEntities = true;

            @Config.Comment("If true, when player shapeshifts into a form that has more HP, its health percentage is perserved")
            @Config.Name("Shape Shifting - Tweak Preserve HP Ratio on Trasform")
            public static boolean shapeShift_tweakPreserveHpPercentOnTransform = false;

            @Config.Comment("If true, when player transforms back into its normal form, its health percentage is perserved")
            @Config.Name("Shape Shifting - Tweak Preserve HP Ratio on Detransform")
            public static boolean shapeShift_tweakPreserveHpPercentOnDetransform = false;

            @Config.Comment("Fixes an edge-case crash that happens when villagers try to sleep")
            @Config.Name("Villager - Fix Crash On Sleeping")
            public static boolean villagerExtendedData_fixCrashOnSleeping = true;

            @Config.Comment("Disallow Elytra usage when the entity is Resized or Transformed")
            @Config.Name("Elytra - Disallow When Resized Or Transformed")
            public static boolean tweak_disallowElytraWhenTransformedOrResized = true;

        }

        public static class BlockTweaks {

            @Config.Comment("Fix Altar blocks requiring to get broken and re-placed to work properly again")
            @Config.Name("Altar - Fix Power Source Persistence")
            public static boolean altar_fixPowerSourcePersistency = true;

            @Config.Comment("If true, implements caching for Altar Power Source map, improving TPS." +
                    "NOTE: Required for CraftTweaker integration for Custom Power Sources")
            @Config.Name("Altar - Tweak Cache Power Source Map")
            public static boolean altar_tweakCachePowerMap = true;

            @Config.Comment("Fixes fetish blocks not dropping when they are harvested due to TileEntity being null " +
                    "when the getDrops method is called")
            @Config.Name("Block Fetish - Fix No Drops on Harvest")
            public static boolean blockFetish_fixNoDropsOnHarvest = true;

            @Config.Comment("Fixes fetish blocks resetting their data on world reload or when many blocks are " +
                    "updated at once, including Players bound to them")
            @Config.Name("Block Fetish - Fix Data Loss on World Reload")
            public static boolean blockFetish_fixMissingDataOnWorldReload = true;

            @Config.Comment("If true, fixes a crash involving mods trying to get the Circle Glyph blockstate from the " +
                    "Chalk metadata (for example, FutureMC bees)")
            @Config.Name("Circle Glyph - Fix Out Of Bounds Crash")
            public static boolean circleGlyph_fixOutOfBoundsCrash = true;

            @Config.Comment("Fix an edge case where the coffin would not have a color associated with it, causing a crash.")
            @Config.Name("Coffin - Fix Edge Case Crash")
            public static boolean coffin_fixEdgeCrash = true;

            @Config.Comment("Cursed Blocks are not fully implemented. If you enable this, they still won't work, but " +
                    "at least they should not crash the game as often")
            @Config.Name("Cursed Blocks - Fix Null Brew Action List Crash")
            public static boolean cursedBlock_fixNullActionListCrash = true;

            @Config.Comment("Fix crash when one of the coffin pieces is moved by a piston.")
            @Config.Name("Coffin - Fix Crash When Moved By Piston")
            public static boolean coffin_fixPistonMoveCrash = true;

            @Config.Comment("If true, enables Crafttweaker integration for Kettle. Defaults to true, " +
                    "as if enabled and not used does not alter Witchery behaviour")
            @Config.Name("Kettle - Tweak Enable Crafttweaker Integration")
            public static boolean kettle_tweakCustomHeatSources = true;

            @Config.Comment("Fix brews getting thrown immediately upon right-clicking the Kettle with a single empty bottle.")
            @Config.Name("Kettle - Fix Brews Thrown Upon Creation")
            public static boolean kettle_fixThrowBrewsUponCreation = true;

            @Config.Comment("Fix true, it will prevent Mandrake entities from spawning when harvesting non-mature mandrake crops.")
            @Config.Name("Mandrake Crop - Fix Drop Even When Not Mature")
            public static boolean mandrakeCrop_fixMandrakeSpawningNotMature = true;

            @Config.Comment("Fix Arthana, Pentacle and other items placed on top of the altar not dropping when " +
                    "the altar block below them is broken.")
            @Config.Name("Placed Items - Fix No Drops")
            public static boolean placedItems_fixNoDrops = true;

            @Config.Comment("If true, fixes a crash the player joins a world where an Altar with placed items on top are " +
                    "in its view in the first rendered frame.")
            @Config.Name("Placed Items - Fix Not Initialized Crash")
            public static boolean placedItems_fixNotInitializedCrash = true;

            @Config.Comment("If true, fix popper rendering, displaying them the right way up")
            @Config.Name("Poppet Shelf - Fix Upside-down Poppets")
            public static boolean poppetShelf_fixUpsideDownPoppetRendering = true;

            @Config.Comment("If true, disables the chunkloading behaviour of Poppet Shelves, requiring external " +
                    "chunkloading to be active when a Player is not nearby")
            @Config.Name("Poppet Shelf - Tweak Disable Chunkloading")
            public static boolean poppetShelf_tweakDisableChunkloading = false;

            @Config.Comment("Workaround for Stockade blocks. When player head gets too close, the entire" +
                    "screen is rendered as a stockade side texture. This patch enlarges the stockade bounding" +
                    "box to make player head not get as close.")
            @Config.Name("Stockade - Fix Bounding Box")
            public static boolean stockade_fixBoundingBox = true;

            @Config.Comment("If true, fix player bottling skill increase, which won't happen otherwise.")
            @Config.Name("Witch's Cauldron - Fix Bottling Skill Increase")
            public static boolean witchsCauldron_fixBottlingSkillIncrease = true;

            @Config.Comment("If true, fix right-clicking on the cauldron with a bucket voiding its contents.")
            @Config.Name("Witch's Cauldron - Fix Bucket Voiding Brew")
            public static boolean witchsCauldron_fixBucketVoidingBrew = true;

            @Config.Comment("If true, fixes a dupe where the same item can be tossed into multiple adjacent cauldrons.")
            @Config.Name("Witch's Cauldron - Fix Multiple Cauldron Dupe")
            public static boolean witchsCauldron_fixMultipleCauldronDupe = true;

            @Config.Comment("If true, fixes an infinite water exploit that works by right-clicking with an empty " +
                    "bucket an empty cauldron, filling the bucket with water.")
            @Config.Name("Witch's Cauldron - Fix Unlimited Water")
            public static boolean witchsCauldron_fixUnlimitedWaterWhenEmpty = true;

            @Config.Comment("If true, enables Crafttweaker integration for Witch's Cauldron. Defaults to true, " +
                    "as if enabled and not used does not alter Witchery behaviour")
            @Config.Name("Witch's Cauldron - Tweak Enable Crafttweaker Integration")
            public static boolean witchsCauldron_tweakCustomHeatSources = true;

            @Config.Comment("If true, disables Forge capability system that other mods might add to fluid containers " +
                    "such as Glass Bottles, as they can create some incompatibilities. This disables such capability " +
                    "only for Witch's Cauldron, causing it to ignore the capability, rather than disabling it")
            @Config.Name("Witch's Cauldron - Tweak Disable Fluid Handler Capability")
            public static boolean witchsCauldron_tweakIgnoreFluidHandlers = false;

            @Config.Comment("If true, sets the glass bottle fluid size to 250 instead of the default 333/334 (depending " +
                    "if the action is filling or draining the cauldron). This makes numbers cleaner, as now 4 bottles " +
                    "make up a bucket. Recommended to set to true")
            @Config.Name("Witch's Cauldron - Tweak Smaller Bottle")
            public static boolean witchsCauldron_tweakSmallerBottle = false;
        }

        public static class ItemTweaks {

            @Config.Comment("If true, allows CraftTweaker integration with Bark Belt")
            @Config.Name("Bark Belt - Tweak Enable Crafttweaker Integration")
            public static boolean barkBelt_tweakCraftTweakerIntegration = true;

            @Config.Comment("If true, players will be able to use the Creative Medallion even if not in creative mode")
            @Config.Name("Creative Medallion - Tweak Disable Creative Requirement")
            public static boolean creativeMedallion_tweakDisableCreativeRequirement = false;

            @Config.Comment("If true, Spectral Stones won't dupe the entity they contain")
            @Config.Name("Spectral Stone - Fix Entity Dupe Exploit")
            public static boolean spectralStone_fixEntityReleaseExploit = true;

            @Config.Comment("If true, set max stack size of all chalk items to 1, regardless of damage. " +
                    "Workaround for some chalk-stacking related bugs")
            @Config.Name("Chalk - Tweak Unstackable Chalk")
            public static boolean itemChalk_tweakUnstackableChalk = false;

            @Config.Comment("If true, the Brew of Erosion item crafted in the kettle will behave exactly like the " +
                    "Brew of Erosion crafted into the Witch's Cauldron")
            @Config.Name("Brew of Erosion Item - Tweak Emulate Erosion Brew")
            public static boolean itemErosionBrew_tweakEmulateBrewEffects = false;

            @Config.Comment("If true, this poppet won't be able to affect players")
            @Config.Name("Poppet Item - Disable PVP")
            public static boolean poppetItem_tweakDisablePvP = false;

            @Config.Comment("If true, this poppet won't be able to affect non-player entities")
            @Config.Name("Poppet Item - Disable PVE")
            public static boolean poppetItem_tweakDisablePvE = false;

            @Config.Comment("If true, a tooltip will be added to all Poppets informing the players about what entities " +
                    "are affected by the poppet")
            @Config.Name("Poppet Item - Disable PVE")
            public static boolean poppetItem_tweakAddTargetRestrictionTooltip = false;

            @Config.Comment("If true, fixes a crash that happens when a Poppet Protection Poppet protects its owner")
            @Config.Name("Poppet Protection Poppet - Fix Crash on Protect")
            public static boolean poppetProtectionPoppet_fixCrashOnProtect = true;

            @Config.Comment("Represents the amount of damage that the poppet takes when it protects its owner from a " +
                    "curse. Default 350 (Vanilla Witchery value). Needs voodooProtectionPoppet_fixCrashOnCurseProtect=true to work")
            @Config.Name("Poppet Protection Poppet - Tweak Damage Taken on Protect")
            public static int poppetProtectionPoppet_tweakDamageTakenOnProtect = 350;

            @Config.Comment("If true, fixes a crash that happens when a Voodoo Protection Poppet protects its owner")
            @Config.Name("Voodoo Protection Poppet - Fix Crash on Protect")
            public static boolean voodooProtectionPoppet_fixCrashOnCurseProtect = true;

            @Config.Comment("Represents the amount of damage that the poppet takes when it protects its owner from a " +
                    "curse. Default 350 (Vanilla Witchery value). Needs voodooProtectionPoppet_fixCrashOnCurseProtect=true to work")
            @Config.Name("Voodoo Protection Poppet - Tweak Damage Taken on Protect")
            public static int voodooProtectionPoppet_tweakDamageTaken = 350;

            @Config.Comment("If true, when the Seer Stone is shift-right-clicked Throwing Skills won't be printed, " +
                    "as it is a mechanic not yet implemented in Witchery: Resurrected")
            @Config.Name("Seer Stone - Tweak Unprint Throwing Skills")
            public static boolean seerStone_tweakUnprintThrowingSkill = false;

        }

        public static class RitesTweaks {

            @Config.Comment("Multiplies the damage taken by a Voodoo Protection Poppet when the owner is protected by " +
                    "this ritual. Default: 6")
            @Config.Name("Rite of Blight - Tweak Strength")
            @Config.RangeInt(min = 1, max = 16)
            public static int blight_tweakStrength = 6;

            @Config.Comment("Multiplies the damage taken by a Voodoo Protection Poppet when the owner is protected by " +
                    "this ritual. Default: 6")
            @Config.Name("Rite of Blindness - Tweak Strength")
            @Config.RangeInt(min = 1, max = 16)
            public static int blindness_tweakStrength = 6;

            @Config.Comment("If true, fixes an edge case when it was not possible to determine the rite's foci's block location")
            @Config.Name("Rite of Broken Earth - Fix NPE on Null Foci Location")
            public static boolean brokenEarth_fixNPEOnNullFociLocation = true;

            @Config.Comment("If true, Rite of Broken Earth will only break things that can be broken with a Brew of " +
                    "Erosion, including (if enabled) CraftTweaker-defined blockstates")
            @Config.Name("Rite of Broken Earth - Tweak Align Breakables With Erosion")
            public static boolean brokenEarth_tweakAlignBreakablesWithErosion = false;

            @Config.Comment("Multiplies the damage taken by a Voodoo Protection Poppet when the owner is protected by " +
                    "this ritual. Default: 1. Witchery applies a strength of 1, if the levelBuff is zero, 3 otherwise. " +
                    "This factor multiplies the value given by Witchery")
            @Config.Name("Rite Curse Creature - Tweak Strength")
            @Config.RangeInt(min = 1, max = 16)
            public static int curseCreature_tweakStrength = 1;

            @Config.Comment("Multiplies the damage taken by a Voodoo Protection Poppet when the owner is protected by " +
                    "this ritual. Default: 3")
            @Config.Name("Rite Curse of The Wolf - Tweak Strength")
            @Config.RangeInt(min = 1, max = 16)
            public static int curseOfTheWolf_tweakStrength = 3;

            @Config.Comment("If true, the Rite of Moving Earth disables moving TileEntities, preventing crashes, bugs and dupes")
            @Config.Name("Rite of Moving Earth - Fix Crash/Dupes while Moving TileEntities")
            public static boolean movingEarth_tweakDisableMovingTEs = true;

            @Config.Comment("If true, the Rite of Moving Earth won't shift blocks upwards if there are obstructions. This will prevent voiding blocks")
            @Config.Name("Rite of Moving Earth - Fix Destroying Blocks")
            public static boolean movingEarth_tweakDisableVoidingBlocks = true;

            @Config.Comment("Set the Ritual of Moving Earth refund policy. Below, the valid values:\n" +
                    "0: never refound the player (default Witchery Behaviour)\n" +
                    "1: if the ritual doesn't move the upwards by its full extent, refund the player\n" +
                    "2: refund only if the rite has not moved any block")
            @Config.Name("Rite of Moving Earth - Tweak Rite Refund Policy")
            public static int movingEarth_tweakRefundPolicy = 0;

            @Config.Comment("A list of blockstates that the Rite of Moving earth won't be able to move.\n" +
                    "Can only restrict more blocks, so Altars, Bedrock and some others won't be moved regardless")
            @Config.Name("Rite of Moving Earth - Tweak Block Blacklist")
            public static String[] movingEarth_tweakBlockBlacklist = new String[] { };

            @Config.Comment("If true, smoke particles and sounds will be played for blocks that won't be moved")
            @Config.Name("Rite of Moving Earth - Tweak Show Particles On Failure")
            public static boolean movingEarth_tweakFailIndicators = false;

            @Config.Comment("If true, when player opens a container the Witchery-added NBT for rite of Prior " +
                    "Incarnation is removed, as it wouldn't be of any use regardless")
            @Config.Name("Rite of Prior Incarnation - Fix NBT Persisting After Pickup")
            @Config.RequiresMcRestart
            public static boolean ritePriorIncarnation_fixNbtNotRemoved = true;

            @Config.Ignore
            public static HashSet<IBlockState> movingEarth_stateBlacklist = new HashSet<>();
        }

        public static class PotionTweaks {

            @Config.Comment("If true, fixes entities not moving after they have been spawned")
            @Config.Name("Insanity Potion - Fix Ghost Entities")
            public static boolean insanity_fixGhostEntities = true;

            @Config.Comment("Fixes Potion of Fortune not working because of wrong TileEntity check")
            @Config.Name("Fortune Potion - Fix No Effect")
            public static boolean fortunePotion_fixNoEffect = true;

            @Config.Comment("Fixes Potion of Resizing not working on players")
            @Config.Name("Resizing Potion - Fix No Effect On Players")
            public static boolean resizing_fixEffectOnPlayers = true;

            @Config.Comment("If true, enables custom sizes for the Resizing Potion. Values are defined in this config. " +
                    "NOTE 1: Enabling this will already chance Witchery default sizes, as they are determined by a formula." +
                    "NOTE 2: If this value is set to below ~0.42f, the players can x-ray through blocks they are directly " +
                    "touching and looking towards. Setting values to below this threshold is not recommended." +
                    "NOTE 3: If this value is set to ~10.0f or higher, the camera will clip into the player's head")
            @Config.Name("Resizing Potion - Tweak Custom Sizes")
            public static boolean resizing_tweakCustomSizes = false;

            @Config.Comment("Sets the custom scale for the Smallest size of the resizing potion")
            @Config.Name("Resizing Potion - Tweak Size Smallest")
            public static float resizing_tweakCustomSizeSmallest = 0.5f;

            @Config.Comment("Sets the custom scale for the Smaller size of the resizing potion")
            @Config.Name("Resizing Potion - Tweak Size Smaller")
            public static float resizing_tweakCustomSizeSmaller = 0.75f;

            @Config.Comment("Sets the custom scale for the Bigger size of the resizing potion")
            @Config.Name("Resizing Potion - Tweak Size Bigger")
            public static float resizing_tweakCustomSizeBigger = 1.5f;

            @Config.Comment("Sets the custom scale for the Biggest size of the resizing potion")
            @Config.Name("Resizing Potion - Tweak Size Biggest")
            public static float resizing_tweakCustomSizeBiggest = 2.0f;
        }

        public static class EntityTweaks {

            @Config.Comment("If true, enables all the Baba Yaga tweaks")
            @Config.Name("Baba Yaga - Tweak Enable Custom Behaviour")
            public static boolean babaYaga_enableTweaks = false;

            @Config.RangeDouble(min = 1.0, max = 256.0)
            @Config.Comment("Sets the max distance within Baba Yaga will give items to their owner")
            @Config.Name("Baba Yaga - Tweak Give Loot Max Distance")
            public static double babaYaga_tweakLivingDropMaxDistance = 64.0;

            @Config.RangeInt(min = 1, max = 10000)
            @Config.Comment("Baba Yaga will give loot to its owner every N ticks. Set here the interval")
            @Config.Name("Baba Yaga - Tweak Give Loot Interval")
            public static int babaYaga_tweakGiveLootTickInterval = 100;

            @Config.RangeInt(min = 1, max = 10000)
            @Config.Comment("Baba Yaga will give loot up until this amount of ticks, then they'll vanish")
            @Config.Name("Baba Yaga - Tweak Give Loot Lifespan")
            public static int babaYaga_tweakMaxGiveTicks = 600;

            @Config.Comment("If true, prevents Banshees from attacking other Banshees, making the execution of some " +
                    "rituals easier as they won't kill each other")
            @Config.Name("Banshee - Tweak Ingore Other Banshees")
            public static boolean banshee_tweakDoNotAttackOtherBanshees = false;

            @Config.Comment("If true, fixes the problem where Coven Witches require certain amount of items as a quest, but if" +
                    "the player holds more items than needed, the quest goes into negative item amount requirement")
            @Config.Name("Coven Witch - Fix Negative Request Amount")
            public static boolean covenWitch_fixNegativeRequestAmount = true;

            @Config.Comment("If true, fixes a freeze when the Broom breaks due to not dismounting passengers")
            @Config.Name("Enchanted Broom - Fix Freeze On Break")
            public static boolean enchantedBroom_fixFreezeOnBreak = true;

            @Config.Comment("If true, makes it so that when a Fairest is spawned, it always has a valid texture")
            @Config.Name("Fairest - Fix Broken Textures")
            public static boolean fairest_fixBrokenTextures = true;

            @Config.Comment("Sets the max number of trades the Goblin can have per level. On initial spawn, and when " +
                    "the player consumes all the Goblin trades, the Goblin will have this number of new merchant recipes")
            @Config.Name("Goblin - Max Trades Per Level")
            public static int goblin_maxTradesPerLevel = 1;

            @Config.Comment("If true, Goblin trades can be customized with CraftTweaker. False by default, because " +
                    "when enabled it completely wipes the Witchery goblin trade tables, and if new trades are not added " +
                    "with CrT, then Goblins won't show any trades")
            @Config.Name("Goblin - Tweak Custom Trades")
            public static boolean goblin_tweakCustomTrades = false;

            @Config.Comment("If true, Goblins no longer have to be in a Village in order to have trades. " +
                    "They spawn, they trade")
            @Config.Name("Goblin - Remove Village Requirement")
            public static boolean goblin_tweakRemoveTradingVillageRequirements = false;

            @Config.Comment("Fix players losing Cat familiars on World reload")
            @Config.Name("Cat Familiar - Fix Owner on World Reload")
            @Config.RequiresMcRestart
            public static boolean familiarCat_fixOwnerDisconnect = true;

            @Config.Comment("Fix players losing Owl familiars on World reload")
            @Config.Name("Owl Familiar - Fix Owner on World Reload")
            @Config.RequiresMcRestart
            public static boolean familiarOwl_fixOwnerDisconnect = true;

            @Config.Comment("Fix players losing Toad familiars on World reload")
            @Config.Name("Toad Familiar - Fix Owner on World Reload")
            @Config.RequiresMcRestart
            public static boolean familiarToad_fixOwnerDisconnect = true;

            @Config.Comment("If true, Infernal Imp won't consume shiny items when it is on cooldown. Otherwise, items " +
                    "given to it will be wasted, as they have no effect")
            @Config.Name("Flame Imp - Tweak Item Consumption On Cooldown")
            public static boolean flameImp_tweakItemConsumptionOnCooldown = true;

            @Config.Comment("If true, Infernal Imp shinies list can be customized with CraftTweaker. Default true, as it " +
                    "does not alter behaviour if not customized. Shinies are also ItemStacks instead of Items, thus " +
                    "they will respect metadata and NBT")
            @Config.Name("Flame Imp - Tweak Custom Shinies")
            public static boolean flameImp_tweakCustomShinies = true;

            @Config.Comment("If true, Infernal Imp gift list can be customized with CraftTweaker. Default true, as it " +
                    "does not alter behaviour if not customized")
            @Config.Name("Flame Imp - Tweak Custom Gifts")
            public static boolean flameImp_tweakCustomGifts = true;

            @Config.Comment("If true, when custom gifts are added by Crafttweaker, if a gift is not set in script it " +
                    "generates a random one from the loot table. If even the loot table generates no gift, behaviour is " +
                    "defined by flameinfernalImp_tweakCustomGiftFallback")
            @Config.Name("Flame Imp - Tweak Custom Extra Items")
            public static boolean flameImp_tweakCustomExtraItems = true;

            @Config.Comment("If true, when custom gifts are added by Crafttweaker, if a gift is not set in script nor " +
                    "in loot table, then fall back to the item that Witchery would have given. If false, the success " +
                    "message will be written in chat, but no items will be given")
            @Config.Name("Flame Imp - Tweak Custom Gifts Fallback")
            public static boolean flameinfernalImp_tweakCustomGiftFallback = true;

            @Config.RangeInt(min = 1, max = 24000)
            @Config.Comment("Sets the minimum amount of time (in ticks) before Infernal Imps will give another gift")
            @Config.Name("Flame Imp - Tweak Gift Delay")
            public static int flameImp_tweakGiftDelayTicks = 3600;

            @Config.Comment("If true, Lord of Torment won't teleport players to the Torment Dimension")
            @Config.Name("Lord of Torment - Tweak Disable Teleportation to Torment")
            public static boolean lordOfTorment_tweakDisableTeleportation = false;

            @Config.Comment("If true, when interacting with Lilith with an Enchantable item they will act as if with an " +
                    "empty hand. Hint: it's possible to use a resource pack to change the message that lilith says to " +
                    "the player that right-clicks with an enchantable item, to avoid confusing players.")
            @Config.Name("Lilith - Tweak Disable Enchanting")
            public static boolean lilith_tweakDisableEnchanting = false;

            @Config.Comment("If true, allows Owls to sit. (No visual change, but the owl won't follow the owner)")
            @Config.Name("Owl - Fix Sitting Behaviour")
            public static boolean owl_fixSitting = true;

            @Config.Comment("If true, Owls won't take items, except breeding items")
            @Config.Name("Owl - Tweak Disable Taking Items")
            public static boolean owl_tweakDisableTakeItems = true;

            @Config.Comment("If true, Owls' model will change slightly when sitting")
            @Config.Name("Owl - Tweak Sit Model Change")
            public static boolean owl_tweakSitModelChange = false;

            @Config.Comment("If true, Owl children will be smaller than adult counterparts")
            @Config.Name("Owl - Tweak Render Small Children")
            public static boolean owl_tweakRenderChildSmaller = false;

            @Config.Comment("If true, Spectre Attributes will be modified according to this config file")
            @Config.Name("Spectre - Tweak Modify Attributes")
            public static boolean spectre_tweakAttributes = false;

            @Config.Comment("If true, Owl children will be smaller than adult counterparts")
            @Config.Name("Spectre - Tweak Attribute Follow range")
            public static float spectre_tweakFollowRange = 40.0f;

            @Config.Comment("If true, Owl children will be smaller than adult counterparts")
            @Config.Name("Spectre - Tweak Attribute Movement Speed")
            public static float spectre_tweakMovementSpeed = 0.4f;

            @Config.Comment("If true, Owl children will be smaller than adult counterparts")
            @Config.Name("Spectre - Tweak Attribute Attack Damage")
            public static float spectre_tweakAttackDamage = 4.0f;

            @Config.Comment("If true, Spectre will have a minimum lifetime, and won't despawn immediately")
            @Config.Name("Spectre - Tweak Delay Before Despawn")
            public static boolean spectre_tweakDelayBeforeDespawn = false;

            @Config.Comment("When the Spectre has no attack target (or it's dead) the Spectre waits this amount " +
                    "of ticks before despawning")
            @Config.Name("Spectre - Tweak Tick Delay Before Despawn")
            public static int spectre_tweakDelayTicksBeforeDespawn = 60;
        }

        public static class BookTweaks {

            @Config.Comment("If true, tries to fix the placement of the plant rendering in the Herbology Book")
            @Config.Name("Herbology Book - Fix Plant Rendering")
            public static boolean herbologyBook_fixPlantRendering = true;
        }

        public static class LootTweaks {

            @Config.Comment("Attack Bat will drop loot according to its Loot Table (witchery:entities/attack_bat)")
            @Config.Name("Attack Bat - Tweak Give Own Loot Table")
            public static boolean attackBat_tweakOwnLootTable = false;

            @Config.Comment("Baba Yaga will drop loot according to its Loot Table (witchery:entities/baba_yaga_death)")
            @Config.Name("Baba Yaga - Tweak Drop Loot by Table")
            public static boolean babaYaga_tweakLootTable = false;

            @Config.Comment("Baba Yaga will give loot to its owner based on a Loot Table (witchery:entities/baba_yaga_owner)")
            @Config.Name("Baba Yaga - Tweak Give By Loot Table")
            public static boolean babaYaga_tweakGiveDropLootTable = false;

            @Config.Comment("If true, Coven Witch will drop loot according to its own Loot Table, instead of " +
                    "Vanilla Witch loot table (witchery:entities/coven_witch). WARN: if true, loot added by other " +
                    "mods to vanilla Witch loot table, will not reflect on Coven Witches")
            @Config.Name("Coven Witch - Tweak Give Own Loot Table")
            public static boolean covenWitch_tweakOwnLootTable = false;

            @Config.Comment("If true, Demon will drop loot according to its Loot Table (witchery:entities/demon)")
            @Config.Name("Demon - Tweak Drop Loot by Table")
            public static boolean demon_tweakLootTable = false;

            @Config.Comment("If true, Duplicate will drop loot according to its Loot Table (witchery:entities/demon)")
            @Config.Name("Duplicate - Tweak Give Own Loot Table")
            public static boolean duplicate_tweakOwnLootTable = false;

            @Config.Comment("If true, Ent will drop loot according to its Loot Table (witchery:entities/ent)")
            @Config.Name("Ent - Tweak Drop Loot by Table")
            public static boolean ent_tweakLootTable = false;

            @Config.Comment("If true, Elle will drop loot according to its Loot Table (witchery:entities/elle)")
            @Config.Name("Elle - Tweak Drop Loot by Table")
            public static boolean elle_tweakLootTable = false;

            @Config.Comment("If true, Fairest will drop loot according to its Loot Table (witchery:entities/fairest)")
            @Config.Name("Fairest - Tweak Drop Loot by Table")
            public static boolean fairest_tweakLootTable = false;

            @Config.Comment("If true, Cat Familiar will drop loot according to its own Loot Table, instead of " +
                    "Vanilla Ocelot loot table (witchery:entities/coven_witch). WARN: if true, loot added by other " +
                    "mods to vanilla Ocelot loot table, will not reflect on Cat familiars")
            @Config.Name("Cat Familiar - Tweak Give Own Loot Table")
            public static boolean familiarCat_tweakOwnLootTable = false;

            @Config.Comment("If true, Imp will drop loot according to its Loot Table (witchery:entities/imp_death)")
            @Config.Name("Infernal Imp - Tweak Drop Loot By Table")
            public static boolean infernalImp_tweakLootTable = false;

            @Config.Comment("If true, Imp will drop loot according to its Loot Table (witchery:entities/imp_gift)")
            @Config.Name("Infernal Imp - Tweak Gift Loot Table")
            public static boolean infernalImp_tweakGiveGiftLootTable = false;

            @Config.Comment("If true, Death will drop loot according to its Loot Table (witchery:entities/death)")
            @Config.Name("Death - Tweak Drop Loot by Table")
            public static boolean death_tweakLootTable = false;

            @Config.Comment("If true, Goblin Gulg will drop loot according to its Loot Table (witchery:entities/goblin_gulg)")
            @Config.Name("Gulg - Tweak Drop Loot by Table")
            public static boolean goblinGulg_tweakLootTable = false;

            @Config.Comment("If true, Goblin Mog will drop loot according to its Loot Table (witchery:entities/goblin_mog)")
            @Config.Name("Mog - Tweak Drop Loot by Table")
            public static boolean goblinMog_tweakLootTable = true;

            @Config.Comment("If true, Lord of Torment will drop loot according to its Loot Table (witchery:entities/lord_of_torment)")
            @Config.Name("Lord of Torment - Tweak Drop Loot by Table")
            public static boolean lordOfTorment_tweakLootTable = false;

            @Config.Comment("If true, Spectre will drop loot according to its Loot Table (witchery:entities/spectre)")
            @Config.Name("Spectre - Tweak Drop Loot by Table")
            public static boolean spectre_tweakLootTable = false;
        }

        public static class DimensionTweaks {

            @Config.Comment("Fixes endless Nightmares spawning around players in Spirit World")
            @Config.Name("Spirit World - Fix Endless Nightmare Spawning")
            public static boolean spiritWorld_fixNightmareSpawning = true;

            @Config.Comment("Tweaks the maximum amount of Nightmares that can spawn around a player in the Spirit World. " +
                    "The cap is computed per-player, so more players will actually make the cap increase proportionally." +
                    "NOTE: requires spiritWorld_fixNightmareSpawning set to true, otherwise this does nothing")
            @Config.Name("Spirit World - Tweak Nightmare Spawn Cap")
            @Config.RangeInt(min = 0, max = 20)
            public static int spiritWorld_tweakNightmareSpawnCap = 1;

            @Config.Comment("By default, Witchery won't spawn Nightmares if the player has killed one recently. This " +
                    "tweak allows customizing such delay, expressed in ticks. Default value is 600 ticks")
            @Config.Name("Spirit World - Tweak Nightmare Spawn Cooldown")
            @Config.RangeInt(min = 0, max = 6000)
            public static int spiritWorld_tweakNightmareSpawnCooldown = 600;

            @Config.Comment("Sets the dimension ID for the Spirit World dimension")
            @Config.Name("Spirit World - Tweak Dimension ID")
            @Config.RequiresMcRestart
            public static int spiritWorld_tweakID = 11;

            @Config.Comment("Sets the dimension ID for the Torment dimension")
            @Config.Name("Torment - Tweak Dimension ID")
            @Config.RequiresMcRestart
            public static int torment_tweakID = 12;

            @Config.Comment("Sets the dimension ID for the Mirror dimension")
            @Config.Name("Mirror - Tweak Dimension ID")
            @Config.RequiresMcRestart
            public static int mirror_tweakID = 13;


        }

        public static class WorldGenTweaks {

            @Config.Comment("If true, fixes a crash that happens while trying to generate an Item Frame entity " +
                    "with a book inside in the Witchery village piece")
            @Config.Name("Item Frame - Fix Crash While Generating Book In Village")
            public static boolean frameWithBook_fixCrashOnVillageGen = true;

        }
    }

    public static class IntegrationConfigurations {

        @Config.Comment("Configuration related to Just Enough Resources integration")
        @Config.Name("JER Integration - Configuration")
        public static JerIntegration jerIntegrationConfig;

        @Config.Comment("Configuration related to Just Enough Items integration")
        @Config.Name("JEI Integration - Configuration")
        public static JeiIntegration jeiIntegrationConfig;

        @Config.Comment("Configuration related to Morph integration")
        @Config.Name("Morph Integration - Configuration")
        public static MorphIntegration morphIntegrationConfig;

        @Config.Comment("Configuration related to Quark integration")
        @Config.Name("Quark Integration - Configuration")
        public static QuarkIntegration quarkIntegrationConfig;

        @Config.Comment("Configuration related to The One Probe integration")
        @Config.Name("TOP Integration - Configuration")
        public static TopIntegration TOPIntegrationConfig;

        @Config.Comment("Configuration related to Thaumcraft integration")
        @Config.Name("Thaumcraft Integration - Configuration")
        public static ThaumcraftIntegration ThaumcraftIntegrationConfig;

        public static class JerIntegration {

            @Config.Comment("Master switch for all JER integrations")
            @Config.Name("JER Integration - Enabled")
            public static boolean enableJerIntegration = true;
        }

        public static class JeiIntegration {

            @Config.Comment("If true, enables Bark Belt JEI Integration")
            @Config.Name("JEI Integration - Enable Bark Belt")
            public static boolean enableJeiBarkBelt = true;

            @Config.Comment("If true, enables Goblin Trade JEI Integration")
            @Config.Name("JEI Integration - Enable Goblin Trades")
            public static boolean enableJeiGoblinTrades = true;

            @Config.Comment("If true, enables Imp Gifts JEI Integration")
            @Config.Name("JEI Integration - Enable Imp Gifts")
            public static boolean enableJeiImpGifts = true;

            @Config.Comment("If true, enables Imp Shinies JEI Integration")
            @Config.Name("JEI Integration - Enable Imp Shinies")
            public static boolean enableJeiImpShinies = true;

        }

        public static class QuarkIntegration {

            @Config.Comment("If true, fixes Mandrakes not spawning when Quark right-click harvest feature is enabled")
            @Config.Name("Quark Integration - Fix Mandrakes Right-click Harvest")
            public static boolean fixMandrakesRightClickHarvest = true;
        }

        public static class MorphIntegration {

            @Config.Comment("If true, fixes an entity size desync between client and server when a morphed player " +
                    "changes dimension")
            @Config.Name("Morph Integration - Fix Entity Size On Dimension Change")
            public static boolean fixSizeDesyncOnDimChange = true;
        }

        public static class TopIntegration {

            @Config.Comment("Master switch for all TOP integrations")
            @Config.Name("TOP Integration - Enabled")
            public static boolean enableTopIntegration = true;

            @Config.Comment("Integration")
            @Config.Name("TOP Integration - Altar")
            public static EProbeElementIntegrationConfig altar = EProbeElementIntegrationConfig.DEFAULT;

            @Config.Comment("If true, enables TOP integration for Witch's Cauldron")
            @Config.Name("TOP Integration - Witch's Cauldron")
            public static EProbeElementIntegrationConfig cauldron = EProbeElementIntegrationConfig.DEFAULT;

            @Config.Comment("If true, enables TOP integration for Kettle")
            @Config.Name("TOP Integration - Kettle")
            public static EProbeElementIntegrationConfig kettle = EProbeElementIntegrationConfig.DEFAULT;

            @Config.Comment("If true, enables TOP integration for Grassper")
            @Config.Name("TOP Integration - Grassper")
            public static EProbeElementIntegrationConfig grassper = EProbeElementIntegrationConfig.DEFAULT;

            @Config.Comment("If true, enables TOP integration for Hobgoblin")
            @Config.Name("TOP Integration - Hobgoblin")
            public static EProbeElementIntegrationConfig goblin = EProbeElementIntegrationConfig.DEFAULT;

            @Config.Comment("If true, enables TOP integration for Flame Imp")
            @Config.Name("TOP Integration - Flame Imp")
            public static EProbeElementIntegrationConfig imp = EProbeElementIntegrationConfig.DEFAULT;

            public enum EProbeElementIntegrationConfig {
                // Only enable basic information
                BASIC_ONLY,

                // Basic information will always be available, extended info only with extended probe
                DEFAULT,

                // All information will always be available
                ALL_BASIC,

                // Integration is disabled
                DISABLED,
            }

        }

        public static class ThaumcraftIntegration {

            @Config.Comment("Master switch for all Thaumcraft integrations")
            @Config.Name("Thaumcraft Integration - Enabled")
            public static boolean enableThaumcraftIntegration = true;

        }
    }

    @Mod.EventBusSubscriber(modid = WitcheryCompanion.MODID)
    public static class ConfigSyncHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if(event.getModID().equals(WitcheryCompanion.MODID)) {
                reloadConfig();
            }
        }

        public static void reloadConfig() {
            reloadRiteOfMovingEarthBlacklist();
            ConfigManager.sync(WitcheryCompanion.MODID, Config.Type.INSTANCE);
        }

        private static void reloadRiteOfMovingEarthBlacklist() {
            // Clear current configuration
            PatchesConfiguration.RitesTweaks.movingEarth_stateBlacklist = new HashSet<>();

            // Re-add configuration
            for (String entry : PatchesConfiguration.RitesTweaks.movingEarth_tweakBlockBlacklist) {
                String[] metaSplit = entry.split("@");
                int meta = 0;
                try {
                    meta = metaSplit.length > 1 ? Integer.parseInt(metaSplit[1]) : 0;
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    WitcheryCompanion.logger.warn("Could not parse blockstate - Invalid meta for entry: {}. Please fix your configs", entry);
                }

                ResourceLocation rl = new ResourceLocation(metaSplit[0]);
                if (!ForgeRegistries.BLOCKS.containsKey(rl)) {
                    WitcheryCompanion.logger.warn("Could not parse blockstate - Block not found: {}. Please fix your configs", entry);
                }

                Block block = ForgeRegistries.BLOCKS.getValue(rl);
                PatchesConfiguration.RitesTweaks.movingEarth_stateBlacklist.add(block.getStateFromMeta(meta));
            }
        }


    }
}
