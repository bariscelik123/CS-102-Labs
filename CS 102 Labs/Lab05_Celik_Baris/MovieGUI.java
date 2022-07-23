import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
import java.util.*;
import java.io.*;

public class MovieGUI extends JFrame {
		private MovieDatabase database;
		
		JPanel category_panel;
        private JComboBox yearcmb;
        private JRadioButton drama;
        private JRadioButton comedy;
        private JRadioButton animation;
        private JRadioButton horror;
        private JTextArea list;
        private Scanner movies;
        private JButton save;
        private JMenuBar menuBar;
        private JMenu menu;
        private JMenuItem loadMovies;
		private int yearsselection;
		private String categoryselection;
        ArrayList<Movie> movielist3 = null;
        //stores the movie years from the movie database
        private ArrayList <Integer> years;
		
		//stores the categories from the movie database
		private ArrayList <String> categories;                                  					 
		
		//stores the year RadioButtons
    	private ArrayList<JRadioButton> buttonList = new ArrayList<JRadioButton>();    			   
        public MovieGUI (String title, String filename) throws FileNotFoundException{
        	database = new MovieDatabase(filename);
	       	setTitle(title);
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300,375);
     		MovieWindow();		
			//updateField();
			addListeners();  

      	}	

		public void addListeners() {
			yearcmb.addItemListener(new ComboChangeListener());
			buttonList.get(0).addActionListener(new RadioListener());
			buttonList.get(1).addActionListener(new RadioListener());

			buttonList.get(2).addActionListener(new RadioListener());

			buttonList.get(3).addActionListener(new RadioListener());

			buttonList.get(4).addActionListener(new RadioListener());

			save.addActionListener( new ButtonListener());
			loadMovies.addActionListener(new ButtonListener());
		}
        private void getComboYears(){
        	try {
        		years = database.getYears();
        	}
        	catch( NullPointerException ex ){
        		System.out.println( "Movies must be loaded before this operation" );
        	}

			
        	
        }
		private void defaultvar() {
			yearsselection = 2017;
			categoryselection = "Action";
		}

        private void getCategories(){
        	try {
        		categories = database.getCategories();
        	}
        	catch( NullPointerException ex ){
        		System.out.println( "Movies must be loaded before this operation" );
        	}	
        }
       
        private void addRadioButtons(){
        	ButtonGroup category_group = new ButtonGroup();
          	
          	getCategories();
          	JRadioButton button;
          	for( String c : categories ){
          		button = new JRadioButton( c, false);
          		buttonList.add(button);
          		category_panel.add(button);	
          		category_group.add(button);
          	}
          	buttonList.get(0).setSelected(true);
        }
        private void MovieWindow() {
        	setLayout(new FlowLayout());
        	
        	//get the years for the combo box and add the combo box
        	getComboYears();
        	JLabel yearLabel = new JLabel("Choose Year");
          	yearcmb = new JComboBox(years.toArray());
           	yearcmb.setSelectedIndex(0);
           	add(yearLabel);
          	add(yearcmb);
          
          	//create button panel and add buttons using method
          	category_panel = new JPanel();
          	category_panel.setLayout(new BoxLayout(category_panel, BoxLayout.Y_AXIS));
          	category_panel.add(new JLabel("Categories", JLabel.CENTER));
          	add(category_panel);
          	addRadioButtons();
          	
          	//create movie list text area, add to scrollpane
          	list = new JTextArea(8, 20);
          	JScrollPane listScroll = new JScrollPane(list,
          	                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
          	                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
          	//add scroll pane to JFrame 
          	add(listScroll);         	                       
 			
 			
 			//create save button and add to JFrame
 			save = new JButton("SAVE TO FILE");
          	add(save);
          	
          	//create menuBar and add menu/item and add to JFrame
          	menuBar = new JMenuBar();
          	menu = new JMenu("Options");
          	loadMovies = new JMenuItem("Exit");
          
			//add item to menu/menu to bar/bar to JFrame
			menu.add( loadMovies );
			menuBar.add(menu);
			this.setJMenuBar(menuBar);
			
		}//end MovieWindow	

		public ArrayList<String> movies (int year) {
			ArrayList<String> x = new ArrayList<String>();
			return x;
		}
		public void updateField(){
			
			if(movielist3.size() == 0) {
				list.setText("");
			}

			else {
				String text = "";
				for (Movie s: movielist3) {
					text = text + s.getMovieName() + " Length : " + s.getLength() + "\n";
				}
				list.setText(movielist3.toString());
			}

				}

	 class RadioListener implements ActionListener{
			public void actionPerformed(ActionEvent x){
				JRadioButton button= (JRadioButton) x.getSource();
				categoryselection = button.getText();
				movielist3 = database.searchMovies(categoryselection, years.get(yearcmb.getSelectedIndex()));
				list.setText(movielist3.toString());
				//updateField();
			}
		}

		 class ComboChangeListener implements ItemListener {

			@Override
			public void itemStateChanged(ItemEvent event) {

			
			if(event.getStateChange()==ItemEvent.SELECTED){
				int year = (int) yearcmb.getSelectedItem();
				yearsselection = year;
				//updateField(); 
			}
		}

		}
		private class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event ) {
				String text = "";
				ArrayList<Movie> movies = database.searchMovies(categoryselection, yearsselection);

					if ( movies.size() != 0) {
						for (Movie x: movies) {
							text = text + x.toString() + "\n";
						}
					}

					String filename = categoryselection + yearsselection;
					try {
					File objfile = new File (filename);
					if(objfile.createNewFile()){
						System.out.println("created");
					}
					else {
						System.out.println("Already exist");
					}
					FileWriter writer = new FileWriter(filename);
					writer.write(text);
					writer.close();
				} 
				catch(IOException m) {
					m.printStackTrace();
				}
					if (event.getSource() == loadMovies) {
						System.exit(0);
					}
				}
			}
		}
	
