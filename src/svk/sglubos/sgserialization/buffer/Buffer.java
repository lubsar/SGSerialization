/* The MIT License (MIT)
 *
 * Copyright (c) 2016-2017 Ľubomír Hlavko
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package svk.sglubos.sgserialization.buffer;

import java.nio.charset.Charset;

import svk.sglubos.sgserialization.Readable;
import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.Writable;

public abstract class Buffer implements Readable, Writable {
	protected byte[] data;
	protected int pointer;
	
	public Buffer(byte[] data) {
		this(data.length);
		System.arraycopy(data, 0, this.data, 0, data.length);
	}
	
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
	
	public void clean() {
		for(int i = 0; i < data.length; i++) {
			data[i] = 0;
		}
		pointer = 0;
	}
	
	public void clean(int capacity) {
		if(capacity < 1) {
			throw new IllegalArgumentException("Capacity must be higher than 0");
		}
		
		data = new byte[capacity];
		pointer = 0;
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
	
	public abstract int write(String string);
	public abstract int write(String string, Charset charset);
	
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
	
	public abstract String readString(int byteLength);
	public abstract String readString(int byteLength, Charset charset);
}
