package com.nuclearfarts.packeterrorlogger.mixin;

import net.minecraft.network.ClientConnection;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.netty.channel.ChannelHandlerContext;

@Mixin(ClientConnection.class)
public abstract class ClientConnectionMixin {
	@Inject(at = @At("HEAD"), method = "exceptionCaught(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Throwable;)V")
	private void logException(ChannelHandlerContext channelHandlerContext, Throwable t, CallbackInfo info) {
		System.out.println("Exception in networking:");
		t.printStackTrace();
	}
}
