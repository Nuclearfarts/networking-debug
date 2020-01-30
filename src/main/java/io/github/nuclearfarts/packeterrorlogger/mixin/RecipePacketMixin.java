package io.github.nuclearfarts.packeterrorlogger.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import io.github.nuclearfarts.packeterrorlogger.Misc;
import net.minecraft.client.network.packet.SynchronizeRecipesS2CPacket;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.PacketByteBuf;

@Mixin(SynchronizeRecipesS2CPacket.class)
public class RecipePacketMixin {

	@Inject(method = "readRecipe(Lnet/minecraft/util/PacketByteBuf;)Lnet/minecraft/recipe/Recipe;",
			at = @At(value = "INVOKE_ASSIGN", target = "net/minecraft/util/PacketByteBuf.readIdentifier()Lnet/minecraft/util/Identifier;", ordinal = 1),
			locals = LocalCapture.CAPTURE_FAILHARD)
	private static void blah(PacketByteBuf buf, CallbackInfoReturnable<Recipe> cir, Identifier serializer, Identifier recipe) {
		Misc.lastRecipe = recipe;
		Misc.lastSerializer = serializer;
	}
}
