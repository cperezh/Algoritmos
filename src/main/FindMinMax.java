package main;

public class FindMinMax {

	 static int[] findMinMax(int[] arr,int prof,int pos,int actSum,int[] actSolution){   
	        
	        int tmpSum;
	        
	        ++prof;
	        
	        if (pos==5)
	            System.out.println("nodo 5");
	        else{
	            System.out.print("arr[pos]:"+arr[pos]+" actSum:"+actSum+" pos: "+pos+" prof: "+prof);
	        }
	        
	        
	        for (int i=pos;i<arr.length;i++){     
	            
	            tmpSum = actSum + arr[i];
	            
	            System.out.println(" tmpSum: "+tmpSum+" pos: "+i+" prof: "+prof);
	       
	            if (prof==4){
	                actSolution[0] = (tmpSum<actSolution[0])?tmpSum:actSolution[0];
	                actSolution[1] = (tmpSum>actSolution[1])?tmpSum:actSolution[1];
	            }
	            else{
	                //Si ya no puedo alcanzar la profundidad de 4 desde esta posicion
	                if ((arr.length - pos)<(4-prof)){
	                    break;
	                }
	                else{
	                    actSolution = findMinMax(arr,prof,i+1,tmpSum,actSolution);
	                }
	            }
	        }
	        
	        return actSolution;
	    }

	    public static void main(String[] args) {
	       
	        int[] arr = test1();
	        
	        
	        int[] sol = {Integer.MAX_VALUE,0};
	            
	        sol = findMinMax(arr,0,0,0,sol);
	        
	        for (int i:sol){
	            System.out.print(i+" ");
	        }
	    }
	    
	    static int[] test1() {
	    	int[] arrTest = {1,2,3,4,5};
	    	
	    	return arrTest;
	    }
	
}
