                  /*  File:  box.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class box extends Template {

     static {templateClass = new box() ; }

     public void setup() {
          filePrefix = "box" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 1.7 ; 
          xmin = -80 ;
          xmax =  120 ;
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
          double x = 60 ;
          double y = 90 ;
          double z = 60 ;
          double r = 4 ;



          fEnv("lineWidth", 0.5) ;
//          fLine(y,0,xmax,0) ;
//          fLine(0,x*x1+z,0,ymax) ;
//          fLine(x*x0, x*x1, xmax*x0, xmax*x1) ;
//          fTeXlabel(xmax+5,0, "lc", "$y$") ;
//          fTeXlabel(0,ymax+5, "bc", "$z$") ;
//          fTeXlabel(xmax*x0-1, xmax*x1-1, "tr", "$x$") ;

//          fDisk(x*x0, x*x1,r,r,FILLED) ; 


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fLine(x*x0, x*x1, x*x0, x*x1+z) ;
          fLine(0, x*x1+z,  0, z) ;
          fLine(y, 0,  y, z) ;
          fLine(x*x0+y, x*x1, x*x0+y, x*x1+z) ;

          fLine(x*x0+y, x*x1+z,  y, z) ;
          fLine(x*x0, x*x1+z, 0, z) ;
          fLine(0, z, y, z) ;
          fLine(x*x0, x*x1+z, x*x0+y, x*x1+z) ;

          fLine(x*x0, x*x1, x*x0+y, x*x1) ;
          fLine(x*x0+y, x*x1, y, 0) ;

          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fLine(0,0, x*x0, x*x1) ;
          fLine(0, 0,  0, x*x1+z) ;
          fLine(0,0,y,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(x*x0+y/2.0, x*x1-3.5, "tc", "$y$") ;
          fTeXlabel(0.5*x*x0+y, x*x1/2.0-6.5, "lc", "$x$") ;
          fTeXlabel(y+2.5, z/2.0, "lc", "$z$") ;

          
     }
}



