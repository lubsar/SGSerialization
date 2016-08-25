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

import java.nio.charset.Charset;

import svk.sglubos.sgserialization.PrimiSerializer;
import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.StructedSerializer;

public class StaticBuffer extends Buffer {
	private PrimiSerializer primiSerializer;
	private StructedSerializer structedSerializer;
	
	public StaticBuffer(int capacity, PrimiSerializer primiSerializer, StructedSerializer structedSerializer) {
		super(capacity);
		this.primiSerializer = primiSerializer;
		this.structedSerializer = structedSerializer;
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
		pointer += serializable.getSize();
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
	public String readString(int bytelength, int index) {
		return structedSerializer.readString(bytelength, index, data);
	}
	
	@Override
	public String readString(int bytelength) {
		String string = structedSerializer.readString(bytelength, pointer, data);
		pointer += bytelength;
		
		return string;
	}
	
	@Override
	public String readString(int bytelength, Charset charset, int index) {
		return structedSerializer.readString(bytelength, charset, index, data);
	}
	
	@Override
	public String readString(int bytelength, Charset charset) {
		String string = structedSerializer.readString(bytelength, charset, pointer, data);
		pointer += bytelength;
		
		return string;
	}
	
	@Override
	public int write(byte data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(byte data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(short data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(short data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(int data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(int data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(long data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(long data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(float data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(float data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(double data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(double data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(char data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(char data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(boolean data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(boolean data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(byte[] data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(byte[] data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(short[] data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(short[] data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(int[] data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(int[] data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(long[] data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(long[] data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(float[] data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(float[] data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(double[] data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(double[] data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(char[] data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(char[] data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(boolean[] data) {
		return pointer = primiSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(boolean[] data, int index) {
		return primiSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(Serializable data) {
		return pointer = structedSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(Serializable data, int index) {
		return structedSerializer.write(data, index, this.data);
	}

	@Override
	public int write(Serializable[] data, int index) {
		return structedSerializer.write(data, index, this.data);
	}

	@Override
	public int write(Serializable[] data) {
		return pointer = structedSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(String data, int index) {
		return structedSerializer.write(data, index, this.data);
	}
	
	@Override
	public int write(String data) {
		return pointer = structedSerializer.write(data, pointer, this.data);
	}
	
	@Override
	public int write(String data, Charset charset, int index) {
		return structedSerializer.write(data, charset, index, this.data);
	}
	
	
	@Override
	public int write(String data, Charset charset) {
		return pointer = structedSerializer.write(data, charset, pointer, this.data);
	}
}
