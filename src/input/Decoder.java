package input;

import java.awt.event.InputEvent;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Properties;

public class Decoder
{
	public static Properties Decode(InputEvent event)
	{
		System.out.println(event.paramString());
		String sta = "eventType="+fix(event.paramString());
		System.out.println(sta);
		Properties props = new Properties();
		try
		{
			props.load(new StringReader(sta));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}
	private static char[][] groupers=
	{
		{'{','}'},
		{'[',']'},
		{'(',')'},
		{'\"','\"'},
		{'\'','\''}
	};
	/**
	 * This method hangs if given certain text
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private static String fix(String query)
	{
		if(true)
			return query;
		ArrayList<String> strs=new ArrayList<String>();
		String pip="";
		int left, right;
		char privch='\uE001';
		char lch, rch;
		for(char[] cha : groupers)
		{
			lch=cha[0];
			rch=cha[1];
			while(
				(query.contains(""+lch)||query.contains(""+rch))
				&&(query.indexOf(lch)!=query.lastIndexOf(rch))
				)
			{
				pip=""; left=0; right=0;
				for(int i=0;i<query.length();++i)
				{
					if(query.charAt(i)=='(')
					{
						left=i;
						break;
					}
				}
				int parsleft=1;
				for(int i=left+1;i<query.length();++i)
				{
					if(query.charAt(i)==lch)
						parsleft+=1;
					if(query.charAt(i)==rch)
						parsleft-=1;
					if(parsleft==0)
					{
						right=i;
						break;
					}
				}
				for(int k=left+1;k<right;++k)
					pip+=query.charAt(k);
				pip=lch+pip+rch;
				strs.add(pip);
				query = query.replace(pip, ""+(privch+=1));
			}
		}
		query.replace(",", System.lineSeparator());
		for(int i=strs.size(); i>0; --i)
			query.replace(""+(privch-=1), ""+strs.get(i-1));
		return query;
	}
}
