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

import svk.sglubos.sgserialization.PrimiArrReader;
import svk.sglubos.sgserialization.PrimiArrWriter;
import svk.sglubos.sgserialization.PrimiReader;
import svk.sglubos.sgserialization.PrimiWriter;
import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.SerializableReader;
import svk.sglubos.sgserialization.SerializableWriter;

public class StaticBuffer extends Buffer {
	private PrimiWriter primitiveWriter;
	private PrimiArrWriter primitiveArrWriter;
	private SerializableWriter serializableWriter;
	private PrimiReader primitiveReader;
	private PrimiArrReader primitiveArrReader;
	private SerializableReader serializableReader;

	public StaticBuffer(int capacity, PrimiWriter primitiveWriter, PrimiArrWriter primitiveArrWriter,
			SerializableWriter serializableWriter, PrimiReader primitiveReader, PrimiArrReader primitiveArrReader,
			SerializableReader serializableReader) {
		super(capacity);
		this.primitiveWriter = primitiveWriter;
		this.primitiveArrWriter = primitiveArrWriter;
		this.serializableWriter = serializableWriter;
		this.primitiveReader = primitiveReader;
		this.primitiveArrReader = primitiveArrReader;
		this.serializableReader = serializableReader;
	}
	
	@Override
	public byte readByte() {
		return primitiveReader.readByte(pointer++, data);
	}
	
	@Override
	public byte readByte(int index) {
		return primitiveReader.readByte(index, data);
	}
	
	@Override
	public short readShort() {
		short tmp = primitiveReader.readShort(pointer, data);
		pointer += 2;
		return tmp;
	}
	
	@Override
	public short readShort(int index) {
		return primitiveReader.readShort(index, data);
	}
	
	@Override
	public int readInt() {
		int tmp = primitiveReader.readInt(pointer, data);
		pointer += 4;
		return tmp;
	}
	
	@Override
	public int readInt(int index) {
		return primitiveReader.readInt(index, data);
	}
	
	@Override
	public long readLong() {
		long tmp = primitiveReader.readLong(pointer, data);
		pointer += 8;
		return tmp;
	}
	
	@Override
	public long readLong(int index) {
		return primitiveReader.readLong(index, data);
	}
	
	@Override
	public float readFloat() {
		float tmp = primitiveReader.readFloat(pointer, data);
		pointer += 4;
		return tmp;
	}
	
	@Override
	public float readFloat(int index) {
		return primitiveReader.readFloat(index, data);
	}
	
	@Override
	public double readDouble() {
		double tmp = primitiveReader.readDouble(pointer, data);
		pointer += 8;
		return tmp;
	}
	
	@Override
	public double readDouble(int index) {
		return primitiveReader.readByte(index, data);
	}
	
	@Override
	public char readChar() {
		char tmp = primitiveReader.readChar(pointer, data);
		pointer += 2;
		return tmp;
	}
	
	@Override
	public char readChar(int index) {
		return primitiveReader.readChar(index, data);
	}
	
	@Override
	public boolean readBoolean() {
		return primitiveReader.readBoolean(pointer++, data);
	}
	
	@Override
	public boolean readBoolean(int index) {
		return primitiveReader.readBoolean(index, data);
	}
	
	@Override
	public byte[] readBytes(int size) {
		byte[] tmp = primitiveArrReader.readBytes(size, pointer, data);
		pointer += size;
		return tmp;
	}
	
	@Override
	public byte[] readBytes(int size, int index) {
		return primitiveArrReader.readBytes(size, index, data);
	}
	
	@Override
	public short[] readShorts(int size) {
		short[] tmp = primitiveArrReader.readShorts(size, pointer, data);
		pointer += size * 2;
		return tmp;
	}
	
	@Override
	public short[] readShorts(int size, int index) {
		return primitiveArrReader.readShorts(size, index, data);
	}
	
	@Override
	public int[] readInts(int size) {
		int[] tmp = primitiveArrReader.readInts(size, pointer, data);
		pointer += size * 4;
		return tmp;
	}
	
	@Override
	public int[] readInts(int size, int index) {
		return primitiveArrReader.readInts(size, index, data);
	}
	
	@Override
	public long[] readLongs(int size) {
		long[] tmp = primitiveArrReader.readLongs(size, pointer, data);
		pointer += size * 8;
		return tmp;
	}
	
	@Override
	public long[] readLongs(int size, int index) {
		return primitiveArrReader.readLongs(size, index, data);
	}
	
	@Override
	public float[] readFloats(int size) {
		float[] tmp = primitiveArrReader.readFloats(size, pointer, data);
		pointer += size * 4;
		return tmp;
	}
	
	@Override
	public float[] readFloats(int size, int index) {
		return primitiveArrReader.readFloats(size, index, data);
	}
	
	@Override
	public double[] readDoubles(int size) {
		double[] tmp = primitiveArrReader.readDoubles(size, pointer, data);
		pointer += size * 8;
		return tmp;
	}
	
	@Override
	public double[] readDoubles(int size, int index) {
		return primitiveArrReader.readDoubles(size, index, data);
	}
	
	@Override
	public char[] readChars(int size) {
		char[] tmp = primitiveArrReader.readChars(size, pointer, data);
		pointer += size * 4;
		return tmp;
	}
	
	@Override
	public char[] readChars(int size, int index) {
		return primitiveArrReader.readChars(size, index, data);
	}
	
	@Override
	public boolean[] readBooleans(int size) {
		boolean[] tmp = primitiveArrReader.readBooleans(size, pointer, data);
		pointer += size;
		return tmp;
	}
	
	@Override
	public boolean[] readBooleans(int size, int index) {
		return primitiveArrReader.readBooleans(size, index, data);
	}
	
	@Override
	public int read(byte[] location) {
		return pointer = primitiveArrReader.read(location, pointer, data);
	}
	
	@Override
	public int read(byte[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}
	
	@Override
	public int read(short[] location) {
		return pointer = primitiveArrReader.read(location, pointer, data);
	}
	
	@Override
	public int read(short[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}
	
	@Override
	public int read(int[] location) {
		return pointer = primitiveArrReader.read(location, pointer, data);
	}
	
	@Override
	public int read(int[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}
	
	@Override
	public int read(long[] location) {
		return pointer = primitiveArrReader.read(location, pointer, data);
	}
	
	@Override
	public int read(long[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}
	
	@Override
	public int read(float[] location) {
		return pointer = primitiveArrReader.read(location, pointer, data);
	}
	
	@Override
	public int read(float[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}
	
	@Override
	public int read(double[] location) {
		return pointer = primitiveArrReader.read(location, pointer, data);
	}
	
	@Override
	public int read(double[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}
	
	@Override
	public int read(char[] location) {
		return pointer = primitiveArrReader.read(location, pointer, data);
	}
	
	@Override
	public int read(char[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}
	
	@Override
	public int read(boolean[] location) {
		return pointer = primitiveArrReader.read(location, pointer, data);
	}
	
	@Override
	public int read(boolean[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}
	
	@Override
	public <T extends Serializable> T readSerializable(T type) {
		T serializable = serializableReader.readSerializable(type, pointer, data);
		pointer += serializable.getSize();
		return serializable;
	}
	
	@Override
	public <T extends Serializable> T readSerializable(T type, int index) {
		return serializableReader.readSerializable(type, index, data);
	}
	
	@Override
	public int readSerializable2(Serializable destination) {
		return pointer = serializableReader.readSerializable2(destination, pointer, data);
	}
	
	@Override
	public int readSerializable2(Serializable destination, int index) {
		return serializableReader.readSerializable2(destination, index, data);
	}
	
	@Override
	public <T extends Serializable> T[] readSerializables(T[] type) {
		T[] serializable = serializableReader.readSerializables(type, pointer, data);
		pointer += type[0].getSize() * type.length;
		return serializable;
	}
	
	@Override
	public <T extends Serializable> T[] readSerializables(T[] type, int index) {
		return serializableReader.readSerializables(type, index, data);
	}
	
	@Override
	public int readSerializables2(Serializable[] destination) {
		return pointer = serializableReader.readSerializables2(destination, pointer, data);
	}
	
	@Override
	public int readSerializables2(Serializable[] destination, int index) {
		return serializableReader.readSerializables2(destination, index, data);
	}
	
	@Override
	public int write(byte data) {
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(byte data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(short data) {
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(short data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(int data) {
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(int data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(long data) {
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(long data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(float data) {
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(float data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(double data) {
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(double data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(char data) {
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(char data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(boolean data) {
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(boolean data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(byte[] data) {
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(byte[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(short[] data) {
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(short[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(int[] data) {
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(int[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(long[] data) {
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(long[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(float[] data) {
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(float[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(double[] data) {
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(double[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(char[] data) {
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(char[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(boolean[] data) {
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(boolean[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(Serializable data) {
		return pointer = serializableWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(Serializable data, int index) {
		return serializableWriter.write(data, index, this.data);
	}

	@Override
	public int write(Serializable[] data, int index) {
		return serializableWriter.write(data, index, this.data);
	}

	@Override
	public int write(Serializable[] data) {
		return pointer = serializableWriter.write(data, pointer, this.data);
	}
}
