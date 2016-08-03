package svk.sglubos.sgserialization.basic.buffer;

import svk.sglubos.sgserialization.PrimiArrReader;
import svk.sglubos.sgserialization.PrimiArrWriter;
import svk.sglubos.sgserialization.PrimiReader;
import svk.sglubos.sgserialization.PrimiWriter;
import svk.sglubos.sgserialization.SerializableReader;
import svk.sglubos.sgserialization.SerializableWriter;
import svk.sglubos.sgserialization.basic.BasicPrimiArrReader;
import svk.sglubos.sgserialization.basic.BasicPrimiArrWriter;
import svk.sglubos.sgserialization.basic.BasicPrimiReader;
import svk.sglubos.sgserialization.basic.BasicPrimiWriter;
import svk.sglubos.sgserialization.basic.BasicSerializableReader;
import svk.sglubos.sgserialization.basic.BasicSerializableWriter;
import svk.sglubos.sgserialization.buffer.DynamicBuffer;
import svk.sglubos.sgserialization.buffer.StaticBuffer;

public class BufferFactory {
	private static final BasicPrimiWriter defPrimiWriter = new BasicPrimiWriter();
	private static final BasicPrimiArrWriter defPrimiArrWriter = new BasicPrimiArrWriter();
	private static final BasicSerializableWriter defSerializableWriter = new BasicSerializableWriter();

	private static final BasicPrimiReader defPrimiReader = new BasicPrimiReader();
	private static final BasicPrimiArrReader defPrimiArrReader = new BasicPrimiArrReader();
	private static final BasicSerializableReader defSerializableReader = new BasicSerializableReader();

	public static StaticBuffer createStaticBuffer(int capacity) {
		return new StaticBuffer(capacity, defPrimiWriter, defPrimiArrWriter, defSerializableWriter, defPrimiReader,
				defPrimiArrReader, defSerializableReader);
	}

	public static StaticBuffer createStaticBuffer(int capacity, PrimiWriter primitiveWriter, PrimiArrWriter primitiveArrWriter,
			SerializableWriter serializableWriter, PrimiReader primitiveReader, PrimiArrReader primitiveArrReader,
			SerializableReader serializableReader) {
		return new StaticBuffer(capacity, primitiveWriter, primitiveArrWriter, serializableWriter, primitiveReader,
				primitiveArrReader, serializableReader);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity, int expansion) {
		return new DynamicBuffer(capacity, expansion, defPrimiWriter, defPrimiArrWriter, defSerializableWriter, defPrimiReader, defPrimiArrReader, defSerializableReader);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity, int expansion, PrimiWriter primitiveWriter, PrimiArrWriter primitiveArrWriter,
			SerializableWriter serializableWriter, PrimiReader primitiveReader, PrimiArrReader primitiveArrReader,
			SerializableReader serializableReader) {
		return new DynamicBuffer(capacity, expansion, primitiveWriter, primitiveArrWriter, serializableWriter, primitiveReader, primitiveArrReader, serializableReader);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity, float expansionRate) {
		return new DynamicBuffer(capacity, expansionRate, defPrimiWriter, defPrimiArrWriter, defSerializableWriter, defPrimiReader, defPrimiArrReader, defSerializableReader);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity, float expansionRate, PrimiWriter primitiveWriter, PrimiArrWriter primitiveArrWriter,
			SerializableWriter serializableWriter, PrimiReader primitiveReader, PrimiArrReader primitiveArrReader,
			SerializableReader serializableReader) {
		return new DynamicBuffer(capacity, expansionRate, primitiveWriter, primitiveArrWriter, serializableWriter, primitiveReader, primitiveArrReader, serializableReader);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity) {
		return new DynamicBuffer(capacity, defPrimiWriter, defPrimiArrWriter, defSerializableWriter, defPrimiReader, defPrimiArrReader, defSerializableReader);
	}
	
	public static DynamicBuffer createDynamicBuffer(int capacity, PrimiWriter primitiveWriter, PrimiArrWriter primitiveArrWriter,
			SerializableWriter serializableWriter, PrimiReader primitiveReader, PrimiArrReader primitiveArrReader,
			SerializableReader serializableReader) {
		return new DynamicBuffer(capacity, primitiveWriter, primitiveArrWriter, serializableWriter, primitiveReader, primitiveArrReader, serializableReader);
	}
}
