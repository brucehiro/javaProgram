package tw.edu.bio.thu;

public class Class_TWId {
	private String id;//�ѩ󨭤��Ҥ�����N�Q�ק�A�ҥH�ϥ�private�ʸ�
	static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
	
	//�غc�����Ĥ@�y�@�w�n�Osuper��this�A�ӥB�u��D��@�ӡC���g�ɷ|�۰ʸ�super()�C
	Class_TWId()
	{
		this((int)(Math.random()*2) == 0);
	}
	Class_TWId(boolean genderCheck)
	{
		this(genderCheck, (int)(Math.random()*26));
	}
	Class_TWId(int area)
	{
		this((int)(Math.random()*2) == 0, area);
	}
	Class_TWId(boolean genderCheck, int area)
	{
		//super();
		char id0 = letters.charAt(area);
		char id1 = genderCheck?'2':'1';
		StringBuffer temp = new StringBuffer("" + id0 + id1);
		//String temp = "" + id0 + id1;
		
		for(int i = 0; i < 7; i++)
		{
			temp.append((int)(Math.random()*10));
			//temp += (int)(Math.random()*10);
		}
		
		for(int i = 0; i < 10; i++)
		{
			if(Class_TWId.IdCheck(temp.toString() + i))
			{
				id = temp.append(i).toString();
				break;
			}
		}
	}
	
	//private id���ͩR�d��b������O���A�ӶǤJ�Ѽ�id���ͩR�d��bTWId{}���C�ѩ�|���|�A�ݩ����O��id�i�H��this.id�ӰϹj�C
	Class_TWId(String id)
	{
		this.id = id;
	}
	
	//true == female; false == male
	boolean genderChoice()
	{
		char gender = id.charAt(1);
//		if(gender == '1')
//		{
//			return false;
//		}
//		else
//		{
//			return true;
//		}
		
		return  gender == '2';
	
	}
	
	static boolean IdCheck(String id)
	{
		if (!id.matches("^[A-Za-z][12][0-9]{8}$")) return false;
		
		
		char id0 = id.charAt(0);
		int n12 = letters.indexOf(id0) + 10;
		int n1 = n12 / 10;
		int n2 = n12 % 10;
		int[] n3 = new int[9];
		
		for(int i = 0; i < 9; i++)
		{
			//.substring��k���Ostatic�A�ҥH�ݭn������~�i�H�ϥΡC��.parseInt��k�Ostatic�A�ҥH�i�H�������J���O��ϥ�(Integer.parseInt)�C
			n3[i] = Integer.parseInt(id.substring(i+1,i+2));
		}
		
		int sum = n1*1 + n2*9 + n3[0]*8 + n3[1]*7 + n3[2]*6 + n3[3]*5 + n3[4]*4 + n3[5]*3 + n3[6]*2 + n3[7]*1 + n3[8]*1; 
		
		return (sum % 10) == 0;
	}
	
//	static boolean preCheck(String id)
//	{
//		int id0 = id.charAt(0);
//		
//		//length == 10
//		if(id.length() != 10)
//		{
//			return false;
//		}
//		
////		else if( id0 < 65 || id0 > 90)
////		{
////			return false;
////		}
//		else if (letters.indexOf(id.charAt(0)) == -1)
//		{
//			return false;
//		}
//		//else if()
//		
//		//charAt(0) -> A-Z
//		//charAt(1) -> 1, 2
//		//other -> 0 - 9
//		return true;
//	}
	
	String getId()
	{
		return id;
	}
}
