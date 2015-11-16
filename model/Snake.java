package First_Work.model;

import First_Work.Dir;



public class Snake {
//	public String headS = "@";
//	public String body = "###";
	public char headS = '@';
	public char body = '#';
    private boolean dead = false;
    private int linha;
    private int coluna;
    
    public Snake(){} 
    
    public void setLinha(int linha){	
    	this.linha = linha;
    }
    
    public void setColuna(int coluna){
    	this.coluna = coluna;
    }
    
    public int getLinha(){
    	return linha;
    }
    
	public int getColuna() {
		 return coluna;
	}
	
    
  
    
    

}
