/**
 * This class contains the method ShortestPath(to display them map), nextCell(to find the best neighbour), and the main which contains 
 * an algorithm that computes the shortest path from the start to finish. This class also uses the classes provided beforehand and a DLList.
 * 
 * @author Jian Xie
 * @version March 2019
 */

import java.io.FileNotFoundException;
import java.io.IOException;

public class ShortestPath {
	private static Map cityMap;
	private static MapCell currentCell;
	private static boolean destinationFound = false;
	
	
	 /** 
     * This method is the constructor method an instantiates a map for the user.
     * 
     * @throws InvalidMapException
	 *             An invalid character was found in the input file
	 * @throws IOException
	 *             An error occurred when trying to access the file.
	 * @throws FileNotFoundException
	 *             Inexistent file             
     * @param filename The filename of the map
     */ 
	public ShortestPath (String filename) throws InvalidMapException, FileNotFoundException, IOException {
		cityMap = new Map(filename);
		
	}
	
	 /** 
	    * This method returns the best neighbour of the cell passed through the parameter.
	    * It returns null if there is no such neighbour.
	    * @param cell Cell is the current cell.
	    */ 
	private MapCell nextCell(MapCell cell) {
		MapCell bestCell = null;
		
		
		//final loop to check remaining conditions. Goes in order from 0-3 and chooses best vertical/horizontal cell(prioritizes smaller i index)
		for (int i = 0; i<4; i++) {
			
			//checks vertical switch
			if ( i == 0 || i == 2) {
				if (cell.isVerticalSwitch() || cell.isOmniSwitch() || cell.isPowerStation()) {
					if (cell.getNeighbour(i) !=null && !cell.getNeighbour(i).isPowerStation()) {
						 if (cell.getNeighbour(i).isVerticalSwitch() && !cell.getNeighbour(i).isMarked()) {
							bestCell = cell.getNeighbour(i);
							return bestCell;
						}
						else if (cell.getNeighbour(i).isCustomer() && !cell.getNeighbour(i).isMarked()){
							bestCell = cell.getNeighbour(i);
							return bestCell;
						}
						else if (cell.getNeighbour(i).isOmniSwitch() && !cell.getNeighbour(i).isMarked()) {
							bestCell = cell.getNeighbour(i);
							return bestCell;
						}
					}}
				}
			
			//checks horizontal switch	
			else if ( i == 1 || i == 3) {
				if (cell.isHorizontalSwitch() || cell.isOmniSwitch() || cell.isPowerStation()) {
					if (cell.getNeighbour(i) !=null && !cell.getNeighbour(i).isPowerStation()) {
						if (cell.getNeighbour(i).isHorizontalSwitch() && !cell.getNeighbour(i).isMarked()) {
							bestCell = cell.getNeighbour(i);
							return bestCell;
						}
						else if (cell.getNeighbour(i).isCustomer() && !cell.getNeighbour(i).isMarked() ){
							bestCell = cell.getNeighbour(i);
							return bestCell;
						}
						else if (cell.getNeighbour(i).isOmniSwitch() && !cell.getNeighbour(i).isMarked()) {
							bestCell = cell.getNeighbour(i);
							return bestCell;
						}
					}}}}	
		
		return bestCell;
	}
	
	 /** 
	    * This method is the mainline logic for the program and includes the algorithm for finding
	    * the shortest path.
	    * @throws InvalidMapException
	    *             An invalid character was found in the input file
	    * @throws IOException
	    *             An error occurred when trying to access the file.
	    * @throws FileNotFoundException
	    *             Inexistent file       
	    */ 
	
	public static void main (String[] args) throws InvalidMapException, FileNotFoundException, IOException {
		
		//variable declaration
		ShortestPath connection = new ShortestPath(args[0]);
		String mapFileName = args[0];
		DLList <MapCell> DLList = new DLList<>();
		MapCell startingCell = cityMap.getStart();
		MapCell smallestCell;
		MapCell neighbouringCells;
		int numOfCells = -1;
		int distanceVar = 0;
		int distanceToC;
		int distanceC;
	
		//algorithm start
		DLList.insert(startingCell, 0);
		startingCell.markInList();
		
		while (!DLList.isEmpty() && !destinationFound) {
			smallestCell = DLList.getSmallest();
			smallestCell.markOutList();
			//loop ends once customer is found
			
			if (smallestCell.isCustomer()) {
				destinationFound = true;
				System.out.println("It took "+ smallestCell.getDistanceToStart() + " Cells to get from the power plant to the customer.");
			}
			else {
				
				//another while loop to check all neighbouring cells.
				while (connection.nextCell(smallestCell) != null) {
					
					neighbouringCells = connection.nextCell(smallestCell);
					distanceVar = (1+ smallestCell.getDistanceToStart());
					
					if (neighbouringCells != null) {
						//sets the distance and predecessor if needed 
						if (neighbouringCells!= null && neighbouringCells.getDistanceToStart() > distanceVar) {
							neighbouringCells.setDistanceToStart(distanceVar);
							neighbouringCells.setPredecessor(smallestCell);
							}
				
						distanceToC = neighbouringCells.getDistanceToStart();
						
						//changes value if neighbouringCells are marked.
						if (neighbouringCells.isMarked() && distanceToC < DLList.getDataValue(neighbouringCells)) {
							DLList.changeValue(neighbouringCells, distanceToC);
						}
						
						//adds a neighbouring cell to the list if it is not already marked.
						if (!neighbouringCells.isMarked()) {
							DLList.insert(neighbouringCells, distanceToC);
							neighbouringCells.markInList();
						}	
					}
				}
				}
			}
			if (destinationFound == false) {
				System.out.println("There is no path to get electricity to the customer.");
			}
	}
}
