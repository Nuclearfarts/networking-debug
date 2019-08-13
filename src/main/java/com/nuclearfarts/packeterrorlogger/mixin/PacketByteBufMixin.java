package com.nuclearfarts.packeterrorlogger.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.nuclearfarts.packeterrorlogger.EnableLog;
import com.nuclearfarts.packeterrorlogger.Statics;

import net.minecraft.util.PacketByteBuf;

@Mixin(PacketByteBuf.class)
public abstract class PacketByteBufMixin implements EnableLog {
	
	private boolean log;
	
	public void enableLog() {
		log = true;
	}
	
	@Inject(at = @At("HEAD"), method = "readBoolean()Z")
	private void readBool(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
		
	}
	
	@Inject(at = @At("HEAD"), method = "readByte()B")
	private void readByte(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readUnsignedByte()S")
	private void readUnsByte(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readShort()S")
	private void readShort(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readShortLE()S")
	private void readShortLE(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readUnsignedShort()I")
	private void readUnsShort(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readUnsignedShortLE()I")
	private void readUnsShortLE(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readMedium()I")
	private void readMedium(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readMediumLE()I")
	private void readMediumLE(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readUnsignedMedium()I")
	private void readUnsMedium(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readUnsignedMediumLE()I")
	private void readUnsMediumLE(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readInt()I")
	private void readInt(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readIntLE()I")
	private void readIntLE(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readUnsignedInt()J")
	private void readUnsInt(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readUnsignedIntLE()J")
	private void readUnsIntLE(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readLong()J")
	private void readLong(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readLongLE()J")
	private void readLongLE(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readChar()C")
	private void readChar(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readFloat()F")
	private void readFloat(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
	
	@Inject(at = @At("HEAD"), method = "readDouble()D")
	private void readDouble(CallbackInfoReturnable<?> info) {
		if(log) {Statics.checkNetworkThread();}
	}
}
