package com.smokeythebandicoot.witcherycompanion.api.progress;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;

public abstract class WitcheryProgressEvent extends Event {

    public final EntityPlayer player;
    public final String progressKey;
    public final String activityTrigger;


    public WitcheryProgressEvent(EntityPlayer player, String progressKey, String activityTrigger) {
        this.player = player;
        this.progressKey = progressKey;
        this.activityTrigger = activityTrigger;
    }

    public enum EProgressTriggerActivity {

        /** Player has discovered a secret bind spirit to fetish recipe **/
        BIND_TO_FETISH("bind_fetish"),

        /** Player has triggered a secret brazier recipe **/
        BRAZIER_RECIPE("brazier_recipe"),

        /** Player has created a brew with a secret ingredient **/
        CAULDRON_BREW("cauldron_brewing"),

        /** Player has triggered a cauldron ritual that contains a secret **/
        CAULDRON_RITUAL("cauldron_ritual"),

        /** Player has triggered a secret rite with circle magic **/
        CIRCLE_MAGIC("circle_magic"),

        /** Player has unlocked progress through a command **/
        COMMAND("command"),

        /** Player has drawn a secret symbol **/
        MYSTIC_BRANCH("mystic_branch"),
        ;

        public final String activityTrigger;

        EProgressTriggerActivity(String triggerDescription) {
            this.activityTrigger = triggerDescription;
        }
    }

}
