package svk.sglubos.sgserialization.basic;

import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.SerializableWriter;

public class BasicSerializableWriter implements SerializableWriter {
	@Override
	public int write(Serializable data, int index, byte[] destination) {
		return data.serialize(index, destination);
	}
}
