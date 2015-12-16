package ua.luckydev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ua.luckydev.jpa.data.Worker;
import ua.luckydev.spring.service.WorkerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class RegisterWorker {

	@ManagedProperty("#{workerService}")
	private WorkerService workerService;

	private Worker worker = new Worker();
	List<Worker> workerList;

	public WorkerService getWorkerService() {
		return workerService;
	}

	public void setWorkerService(WorkerService workerService) {
		this.workerService = workerService;
	}

	public Worker getWorker() {
		return worker;
	}

//	public void setWorker (Worker worker) {
//		this.worker = worker;
//	}
//
//		public List<Worker> getWorkerList(){
//		workerList=new ArrayList<Worker>();
//			Worker worker1 = new Worker();
//			worker1.setFio("1111");
//			worker1.setDatebirth(new Date());
//			Worker worker2 = new Worker();
//			worker2.setFio("2222");
//			worker2.setDatebirth(new Date());
//			Worker worker3 = new Worker();
//			worker3.setFio("3333");
//			worker3.setDatebirth(new Date());
//
//		workerList.add(worker1);
//		workerList.add(worker2);
//		workerList.add(worker3);
//		return workerList;
//	}

	public List<Worker> getWorkerList(){
		workerList=new ArrayList<Worker>();
		workerList.addAll(workerService.listPersons());
		return workerList;
	}


	public String register() {
		// Calling Business Service
		workerService.register(worker);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Employee "+this.worker.getFio() + " Is Registered Successfully"));
		return "";
	}
}