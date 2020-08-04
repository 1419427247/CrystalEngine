package pers.crystal.engine.utility.net;

import java.net.InetAddress;


public interface CEInstruction
{
	public abstract void Do(InetAddress inetAddress,CEMessage massage);
}
