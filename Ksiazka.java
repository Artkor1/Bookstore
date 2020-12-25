package ksiegarnia;

public class Ksiazka {

	
	private int id;
	private String tytul;
	private int rok_wydania;
	private float cena;
	private String oprawka;
	private Autor autor_ksiazki;
	
	public Ksiazka(int id, String tytul, int rok_wydania, float cena, String oprawka, Autor autor_ksiazki)
	{
		this.id=id;
		this.tytul=tytul;
		this.rok_wydania=rok_wydania;
		this.cena=cena;
		this.oprawka=oprawka;
		this.autor_ksiazki=autor_ksiazki;
	}
	public Ksiazka()
	{
		
	}
	
	public int getId()
	{
		return id;
	}
	public String getTytul()
	{
		return tytul;
	}
	public int getRok_wydania()
	{
		return rok_wydania;
	}
	public float getCena()
	{
		return cena;
	}
	public String getOprawka()
	{
		return oprawka;
	}
	public Autor getAutor_ksiazki()
	{
		return autor_ksiazki;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	public void setTytul(String tytul)
	{
		this.tytul=tytul;
	}
	public void setRok_wydania(int rok_wydania)
	{
		this.rok_wydania=rok_wydania;
	}
	public void setCena(float cena)
	{
		this.cena=cena;
	}
	public void setOprawka(String oprawka)
	{
		this.oprawka=oprawka;
	}
	public void setAutor_ksiazki(Autor autor_ksiazki)
	{
		this.autor_ksiazki=autor_ksiazki;
	}
	
	public String toString()
	{
		return tytul + ", autor: " + autor_ksiazki + ", rok wydania: " + rok_wydania  
				+ ", " + oprawka + " oprawka, cena: " + cena;
	}
}
