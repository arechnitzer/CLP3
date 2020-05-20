                  /*  File:  room1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class room1 extends Template {

     static {templateClass = new room1() ; }

     public void setup() {
          filePrefix = "room1" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -5 ;
          ymax =  5 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
//          fLine(0,ymin,0,ymax) ;
//          fTeXlabel(xmax,-0.3, "tr", "$x$") ;
//          fTeXlabel(-0.3, ymax, "tr", "$y$") ;
         int n = 2 ;
         double dth = 360.0/n ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;


          double r = 5 ; double th = 0 ; double thrad=th*Math.PI/180.0 ;
          double x = r*Math.cos(thrad) ; double y = r*Math.sin(thrad) ; 

          for ( int i=1; i <= n ; i++ ) {
               th += dth ;  thrad=th*Math.PI/180.0 ;
               x = r*Math.cos(thrad) ;  y = r*Math.sin(thrad) ; 
              fLine(0, 0,  x, y) ;
              fArrowhead(0.6*x,0.6*y, th+180) ;
          } 


//          fEnv("useColorPs", "false") ;
//          canvas.append( new fPsWrite(Black+"\n")) ;
//          fEnv("psFillGray", 1.0) ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 0.5) ;
          fDisk(0, 0, 0.3, 0.3, FILLED) ;

     }
}
