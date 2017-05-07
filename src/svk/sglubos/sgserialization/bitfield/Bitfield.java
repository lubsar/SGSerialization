package svk.sglubos.sgserialization.bitfield;

import svk.sglubos.sgserialization.Serializable;

public abstract class Bitfield implements Serializable {
	public abstract byte getBit(byte bit);
	public abstract void setBit(byte bit);
	public abstract void clearBit(byte bit);
	public abstract void toggleBit(byte bit);
}