package week1capstone;


public class Ethodsmay {

	public static void main(String[] args) {
	}
	
	public static String ranslatortay(String english) {
		StringBuffer sb = new StringBuffer();
		english = english.toLowerCase();
		String[] engArr = english.split(" ");
		String[] pigArr = new String[engArr.length];
		String igpayAtinlay = "";
		
		for(int i = 0; i < engArr.length; ++i) {
			char firstLetter = engArr[i].charAt(0);
			boolean vowel = false;
				pigArr[i] = engArr[i];
				
			switch(firstLetter){
			case 'a':
			case 'A':
			case 'e':
			case 'E':
			case 'i':
			case 'I':
			case 'o':
			case 'O':
			case 'u':
			case 'U': 
				vowel = true;
				break;
			}
			if(i < engArr.length - 1) {
				if(vowel) {
					pigArr[i] = pigArr[i].concat("way" + " ");		
					sb.append(pigArr[i]);
				}else if (!vowel){
					pigArr[i] = pigArr[i].concat(engArr[i].charAt(0) + "ay");
					pigArr[i] = pigArr[i].replaceFirst(pigArr[i].substring(0,1), "");		
					pigArr[i] = pigArr[i].concat(" ");		
					sb.append(pigArr[i]);
				} //inner else if
			}else if(i == engArr.length - 1) {
				if(vowel) {
					pigArr[i] = pigArr[i].concat("way");		
					sb.append(pigArr[i]);
				}else if (!vowel){
					pigArr[i] = pigArr[i].concat(engArr[i].charAt(0) + "ay");
					pigArr[i] = pigArr[i].replaceFirst(pigArr[i].substring(0,1), "");		
					sb.append(pigArr[i]);
				}//inner else if
			}//outer else if
		} //for
		igpayAtinlay = sb.toString();
		return igpayAtinlay;
	} //method
	
	public static String apitalizationcay(String english) {
			String roperpayApscay = english.substring(0,1).toUpperCase() + english.substring(1).toLowerCase();
			return roperpayApscay;
	}
	
	public static void unctuationpay(String english) {
		
	}
}
