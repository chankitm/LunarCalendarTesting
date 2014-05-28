package kr.co.heylark.LunarCalendar;

import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LunarCalendarMain {

	public static void main(String[] args) {
		LunarCalendar lc = new LunarCalendar();
		
		Scanner s;
		String inputDateStr = null;
		String inputTypeStr = null;
		
		while(true){
			try {
				s = new Scanner(System.in);
				
				//Show Message
				System.out.format("Input [0] -> Exit\nInput Date(yyyyMMdd) : ");
				
				//Input
				inputDateStr = s.nextLine();
				
				//Check Input Date
				lc.default_sdf.parse(inputDateStr);
				
				//Check Exit
				if(inputDateStr.equals("0")){
					System.out.format("Bye~ Bye~ :)");
					break;
				}
				
				//Show Option
				System.out.format("Input [0] -> Gregorian To Lunar\n");
				System.out.format("Input [1] -> Lunar To Gregorian\n");
				System.out.format("Input : ");
				
				//Input
				inputTypeStr = s.nextLine();
				
				if(inputTypeStr.equals("0")){
					//Gregorian To Lunar
					System.out.format("Gregorian To Lunar : %s -> %s\n\n", inputDateStr, lc.default_sdf.format( lc.GregorianToLunar( lc.default_sdf.parse(inputDateStr) )));
				}else if(inputTypeStr.equals("1")){
					//Lunar To Gregorian
					System.out.format("Lunar To Gregorian : %s -> %s\n\n", inputDateStr, lc.default_sdf.format( lc.LunarToGregorian( lc.default_sdf.parse(inputDateStr) )));
				}else{
					//Other's Show Input Date
					System.out.format("Input : %s\n\n", inputDateStr);
				}
				
			} catch (ParseException e) {
				System.out.format("ParseException : Input [%s] Input DateFormat(yyyyMMdd)\n\n", inputDateStr);
			} catch (NoSuchElementException e) {
				System.out.format("NoSuchElementException : %s\n\n", e.getLocalizedMessage());
			} catch (IllegalStateException e) {
				System.out.format("IllegalStateException : %s\n\n", e.getLocalizedMessage());
			} catch (NullPointerException e) {
				System.out.format("NullPointerException : %s\n\n", e.getLocalizedMessage());
			}
		}
	}

}
