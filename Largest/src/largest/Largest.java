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
		//int index;
		int max = list[0];

		for (int index = 0; index < list.length; index++){
				if (list[index] > max) {
					max = list[index];
				}
				max = Math.max(list[index], max);
		}
		return max;
	}
} // end class
