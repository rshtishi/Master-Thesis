package projekti;

public interface LookupTable 
{
	public void put(String id,Symbol s);
	public String getValue(String id);
	public String getType(String id);
	public boolean containsKey(String id);
	
}
