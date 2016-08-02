package svk.sglubos.sgserialization.basic;

import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.SerializableWriter;

public class BasicSerializableWriter implements SerializableWriter {
	@Override
	public int write(Serializable data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data.getSize() <= destination.length : "Destionation does not have enough capacity";
		
		return data.serialize(index, destination);
	}

	@Override
	public int write(Serializable[] data, int index, byte[] destination) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + data[0].getSize() * data.length <= destination.length : "Destionation does not have enough capacity";
		
		for(Serializable s : data) {
			s.serialize(index, destination);
			index += s.getSize();
		}
		
		return index;
	}
}
