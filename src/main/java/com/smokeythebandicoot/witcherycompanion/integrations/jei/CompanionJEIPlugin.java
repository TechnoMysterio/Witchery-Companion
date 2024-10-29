package com.smokeythebandicoot.witcherycompanion.integrations.jei;

import com.smokeythebandicoot.witcherycompanion.integrations.jei.altar.AltarCategory;
import com.smokeythebandicoot.witcherycompanion.integrations.jei.barkbelt.BarkBeltCategory;
import com.smokeythebandicoot.witcherycompanion.integrations.jei.goblin.GoblinTradeCategory;
import com.smokeythebandicoot.witcherycompanion.integrations.jei.imp.gifts.ImpGiftCategory;
import com.smokeythebandicoot.witcherycompanion.integrations.jei.imp.shinies.ImpShinyCategory;
import com.smokeythebandicoot.witcherycompanion.integrations.jei.mirror.MirrorCategory;
import com.smokeythebandicoot.witcherycompanion.integrations.jei.mutandis.MutandisBlockCategory;
import com.smokeythebandicoot.witcherycompanion.integrations.jei.mutandis.MutandisExtremisPlantCategory;
import com.smokeythebandicoot.witcherycompanion.integrations.jei.mutandis.MutandisPlantCategory;
import com.smokeythebandicoot.witcherycompanion.integrations.jei.suncollector.SunCollectorCategory;
import com.smokeythebandicoot.witcherycompanion.integrations.jei.wolfaltar.WolfAltarCategory;
import com.smokeythebandicoot.witcherycompanion.utils.Mods;
import mezz.jei.api.*;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraftforge.fml.common.Loader;

import javax.annotation.Nonnull;

@JEIPlugin
public class CompanionJEIPlugin implements IModPlugin {

    public static IJeiHelpers jeiHelpers;
    public static IGuiHelper guiHelper;
    public static IJeiRuntime jeiRuntime;


    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {

        jeiHelpers = registry.getJeiHelpers();
        guiHelper = jeiHelpers.getGuiHelper();

        AltarCategory.register(registry);
        GoblinTradeCategory.register(registry);
        ImpShinyCategory.register(registry);
        BarkBeltCategory.register(registry);
        MutandisBlockCategory.register(registry);
        MutandisPlantCategory.register(registry);
        MutandisExtremisPlantCategory.register(registry);
        MirrorCategory.register(registry);
        SunCollectorCategory.register(registry);
        WolfAltarCategory.register(registry);

        // This category requires Just Enough Resources for Loot de-serialization
        if (Loader.isModLoaded(Mods.JER))
            ImpGiftCategory.register(registry);
    }

    @Override
    public void register(IModRegistry registry) {

        jeiHelpers = registry.getJeiHelpers();
        guiHelper = jeiHelpers.getGuiHelper();

        AltarCategory.initialize(registry);
        GoblinTradeCategory.initialize(registry);
        ImpShinyCategory.initialize(registry);
        BarkBeltCategory.initialize(registry);
        MirrorCategory.initialize(registry);
        MutandisBlockCategory.initialize(registry);
        MutandisPlantCategory.initialize(registry);
        MutandisExtremisPlantCategory.initialize(registry);
        SunCollectorCategory.initialize(registry);
        WolfAltarCategory.initialize(registry);

        // This category requires Just Enough Resources for Loot de-serialization
        if (Loader.isModLoaded(Mods.JER))
            ImpGiftCategory.initialize(registry);

    }

    @Override
    public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {
        CompanionJEIPlugin.jeiRuntime = jeiRuntime;
    }

}
