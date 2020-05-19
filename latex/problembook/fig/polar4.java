                  /*  File:  polar4.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar4 extends Template {

     static {templateClass = new polar4() ; }

     public void setup() {
          filePrefix = "polar4" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 1 ;
          ymin = -0.2 ;
          ymax = 1 ;
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
          fEnv("lineWidth", 1) ;
          double th = 30 ; double thRad = th*Math.PI/180.0 ;
          double thPhi = 60 ; double thPhiRad = thPhi*Math.PI/180.0 ;
          double r = 1 ;
          double x = r*Math.cos(thRad) ; double  y = r*Math.sin(thRad) ;
          double X = r*Math.cos(thPhiRad) ; double  Y = r*Math.sin(thPhiRad) ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fArrow(0,0, x,y) ;
          fTeXlabel(0.5*x-0.03, 0.5*y-0.01 , "br", "$r$") ;
          fTeXlabel(x+0.02, y , "cl", "$\\llt a,b\\rgt$") ;

          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("psFillColor", Pink) ;
          fArrow(0,0, X,Y) ;
          fTeXlabel(0.5*X, 0.5*Y , "br", "$r$") ;
          fTeXlabel(X+0.02, Y , "cl", "$\\llt A,B\\rgt$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "false") ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03 , "tr", "$x$") ;
          fTeXlabel(-0.02, ymax , "tr", "$y$") ;
          fLine(x,y, x,0) ;
          fLine(X,Y, X,0) ;

          double rr = 0.25 ;
          fEllipticalArc(0,0, rr, rr, 0,th, OPEN) ;
          fTeXlabel(1.1*rr, 0.03 , "bl", "$\\theta$") ;          

          rr = 0.20 ;
          fEllipticalArc(0,0, rr, rr, th,thPhi, OPEN) ;
          fTeXlabel(0.8*rr, 0.16 , "bl", "$\\varphi$") ;          
     }
}
