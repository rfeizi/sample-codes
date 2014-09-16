public class Row {
	static int rowSize = Apriori.rowSize;
	String[] data=new String[rowSize];
	
	public Row(){
		for(int i=0;i<12;++i)
			data[i]="?";
	}


	
	public String toString() {
		String ret="{ ";
		for(int i=0;i<rowSize-1;++i)
			ret+=data[i]+", ";
		
		ret+=data[rowSize-1];
		
		return ret+"}\n";
	}
	



	public boolean isSupersetOf(Object obj,int len) {
		int count=0;
		if(!(obj instanceof Row))
			return false;
		Row row=(Row) obj;
		for(int i=0;i<rowSize;i++){
			
			if((data[i].equals(row.data[i]))){
				if(!data[i].equals("?") ){
					count++;
				}
			}
			
		}
		if (count>=len){
		
		return true;
		}
		else 
			return false;
	}

}
