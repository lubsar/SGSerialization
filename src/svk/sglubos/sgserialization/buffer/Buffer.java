package svk.sglubos.sgserialization.buffer;

import svk.sglubos.sgserialization.Writable;
import svk.sglubos.sgserialization.Readable;
import svk.sglubos.sgserialization.Serializable;

public abstract class Buffer implements Readable, Writable{
	protected byte[] data;
	protected int pointer;
	
	public Buffer(int capacity) {
		if(capacity < 1) {
			throw new IllegalArgumentException("Capacity must be higher than 0");
		}
		
		data = new byte[capacity];
	}
	
	public int getPointer() {
		return pointer;
	}
	
	public void setPointer(int pointer) {
		if(pointer < 0) {
			throw new IllegalArgumentException("Pointer cannot be negative");
		}
		
		this.pointer = pointer;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public abstract int write(byte data);
	public abstract int write(short data);
	public abstract int write(int data);
	public abstract int write(long data);
	public abstract int write(float data);
	public abstract int write(double data);
	public abstract int write(char data);
	public abstract int write(boolean data);
	public abstract int write(byte[] data);
	public abstract int write(short[] data);
	public abstract int write(int[] data);
	public abstract int write(long[] data);
	public abstract int write(float[] data);
	public abstract int write(double[] data);
	public abstract int write(char[] data);
	public abstract int write(boolean[] data);
	public abstract int write(Serializable data);
	public abstract int write(Serializable[] data);
	
	public abstract byte readByte();
	public abstract short readShort();
	public abstract int readInt();
	public abstract long readLong();
	public abstract float readFloat();
	public abstract double readDouble();
	public abstract char readChar();
	public abstract boolean readBoolean();
	public abstract byte[] readBytes(int size);
	public abstract short[] readShorts(int size);
	public abstract int[] readInts(int size);
	public abstract long[] readLongs(int size);
	public abstract float[] readFloats(int size);
	public abstract double[] readDoubles(int size);
	public abstract char[] readChars(int size);
	public abstract boolean[] readBooleans(int size);
	public abstract int read(byte[] location);
	public abstract int read(short[] location);
	public abstract int read(int[] location);
	public abstract int read(long[] location);
	public abstract int read(float[] location);
	public abstract int read(double[] location);
	public abstract int read(char[] location);
	public abstract int read(boolean[] location);
	public abstract <T extends Serializable> T readSerializable(T type);
	public abstract int readSerializable2(Serializable destination);
	public abstract <T extends Serializable> T[] readSerializables(T[] type);
	public abstract int readSerializables2(Serializable[] destination);
}
