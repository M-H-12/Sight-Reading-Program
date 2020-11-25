import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppController {
	
	private AppView view;
	private AppModel model;
	
	public AppController() {
		
		view = new AppView();
		model = new AppModel();
		this.view.singleListener(new AddSingleListener());
		this.view.fiveListener(new AddFiveListener());
		this.view.quitListener(new AddQuitListener());
		
	}

	public AppView getView() {
		return view;
	}

	public void setView(AppView view) {
		this.view = view;
	}

	public AppModel getModel() {
		return model;
	}

	public void setModel(AppModel model) {
		this.model = model;
	}
	
	public static void main(String[] args) {
		AppController app = new AppController();

	}

	class AddSingleListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource() == view.getSingle()) {
				
				System.out.println("Single");
				
			}
			
		}
		
	}
	
	class AddFiveListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource() == view.getFive()) {
				
				System.out.println("Five");
				
			}
			
		}
		
	}
	
	class AddQuitListener implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				if(e.getSource() == view.getQuit()) view.dispose();
					
			}
			
	}


}
