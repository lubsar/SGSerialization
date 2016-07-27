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
	public byte readByte(int index) {
		return primitiveReader.readByte(index, data);
	}

	@Override
	public short readShort(int index) {
		return primitiveReader.readShort(index, data);
	}

	@Override
	public int readInt(int index) {
		return primitiveReader.readInt(index, data);
	}

	@Override
	public long readLong(int index) {
		return primitiveReader.readLong(index, data);
	}

	@Override
	public float readFloat(int index) {
		return primitiveReader.readFloat(index, data);
	}

	@Override
	public double readDouble(int index) {
		return primitiveReader.readByte(index, data);
	}

	@Override
	public char readChar(int index) {
		return primitiveReader.readChar(index, data);
	}

	@Override
	public boolean readBoolean(int index) {
		return primitiveReader.readBoolean(index, data);
	}
	
	@Override
	public byte[] readBytes(int index, int size) {
		return primitiveArrReader.readBytes(index, size, data);
	}

	@Override
	public short[] readShorts(int index, int size) {
		return primitiveArrReader.readShorts(index, size, data);
	}

	@Override
	public int[] readInts(int index, int size) {
		return primitiveArrReader.readInts(index, size, data);
	}

	@Override
	public long[] readLongs(int index, int size) {
		return primitiveArrReader.readLongs(index, size, data);
	}

	@Override
	public float[] readFloats(int index, int size) {
		return primitiveArrReader.readFloats(index, size, data);
	}

	@Override
	public double[] readDoubles(int index, int size) {
		return primitiveArrReader.readDoubles(index, size, data);
	}

	@Override
	public char[] readChars(int index, int size) {
		return primitiveArrReader.readChars(index, size, data);
	}

	@Override
	public boolean[] readBooleans(int index, int size) {
		return primitiveArrReader.readBooleans(index, size, data);
	}

	@Override
	public int read(byte[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}

	@Override
	public int read(short[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}

	@Override
	public int read(int[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}

	@Override
	public int read(long[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}

	@Override
	public int read(float[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}

	@Override
	public int read(double[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}

	@Override
	public int read(char[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}

	@Override
	public int read(boolean[] location, int index) {
		return primitiveArrReader.read(location, index, data);
	}

	@Override
	public <T extends Serializable> T readSerializable(T type, int index) {
		return serializableReader.readSerializable(type, index, data);
	}

	@Override
	public int readSerializable2(Serializable destination, int index) {
		return serializableReader.readSerializable2(destination, index, data);
	}

	@Override
	public int write(byte data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}

	@Override
	public int write(short data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}

	@Override
	public int write(int data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}

	@Override
	public int write(long data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}

	@Override
	public int write(float data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}

	@Override
	public int write(double data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}

	@Override
	public int write(char data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}

	@Override
	public int write(boolean data, int index) {
		return primitiveWriter.write(data, index, this.data);
	}

	@Override
	public int write(byte[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}

	@Override
	public int write(short[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}

	@Override
	public int write(int[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}

	@Override
	public int write(long[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}

	@Override
	public int write(float[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}

	@Override
	public int write(double[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}

	@Override
	public int write(char[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}

	@Override
	public int write(boolean[] data, int index) {
		return primitiveArrWriter.write(data, index, this.data);
	}

	@Override
	public int write(Serializable data, int index) {
		return serializableWriter.write(data, index, this.data);
	}
}
