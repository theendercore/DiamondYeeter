package com.theendercore.diamond_yeeter;

import com.theendercore.diamond_yeeter.config.Config;
import com.theendercore.diamond_yeeter.config.Rec;
import com.theendercore.diamond_yeeter.config.Vec2i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.theendercore.diamond_yeeter.config.Config.*;

@Mod("diamond_yeeter")
public class DiamondYeeter {

    @SuppressWarnings(value = "unused")
    public static final Logger LOGGER = LoggerFactory.getLogger("DiamondYeeter");

    public DiamondYeeter() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SPEC, "diamond_yeeter.toml");
        MinecraftForge.EVENT_BUS.register(this);
    }

    static public boolean isDiamond(Block block) {
        return block.equals(Blocks.DIAMOND_ORE) || block.equals(Blocks.DEEPSLATE_DIAMOND_ORE);
    }
    static public boolean isDisabled(BlockPos pos) {
        int x = pos.getX();
        int y = pos.getZ();
        Rec shape = new Rec(new Vec2i(negativeX.get(), negativeZ.get()), new Vec2i(positiveX.get(), positiveZ.get()));
        return ((x >= shape.a().x() && x <= shape.b().x())
                && (y >= shape.a().y() && y <= shape.b().y()));
    }
}