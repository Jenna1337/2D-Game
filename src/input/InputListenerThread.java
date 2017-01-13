package input;

import java.awt.Component;
import java.awt.event.InputEvent;
import java.util.Properties;

public abstract class InputListenerThread extends InputAdapter
{
	private int triggerKey;
	private int type;
	public InputListenerThread(Component comp, int mask, int onKey)
	{
		this.type=mask;
		comp.addMouseListener(this);
		comp.addMouseWheelListener(this);
		comp.addKeyListener(this);
		this.triggerKey = onKey;
	}
	public void InputRecieved(InputEvent arg0, int arg1)
	{
		//System.out.println(Integer.toBinaryString(arg1)+" "+Integer.toBinaryString(type)+" "+Integer.toBinaryString(arg1&type));
		Properties props = Decoder.Decode(arg0);
		String etype = props.getProperty("eventType");
		//System.out.println(arg0.paramString());
		if((arg1&type)==KeyMask)
			//if(((KeyEvent)arg0).equals(triggerKey))
			this.run(props);
		else if((arg1&type)==MouseMask)
			//if(((MouseEvent)arg0).equals(triggerKey))
			this.run(props);
		else if((arg1&type)==MouseWheelMask)
			//if(((MouseWheelEvent)arg0).equals(triggerKey))
			this.run(props);
	}
	/**
	 * @param event Properties of the event recieved
	 */
	public abstract void run(Properties event);
}
