package io.github.nuclearfarts.packeterrorlogger;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.Identifier;

public class Misc {
	
	public static ByteBuf lastPacketClone;
	public static ByteBuf lastPacket;
	private static int erroringPacketNumber = 0;
	public static Identifier lastSerializer;
	public static Identifier lastRecipe;
	
	
	public static void log() {
		try(OutputStream fOut = new BufferedOutputStream(new FileOutputStream("erroring-packet-" + erroringPacketNumber))) {
			System.out.println("Packet error index: " + erroringPacketNumber);
			System.out.println("Packet start index: " + lastPacketClone.readerIndex());
			System.out.println("Packet errored at read offset: " + lastPacket.readerIndex());
			System.out.println("Last recipe: " + lastRecipe + " (serializer: " + lastSerializer + ")");
			erroringPacketNumber++;
			lastPacketClone.forEachByte(b -> {fOut.write(b); return true;});
		} catch (IOException e) {
			System.err.println("Could not write blob of erroring packet: ");
			e.printStackTrace();
		}
	}
	
}
