import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class Apriori {

	static ArrayList<HashSet<String>> catValues = new ArrayList<HashSet<String>>();

	static ArrayList<HashSet<Candidate>> candidates = new ArrayList<HashSet<Candidate>>();
	static ArrayList<HashSet<Candidate>> frequentItemsets = new ArrayList<HashSet<Candidate>>();
	static ArrayList<Row> itemsets = new ArrayList<Row>();
	static int rowSize = 12;
	static int M = 32000;
	static double min_sup = 20.0 / 100;
	static int dbrun=0;
	static int[] numReads=new int[rowSize+1];

	public static void main(String[] args) {
		// printCategoriesSize();
		
		for (int i = 0; i < rowSize+1; ++i) {
			candidates.add(new HashSet<Candidate>());
			catValues.add(new HashSet<String>());
			frequentItemsets.add(new HashSet<Candidate>());
			numReads[i]=0;
		}
		
		

		int count = 0;
		ArrayList<Double> _fnlwgt = new ArrayList<Double>();
		ArrayList<Double> _edunum = new ArrayList<Double>();
		ArrayList<Double> _capitalgain = new ArrayList<Double>();
		ArrayList<Double> _capitalloss = new ArrayList<Double>();
		ArrayList<Double> _hourperweek = new ArrayList<Double>();

		Scanner sc = null;
		try {
			sc = new Scanner(new File("adult.data"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.useDelimiter("[ ,\\n]+");
		while (sc.hasNext()) {

			Row itemset = new Row();
			int tempAge = sc.nextInt();
			if (tempAge >= 65) {
				itemset.data[0] = "Old";
			} else if (tempAge >= 46) {
				itemset.data[0] = "Senior";
			} else if (tempAge >= 26) {
				itemset.data[0] = "Middle_age";
			} else if (tempAge >= 0) {
				itemset.data[0] = "Young";
			}

			else
				itemset.data[0] = "Notspec";

			// ////////////////////////////////////////////
			String tempwc = sc.next();

			itemset.data[1] = tempwc;
			// ///////////////////////////////////////////
			double tempfw = sc.nextDouble();
			// _fnlwgt.add(tempfw);
			// setHourperweek(tempfw);
			// itemset.hpw=HoursPerWeek.valueOf(tempwc);

			// TO DO
			// ///////////////////////////////////////////
			String tempedu = sc.next();

			itemset.data[1] = tempedu;
			// //////////////////////////////////////////
			double tempedunum = sc.nextDouble();

			// ///////////////////////////////////////////
			String tempms = sc.next();
			itemset.data[2] = tempms;
			// ///////////////////////////////////////////
			String tempoc = sc.next();
			itemset.data[3] = tempoc;
			// ///////////////////////////////////////////
			String temprel = sc.next();
			itemset.data[4] = temprel;
			// ///////////////////////////////////////////
			String temprace = sc.next();
			itemset.data[5] = temprace;
			// ///////////////////////////////////////////
			itemset.data[6] = sc.next();
			// //////////////////////////////////////////
			double tempecg = sc.nextDouble();
			_capitalgain.add(tempecg);
			String capitalgain = setCapitalgain(tempecg);
			itemset.data[7] = capitalgain;
			// ///////////////////////////////////////////
			double tempcl = sc.nextDouble();
			_capitalloss.add(tempcl);
			String capitalloss = setCapitalloss(tempcl);
			itemset.data[8] = capitalloss;
			// ///////////////////////////////////////////
			double temphpw = sc.nextDouble();
			_hourperweek.add(temphpw);
			String hourperweek = setHourperweek(temphpw);
			itemset.data[9] = hourperweek;
			// //////////////////////////////////////////
			String tempnc = sc.next();
			if (tempnc.equals("Outlying_US(Guam_USVI_etc)")) {
				tempnc = "Outlying_US";
			}
			if (tempnc.equals("Trinadad&Tobago")) {
				tempnc = "TrinadadTobago";
			}
			if (tempnc.equals("?")) {
				tempnc = "Notspec";
			}
			itemset.data[10] = tempnc;
			// ///////////////////////////////////////

			// TODO
			itemset.data[11] = sc.next();

			itemsets.add(itemset);

			for (int i = 0; i < rowSize; ++i)
				catValues.get(i).add(itemset.data[i]);

			count = count + 1;
			// System.out.println(count+"th itemset added");
			// System.out.println(count);
			// System.out.println(itemset);

		}
		System.out.println("all itemset added");
		Collections.sort(_hourperweek);
		Collections.sort(_edunum);
		Collections.sort(_fnlwgt);
		Collections.sort(_capitalgain);
		Collections.sort(_capitalloss);

		// System.out.println(itemsets);
//		System.out.println("end");
		Date d1=new Date();
		long start= d1.getTime();
		dicProcess();
		Date d2=new Date();
		long end= d2.getTime();
		System.out.println("time: "+(end-start)/1000+" secs.");;
		System.out.println(dbrun);
	}

	private static void dicProcess() {

		for (int i = 0; i < rowSize; ++i) {
			Object[] values = catValues.get(i).toArray();
			for (Object obj : values) {
				String s = (String) obj;
				Candidate cand = new Candidate();
				cand.data[i] = s;
				if (s.equals("?"))
					continue;
				candidates.get(1).add(cand);

			}

		}

		/*****************************************************************/
		int initialM = 0;
		
		int uncountedCandidates = candidates.get(1).size();

		int stage=0;
		int startLength=1;
		
		while (uncountedCandidates>0) {
//			System.out.println(uncountedCandidates);
			stage++;

			
			for ( int h = 0; h < M ; h++ ) {
				int i = (h+initialM)%itemsets.size();
				
				for (int k = startLength; k < candidates.size() && k <= stage ; k++) {

					Object[] cands=candidates.get(k).toArray();
					
					for (Object obj: cands) {
						Candidate cand=(Candidate) obj;
						if (cand.counted == false) {

							if (itemsets.get(i).isSupersetOf(cand, k)) {

								cand.frequency++;

								if (((double) cand.frequency) / itemsets.size() >= min_sup
										&& cand.frequent == false) {
									cand.frequent = true;
									frequentItemsets.get(k).add(cand);
									Candidate cand2=new Candidate();
									cand.copyCandidateTo(cand2);
//									if(cand.equals(cand2))
//										System.err.println("TRUEEEEEEEEEEEEEEEEEEEEEEE");
//									if(!frequentItemsets.get(k).contains(cand))
//										System.err.println("GHAAAAAAAAAAAAAAALAAAAAAAAT");

									// generate immidiate supersets of size k+1
									// and check if it can be a candidate
									int a=generateCandidate(k, cand);
									uncountedCandidates+=a;
//									System.err.println("added new Candidates: "+a);

								}

							}

							cand.readNum++;
							if (cand.readNum == itemsets.size()) {
								cand.counted = true;
								uncountedCandidates--;
								//candidates.get(k).remove(cand);
							}
						}
					}
					
				}
				
				
			}

			if(itemsets.size()-initialM<=M)
				dbrun++;
			initialM = (initialM+M)%itemsets.size();
			

		}
		/***********************************************************************/

		for (int m = 0; m < rowSize; ++m) {
			System.out.println(m + "-length candidate itemsets: ");
			for (Candidate cand: frequentItemsets.get(m)) {
				System.out.print(cand + "\t");
				System.out.println(cand.frequency);
			}
			System.out.println();
		}
	}

	private static int generateCandidate(int candidateSize, Candidate candidate) {
		int newCandidates=0;
		ArrayList<Candidate> imSupersets = new ArrayList<Candidate>();


		for (int i = 0; i < rowSize; ++i) {
	
			if (candidate.data[i].equals("?")) {
				Object[] values = catValues.get(i).toArray();

				for (Object obj : values) {
					String s = (String) obj;
					if(!s.equals("?")){
						Candidate cand = new Candidate();
						candidate.copyCandidateTo(cand);
						cand.data[i] = s;
						if(!candidates.get(candidateSize+1).contains(cand)){
							imSupersets.add(cand);
						}
					}
				}
			}
			
		}
		
//		System.err.println("supersets :"+imSupersets.size());

		
		for (Candidate cand: imSupersets){
			if( allSubsetsFrequent(cand,candidateSize)){

				candidates.get(candidateSize + 1).add(cand);
				newCandidates++;
			}
			
		}
		
		return newCandidates;

	}

	private static boolean allSubsetsFrequent(Candidate cand, int candidateSize) {
		
//		System.err.println(frequentItemsets.get(candidateSize).size());
		for(int j=0;j<rowSize;++j)
			if(!cand.data[j].equals("?")){
				Candidate temp=new Candidate();
				cand.copyCandidateTo(temp);
				temp.data[j]="?";
				
				if(!frequentItemsets.get(candidateSize).contains(temp)){
					return false;
				}
			}
			
		return true;
	}


	private static void printCandidates(
			ArrayList<ArrayList<Candidate>> candidates2, int i) {
		for (int k = 0; k < candidates2.get(i).size(); ++k) {
			System.out.println("new supersets of size" + i + ":"
					+ candidates2.get(i).get(k) + "\n");

		}

	}


	public static String setHourperweek(double number) {

		String hourperweek = new String("");

		if (number >= 60) {
			hourperweek = "Too_much";
		} else if (number >= 40) {
			hourperweek = "Over_time";
		} else

		if (number >= 25) {
			hourperweek = "Full_time";
		} else if (number >= 0) {
			hourperweek = "Part_time";
		}

		else
			hourperweek = "?";

		return hourperweek;

	}

	public static String setEdumun(double number) {

		String edunum = new String("");
		if (number >= 10) {
			edunum = "_10_16";
		} else if (number >= 5) {
			edunum = "_5_10";
		} else

		if (number > 1) {
			edunum = "_1_5";
		} else
			edunum = "?";

		return edunum;
	}

	public static String setCapitalgain(double number) {

		String capitalgain = new String("");

		if (number > 41310) {
			capitalgain = "High";
		} else if (number >= 30000) {
			capitalgain = "Medium";
		} else

		if (number >= 100) {
			capitalgain = "Low";
		}

		if (number == 0) {
			capitalgain = "None";

		} else
			capitalgain = "?";

		return capitalgain;
	}

	public static String setCapitalloss(double number) {

		String capitalloss = new String("");
		if (number >= 2000) {
			capitalloss = "High";
		} else if (number >= 1000) {
			capitalloss = "Medium";
		} else if (number >= 300) {
			capitalloss = "Low";

		}

		else if (number == 0) {
			capitalloss = "None";
		} else
			capitalloss = "?";

		return capitalloss;

	}

	public static double getMin(ArrayList<Double> arr) {
		double min = 100000000.0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) < min) {
				min = arr.get(i);
			}
		}
		return min;
	}

	public static double getMax(ArrayList<Double> arr) {
		double max = -100.0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > max) {
				max = arr.get(i);
			}
		}
		return max;
	}

}