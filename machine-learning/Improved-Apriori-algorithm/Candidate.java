import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;


public class Candidate extends Row{
	boolean frequent;
	boolean counted;
	int readNum;
	boolean dbrun=false;
	
	int frequency;

	public Candidate(){
		frequent=false;
		counted=false;
		readNum=0;
		frequency=0;
		
	}
	
	

	



	public void copyCandidateTo(Candidate cand) {
		for(int i=0;i<rowSize;++i){
			cand.data[i]=data[i];
		}
		
	}


	




	@Override
	public int hashCode() {
		String str=new String();
		for(int i=0;i<rowSize;++i)
			str+=data[i];
		return str.hashCode();
	}







	@Override
	public boolean equals(Object temp) {
		if(temp==null)
			return false;
		
		if(! (temp instanceof Candidate)){
			return false;
		} 
		Candidate cand=(Candidate)temp;
		for(int i=0;i<rowSize;++i){
			if(! cand.data[i].equals(data[i])){
				return false;
			}
		}
		
		
		return true;
		
	}
	
	
	

	

	
	
}
