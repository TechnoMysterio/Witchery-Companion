package com.smokeythebandicoot.witcherycompanion.mixins.item;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.smokeythebandicoot.witcherycompanion.api.progress.ProgressUtils;
import com.smokeythebandicoot.witcherycompanion.api.progress.WitcheryProgressEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.msrandom.witchery.infusion.symbol.SymbolEffect;
import net.msrandom.witchery.item.ItemMysticBranch;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * Mixins:
 * [Feature] unlock secret SymbolEffects
 */
@Mixin(ItemMysticBranch.class)
public abstract class ItemMysticBranchMixin extends Item {

    @WrapOperation(method = "onPlayerStoppedUsing", remap = false, at = @At(value = "INVOKE", remap = false,
            target = "Lnet/msrandom/witchery/infusion/symbol/SymbolEffect;perform(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/EntityPlayer;I)V"))
    private void unlockSecret(SymbolEffect instance, World world, EntityPlayer entityPlayer, int i, Operation<Void> original) {
        // At this point in the function, the effect and the player have already passed null-checks
        int effectId = SymbolEffect.REGISTRY.getId(instance);
        ResourceLocation effectKey = SymbolEffect.REGISTRY.getKey(effectId);

        if (effectKey == null) return;
        ProgressUtils.unlockProgress(entityPlayer, effectKey.path,
                WitcheryProgressEvent.EProgressTriggerActivity.MYSTIC_BRANCH.activityTrigger);

    }

}
