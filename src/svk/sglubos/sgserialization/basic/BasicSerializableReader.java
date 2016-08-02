package svk.sglubos.sgserialization.basic;

import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.SerializableReader;

public class BasicSerializableReader implements SerializableReader {
	@Override
	public <T extends Serializable> T readSerializable(T type, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + type.getSize() <= source.length : "Source does not contain enough data";
		
		return type.deserialize(index, source);
	}
	
	@Override
	public int readSerializable2(Serializable destination, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + destination.getSize() <= source.length : "Source does not contain enough data";
		
		return destination.deserialize2(index, source);
	}

	@Override
	public <T extends Serializable> T[] readSerializables(T[] type, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + type[0].getSize() * type.length <= source.length : "Source does not contain enough data";
		
		for(T t : type) {
			t.deserialize(index, source);
			index += t.getSize();
		}
		
		return type;
	}

	@Override
	public int readSerializables2(Serializable[] destination, int index, byte[] source) {
		assert index >= 0 : "Index cannot be less than 0";
		assert index + destination[0].getSize() * destination.length <= source.length : "Source does not contain enough data";
		
		for(Serializable s : destination) {
			s.deserialize(index, source);
			index += s.getSize();
		}
		
		return index;
	}
}
