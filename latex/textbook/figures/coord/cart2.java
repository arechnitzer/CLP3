                  /*  File:  cart2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cart2 extends Template {

     static {templateClass = new cart2() ; }

     public void setup() {
          filePrefix = "cart2" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2 ;    
          ysize = 1.2 ;  
          xmin = -80 ;
          xmax =  90 ;
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
          double y = 25 ;
          double z = 50 ;
          double r = 4 ;



          fEnv("lineWidth", 0.5) ;
          fLine(0,0,xmax,0) ;
          fLine(0,z,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;
          canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
          fLine(0,0,0,z) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0-1, xmax*x1-1, "tr", "$x$") ;

          fDisk(0,z,r,r,FILLED) ; 


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fLine(0,z, ymax,z) ;
          fLine(ymax,z, xmax*x0+ymax, xmax*x1+z) ;
          fLine(0,z, xmax*x0, xmax*x1+z) ;
          fLine(xmax*x0, xmax*x1+z, xmax*x0+ymax, xmax*x1+z) ;
          fTeXlabel(-2, z+2, "br", "$(0,0,z)$") ;

          fTeXlabel(5,-60, "tc", "surface of constant $z$") ;
          fTeXlabel(5,-85, "tc", "(a plane)") ;
          
     }
}



