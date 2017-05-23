// Distributed with a free-will license.
// Use it any way you want, profit or free, provided it fits in the licenses of its associated works.
// HYT939
// This code is designed to work with the HYT939_I2CS I2C Mini Module available from ControlEverything.com.
// https://www.controleverything.com/content/Humidity?sku=HYT939_I2CS#tabs-0-product_tabset-2

//import com.pi4j.io.i2c.I2CBus;
//import com.pi4j.io.i2c.I2CDevice;
//import com.pi4j.io.i2c.I2CFactory;
//import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;



public class HYT939
{
	public static void main(String args[]) throws Exception
	{
		// Create I2CBus
		//I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);
		// Get I2C device, HYT939 I2C address is 0x28(40)
		//I2CDevice device = bus.getDevice(0x28);

		// Send normal mode command 
		//device.write((byte)0x80);
		//Thread.sleep(500);

		// Read 4 bytes of data
		// humidity msb, humidity lsb, temp msb, temp lsb
		//byte[] data = new byte[4];
		//device.read(data,0,4);

		// Convert the data to 14-bits
		//double humidity = (((data[0] & 0x3F) * 256) + (data[1] & 0xFF)) * (100.0 / 16383.0);
		//double cTemp = ((((data[2] & 0xFF) * 256) + (data[3] & 0xFC)) / 4) * (165.0 / 16383.0) - 40;
		//double fTemp = (cTemp * 1.8 ) + 32;

		// Output data to screen
		//System.out.printf("Relative Humidity is : %.2f %%RH %n", humidity);
		//System.out.printf("Temperature in Celsius is : %.2f C %n", cTemp);
		//System.out.printf("Temperature in Fahrenheit is : %.2f F %n", fTemp);
		
		String url = "http://loxeras.com/api/insert.php";
		String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
		String param1 = "1";
		String param2 = "2";
		String param3 = "3";
			

		String query = String.format("t=%s&h=%s&i=%s", 
		URLEncoder.encode(param1, charset), 
		URLEncoder.encode(param2, charset),
		URLEncoder.encode(param3, charset));
		
		URLConnection connection = new URL(url + "?" + query).openConnection();
		connection.setRequestProperty("Accept-Charset", charset);
		InputStream response = connection.getInputStream();
		
		InputStream response = new URL(url).openStream();

		
		
		
	}
}