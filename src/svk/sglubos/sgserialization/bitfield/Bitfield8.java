package svk.sglubos.sgserialization.bitfield;

public class Bitfield8 extends Bitfield {
	public byte data;
	
	public Bitfield8() {}
	
	public Bitfield8(byte data) {
		this.data = data;
	}
	
	@Override
	public int serialize(int index, byte[] location) {
		location[index] = data;
		return index++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bitfield8 deserialize(int index, byte[] source) {
		return new Bitfield8(source[index]);
	}

	@Override
	public int deserialize2(int index, byte[] source) {
		this.data = source[index];
		return index++;
	}

	@Override
	public int getSize() {
		return 1;
	}

	@Override
	public byte getBit(byte bit) {
		assert (bit >= 0) && (bit < 8): "Bit must be between 0 and 7"; 
		return (byte) ((data >> bit) & 0b00000001); 
	}

	@Override
	public void setBit(byte bit) {
		assert (bit >= 0) && (bit < 8): "Bit must be between 0 and 7";
		data |= (1 << bit);
	}

	@Override
	public void clearBit(byte bit) {
		assert (bit >= 0) && (bit < 8): "Bit must be between 0 and 7";
		data = (byte) (data & ~(1 << bit));
	}

	@Override
	public void toggleBit(byte bit) {
		assert (bit >= 0) && (bit < 8): "Bit must be between 0 and 7";
		data ^= 1 << bit;
	}
}
