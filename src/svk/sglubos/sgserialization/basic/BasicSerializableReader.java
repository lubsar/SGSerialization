package svk.sglubos.sgserialization.basic;

import svk.sglubos.sgserialization.Serializable;
import svk.sglubos.sgserialization.SerializableReader;

public class BasicSerializableReader implements SerializableReader {
	@Override
	public <T extends Serializable> T readSerializable(T type, int index, byte[] source) {
		return type.deserialize(index, source);
	}
	
	@Override
	public int readSerializable2(Serializable destination, int index, byte[] source) {
		return destination.deserialize2(index, source);
	}
}
