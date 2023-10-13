//Sahil and the smart ones' first EP tracklist
//queue, linear search, insertion sort, mergesort, quicksort

/*
reading from file
1. queue
2. --
3. --
4.immunocompromisde, from menu opption, switch case
5.check due booster
*/

/*
-------------------------------------------------------------------------------------------------------------------------------------------
Enter month number:
-------------------------------------------------------------------------------------------------------------------------------------------
Menu functions:
---------------
1.Add record (queue into arraylist) condition: check if patient number already taken  DONE
2.Remove records  DONE
3.View particular record(linear search ((flatn, name)or (id))  DONE
4.View all records sorted: -------------------------------------------------------------------------------------> INSERTION SORT
		alphabetically
		id(eeznuts) 
5.List of people due for booster (we can ask for the time period for which to check as a suboption in a switch case)
				In next n months
                (sort by month using insertion sort) -----------------------------------------------------------> INSERTION SORT
6.List of ppl who took specific vaccine(enter pharm company name) ----------------------------------------------> MERGE SORT
		alph
        id
7.List of ppl who are at risk (immuno compromised) -------------------------------------------------------------> QUICK SORT
		alph
        id
-------------------------------------------------------------------------------------------------------------------------------------------
Mock records:
-------------
Patient id, patient name, flat no, age(to see if eligible for vaccine yet), shots taken, immunocompromised?(y/n), pharm comp, month of s1,s2,s3,s4
id	n		fln	age	sh	ic	pc	s1mnth	s2mnth	s3mnth	s4mnth
1	juan	1	19	3	0	p	1		2		8		0
2	poop	1	54	4	0	m	1		2		8		9
3	turd	2	25	4	1	p	1		2		5		6

-------------------------------------------------------------------------------------------------------------------------------------------
Conditions
----------
<12:	0 shots
		shot1
gen:	shot2 +1 month, shot3(1st booster) +6 months, shot4(2nd booster) 0
ic:		shot3(1st booster) +3 months, shot4(2nd booster) +1 month
>50:	shot3(1st booster) +6 months, shot4(2nd booster) +1 month
(ic more important than age)

assuming every pharm company has same value and efficacy
-------------------------------------------------------------------------------------------------------------------------------------------

initialize the shot pharm company and date fields with - or just dont initialize them whichever makes the thing easier
*/
import java.util.*;
import java.io.*;

public class patient
{
	int id;
	String name;
	int flat=0;
	int age=0;
	int doses_taken=0;
	boolean immunocompromised=false;
	char pharm='-';
	int s1=0;
  	int s2=0;
  	int s3=0;
  	int s4=0;
  	public patient()
    {
      	name=null;
      	immunocompromised=true;
      	id=flat=age=doses_taken=s1=s2=s3=s4=0;
      	pharm='-';
	}
  	public patient(int i,String n,int f,int a,int dt,boolean ic,char p,int sh1,int sh2,int sh3,int sh4)
    {
  		id=i;
      	name=n;
      	flat=f;
      	age=a;
      	doses_taken=dt;
      	immunocompromised=ic;
      	pharm=p;
      	s1=sh1;
      	s2=sh2;
		s3=sh3;
      	s4=sh4;
	}
} 


public class main
{
/* menus shits*/
  	public static void menu(){
      System.out.println("PLACEHOLDER PLACEHOLDER PLACEHOLDER");
      System.out.println(" 1) Add Records \n 2) Remove Records \n 3) Search For A Record \n 4) List of the ImmunoCompromised  \n 5) Check if due for booster \n 6) List  ");
      
    }
  	
  	public static void addRec(ArrayList<patient> p){
      	/*
      	int qL=0;
        System.out.println("Enter number of records to add: ");
        you get N.
        System.out.println("Enter data now: ");
        int r = 0;
        ArrayList<patient> p1 = new ArrayList<patient>();                                
        if(r != N)
        {
          System.out.println("ID Number:"); Scanner idObj = new Scanner(System.in); int idNew = idObj.nextInt();
          p1.id.add(idNew)   
          r ← r+1
        }
        if r=N then
          throw QueueFullException
          

        
        */
      	System.out.println("Enter the following...");
      	System.out.println("ID Number:"); Scanner idObj = new Scanner(System.in); int idNew = idObj.nextInt();
      	System.out.println("Name:"); Scanner nameObj = new Scanner(System.in); String nameNew = nameObj.nextLine();
      	System.out.println("Flat Number:"); Scanner flatObj = new Scanner(System.in); int flatNew = flatObj.nextInt();
      	System.out.println("Age:"); Scanner ageObj = new Scanner(System.in); int ageNew = ageObj.nextInt();
      	System.out.println("Doses Received:"); Scanner dtObj = new Scanner(System.in); int dtNew = dtObj.nextInt();												//this part of the code works, now we can take the data from the individual inputs
      	System.out.println("Immunocomprised?(true/false)"); Scanner icObj = new Scanner(System.in); boolean icNew = icObj.nextBoolean();
      	System.out.println("Pharmaceutical company(p,m,s,c,j,a)"); Scanner pObj = new Scanner(System.in); String pNew = pObj.next().charAt(0)();
      
      	System.out.println("Month of shot 1(0 if not received):"); Scanner sh1Obj = new Scanner(System.in); int sh1New = sh1Obj.nextInt();
      	System.out.println("Month of shot 2(0 if not received):"); Scanner sh2Obj = new Scanner(System.in); int sh2New = sh2Obj.nextInt();
      	System.out.println("Month of shot 3(0 if not received):"); Scanner sh3Obj = new Scanner(System.in); int sh3New = sh3Obj.nextInt();
      	System.out.println("Month of shot 4(0 if not received):"); Scanner sh4Obj = new Scanner(System.in); int sh4New = sh4Obj.nextInt();
      	
        patient temp = new patient(idNew, nameNew, flatNew, ageNew, dtNew, icNew, pNew, sh1New, sh2New, sh3New, sh4New);
      	p.add(temp);
        
    }
  	public static void delRec(ArrayList<patient> p)	
    {
    	Scanner rdr = new Scanner(System.in);
      	System.out.println("Enter id number: ");
      	int num = rdr.nextInt();
      	patient temp = new patient();
      	for(int i=0;i<p.size();i++)	
        {
          	temp=p.get(i);
          	if(num==temp.id)
            {	
              	p.remove(i);
              	System.out.println("Record of ID "+(i+1)+" removed...");
            }	
        }
    }
  	public static void viewRec(ArrayList<patient> p) //search for a Record
    {	
      	System.out.println("");
    	Scanner rdr = new Scanner(System.in);
      	System.out.println("Enter id number: ");                            
      	int num = rdr.nextInt();
      	patient temp = new patient();
    
      	try{
      	for(int i=0;i<p.size();i++)				//linear search
        {	
        	temp=p.get(i);
          	if(temp.id==num)
            {	
            	System.out.println("ID Number:" + temp.id + "\nName:" + temp.name + "\nFlat:" + temp.flat + "\nAge:" + temp.age +
                                   "\nDoses received:" + temp.doses_taken + "\nImmunocompromised:" + temp.immunocompromised +
                                   "\nPharmaceutical company:" + temp.pharm);
                System.out.println("\nMonth when vaccine received(1-Jan, 2-Feb...)\nFirst:"+temp.s1+" Second:"+temp.s2+" Third:"+temp.s3+" Fourth:"+temp.s4);
            }
        }
        } catch(Exception e){
          	System.out.println("Some error occured. uWu");
        }
    }
    
  	public static void immuSearch(ArrayList<patient> p){
      
      	patient temp = new patient();
      	int[] sortr;
      	int n=0;
      	for(int i=0;i<p.size();i++)
      	{
        	temp=p.get(i);
          	if(temp.immunocompromised==true)
            {
              	sortr[n]=temp.id;
              	n++;
            }
      	}
      	int size = sortr.length;
      	insertionSort(sortr);
      	viewRec(p);
    }
  
	public static void checkBoost(){
      
      	System.out.println("Enter the ID number of the record to be checked: ");
        Scanner sc = new Scanner(System.in);
      
        pid = sc.nextInt();
      
        patient temp = new patient();
      
      for(int i=0;i<p.size;i++)
      { 
        temp=p.get(i);
      
        while(temp.id==pid)
      {
          if(temp.s3==0)
         System.out.println("Booster shot not taken");
      
      for(int i=0;i<size;i++)
      {
        System.out.println("Your next shot is in "+temp.s4);
      }  
        
      }
      
      }
      	
    }
  	
  	public static void specVac{
      
    }
  	public static void main(String[] args){
      	
      	Scanner askObj = new Scanner(System.in);
      	int ask;
      	char repeat='y';
      	ArrayList<patient> ass = new ArrayList<patient>(); 
      	patient temp = new patient();
      	
      	//read from file
      	Scanner readFile = new Scanner(new File("list.txt"));
      	while (readFile.hasNext()){
        	String data = readFile.nextLine();
      		String[] arrTemp = data.split(" ");                  //Splits each line into individual values for the ArrayList
            temp.id =  Integer.parseInt(arrTemp[0]);
            temp.name = arrTemp[1];
            temp.flat = Integer.parseInt(arrTemp[2]);
            temp.age = Integer.parseInt(arrTemp[3]);
            temp.doses_taken = Integer.parseInt(arrTemp[4]);
            temp.immunocompromised = Boolean.parseBoolean(arrTemp[5]);
            temp.pharm = arrTemp[6].charAt(0);
          	temp.s1 = Integer.parseInt(arrTemp[7]);
          	temp.s2 = Integer.parseInt(arrTemp[8]);
          	temp.s3 = Integer.parseInt(arrTemp[9]);
          	temp.s4 = Integer.parseInt(arrTemp[10]);
          	ass.add(temp);
          }
      	
      	do													//conditions for menu- switch case and repeat loop
        {
         	menu();
          	System.out.println("Enter choice:");
        	ask = askObj.nextInt();
            switch (ask){
              case 1:
                addRec(ass);
                break;
              case 2:
                delRec(ass);
                break;
              case 3:
                viewRec(ass);
                break;
              case 4:
                immuSearch(ass);
                break;
              case 5:
                checkBoost();
                break;
              default:
                System.out.println("Option not available D:");
            }
          	System.out.println("Do you wish to continue?(y/n):");
          	repeat = askObj.nextInt();
        }while(repeat!='n'||repeat!='N');
    }


	//INSERTION SORT INSERTION SORT INSERTION SORT INSERTION SORT INSERTION SORT INSERTION SORT INSERTION SORT INSERTION SORT INSERTION SORT INSERTION SORT INSERTION SORT INSERTION SORT INSERTION SORT 
    public void insertionSort(int ass[]) {
    int size = ass.length;

    for (int step = 1; step < size; step++) {
      int key = ass[step];
      int j = step - 1;

      // Compare key with each element on the left of it until an element smaller than
      // it is found.
      // For descending order, change key<array[j] to key>array[j].
      while (j >= 0 && key < ass[j]) {
        ass[j + 1] = ass[j];
        --j;
      }

      // Place key at after the element just smaller than it.
      ass[j + 1] = key;
      
      System.out.println("Record: "+ass[i]);

    }
  }
  
  	//MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT MERGE SORT 

    // Merge two subarrays L and M into arr
void merge(int arr[], int p, int q, int r) {

    // Create L ← A[p..q] and M ← A[q+1..r]
    int n1 = q - p + 1;
    int n2 = r - q;

    int L[n1], M[n2];

    for (int i = 0; i < n1; i++)
        L[i] = arr[p + i];
    for (int j = 0; j < n2; j++)
        M[j] = arr[q + 1 + j];

    // Maintain current index of sub-arrays and main array
    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    // Until we reach either end of either L or M, pick larger among
    // elements L and M and place them in the correct position at A[p..r]
    while (i < n1 && j < n2) {
        if (L[i] <= M[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = M[j];
            j++;
        }
        k++;
    }

    // When we run out of elements in either L or M,
    // pick up the remaining elements and put in A[p..r]
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = M[j];
        j++;
        k++;
    }
}

}
// QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT QUICK SORT 
class Quicksort{

  // method to find the partition position
  static int partition(int array[], int low, int high) {
    
    // choose the rightmost element as pivot
    int pivot = array[high];
  
    // pointer for greater element
    int i = (low - 1);
    
    // traverse through all elements
    // compare each element with pivot
    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {

        // if element smaller than pivot is found
        // swap it with the greatr element pointed by i
        i++;

        // swapping element at i with element at j
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    // swapt the pivot element with the greater element specified by i
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    // return the position from where partition is done
    return (i + 1);
  }

  static void quickSort(int array[], int low, int high) {
    if (low < high) {

      // find pivot element such that elements smaller than pivot are on the left elements greater than pivot are on the right
      int pi = partition(array, low, high);
      
      // recursive call on the left of pivot
      quickSort(array, low, pi - 1);

      // recursive call on the right of pivot
      quickSort(array, pi + 1, high);
    }
  }
}

// Main class


/* THIS IS LIST OF PATIENTS/TENANTS         FILE 
id	name	flatnum	age	shotstaken(0-4)	immunoc?(0-1)	pharmcompany(p,m,s,c,j,a)	s1mnth	s2mnth	s3mnth	s4mnth(1-12)
01 Juan 1 19 3 0 p 1 2 8 0
02 Harry 1 54 4 0 m 1 2 8 1
03 Harrison 2 25 4 1 p 1 2 5 6
04 Ford 2 17 3 0 0 0 0 0 0
05 Elijah 3 43 2 0 m 2 3 0 0
06 Wood 2 21 3 1 s 4 5 8 0
07 Heather 1 23 4 0 p 3 4 10 11
08 Mia 6 22 2 0 j 5 6 0 0
09 Evelyn 4 32 3 0 m 7 8 2 0
10 Khalifa 4 28 2 0 a 3 4 0 0
11 Aurora 7 19 3 0 j 6 7 1 0
12 Luna 5 34 4 0 a 1 2 8 9
13 Simon 8 25 4 1 j 4 5 8 9
14 Cowell 2 10 0 0 0 0 0 0 0
15 Anthony 3 43 2 0 m 7 8 0 0
16 Hopkins 2 21 3 1 s 2 3 6 0
17 Penelope 1 23 4 0 p 1 2 8 9
18 Eva 6 22 2 0 s 9 10 0 0
19 Sam 4 32 3 0 m 8 9 3 0
20 Jessica 4 28 2 0 c 7 8 0 0	

*/
------------------------------------------------------------------------------------------------------------
String[] arrTemp = data.split(" ");
temp.id = arrTemp[0];
temp.name = arrTemp[1];
temp.flat = arrTemp[2];
temp.age = arrTemp[3];
temp.
ass.add(new patient(temp.id,temp.name,temp.flat,temp.doses_taken,temp.immunocompromised,temp.pharm,temp.s1,temp.s2,temp.s3,temp.s4));

patient temp = new patient();
  temp=ass.get(0);
  temp.name;
------------------------------------------------------------------------------------------------------------
