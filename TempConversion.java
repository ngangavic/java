import javax.swing.JOptionPane;

public class TempConversion {

	//fahren to cel
	public int celsius(int fahrenheit) {
		
		int cel = (fahrenheit-32)*5/9; 
		
		return cel;
	}
	
	//cel to fah
	public int fahrenheit(int celsius) {
		
		int fah = (celsius*5/9)+32; 
		
		return fah;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		TempConversion tempConversion = new TempConversion();
		s=JOptionPane.showInputDialog("Select conversion type\n 1.Celsius to Fahrenheit \n 2. Fahrenheit to Celsius");
		int selection = Integer.parseInt(s);
		if(selection==1) {
			//celecius to fah
			s=JOptionPane.showInputDialog("Enter temperatures in celsius");
			int celsius = Integer.parseInt(s);
			int ans=tempConversion.celsius(celsius);
			JOptionPane.showMessageDialog(null,"Temperature in fahrenheit is "+ans +"\u2109");
			
		}else if(selection==2) {
			//fah to celcius
			s=JOptionPane.showInputDialog("Enter temperatures in fahrenheit");
			int fahrenheit = Integer.parseInt(s);
			int ans=tempConversion.celsius(fahrenheit);
			JOptionPane.showMessageDialog(null,"Temperature in celecius is "+ans+" \u2103");
		
		}else {
			//error
			JOptionPane.showMessageDialog(null,"You entered a wrong selection");
			
		}

	}

}
