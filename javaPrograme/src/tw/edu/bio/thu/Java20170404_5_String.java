package tw.edu.bio.thu;

public class Java20170404_5_String {

	public static void main(String[] args) {
		//先建立string物件，再賦予內容
		String a1 = new String();
		a1 = "abcdefg";
		System.out.println(a1);
		
		//建立物件並同時賦予內容(用""即為建立物件)
		String a2 = "1234567";
		System.out.println(a2);
		
		//利用string的其中一個建構式(string(byte[], offset, length)，先建立一byte陣列，再建立string物件，並以byte陣列賦予string內容。
		byte[] b1 = {97,98,99,100};
		//offset為byte[]的偏移量，0為由陣列的第一個元素開始。length為讀入string的長度。
		String a3 = new String(b1,0,4);
		System.out.println(a3);
		
		
		

	}

}
