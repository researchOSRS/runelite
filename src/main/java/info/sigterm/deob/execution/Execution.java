package info.sigterm.deob.execution;

import info.sigterm.deob.ClassFile;
import info.sigterm.deob.ClassGroup;
import info.sigterm.deob.Method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Execution
{
	private ClassGroup group;
	public List<Frame> frames = new ArrayList<>();

	public Execution(ClassGroup group)
	{
		this.group = group;
	}
	
	public int run()
	{
		int fcount = 0;
		
		while (!frames.isEmpty())
		{
			Frame frame = frames.remove(0);
			System.out.println("Executing frame " + frame);
			++fcount;
			frame.execute();
		}
		
		return fcount;
	}
}
