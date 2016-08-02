package svk.sglubos.sgserialization;

public interface SerializableReader {
	public <T extends Serializable> T readSerializable(T type,int index, byte[] source);
	public int readSerializable2(Serializable destination, int index, byte[] source);
	public <T extends Serializable> T[] readSerializables(T[] type,int index, byte[] source);
	public int readSerializables2(Serializable[] destination, int index, byte[] source);
}
