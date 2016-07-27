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
import svk.sglubos.sgserialization.buffer.StaticBuffer;

public class BufferFactory {
	private static final BasicPrimiWriter defPrimiWriter = new BasicPrimiWriter();
	private static final BasicPrimiArrWriter defPrimiArrWriter = new BasicPrimiArrWriter();
	private static final BasicSerializableWriter defSerializableWriter = new BasicSerializableWriter();

	private static final BasicPrimiReader defPrimiReader = new BasicPrimiReader();
	private static final BasicPrimiArrReader defPrimiArrReader = new BasicPrimiArrReader();
	private static final BasicSerializableReader defSerializableReader = new BasicSerializableReader();

	public StaticBuffer createStaticBuffer(int capacity) {
		return new StaticBuffer(capacity, defPrimiWriter, defPrimiArrWriter, defSerializableWriter, defPrimiReader,
				defPrimiArrReader, defSerializableReader);
	}

	public StaticBuffer createStaticBuffer(int capacity, PrimiWriter primitiveWriter, PrimiArrWriter primitiveArrWriter,
			SerializableWriter serializableWriter, PrimiReader primitiveReader, PrimiArrReader primitiveArrReader,
			SerializableReader serializableReader) {
		return new StaticBuffer(capacity, primitiveWriter, primitiveArrWriter, serializableWriter, primitiveReader,
				primitiveArrReader, serializableReader);
	}
}
