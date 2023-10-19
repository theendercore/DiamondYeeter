package com.theendercore.diamond_yeeter.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder().comment("The Secret Values").push("Coordinates");
    public static final ForgeConfigSpec.IntValue negativeX = BUILDER
            .comment("Negative X")
            .defineInRange("negative_x", -1_000, -1_000_000, -1);
    public static final ForgeConfigSpec.IntValue negativeZ = BUILDER
            .comment("Negative Z")
            .defineInRange("negative_z", -1_000, -1_000_000, -1);
    public static final ForgeConfigSpec.IntValue positiveX = BUILDER
            .comment("Positive X")
            .defineInRange("positive_x", 1_000, 1,1_000_000);
    public static final ForgeConfigSpec.IntValue positiveZ = BUILDER
            .comment("Positive Z")
            .defineInRange("positive_z", 1_000, 1,1_000_000);
    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
