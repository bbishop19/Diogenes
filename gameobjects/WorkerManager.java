package gameobjects;
import java.util.ArrayList;
import bc.*;

public class WorkerManager extends BasicUnitManager {
	public ArrayList<Worker> workerList;
	public boolean factoryNeed;
	public int optimalWorkers = 5;
	public WorkerManager(GameController gc, ArrayList<GameObject> objectList) {
		super(gc, objectList);
		workerList = new ArrayList<Worker>();
		for(GameObject o : objectList){
			workerList.add((Worker)o);
		}
	}
	
	public void update(){
		getFactoryNeed();
		int workersThisTurn = 0;
		for(Worker worker : workerList){
			if(!gc.canSenseUnit(worker.id)){
				workerList.remove(worker);
				continue;
			}
			if(workerList.size()+workersThisTurn < optimalWorkers){
				if(worker.replicate()){
					workersThisTurn++;
				}
			}
			else if(factoryNeed && worker.currentTask == 5){
				worker.currentTask = 3;
				factoryNeed = false;
			}
			else if(worker.currentTask == 5){
				int closestId = worker.getClosestFactoryBlueprint();
				if(closestId != -1){
					worker.targetId = closestId;
					worker.currentTask = 2;
				}
			}
			else if(worker.currentTask == 2 && worker.getClosestFactoryBlueprint() == -1){
				worker.currentTask = 5;
			}
		}
		for(Worker worker : workerList){
			worker.update();
		}
	}
	
	public int getOptimalWorkers(){
		//TODO make this
		return 0;
	}
	
	public void getFactoryNeed(){
		if(gc.karbonite() > 100){
			factoryNeed = true;
		}
	}
}
