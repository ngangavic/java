import javax.swing.JOptionPane;

public class TempConversion {

	//fahren to cel
	public float celsius(float fahrenheit) {

		return (fahrenheit-32)*5/9;
	}
	
	//cel to fah function
	public float fahrenheit(float celsius) {

		return (celsius*5/9)+32;

	}
	
	public static void main(String[] args) {
		try {
			String s;
			TempConversion tempConversion = new TempConversion();
			s = JOptionPane.showInputDialog("Select conversion type\n 1.Celsius to Fahrenheit \n 2. Fahrenheit to Celsius");
			int selection = Integer.parseInt(s);
			if (selection == 1) {
				//celecius to fah
				s = JOptionPane.showInputDialog("Enter temperatures in celsius");
				float celsius = Float.parseFloat(s);
				float ans = tempConversion.celsius(celsius);
				JOptionPane.showMessageDialog(null, "Temperature in fahrenheit is " + ans + "\u2109");

			} else if (selection == 2) {
				//fah to celcius
				s = JOptionPane.showInputDialog("Enter temperatures in fahrenheit");
				float fahrenheit = Float.parseFloat(s);
				float ans = tempConversion.celsius(fahrenheit);
				JOptionPane.showMessageDialog(null, "Temperature in celsius is " + ans + " \u2103");

			} else {
				//error
				JOptionPane.showMessageDialog(null, "You entered a wrong selection");

			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,e);
		}

	}

}
