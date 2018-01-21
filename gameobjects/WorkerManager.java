package gameobjects;
import java.util.ArrayList;
import bc.*;

public class WorkerManager extends BasicUnitManager {
	public ArrayList<Worker> workerList;
	public WorkerManager(GameController gc, ArrayList<GameObject> objectList) {
		super(gc, objectList);
		workerList = new ArrayList<Worker>();
		for(GameObject o : objectList){
			workerList.add((Worker)o);
		}
	}
	
	public void update(){
		for(Worker worker : workerList){
			worker.update();
		}
	}
	
	public int getOptimalWorkers(){
		//TODO make this
		return 0;
	}
}
