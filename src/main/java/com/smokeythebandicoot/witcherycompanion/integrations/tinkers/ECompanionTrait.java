package com.smokeythebandicoot.witcherycompanion.integrations.tinkers;


import com.smokeythebandicoot.witcherycompanion.integrations.tinkers.conarm.modifiers.ModifierBabasBless;
import com.smokeythebandicoot.witcherycompanion.integrations.tinkers.conarm.traits.TraitNecromancerClothing;
import com.smokeythebandicoot.witcherycompanion.integrations.tinkers.conarm.traits.TraitWitchClothing;

public enum ECompanionTrait {
    BABA_CLOTHING(ModifierBabasBless.id),
    WITCH_CLOTHING(TraitWitchClothing.id),
    NECROMANCER_CLOTHING(TraitNecromancerClothing.id),
    ;

    final String id;

    ECompanionTrait(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

}
