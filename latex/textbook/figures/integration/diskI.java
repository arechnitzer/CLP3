                  /*  File:  diskI.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class diskI extends Template {

     static {templateClass = new diskI() ; }

     public void setup() {
          filePrefix = "diskI" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -2.5 ;
          xmax = 2.7 ;
          ymin = -2.5 ;
          ymax = 2.7 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;



          fEnv("psFillGray", 0.9) ;
          fDisk(0,0, 2,2, FILLED);
          fTeXlabel(0.8,0.7, "cc", "$\\cR$") ;

          fEnv("lineWidth", 0.5) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;


          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fDisk(0,0, 2,2, CLOSED);


          fEnv("lineWidth", 0.5) ;
          double n = 12 ;
          double dth = 2*Math.PI/n  ;
          double th = 0 ;
          double x, y ;
           x = 0.5 ; y=-1.5 ;
           fLine(x,y, x,0) ;
           fDisk(x,y, 0.08, 0.08, FILLED) ;
           fTeXlabel(x+0.07,0.5*y, "cl", "$|y|$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fLine(xmin, 0, xmax, 0) ;
          fTeXlabel(xmax,-0.07, "tr", "$x$") ;


           
//          fTeXlabel(1.0, ymin-0.1, "tc", "$r=a$") ;
          
     }
}
