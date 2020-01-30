package io.github.nuclearfarts.packeterrorlogger.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.nuclearfarts.packeterrorlogger.Misc;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.DecoderHandler;

@Mixin(DecoderHandler.class)
public class DecoderHandlerMixin {
	
	@Inject(at = @At("HEAD"), method = "decode")
	private void decodeMixin(ChannelHandlerContext channelHandlerContext_1, ByteBuf byteBufIn, List<Object> out, CallbackInfo info) {
		Misc.lastPacket = byteBufIn;
		Misc.lastPacketClone = byteBufIn.copy();
	}
}
