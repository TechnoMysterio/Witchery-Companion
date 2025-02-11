package com.smokeythebandicoot.witcherycompanion.integrations.jei.imp.gifts;

import com.smokeythebandicoot.witcherycompanion.integrations.jei.abstractbase.BaseRecipeWrapper;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


public class ImpGiftWrapper extends BaseRecipeWrapper {

    protected List<ItemStack> giftsAtLevel;
    protected int level;


    public ImpGiftWrapper(IGuiHelper guiHelper, List<ItemStack> gifts, int level) {
        this.giftsAtLevel = gifts;
        this.level = level;
    }

    public ImpGiftWrapper(IGuiHelper guiHelper, ItemStack gift, int level) {
        this.giftsAtLevel = new ArrayList<>();
        giftsAtLevel.add(gift);
        this.level = level;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(VanillaTypes.ITEM, new ArrayList<>());
        ingredients.setOutputs(VanillaTypes.ITEM, giftsAtLevel == null ? new ArrayList<>() : giftsAtLevel);
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        minecraft.fontRenderer.drawString("Level: §6" + level, 24, 8, 0xffffff);
    }

}
