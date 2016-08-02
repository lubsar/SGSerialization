package svk.sglubos.sgserialization.buffer;

import svk.sglubos.sgserialization.PrimiArrReader;
import svk.sglubos.sgserialization.PrimiArrWriter;
import svk.sglubos.sgserialization.PrimiReader;
import svk.sglubos.sgserialization.PrimiWriter;
import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.SerializableReader;
import svk.sglubos.sgserialization.SerializableWriter;

public class DynamicBuffer extends Buffer {
	private int expansion;
	private boolean expandByRate = false;
	private float expansionRate = 1.0f;
	private boolean expandAsNeeded = false;
	
	private PrimiWriter primitiveWriter;
	private PrimiArrWriter primitiveArrWriter;
	private SerializableWriter serializableWriter;
	private PrimiReader primitiveReader;
	private PrimiArrReader primitiveArrReader;
	private SerializableReader serializableReader;

	public DynamicBuffer(int capacity, int expansion, PrimiWriter primitiveWriter, PrimiArrWriter primitiveArrWriter,
			SerializableWriter serializableWriter, PrimiReader primitiveReader, PrimiArrReader primitiveArrReader,
			SerializableReader serializableReader) {
		super(capacity);
		this.expansion = expansion;
		this.primitiveWriter = primitiveWriter;
		this.primitiveArrWriter = primitiveArrWriter;
		this.serializableWriter = serializableWriter;
		this.primitiveReader = primitiveReader;
		this.primitiveArrReader = primitiveArrReader;
		this.serializableReader = serializableReader;
	}
	
	public DynamicBuffer(int capacity, float expansionRate, PrimiWriter primitiveWriter, PrimiArrWriter primitiveArrWriter,
			SerializableWriter serializableWriter, PrimiReader primitiveReader, PrimiArrReader primitiveArrReader,
			SerializableReader serializableReader) {
		super(capacity);
		this.expansionRate = expansionRate;
		this.expandByRate = true;
		this.primitiveWriter = primitiveWriter;
		this.primitiveArrWriter = primitiveArrWriter;
		this.serializableWriter = serializableWriter;
		this.primitiveReader = primitiveReader;
		this.primitiveArrReader = primitiveArrReader;
		this.serializableReader = serializableReader;
	}
	
	public DynamicBuffer(int capacity, PrimiWriter primitiveWriter, PrimiArrWriter primitiveArrWriter,
			SerializableWriter serializableWriter, PrimiReader primitiveReader, PrimiArrReader primitiveArrReader,
			SerializableReader serializableReader) {
		super(capacity);
		this.expandAsNeeded = true;
		this.primitiveWriter = primitiveWriter;
		this.primitiveArrWriter = primitiveArrWriter;
		this.serializableWriter = serializableWriter;
		this.primitiveReader = primitiveReader;
		this.primitiveArrReader = primitiveArrReader;
		this.serializableReader = serializableReader;
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
		this.pointer +=serializable.getSize();
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
		if(pointer + 1 <= this.data.length) {
			expand2(1);
		}
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(byte data, int index) {
		if(index + 1 <= this.data.length) {
			expand2(1);
		}
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(short data) {
		if(pointer + 2 <= this.data.length) {
			expand2(2);
		}
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(short data, int index) {
		if(index + 2 <= this.data.length) {
			expand2(2);
		}
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(int data) {
		if(pointer + 4 <= this.data.length) {
			expand2(4);
		}
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(int data, int index) {
		if(index + 4 <= this.data.length) {
			expand2(4);
		}
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(long data) {
		if(pointer + 8 <= this.data.length) {
			expand2(8);
		}
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(long data, int index) {
		if(index + 8 <= this.data.length) {
			expand2(8);
		}
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(float data) {
		if(pointer + 4 <= this.data.length) {
			expand2(4);
		}
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(float data, int index) {
		if(index + 4 <= this.data.length) {
			expand2(4);
		}
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(double data) {
		if(pointer + 8 <= this.data.length) {
			expand2(8);
		}
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(double data, int index) {
		if(index + 8 <= this.data.length) {
			expand2(8);
		}
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(char data) {
		if(pointer + 2 <= this.data.length) {
			expand2(2);
		}
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(char data, int index) {
		if(index + 2 <= this.data.length) {
			expand2(2);
		}
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(boolean data) {
		if(pointer + 1 <= this.data.length) {
			expand2(1);
		}
		return pointer = primitiveWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(boolean data, int index) {
		if(index + 1 <= this.data.length) {
			expand2(1);
		}
		return primitiveWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(byte[] data) {
		if(pointer + data.length <= this.data.length) {
			expand2(data.length);
		}
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(byte[] data, int index) {
		if(index + data.length <= this.data.length) {
			expand2(data.length);
		}
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(short[] data) {
		if(pointer + data.length * 2 <= this.data.length) {
			expand2(data.length * 2);
		}
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(short[] data, int index) {
		if(index + data.length * 2 <= this.data.length) {
			expand2(data.length * 2);
		}
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(int[] data) {
		if(pointer + data.length * 4 <= this.data.length) {
			expand2(data.length * 4);
		}
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(int[] data, int index) {
		if(index + data.length * 4 <= this.data.length) {
			expand2(data.length * 4);
		}		
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(long[] data) {
		if(pointer + data.length * 8 <= this.data.length) {
			expand2(data.length * 8);
		}
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(long[] data, int index) {
		if(index + data.length * 8 <= this.data.length) {
			expand2(data.length * 8);
		}
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(float[] data) {
		if(pointer + data.length * 4 <= this.data.length) {
			expand2(data.length * 4);
		}
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(float[] data, int index) {
		if(index + data.length * 4 <= this.data.length) {
			expand2(data.length * 4);
		}
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(double[] data) {
		if(pointer + data.length * 8 <= this.data.length) {
			expand2(data.length * 8);
		}
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(double[] data, int index) {
		if(index + data.length * 8 <= this.data.length) {
			expand2(data.length * 8);
		}
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(char[] data) {
		if(pointer + data.length * 2 <= this.data.length) {
			expand2(data.length * 2);
		}
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(char[] data, int index) {
		if(index + data.length * 2 <= this.data.length) {
			expand2(data.length * 2);
		}
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(boolean[] data) {
		if(pointer + data.length <= this.data.length) {
			expand2(data.length);
		}
		return pointer = primitiveArrWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(boolean[] data, int index) {
		if(index + data.length <= this.data.length) {
			expand2(data.length);
		}
		return primitiveArrWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(Serializable data) {
		if(pointer + data.getSize() <= this.data.length) {
			expand2(data.getSize());
		}
		return pointer = serializableWriter.write(data, pointer, this.data);
	}
	
	@Override
	public int write(Serializable data, int index) {
		if(index + data.getSize() <= this.data.length) {
			expand2(data.getSize());
		}
		return serializableWriter.write(data, index, this.data);
	}
	
	@Override
	public int write(Serializable[] data, int index) {
		return serializableWriter.write(data, index, this.data);
	}

	@Override
	public int write(Serializable[] data) {
		if(pointer + data[0].getSize() * data.length <= this.data.length) {
			expand2(data[0].getSize() * data.length);
		}
		return pointer = serializableWriter.write(data, pointer, this.data);
	}
}
