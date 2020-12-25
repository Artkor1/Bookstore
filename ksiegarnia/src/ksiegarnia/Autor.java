package ksiegarnia;

public class Autor {

	private int id;
	private String imie;
	private String nazwisko;
	
	public Autor(int id, String imie, String nazwisko)
	{
		this.id=id;
		this.imie=imie;
		this.nazwisko=nazwisko;
	}
	public Autor()
	{
		
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getImie()
	{
		return imie;
	}
	
	public String getNazwisko()
	{
		return nazwisko;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setImie(String imie)
	{
		this.imie=imie;
	}
	
	public void setNazwisko(String nazwisko)
	{
		this.nazwisko=nazwisko;
	}
	
	public String toString()
	{
		return imie + " " + nazwisko;
	}
}
