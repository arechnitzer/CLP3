                  /*  File:  cylinderR.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cylinderR extends Template {

     static {templateClass = new cylinderR() ; }

     public void setup() {
          filePrefix = "cylinderR" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3*0.7 ;      
          ysize = 4*180/120*0.7 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -90 ;
          ymax = 90 ;
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
          double r = 30 ;
          double h = 25 ;
          double y = h ;
          double x = r*y/h ;
          fEnv("lineWidth", 1) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,h,x,x/3.0, FILLED) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(-x,-h, -x,h) ;
          fLine(x,-h, x,h) ;
          fDisk(0,h,x,x/3.0, CLOSED) ;
          fEllipticalArc(0,-h, x,x/3.0, 180, 360, OPEN) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fEllipticalArc(0,-h, x,x/3.0, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(0, -h-x/3.0-3, "tc", "$x^2+y^2=1$") ;

          fEnv("lineWidth", 0.5) ;
          double th = 225*Math.PI/180.0 ; 
          double X = x*Math.cos(th) ;  double Y = x*Math.sin(th)/3.0 ;
          fLine(X, Y-h, X, Y+h) ; 
          th = 270*Math.PI/180.0 ; 
          X = x*Math.cos(th) ;  Y = x*Math.sin(th)/3.0 ;
          fLine(X, Y-h, X, Y+h) ; 
          th = 315*Math.PI/180.0 ; 
          X = x*Math.cos(th) ;  Y = x*Math.sin(th)/3.0 ;
          fLine(X, Y-h, X, Y+h) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          th = 60*Math.PI/180.0 ; 
          X = x*Math.cos(th) ;  Y = x*Math.sin(th)/3.0 ;
          fLine(X, Y-h, X, Y+h) ;
          th = 105*Math.PI/180.0 ; 
          X = x*Math.cos(th) ;  Y = x*Math.sin(th)/3.0 ;
          fLine(X, Y-h, X, Y+h) ;
          th = 150*Math.PI/180.0 ; 
          X = x*Math.cos(th) ;  Y = x*Math.sin(th)/3.0 ;
          fLine(X, Y-h, X, Y+h) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

 


     }
}
