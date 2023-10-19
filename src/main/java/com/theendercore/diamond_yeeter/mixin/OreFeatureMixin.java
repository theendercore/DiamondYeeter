package com.theendercore.diamond_yeeter.mixin;

import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;
import java.util.function.Function;

import static com.theendercore.diamond_yeeter.DiamondYeeter.isDiamond;
import static com.theendercore.diamond_yeeter.DiamondYeeter.isDisabled;

@Mixin(OreFeature.class)
public class OreFeatureMixin {
    @Inject(at = @At("RETURN"), method = "canPlaceOre", cancellable = true)
    private static void enderCustomWorldGen$canPlaceOre(BlockState pState, Function<BlockPos, BlockState> pAdjacentStateAccessor, Random pRandom, OreConfiguration pConfig, OreConfiguration.TargetBlockState pTargetState, BlockPos.MutableBlockPos pMutablePos, CallbackInfoReturnable<Boolean> cir) {
        if (isDiamond(pTargetState.state.getBlock()) && isDisabled(pMutablePos))
            cir.setReturnValue(false);
    }
}

