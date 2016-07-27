package svk.sglubos.sgserialization;

public interface SerializableWriter {
	public int write(Serializable data, int index, byte[] destination);
}
