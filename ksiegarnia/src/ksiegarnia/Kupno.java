package ksiegarnia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Kupno {

	private int id;
	private Date data_zamowienia;
	private Date data_dostarczenia;
	private float kwota;
	private boolean czy_zaplacono;
	private ArrayList<Ksiazka> koszyk;
	
	public Kupno(int id, Date data_zamowienia, Date data_dostarczenia, float kwota, boolean czy_zaplacono, ArrayList<Ksiazka> koszyk)
	{
		this.id=id;
		this.data_zamowienia=data_zamowienia;
		this.data_dostarczenia=data_dostarczenia;
		this.kwota=kwota;
		this.czy_zaplacono=czy_zaplacono;
		this.koszyk=koszyk;
		this.koszyk=koszyk;
	}
	public Kupno(int id, Date data_zamowienia, Date data_dostarczenia, float kwota, boolean czy_zaplacono)
	{
		this.id=id;
		this.data_zamowienia=data_zamowienia;
		this.data_dostarczenia=data_dostarczenia;
		this.kwota=kwota;
		this.czy_zaplacono=czy_zaplacono;
		koszyk = new ArrayList<Ksiazka>();
	}
	public Kupno()
	{
		
	}
	
	public void addToKoszyk(Ksiazka k)
	{
		System.out.println("Dodano do koszyka ksi¹¿kê: " + k.getTytul());
		kwota+=k.getCena();
		koszyk.add(k);
	}
	
	public void removeFromKoszyk(int i)
	{
		if(i>=0 && i<koszyk.size())
		{
			System.out.println("Usuniêto ksi¹¿kê: " + koszyk.get(i).getTytul());
			kwota-=koszyk.get(i).getCena();
			koszyk.remove(i);
		}
	}
	
	public int sizeKoszyk()
	{
		return koszyk.size();
	}
	public Ksiazka getKsiazka(int i)
	{
		return koszyk.get(i);
	}
	
	public void clearKoszyk()
	{
		kwota=0;
		koszyk.clear();
	}
	
	public void finalizeKupno()
	{
		id++;
		koszyk.clear();
		kwota=0;
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DAY_OF_MONTH, 7);
        Date d2 = c.getTime();
        data_zamowienia=d;
        data_dostarczenia=d2;
	}
	
	public int getId()
	{
		return id;
	}
	public Date getData_zamowienia()
	{
		return data_zamowienia;
	}
	public Date getData_dostarczenia()
	{
		return data_dostarczenia;
	}
	public float getKwota()
	{
		return kwota;
	}
	public boolean getCzy_zaplacono()
	{
		return czy_zaplacono;
	}
	public ArrayList<Ksiazka> getKoszyk()
	{
		return koszyk;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	public void setData_zamowienia(Date data_zamowienia)
	{
		this.data_zamowienia=data_zamowienia;
	}
	public void setData_dostarczenia(Date data_dostarczenia)
	{
		this.data_dostarczenia=data_dostarczenia;
	}
	public void setKwota(float kwota)
	{
		this.kwota=kwota;
	}
	public void setCzy_zaplacono(boolean czy_zaplacono)
	{
		this.czy_zaplacono=czy_zaplacono;
	}
	public void setKoszyk(ArrayList<Ksiazka> koszyk)
	{
		this.koszyk=koszyk;
	}
	
	public String toString()
	{
		String result="Koszyk: ";
		for(int i=0;i<koszyk.size();i++)
		{
			result+="\n" + (i+1) +". " + koszyk.get(i);
		}
		result+="\nCa³kowita kwota: " + kwota + "   zap³acono: " + (czy_zaplacono ? "tak" : "nie") +
				"\nData zamówienia: " + data_zamowienia + "\nPrzewidywana data dostarczenia: " +
				data_dostarczenia;
		
		return result;
	}

}
