package info.sigterm.deob.pool;

import info.sigterm.deob.ConstantPool;
import info.sigterm.deob.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Float extends PoolEntry
{
	private float value;

	public Float(ConstantPool pool) throws IOException
	{
		super(pool, ConstantType.FLOAT);

		DataInputStream is = pool.getClassFile().getStream();

		value = is.readFloat();
	}
	
	public Float(ConstantPool pool, float f)
	{
		super(pool, ConstantType.FLOAT);
		
		value = f;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Float))
			return false;
		
		Float f = (Float) other;
		return value == f.value;
	}

	@Override
	public Type getTypeClass()
	{
		return new Type(float.class.getCanonicalName());
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeFloat(value);
	}
}
