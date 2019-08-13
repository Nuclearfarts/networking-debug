package com.nuclearfarts.packeterrorlogger;

public final class Statics {

	private static Thread networkThread = null;
	
	public static void onNetworkThread() {
		if(!Thread.currentThread().equals(networkThread)) {
			System.out.println("New network thread: " + Thread.currentThread());
			networkThread = Thread.currentThread();
		}
	}
	
	public static void checkNetworkThread() {
		if(!Thread.currentThread().equals(networkThread)) {
			System.out.println("PacketByteBuf accessed off network thread! THIS IS BAD! Current thread: " + Thread.currentThread());
			System.out.println("Stacktrace:");
			new Exception("this isn't actually an exception, it's just for printing the stacktrace").printStackTrace();
		}
	}

}
