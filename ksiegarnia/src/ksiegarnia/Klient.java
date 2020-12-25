package ksiegarnia;

public class Klient {
	
	private int id;
	private String imie;
	private String nazwisko;
	private String nr_telefonu;
	private String email;
	private String adres;
	private String haslo;
	private Kupno zakupy;
	
	public Klient(int id, String imie, String nazwisko, String nr_telefonu, String email, String adres, String haslo, Kupno zakupy)
	{
		this.id=id;
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.nr_telefonu=nr_telefonu;
		this.email=email;
		this.adres=adres;
		this.haslo=haslo;
		this.zakupy=zakupy;
	}
	public Klient(int id, String imie, String nazwisko, String nr_telefonu, String email, String adres, String haslo)
	{
		this.id=id;
		this.imie=imie;
		this.nazwisko=nazwisko;
		this.nr_telefonu=nr_telefonu;
		this.email=email;
		this.adres=adres;
		this.haslo=haslo;
	}
	public Klient()
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
	public String getNr_telefonu()
	{
		return nr_telefonu;
	}
	public String getEmail()
	{
		return email;
	}
	public String getAdres()
	{
		return adres;
	}
	public String getHaslo()
	{
		return haslo;
	}
	public Kupno getZakupy()
	{
		return zakupy;
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
	public void setNr_telefonu(String nr_telefonu)
	{
		this.nr_telefonu=nr_telefonu;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setAdres(String adres)
	{
		this.adres=adres;
	}
	public void setHaslo(String haslo)
	{
		this.haslo=haslo;
	}
	public void setZakupy(Kupno zakupy)
	{
		this.zakupy=zakupy;
	}
	
	public String toString()
	{
		return imie + " " + nazwisko + ", tel: " + nr_telefonu +
				", email: " + email + ", adres zamieszkania: " + adres;
	}
}
