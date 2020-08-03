package pers.crystal.engine.utility;

import java.net.InetAddress;

import pers.crystal.engine.utility.net.CEMessage;


public interface CEInstruction
{
	public abstract void Do(InetAddress inetAddress,CEMessage massage);
}
