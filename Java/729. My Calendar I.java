class MyCalendar {

	 public class pairs
	 {
		int start;
		int end;

		public pairs(int start,int end)  {
			this.start=start;
			this.end=end;
		}
		 
	 }

	ArrayList<pairs> list;

	public MyCalendar() {
		 list=new ArrayList<pairs>();
	}

	public boolean book(int start, int end) {
		
		 pairs temp = new pairs(start,end);
		boolean bool=true;

		int i=0;

		while(list.size()>0 && i<list.size())
		{
			if(temp.start<list.get(i).start)
			{
				if(temp.end<=list.get(i).start)
				{
					bool=true;
				}
				else {
					bool=false ;
					break;
				}
			}

			else
			{
				if(temp.start>=list.get(i).end) {
					bool=true;
				}
				else {
					bool=false ;
					break;
				}
			}
			
			i++;
		}

		if(bool==true) {
			list.add(new pairs(start,end));
		}

		return bool ;
	}
}