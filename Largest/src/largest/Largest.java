/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package largest;

/**
 *
 * @author Alex Boccaccio
 */
public class Largest {

    public Largest() {
	}
	
	public int largest(int[] list){
		int index;
		int max;
		if( list.length > 0) {
			max = list[0];
		} else return 0;
		// this list is too liw
		for (index = 0; index < list.length; index++){
				if (list[index] > max) {
					max = list[index];
				}
		}
		return max;
	}
} // end class
