package ksiegarnia;


import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;


import java.util.ArrayList;




public class Main {
	
	private static Connection myConn;
	private static Statement myStmt;
	private static Scanner scanner;
	private static Klient klient;
	private static Autor autor;
	private static Ksiazka ksiazka;
	private static Kupno kupno;
	
	public void logowanie() throws SQLException
	{
		System.out.println("Witamy w internetowej ksiêgarni");
		System.out.println("[1] - Zaloguj siê \n[2] - Wyjdz");
		
		//Scanner scanner = new Scanner(System.in); 
	    int wybor1 = 0;
	    
	    while (wybor1 != 1 && wybor1 != 2)
	    {
		    System.out.print("Wybierz: ");
		    wybor1 = scanner.nextInt();
	    }
	    
	    if(wybor1==1) //logowanie, podawanie email
	    {
	    	System.out.print("\nEmail: ");
	    	String wybor2 = scanner.next();
	    	
	    	
	    	PreparedStatement sql = myConn.prepareStatement("select Email, Haslo from klient where Email=?");
	    	sql.setString(1, wybor2);
            ResultSet rs = sql.executeQuery();
            
            
            while(!(rs.next() || wybor2.equals("0")))
            {
            	System.out.print("B³¹d \nEmail: ");
            	wybor2 = scanner.next();
            	sql.setString(1, wybor2);
                rs = sql.executeQuery();
            }
            
            if(!wybor2.equals("0"))		// podawanie has³a
            {
            	String haslo=rs.getString(2);
            	
            	System.out.print("Has³o: ");
            	String wybor3 = scanner.next();
            	
            	
            	while(!(haslo.equals(wybor3) || wybor3.equals("0")))
            	{
            		System.out.print("B³¹d \nHas³o: ");
            		wybor3 = scanner.next();
            	}
            	
            	if (!wybor3.equals("0"))  // udane logowanie
            	{
            		PreparedStatement sql2 = myConn.prepareStatement("select * from klient where Email=?");
        	    	sql2.setString(1, wybor2);
                    ResultSet rs2 = sql2.executeQuery();
                    if(rs2.next())   //tworzenie instancji klienta
                    {
                        klient = new Klient(rs2.getInt("IdKlienta"), rs2.getString("Imie"), rs2.getString("Nazwisko"),
                        		rs2.getString("NrTelefonu"), rs2.getString("Email"), rs2.getString("Adres"), rs2.getString("Haslo"));
                    }
                    
                    //tworzenie instancji koszyka dla klienta
                    int id_koszyka=1;
                    DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                    Date d = new Date();
                    //System.out.println(df.format(d));
                    Calendar c = Calendar.getInstance();
                    c.setTime(d);
                    c.add(Calendar.DAY_OF_MONTH, 7);
                    Date d2 = c.getTime();
                    //System.out.println(df.format(d2));
					String sql3 = "select max(IdKupna) as max from kupno;";
		            ResultSet rs3 = myConn.createStatement().executeQuery(sql3);
		            if(rs3.next())
		            {
		            	id_koszyka = rs3.getInt("max") + 1;
		            }
		            kupno = new Kupno(id_koszyka, d, d2, 0, false);
                    
		            
		            
                    System.out.println("Zalogowano jako " + klient.getImie() + " " + klient.getNazwisko());
                   // scanner.close();
                    menu();
            	}
            	
            	else	//powrot do logowania
            	{
            		System.out.println("\n\n\n");
            		//scanner.close();
            		logowanie();
            	}
            }
	    	
            else	//powrot do logowania
        	{
        		System.out.println("\n\n\n");
        		//scanner.close();
        		logowanie();
        	}
	    	
	    }
	    else //koniec
	    {
	    	System.out.println("Dziêkujemy za wizytê w naszej ksiêgarni.");
	    }
	}
	
	public void menu() throws SQLException	//g³ówne funkcje ksiêgarni
	{
		System.out.println("\n\n\nMenu g³ówne");
		System.out.println("[1]-Przegl¹daj dostêpne ksi¹¿ki");
		System.out.println("[2]-Przegl¹daj koszyk");
		System.out.println("[3]-Sfinalizuj zakup");
		System.out.println("[4]-Opró¿nij koszyk");
		System.out.println("[5]-Dane u¿ytkownika");
		System.out.println("[6]-Przyk³adowe pytania do bazy danych");
		System.out.println("[7]-Wyloguj");
		
		//Scanner scanner = new Scanner(System.in); 
	    int wybor1 = 0;
	    while (wybor1 != 1 && wybor1 != 2 && wybor1 !=3 && wybor1 !=4 && wybor1!=5 && wybor1!=6 && wybor1!=7)
	    {
		    System.out.println("Wybierz: ");
		    wybor1 = scanner.nextInt();
	    }
	    
	    switch(wybor1)
	    {
	    case 1:
	    	przegladajKsiazki();
	    	break;
	    case 2:
	    	przegladajKoszyk();
	    	break;
	    case 3:
	    	finalizujZakup();
	    	break;
	    case 4:
	    	oproznijKoszyk();
	    	break;
	    case 5:
	    	daneUzytkownika();
	    	break;
	    case 6:
	    	pytania();
	    	break;
	    case 7:
	    	wylogowanie();
	    	break;
	    default:
	    	break;
	    }
	}
	
	public void przegladajKsiazki() throws SQLException
	{
		ResultSet rs = myStmt.executeQuery("select * from ksiazka natural join autor order by ksiazka.IdKsiazki");
		System.out.println("\nSpis ksi¹¿ek: ");
		while (rs.next())
		{
			System.out.println(rs.getInt("IdKsiazki") + ". " + rs.getString("Tytul") + ", " + rs.getString("Imie")+ " " + rs.getString("Nazwisko") +
					", " + rs.getInt("RokWydania") + "r, " + rs.getFloat("Cena") + "zl, " + rs.getString("Oprawka") + " oprawka");
		}
		int wybor1 = -1;
		while(wybor1!=0)
		{
			System.out.println("Wpisz indeks ksi¹¿ki aby dodaæ j¹ do koszyka lub wpisz 0 aby wróciæ: ");
		    wybor1 = scanner.nextInt();
		    
		    PreparedStatement sql = myConn.prepareStatement("select * from ksiazka natural join autor where IdKsiazki=?");
	    	sql.setInt(1, wybor1);
	        ResultSet rs2 = sql.executeQuery();
		    if(rs2.next())
		    {
		    	autor = new Autor(rs2.getInt("IdAutora"), rs2.getString("Imie"), rs2.getString("Nazwisko"));
		    	ksiazka = new Ksiazka(rs2.getInt("IdKsiazki"), rs2.getString("Tytul"), rs2.getInt("RokWydania"), rs2.getFloat("Cena"), rs2.getString("Oprawka"), autor);
		    	kupno.addToKoszyk(ksiazka);
		    	
		    }
		}
		
	    menu();
	}
	
	public void przegladajKoszyk() throws SQLException
	{
		//TODO narazie wstêpna wersja wyswietlania, dodaæ opcje usuwania ksiazki
		int wybor1 = -1;
		while(wybor1!=0)
		{
			System.out.println("\n");
			System.out.println(kupno);
			System.out.println("\nWpisz indeks ksi¹¿ki aby usun¹æ j¹ z koszyka lub wpisz 0 aby wróciæ: ");
			wybor1 = scanner.nextInt();
			kupno.removeFromKoszyk(wybor1-1);
		}
		menu();
	}
	
	public void finalizujZakup() throws SQLException
	{
		PreparedStatement sql = myConn.prepareStatement("insert into kupno"
        		+ "(IdKupna, DataZamowienia, DataDostarczenia, Kwota, CzyZaplacono, IdKlienta) VALUE (?,?,?,?,?,?)");
        sql.setInt(1, kupno.getId());
        sql.setDate(2,  new java.sql.Date(kupno.getData_zamowienia().getTime()));
        sql.setDate(3,  new java.sql.Date(kupno.getData_dostarczenia().getTime()));
        sql.setFloat(4, kupno.getKwota());
        sql.setInt(5, 1);
        sql.setInt(6, klient.getId());
        sql.executeUpdate();
        for(int i=0; i<kupno.sizeKoszyk();i++)
        {
        	PreparedStatement sql2 = myConn.prepareStatement("insert into kupnoksiazka"
            		+ "(IdKupna, IdKsiazki) VALUE (?,?)");
            sql2.setInt(1, kupno.getId());
            sql2.setInt(2, kupno.getKsiazka(i).getId());
            sql2.executeUpdate();
        }
        System.out.println("Dokonano zakupu. Kwota do zap³aty: " + kupno.getKwota() +", przewidywany czas dostawy: " + kupno.getData_dostarczenia());
        kupno.finalizeKupno();
        
        menu();
	}
	
	public void oproznijKoszyk() throws SQLException
	{
		kupno.clearKoszyk();
		menu();
	}
	
	public void daneUzytkownika() throws SQLException
	{
		System.out.println("\n" + klient);
		menu();
	}
	
	public void wylogowanie() throws SQLException
	{
		logowanie();
	}
	
	public void pytania() throws SQLException
	{
		System.out.println("\n1. Wybierz dane o wszystkich klientach ksiêgarni"
				+ "\n2. Wybierz Imiê, Nazwisko oraz adres email klientów, którzy posiadaj¹ email w domenie gmail"
				+ "\n3. Wybierz wszystkie dane o klientach, którzy zakupili ksi¹¿kê pod tytu³em \"Krzy¿acy\""
				+ "\n4. Wybierz wszystkie kupna klienta o numerze ID = 3"
				+ "\n5. Wybierz wszystkie kupna, które zamówiono w obecnym roku"
				+ "\n6. Wybierz kwoty wszystkich zakupów, które zosta³y ju¿ zap³acone"
				+ "\n7. Wybierz wszystkie ksi¹¿ki, które zakupi³ klient Tomasz Górski"
				+ "\n8. Wybierz tytu³y wszystkich ksi¹¿ek, których cena jest wiêksza od 20z³ i mniejsza od 30z³"
				+ "\n9. Wybierz wszystkie ksi¹¿ki alfabetycznie"
				+ "\n10. Wybierz dane o wszystkich autorach wraz z ich ksi¹¿kami"
				+ "\n11. Wybierz nazwisko autora ksi¹¿ki \"Quo Vadis\""
				+ "\n12. Wybierz liczbê dostêpnych autorów");
		int wybor1 = -1;
		while(wybor1!=0)
		{
			System.out.println("\nWpisz indeks pytania lub wpisz 0 aby wróciæ: ");
			wybor1 = scanner.nextInt();
			switch(wybor1)
		    {
		    case 1:
		    	ResultSet rs1 = myStmt.executeQuery("Select * from klient");
				while (rs1.next())
				{
					System.out.println(rs1.getInt("IdKlienta") + "  " + rs1.getString("Imie") + "  " + rs1.getString("Nazwisko") +
							" " + rs1.getString("NrTelefonu") + "  " + rs1.getString("Email") + "  " + rs1.getString("Adres") + "  " + rs1.getString("Haslo"));
				}
		    	break;
		    case 2:
		    	ResultSet rs2 = myStmt.executeQuery("Select * from klient where Email like '%gmail.com'");
				while (rs2.next())
				{
					System.out.println(rs2.getString("Imie") + "  " + rs2.getString("Nazwisko") + "  " + rs2.getString("Email"));
				}
		    	break;
		    case 3:
		    	ResultSet rs3 = myStmt.executeQuery("Select distinct klient.* from klient natural join kupno natural join kupnoksiazka natural join ksiazka where ksiazka.Tytul = 'Krzy¿acy'");
				while (rs3.next())
				{
					System.out.println(rs3.getInt("IdKlienta") + "  " + rs3.getString("Imie") + "  " + rs3.getString("Nazwisko") +
							" " + rs3.getString("NrTelefonu") + "  " + rs3.getString("Email") + "  " + rs3.getString("Adres") + "  " + rs3.getString("Haslo"));
				}
		    	break;
		    case 4:
		    	ResultSet rs4 = myStmt.executeQuery("Select * from kupno natural join klient where klient.IdKlienta=3");
				while (rs4.next())
				{
					System.out.println(rs4.getInt("IdKupna") + "  " + rs4.getDate("DataZamowienia") + "  " + rs4.getDate("DataDostarczenia") +
							" " + rs4.getFloat("Kwota"));
				}
		    	break;
		    case 5:
		    	ResultSet rs5 = myStmt.executeQuery("Select * from kupno where YEAR(DataZamowienia) = YEAR(CURDATE())");
				while (rs5.next())
				{
					System.out.println(rs5.getInt("IdKupna") + "  " + rs5.getDate("DataZamowienia") + "  " + rs5.getDate("DataDostarczenia") +
							" " + rs5.getFloat("Kwota") + "  " + rs5.getInt("IdKlienta"));
				}
		    	break;
		    case 6:
		    	ResultSet rs6 = myStmt.executeQuery("Select Kwota from kupno where CzyZaplacono = '1';");
				while (rs6.next())
				{
					System.out.println(rs6.getFloat("Kwota"));
				}
		    	break;
		    case 7:
		    	ResultSet rs7 = myStmt.executeQuery("Select ksiazka.* from ksiazka natural join kupnoksiazka natural join kupno natural join klient where klient.Imie = 'Tomasz' and klient.Nazwisko = 'Górski'");
				while (rs7.next())
				{
					System.out.println(rs7.getInt("IdKsiazki") + "  " + rs7.getString("Tytul") + "  " + rs7.getInt("RokWydania") + "  " + rs7.getInt("Cena") + "  " + rs7.getString("Oprawka"));
				}
		    	break;
			case 8:
				ResultSet rs8 = myStmt.executeQuery("Select Tytul from ksiazka where Cena between 20 and 30");
				while (rs8.next())
				{
					System.out.println(rs8.getString("Tytul"));
				}
				break;
			case 9:
				ResultSet rs9 = myStmt.executeQuery("Select * from ksiazka order by Tytul asc");
				while (rs9.next())
				{
					System.out.println(rs9.getString("Tytul") + "  " + rs9.getInt("RokWydania") + "  " + rs9.getInt("Cena") + "  " + rs9.getString("Oprawka"));
				}
				break;
			case 10:
				ResultSet rs10 = myStmt.executeQuery("Select autor.*, ksiazka.*  from autor natural join ksiazka");
				while (rs10.next())
				{
					System.out.println(rs10.getInt("IdAutora") + "  " + rs10.getString("Imie") + "  " + rs10.getString("Nazwisko") + "  " + rs10.getString("Tytul") 
					+ " " + rs10.getInt("RokWydania") + "  " + rs10.getFloat("Cena") + "  " + rs10.getString("Oprawka"));
				}
				break;
			case 11:
				ResultSet rs11 = myStmt.executeQuery("Select distinct autor.Nazwisko from autor natural join ksiazka where ksiazka.Tytul='Quo Vadis'");
				while (rs11.next())
				{
					System.out.println(rs11.getString("Nazwisko"));
				}
				break;
			case 12:
				ResultSet rs12 = myStmt.executeQuery("Select Count(*) as Suma from autor;");
				while (rs12.next())
				{
					System.out.println(rs12.getInt("Suma"));
				}
				break;
			default:
				break;
		    }
		}
		menu();
	}
	
	
	public static void main(String[] args) throws SQLException {
		try {
			//get a conection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksiegarnia?serverTimezone=UTC","student","student");
			
			//create a statement
			myStmt = myConn.createStatement();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		Main m = new Main();
		scanner = new Scanner(System.in); 
		m.logowanie();
		scanner.close();
	}
}




