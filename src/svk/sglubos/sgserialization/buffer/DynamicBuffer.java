/* The MIT License (MIT)
 *
 * Copyright (c) 2016 Ľubomír Hlavko
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

import svk.sglubos.sgserialization.PrimiSerializer;
import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.StructedSerializer;

public class DynamicBuffer extends Buffer {
	private int expansion;
	private boolean expandByRate = false;
	private float expansionRate = 1.0f;
	private boolean expandAsNeeded = false;
	
	private PrimiSerializer primiSerializer;
	private StructedSerializer structedSerializer;
	
	public DynamicBuffer(int capacity, int expansion, PrimiSerializer primiSerializer, StructedSerializer structedSerializer) {
		super(capacity);
		this.expansion = expansion;
		this.primiSerializer = primiSerializer;
		this.structedSerializer = structedSerializer;
	}
	
	public DynamicBuffer(int capacity, float expansionRate, PrimiSerializer primiSerializer, StructedSerializer structedSerializer) {
		super(capacity);
		this.expansionRate = expansionRate;
		this.expandByRate = true;
		this.primiSerializer = primiSerializer;
		this.structedSerializer = structedSerializer;
	}
	
	public DynamicBuffer(int capacity, PrimiSerializer primiSerializer, StructedSerializer structedSerializer) {
		super(capacity);
		this.expandAsNeeded = true;
		this.primiSerializer = primiSerializer;
		this.structedSerializer = structedSerializer;
	}
	
	public float getExpansionRate() {
		return expansionRate;
	}
	
	public void setExpansionRate(float expansionRate) {
		if(expansionRate < 1) {
			throw new IllegalArgumentException("Expansionrate must be more than 0");
		}
		
		this.expansionRate = expansionRate;
	}
	
	public boolean isExpandedByRate() {
		return expandByRate;
	}
	
	public void setExpandByRate(boolean expandByRate) {
		this.expandByRate = expandByRate;
	}
	
	public boolean isExpandedAsNeeded() {
		return expandAsNeeded;
	}
	
	public void setExpandAsNeeded(boolean expandAsNeeded) {
		this.expandAsNeeded = expandAsNeeded;
	}
	
	public int getExpansion() {
		return expansion;
	}
	
	public void setExpansion(int expansion) {
		if(expansion < 1) {
			throw new IllegalArgumentException("Expansion must be more than 0");
		}
		
		this.expansion = expansion;
	}
	
	public void expand() {
		if(expandByRate) {
			expandArray((int) (data.length * expansionRate));
		} else {
			expandArray(expansion);
		}
	}
	
	private void expand2(int requiredSpace) {
		if(expandAsNeeded) {
			expandArray(requiredSpace);
		} else {
			expand();
		}
	}
	
	private void expandArray(int expansion) {
		byte[] expanded = new byte[data.length + expansion];
		System.arraycopy(data, 0, expanded, 0, data.length);
		data = expanded;
	}
	
	@Override
	public byte readByte() {
		return primiSerializer.readByte(pointer++, data);
	}
	
	@Override
	public byte readByte(int index) {
		return primiSerializer.readByte(index, data);
	}
	
	@Override
	public short readShort() {
		short tmp = primiSerializer.readShort(pointer, data);
		pointer += 2;
		return tmp;
	}
	
	@Override
	public short readShort(int index) {
		return primiSerializer.readShort(index, data);
	}
	
	@Override
	public int readInt() {
		int tmp = primiSerializer.readInt(pointer, data);
		pointer += 4;
		return tmp;
	}
	
	@Override
	public int readInt(int index) {
		return primiSerializer.readInt(index, data);
	}
	
	@Override
	public long readLong() {
		long tmp = primiSerializer.readLong(pointer, data);
		pointer += 8;
		return tmp;
	}
	
	@Override
	public long readLong(int index) {
		return primiSerializer.readLong(index, data);
	}
	
	@Override
	public float readFloat() {
		float tmp = primiSerializer.readFloat(pointer, data);
		pointer += 4;
		return tmp;
	}
	
	@Override
	public float readFloat(int index) {
		return primiSerializer.readFloat(index, data);
	}
	
	@Override
	public double readDouble() {
		double tmp = primiSerializer.readDouble(pointer, data);
		pointer += 8;
		return tmp;
	}
	
	@Override
	public double readDouble(int index) {
		return primiSerializer.readByte(index, data);
	}
	
	@Override
	public char readChar() {
		char tmp = primiSerializer.readChar(pointer, data);
		pointer += 2;
		return tmp;
	}
	
	@Override
	public char readChar(int index) {
		return primiSerializer.readChar(index, data);
	}
	
	@Override
	public boolean readBoolean() {
		return primiSerializer.readBoolean(pointer++, data);
	}
	
	@Override
	public boolean readBoolean(int index) {
		return primiSerializer.readBoolean(index, data);
	}
	
	@Override
	public byte[] readBytes(int size) {
		byte[] tmp = primiSerializer.readBytes(size, pointer, data);
		pointer += size;
		return tmp;
	}
	
	@Override
	public byte[] readBytes(int size, int index) {
		return primiSerializer.readBytes(size, index, data);
	}
	
	@Override
	public short[] readShorts(int size) {
		short[] tmp = primiSerializer.readShorts(size, pointer, data);
		pointer += size * 2;
		return tmp;
	}
	
	@Override
	public short[] readShorts(int size, int index) {
		return primiSerializer.readShorts(size, index, data);
	}
	
	@Override
	public int[] readInts(int size) {
		int[] tmp = primiSerializer.readInts(size, pointer, data);
		pointer += size * 4;
		return tmp;
	}
	
	@Override
	public int[] readInts(int size, int index) {
		return primiSerializer.readInts(size, index, data);
	}
	
	@Override
	public long[] readLongs(int size) {
		long[] tmp = primiSerializer.readLongs(size, pointer, data);
		pointer += size * 8;
		return tmp;
	}
	
	@Override
	public long[] readLongs(int size, int index) {
		return primiSerializer.readLongs(size, index, data);
	}
	
	@Override
	public float[] readFloats(int size) {
		float[] tmp = primiSerializer.readFloats(size, pointer, data);
		pointer += size * 4;
		return tmp;
	}
	
	@Override
	public float[] readFloats(int size, int index) {
		return primiSerializer.readFloats(size, index, data);
	}
	
	@Override
	public double[] readDoubles(int size) {
		double[] tmp = primiSerializer.readDoubles(size, pointer, data);
		pointer += size * 8;
		return tmp;
	}
	
	@Override
	public double[] readDoubles(int size, int index) {
		return primiSerializer.readDoubles(size, index, data);
	}
	
	@Override
	public char[] readChars(int size) {
		char[] tmp = primiSerializer.readChars(size, pointer, data);
		pointer += size * 4;
		return tmp;
	}
	
	@Override
	public char[] readChars(int size, int index) {
		return primiSerializer.readChars(size, index, data);
	}
	
	@Override
	public boolean[] readBooleans(int size) {
		boolean[] tmp = primiSerializer.readBooleans(size, pointer, data);
		pointer += size;
		return tmp;
	}
	
	@Override
	public boolean[] readBooleans(int size, int index) {
		return primiSerializer.readBooleans(size, index, data);
	}
	
	@Override
	public int read(byte[] location) {
		return pointer = primiSerializer.read(location, pointer, data);
	}
	
	@Override
	public int read(byte[] location, int index) {
		return primiSerializer.read(location, index, data);
	}
	
	@Override
	public int read(short[] location) {
		return pointer = primiSerializer.read(location, pointer, data);
	}
	
	@Override
	public int read(short[] location, int index) {
		return primiSerializer.read(location, index, data);
	}
	
	@Override
	public int read(int[] location) {
		return pointer = primiSerializer.read(location, pointer, data);
	}
	
	@Override
	public int read(int[] location, int index) {
		return primiSerializer.read(location, index, data);
	}
	
	@Override
	public int read(long[] location) {
		return pointer = primiSerializer.read(location, pointer, data);
	}
	
	@Override
	public int read(long[] location, int index) {
		return primiSerializer.read(location, index, data);
	}
	
	@Override
	public int read(float[] location) {
		return pointer = primiSerializer.read(location, pointer, data);
	}
	
	@Override
	public int read(float[] location, int index) {
		return primiSerializer.read(location, index, data);
	}
	
	@Override
	public int read(double[] location) {
		return pointer = primiSerializer.read(location, pointer, data);
	}
	
	@Override
	public int read(double[] location, int index) {
		return primiSerializer.read(location, index, data);
	}
	
	@Override
	public int read(char[] location) {
		return pointer = primiSerializer.read(location, pointer, data);
	}
	
	@Override
	public int read(char[] location, int index) {
		return primiSerializer.read(location, index, data);
	}
	
	@Override
	public int read(boolean[] location) {
		return pointer = primiSerializer.read(location, pointer, data);
	}
	
	@Override
	public int read(boolean[] location, int index) {
		return primiSerializer.read(location, index, data);
	}
	
	@Override
	public <T extends Serializable> T readSerializable(T type) {
		T serializable = structedSerializer.readSerializable(type, pointer, data);
		this.pointer +=serializable.getSize();
		return serializable;
	}
	
	@Override
	public <T extends Serializable> T readSerializable(T type, int index) {
		return structedSerializer.readSerializable(type, index, data);
	}
	
	@Override
	public int readSerializable2(Serializable destination) {
		return pointer = structedSerializer.readSerializable2(destination, pointer, data);
	}
	
	@Override
	public int readSerializable2(Serializable destination, int index) {
		return structedSerializer.readSerializable2(destination, index, data);
	}
	
	@Override
	public <T extends Serializable> T[] readSerializables(T[] type) {
		T[] serializable = structedSerializer.readSerializables(type, pointer, data);
		pointer += type[0].getSize() * type.length;
		return serializable;
	}
	
	@Override
	public <T extends Serializable> T[] readSerializables(T[] type, int index) {
		return structedSerializer.readSerializables(type, index, data);
	}
	
	@Override
	public int readSerializables2(Serializable[] destination) {
		return pointer = structedSerializer.readSerializables2(destination, pointer, data);
	}
	
	@Override
	public int readSerializables2(Serializable[] destination, int index) {
		return structedSerializer.readSerializables2(destination, index, data);
	}
	
	@Override
	public int write(byte data) {
		if(pointer + 1 <= this.data.length) {
			expand2(1);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(byte data, int index) {
		if(index + 1 <= this.data.length) {
			expand2(1);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(short data) {
		if(pointer + 2 <= this.data.length) {
			expand2(2);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(short data, int index) {
		if(index + 2 <= this.data.length) {
			expand2(2);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(int data) {
		if(pointer + 4 <= this.data.length) {
			expand2(4);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(int data, int index) {
		if(index + 4 <= this.data.length) {
			expand2(4);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(long data) {
		if(pointer + 8 <= this.data.length) {
			expand2(8);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(long data, int index) {
		if(index + 8 <= this.data.length) {
			expand2(8);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(float data) {
		if(pointer + 4 <= this.data.length) {
			expand2(4);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(float data, int index) {
		if(index + 4 <= this.data.length) {
			expand2(4);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(double data) {
		if(pointer + 8 <= this.data.length) {
			expand2(8);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(double data, int index) {
		if(index + 8 <= this.data.length) {
			expand2(8);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(char data) {
		if(pointer + 2 <= this.data.length) {
			expand2(2);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(char data, int index) {
		if(index + 2 <= this.data.length) {
			expand2(2);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(boolean data) {
		if(pointer + 1 <= this.data.length) {
			expand2(1);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(boolean data, int index) {
		if(index + 1 <= this.data.length) {
			expand2(1);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(byte[] data) {
		if(pointer + data.length <= this.data.length) {
			expand2(data.length);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(byte[] data, int index) {
		if(index + data.length <= this.data.length) {
			expand2(data.length);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(short[] data) {
		if(pointer + data.length * 2 <= this.data.length) {
			expand2(data.length * 2);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(short[] data, int index) {
		if(index + data.length * 2 <= this.data.length) {
			expand2(data.length * 2);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(int[] data) {
		if(pointer + data.length * 4 <= this.data.length) {
			expand2(data.length * 4);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(int[] data, int index) {
		if(index + data.length * 4 <= this.data.length) {
			expand2(data.length * 4);
		}		
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(long[] data) {
		if(pointer + data.length * 8 <= this.data.length) {
			expand2(data.length * 8);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(long[] data, int index) {
		if(index + data.length * 8 <= this.data.length) {
			expand2(data.length * 8);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(float[] data) {
		if(pointer + data.length * 4 <= this.data.length) {
			expand2(data.length * 4);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(float[] data, int index) {
		if(index + data.length * 4 <= this.data.length) {
			expand2(data.length * 4);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(double[] data) {
		if(pointer + data.length * 8 <= this.data.length) {
			expand2(data.length * 8);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(double[] data, int index) {
		if(index + data.length * 8 <= this.data.length) {
			expand2(data.length * 8);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(char[] data) {
		if(pointer + data.length * 2 <= this.data.length) {
			expand2(data.length * 2);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(char[] data, int index) {
		if(index + data.length * 2 <= this.data.length) {
			expand2(data.length * 2);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(boolean[] data) {
		if(pointer + data.length <= this.data.length) {
			expand2(data.length);
		}
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(boolean[] data, int index) {
		if(index + data.length <= this.data.length) {
			expand2(data.length);
		}
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(Serializable data) {
		if(pointer + data.getSize() <= this.data.length) {
			expand2(data.getSize());
		}
		return pointer = structedSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(Serializable data, int index) {
		if(index + data.getSize() <= this.data.length) {
			expand2(data.getSize());
		}
		return structedSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(Serializable[] data, int index) {
		return structedSerializer.write(data, index, this.data);
	}

	@Override
	public int write(Serializable[] data) {
		if(pointer + data[0].getSize() * data.length <= this.data.length) {
			expand2(data[0].getSize() * data.length);
		}
		return pointer = structedSerializer.write(data, pointer, this.data);
	}
}
