package XML;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class AjouterCV{
	
	// Les dimensions du panel

	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 500;
	
    //Les Attributs
    
		private JFrame frame;
		private JButton envoyer;
		private JTextField Nom;
		private JTextField Prenom;
		private JTextField Email;
		private JTextField Adresse;
		private JTextField ID;
		private JTextArea Langues;
		private JTextArea Langues1;
		
		private JComboBox Niveaux1;
		private JComboBox Niveaux2;
		private JComboBox NiveauxLn1;
		private JComboBox NiveauxLn2;
		private JComboBox Duree;
		private JComboBox Duree1;
		private JTextArea Competences;
		private JTextArea Competences1;
		private JTextArea Experiences;
		private JTextArea Experiences1;
		private JTextArea Loisirs;
		
		
		
		
	 
	 public AjouterCV() {
		 
         createView();
         placeComponents();
         CreateController();
         
     
	 
	 }
	 
	public void display() {
			
	      frame.pack();
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true);
	    }

	private void CreateController() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
   	 envoyer.addActionListener(new ActionListener() {
   		 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String cv;
				 try {
					 String mail = Email.getText();
					 String id = ID.getText();
					 String adresse = Adresse.getText();
					 String nom = Nom.getText();
					 String prenom = Prenom.getText();
					 String loisirs =Loisirs.getText();
					 String langues = Langues.getText();
					 String Nivln  = NiveauxLn1.getSelectedItem().toString();
					 String langues1 = Langues1.getText();
					 String Nivln1  = NiveauxLn2.getSelectedItem().toString();
					 String competences = Competences.getText();
					 String com1  = Niveaux1.getSelectedItem().toString();
					 String competences1 = Competences1.getText();
					 String com2  = Niveaux2.getSelectedItem().toString();
					 String Exp1 = Experiences.getText();
					 String d1  = Duree.getSelectedItem().toString();
					 String Exp2 = Experiences1.getText();
					 String d2 = Duree1.getSelectedItem().toString();
					 
					 String myurl = new String("http://resumexml.saidiaym.cloudbees.net/rest/Resume/"+id+"/"+prenom+"/"+nom+"/"+mail+"/adresse/"+adresse+"/competences/"+competences+"/"+com1+"/"+competences1+"/"+com2+"/experiences/"+Exp1+"/"+d1+"/"+Exp2+"/"+d2+"/langues/"+langues+"/"+Nivln+"/"+langues1+"/"+Nivln1+"/loisirs/"+loisirs );
						System.out.println("http://resumexml.saidiaym.cloudbees.net/rest/Resume/"+id+"/"+prenom+"/"+nom+"/"+mail+"/adresse/"+adresse+"/competences/"+competences+"/"+com1+"/"+competences1+"/"+com2+"/experiences/"+Exp1+"/"+d1+"/"+Exp2+"/"+d2+"/langues/"+langues+"/"+Nivln+"/"+langues1+"/"+Nivln1+"/loisirs/"+loisirs);
					 cv = ApplicationPrinc.get(myurl);
						System.out.println(cv);
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 Email.setText("");
				 ID.setText("");
				 Adresse.setText("");
				 Nom.setText("");
				 Prenom.setText("");
				 Loisirs.setText("");
				 Langues.setText("");
				 Langues1.setText("");
				 Competences.setText("");
				 Competences1.setText("");
				 Experiences.setText("");
				 Experiences1.setText("");
				 
			
				 
				 
			}
		});
		
	}
	
	private void createView() {
		// TODO Auto-generated method stub
		
		 frame = new JFrame("FormulaireCV");
		 frame.setPreferredSize(
	                new Dimension(FRAME_WIDTH, FRAME_HEIGHT)
	        );
		
		 Nom = new JTextField(10);
		 Prenom = new JTextField(10);
		 ID = new JTextField(10);
		 Email = new JTextField(10);
		 Adresse = new JTextField(10);
		 envoyer = new JButton("transfererServ");
		 
		 NiveauxLn1 = new JComboBox();
		 NiveauxLn1.addItem("Faibles");
		 NiveauxLn1.addItem("Moyen");
		 NiveauxLn1.addItem("Haut");
		 NiveauxLn2 = new JComboBox();
		 NiveauxLn2.addItem("Faibles");
		 NiveauxLn2.addItem("Moyen");
		 NiveauxLn2.addItem("Haut");
		 Niveaux1 = new JComboBox();
		 Niveaux1.addItem("Faibles");
		 Niveaux1.addItem("Moyen");
		 Niveaux1.addItem("Haut");
		 Niveaux2 = new JComboBox();
		 Niveaux2.addItem("Faibles");
		 Niveaux2.addItem("Moyen");
		 Niveaux2.addItem("Haut");
		 Duree = new JComboBox();
		 Duree.addItem("2 mois");
		 Duree.addItem("Plus 2 mois");
		 Duree1 = new JComboBox();
		 Duree1.addItem("2 mois");
		 Duree1.addItem(" plus Que 2");
		 
		 Competences = new JTextArea();
	     Competences.setPreferredSize(new Dimension(200,20));
	     Competences.setEditable(true);
	     Competences1 = new JTextArea();
	     Competences1.setPreferredSize(new Dimension(200,20));
	     Competences1.setEditable(true);
	     Experiences = new JTextArea();
	     Experiences.setPreferredSize(new Dimension(200,20));
	     Experiences.setEditable(true);
	     Experiences1 = new JTextArea();
	     Experiences1.setPreferredSize(new Dimension(200,20));
	     Experiences1.setEditable(true);
	     Loisirs = new JTextArea();
	     Loisirs.setPreferredSize(new Dimension(200,20));
	     Loisirs.setEditable(true);	
	     Loisirs = new JTextArea();
	     Loisirs.setPreferredSize(new Dimension(200,20));
	     Loisirs.setEditable(true);	
	     Langues = new JTextArea();
	     Langues.setPreferredSize(new Dimension(200,20));
	     Langues.setEditable(true);	
	     Langues1 = new JTextArea();
	     Langues1.setPreferredSize(new Dimension(200,20));
	     Langues1.setEditable(true);	
	     	
	}

	private void placeComponents() {
		// TODO Auto-generated method stub
		JPanel Grid = new JPanel(new GridLayout(0,1));{
			JPanel f = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
			f.add(new JLabel("Email @:"));
			f.add(Email);
			}
			Grid.add(f);
			JPanel N = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
			N.add(new JLabel("NOM :"));
			N.add(Nom);
			}
			Grid.add(N);
			JPanel P = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
			P.add(new JLabel("Prenom :"));
			P.add(Prenom);
			}
			Grid.add(P);
			JPanel I = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
			I.add(new JLabel("ID :"));
			I.add(ID);
			}
			Grid.add(I);
			JPanel v = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
				v.add(new JLabel("Adresse:"));
				v.add(Adresse);
				}
			Grid.add(v);
		}
		JPanel Grid1 = new JPanel(new GridLayout(0,1));{
			JPanel f = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
				
				JScrollPane sp = new JScrollPane(Competences);
		    	sp.setBorder(BorderFactory.createTitledBorder("CompetencesProf"));
		    	f.add(sp);
		    	f.add(Niveaux1);
		    	
		    	JScrollPane sp1 = new JScrollPane(Competences1);
		    	sp1.setBorder(BorderFactory.createTitledBorder("CompetencesProf1"));
		    	f.add(sp1);
		    	f.add(Niveaux2);
		    	
		    	
		    	
		    	
			}
			Grid1.add(f);
			
	    	JPanel k = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
	    	JScrollPane sp2 = new JScrollPane(Loisirs);
	    	sp2.setBorder(BorderFactory.createTitledBorder("Loisirs"));
	    	k.add(sp2);
	    	
	  
	    	}
	    	
	    	Grid1.add(k);
	    	JPanel E = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
	    	JScrollPane sp1 = new JScrollPane(Experiences);
	    	sp1.setBorder(BorderFactory.createTitledBorder("Experiences"));
	    	E.add(sp1);
	    	E.add(Duree1);
	    	JScrollPane spE = new JScrollPane(Experiences1);
	    	spE.setBorder(BorderFactory.createTitledBorder("Experiences1"));
	    	E.add(spE);
	    	E.add(Duree);
	    	
	    	}
	    	Grid1.add(E);
	    	JPanel j = new JPanel(new FlowLayout(new FlowLayout().CENTER));{
	    	j.add(new JLabel("LANGUES:"));
	    	j.add(Langues);
	    	j.add(NiveauxLn1);
	    	j.add(Langues1);
	    	j.add(NiveauxLn2);
	    	}
	    	Grid1.add(j);
	    	
	    	
			
		}
		JPanel k = new JPanel(new FlowLayout(FlowLayout.CENTER));{
			k.add(envoyer);
			
		}
		frame.add(k,BorderLayout.NORTH);
		frame.add(Grid,BorderLayout.WEST);
		frame.add(Grid1,BorderLayout.CENTER);
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
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AjouterCV().display();
            }
        });
}
}
