import java.util.ArrayList;

public class States {

	private String name;
	private ArrayList<Transition> trans = new ArrayList();
	private boolean isFinal;
	private String position;
	
	public States(String name,boolean isFinal,String position){
		this.name= name;
		this.isFinal=isFinal;
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	public ArrayList<Transition> getTransition() {
		return trans;
	}
	public boolean getisFinal() {
		return isFinal;
	}	
	public String getPosition() {
		return position;
	}
	public void addTransition(Transition transition){
		trans.add(transition);
	}
	
}
