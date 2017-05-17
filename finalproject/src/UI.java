
public class UI 
{
	void keyPressed()
	{

	     //sets controls for wasd
	     if(controls == "wasd"){ 
	          if(key == 'w' || key == 'W'){ 
	            y -= speed; //move forwards
	          }
	          if(key == 's' || key == 'S'){
	            y += speed; //move backwards
	          }
	            if(key == 'd' || key == 'D'){
	            x += speed; //move right
	          }
	          if(key == 'a' || key == 'A'){
	            x -= speed; //move left
	          }
	         }

	      //sets controls for arrows 
	      if(controls == "arrows"){ 
	        if(key == CODED){
	          if(keyCode == UP){ 
	            y -= speed; //move forwards
	          }
	          if(keyCode == DOWN){
	            y += speed; //move backwards
	          }
	            if(keyCode == RIGHT){
	            x += speed; //move right
	          }
	          if(keyCode == LEFT){
	            x -= speed; //move left
	          }
	         }  
	        }  
	       }
}
