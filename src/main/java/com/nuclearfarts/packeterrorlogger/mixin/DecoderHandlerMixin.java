package com.nuclearfarts.packeterrorlogger.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.nuclearfarts.packeterrorlogger.EnableLog;
import com.nuclearfarts.packeterrorlogger.Statics;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.DecoderHandler;
import net.minecraft.util.PacketByteBuf;

@Mixin(DecoderHandler.class)
public abstract class DecoderHandlerMixin {

	@Inject(at = @At("HEAD"), method = "decode")
	private void decodeMixin(CallbackInfo info) {
		Statics.onNetworkThread();
	}

	@Inject(locals = LocalCapture.CAPTURE_FAILHARD, at = @At(value = "INVOKE", target = "net/minecraft/util/PacketByteBuf.readVarInt()I"), method = "decode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Ljava/util/List;)V")
	private void enableLogging(ChannelHandlerContext channelHandlerContext_1, ByteBuf byteBuf_1, List<Object> list_1, CallbackInfo ci, PacketByteBuf packetByteBuf_1) {
		((EnableLog)packetByteBuf_1).enableLog();
	}
}
