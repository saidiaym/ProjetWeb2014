package XML;



import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import org.w3c.dom.Node;


public class ApplicationPrinc {
	
	//constante
	
	private static final int WIDTH = 700;
	private static final int HEIGTH = 700;
	
	// ATTRIBUTS
	
	private JFrame frame;

	
	private JButton AfficherAll;
	private JButton ajouter;
	private JButton reset;
	private ConverterXML pars = new  ConverterXML();
	
	
	private JScrollPane scroll;
	private JScrollPane scroll1;
	private File[] roots;
	private JTextArea area;
	private javax.swing.JTree Tree ;
	private DefaultMutableTreeNode root;

	private TreeModel treemodel;
	private List<String> ID;
	
	
	public ApplicationPrinc() throws IOException {
        createModel();
		createView();
        placeComponents();
        createController();
	}
	
	public void Display() {
		
		frame.pack();
		frame.setVisible(true);
		frame.validate();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	}
	
	
	public void createModel() {
		
	}
	
	private void createController() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO Auto-generated method stub
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.setText("");   	
			}
		});
		 
		 AfficherAll.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent arg0)  {
				// TODO Auto-generated method stub
				String result;
				
					 try {
						 
						result = ApplicationPrinc.get("http://resumexml.saidiaym.cloudbees.net/rest/Resume/all");
						area.setText("");
						frame.repaint();
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			
			});
		 ajouter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					openFrame();  
					frame.dispose();
				
				}
			});
		 Tree.addTreeSelectionListener(new TreeSelectionListener() {
		
				public void valueChanged(TreeSelectionEvent e) {
					DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) Tree.getLastSelectedPathComponent();
					if (node1 == null) {
						return;
					}
					Object nodeInfo;
				
					if (node1.isLeaf())
					{
						/*int  identifiant = node1.getIndex(node1.getNextLeaf());
						System.out.println(identifiant);*/
						String leafts  = e.getNewLeadSelectionPath().getLastPathComponent().toString();
						System.out.println();
						try {
						
							 List<String> myList = new LinkedList<String>();
							 String result;
							result = ApplicationPrinc.get("http://resumexml.saidiaym.cloudbees.net/rest/Resume/" + leafts);
							Node myNode = ConverterXML.ConvertStringToNode(result);
							ConverterXML.Idrecup(myNode, myList, "nom");
							  String nom = myList.get(0);
							  myList.clear();
							 ConverterXML.Idrecup(myNode, myList, "prenom");
							  String prenom = myList.get(0);
							  myList.clear();
							  
							 ConverterXML.Idrecup(myNode, myList, "mail");
							  String mail = myList.get(0);
							  myList.clear();
							  
							 ConverterXML.Idrecup(myNode, myList, "adresse");
							  String adresse = myList.get(0);
							  myList.clear();
							  ConverterXML.Idrecup(myNode, myList, "experience");

							  String exp1 = myList.get(0);
							 
							  myList.clear();
							  
							 ConverterXML.Idrecup(myNode, myList, "competences");
								 
							  String com1 = myList.get(0);
							  String com2 = myList.get(1);
							  
							  myList.clear();
							  
							  ConverterXML.Idrecup(myNode, myList, "langues");
							  
								 
							  String lan1 = myList.get(0);
							  String lan2 = myList.get(1);
							
							  myList.clear();
							  
							  
							  ConverterXML.Idrecup(myNode, myList, "loisir");
							  
								 
							  String loisir1 = myList.get(0);
							 
							  myList.clear();
							  String CVdom = new String();
							  String NewLigne = System.getProperty("line.separator");
							  CVdom = "Nom :"+ nom + NewLigne + "Prenom :" + prenom +  NewLigne +"Mail :"+mail+NewLigne+"Adresse"+adresse+NewLigne+ "Experiences :" + NewLigne + exp1 + NewLigne+ /*exp2*/ NewLigne + "Competences :" + NewLigne + com1 + NewLigne+ com2+ NewLigne  +"Langues :" + NewLigne + lan1 + NewLigne+ lan2+ NewLigne + "Loisirs :" + NewLigne + loisir1 + NewLigne    ;
							  
							  area.setText(CVdom);
						  
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 	 
						  
						  
					}	
					
					}
			});
		 
	 }
	 public static String get(String url) throws IOException {
		 String source ="";	
		URL oracle = new URL(url);
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(
		new InputStreamReader(
		yc.getInputStream()));
		String inputLine;
		 
		while ((inputLine = in.readLine()) != null)
		source +=inputLine;
		in.close();
		return source;
}
	 private void openFrame() {                                  
		    AjouterCV t = new AjouterCV();
		    t.display();
		  }
	
	
	private void createView() {
		
		// TODO Auto-generated method stub
		frame = new JFrame("Gestionnaire des fichiers");
		frame.setPreferredSize(
				new Dimension(WIDTH, HEIGTH)
		);
		AfficherAll = new JButton("AfficherAll");
		ajouter = new JButton("ajouter");
		reset = new JButton("Reset");
		area = new JTextArea();
		scroll1 = new JScrollPane(area);
		Tree = new JTree(treemodel);
		root =  new DefaultMutableTreeNode("CVS");
	    DefaultTreeModel treeModel = new DefaultTreeModel(root);
	    
	    Tree = new javax.swing.JTree(treeModel);
	    Tree.setShowsRootHandles(true);
		
		scroll = new javax.swing.JScrollPane();  
	    scroll.setViewportView(Tree);  
		scroll.setPreferredSize(new Dimension(150,700));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
	  	
	}

	private void placeComponents() throws IOException {
		// TODO Auto-generated method stub
	        
		JPanel p = new JPanel(new BorderLayout());
		JPanel q = new JPanel(new FlowLayout());{
			
			q.add(AfficherAll);
			q.add(ajouter);
			q.add(reset);
		}
		p.add(q,BorderLayout.NORTH);
		
		JPanel j = new JPanel(new BorderLayout());{
		j.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Affichage",0,0,new Font("dialog",1,12),Color.black));
		j.add(area);
		}
		p.add(j,BorderLayout.CENTER);
		frame.add(scroll,BorderLayout.WEST);
		frame.add(p,BorderLayout.CENTER);
		 

		 String listCVString;
		 	ID = new LinkedList<String>();
			listCVString = ApplicationPrinc.get("http://resumexml.saidiaym.cloudbees.net/rest/Resume/all");
			 System.out.println(listCVString); 
			Node myNode = ConverterXML.ConvertStringToNode(listCVString);
			System.out.println(myNode.getNodeName());
				ConverterXML.Idrecup(myNode, ID, "identifiant");
				 for(int i = 0; i<ID.size();i++){
			            System.out.println(ID.get(i));
			         }
		
		
	        
	        try {
				fillTree(ID);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	 public javax.swing.JTree getjTreeFile() {
			return Tree;
		}
		 
		 public void fillTree(List<String> ID) throws IOException{
			 for(String row:ID){
				 
				 DefaultMutableTreeNode node=new DefaultMutableTreeNode(row);
				 
				 root.add(node);
			 }
			 
		}

	 public static void main(String[] args) {
		 SwingUtilities.invokeLater(
		     new Runnable() {
	             public void run() {
	                 try {
						new ApplicationPrinc().Display();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	             }
	         }
	     );
	 }
}
