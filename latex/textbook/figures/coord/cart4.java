                  /*  File:  cart4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cart4 extends Template {

     static {templateClass = new cart4() ; }

     public void setup() {
          filePrefix = "cart4" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2*220/170 ;    
          ysize = 1.2 ;  
          xmin = -80 ;
          xmax =  140 ;
          ymin = -80 ;
          ymax =  90 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 30 ;
//          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
//          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double x = 50 ;
          double xxmax = 90 ;
          double y = 50 ;
          double z = 40 ;
          double r = 4 ;



          fEnv("lineWidth", 0.5) ;
          fLine(y,0,xmax,0) ;
          fLine(0,xxmax*x1+ymax+18,0,ymax) ;
          fLine(y+xxmax*x0,(y+xxmax*x0)*xxmax*x1/(xxmax*x0), xxmax*x0, xxmax*x1) ;
          canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
          fLine(0,0,y,0) ;
          fLine(0,0,0, xxmax*x1+ymax+12) ;
          fLine(0,0, y+xxmax*x0, (y+xxmax*x0)*xxmax*x1/(xxmax*x0)) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xxmax*x0-1, xxmax*x1-1, "tr", "$x$") ;

          fDisk(y,0,r,r,FILLED) ; 


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fLine(y,0, y,ymax) ;
          fLine(y,ymax, y+xxmax*x0, xxmax*x1+ymax) ;
          fLine(y,0, y+xxmax*x0, xxmax*x1) ;
          fLine(y+xxmax*x0, xxmax*x1, y+xxmax*x0, xxmax*x1+ymax) ;
          fTeXlabel(y+2, -2, "tl", "$(0,y,0)$") ;

          fTeXlabel(30,-60, "tc", "surface of constant $y$") ;
          fTeXlabel(5,-85, "tc", "(a plane)") ;
          
     }
}



