package svk.sglubos.sgserialization;

public interface Serializable {
	public int serialize(int index, byte[] location);
	public <T extends Serializable> T deserialize(int index, byte[] source);
	public int deserialize2(int index, byte[] source);
	public int getSize();
}
