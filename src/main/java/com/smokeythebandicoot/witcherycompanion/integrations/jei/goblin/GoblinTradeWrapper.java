package com.smokeythebandicoot.witcherycompanion.integrations.jei.goblin;

import com.smokeythebandicoot.witcherycompanion.integrations.jei.abstractbase.BaseRecipeWrapper;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


public class GoblinTradeWrapper extends BaseRecipeWrapper {

    protected List<ItemStack> inputs;
    protected List<ItemStack> outputs;
    protected String professionName;


    public GoblinTradeWrapper(IGuiHelper guiHelper, MerchantRecipe recipe, String professionName) {
        this.professionName = professionName;

        inputs = new ArrayList<>();
        outputs = new ArrayList<>();

        inputs.add(recipe.getItemToBuy().copy());
        if (recipe.hasSecondItemToBuy()) {
            inputs.add(recipe.getSecondItemToBuy().copy());
        }

        outputs.add(recipe.getItemToSell().copy());
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(VanillaTypes.ITEM, inputs);
        ingredients.setOutputs(VanillaTypes.ITEM, outputs);
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        minecraft.fontRenderer.drawString(professionName, 0, -12, 0x000000);
    }
}
