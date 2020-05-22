                  /*  File:  hiker.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hiker extends Template {

     static {templateClass = new hiker() ; }

     public void setup() {
          filePrefix = "hiker" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*11.0/10.0 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -10 ;
          xmax = 100 ;
          ymin = -10 ;
          ymax =  90 ;
          topmargin = 0.1 ;   // in inches
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
          fLine(0,ymin,0,ymax) ;
          fCurve("[sqrt(1000/2)*cos(t),sqrt(1000/3)*sin(t)]", 1, 0, Math.PI/2, OPEN);
          fCurve("[sqrt(4000/2)*cos(t),sqrt(4000/3)*sin(t)]", 1, 0, Math.PI/2, OPEN);
          fCurve("[sqrt(9000/2)*cos(t),sqrt(9000/3)*sin(t)]", 1, 0, Math.PI/2, OPEN);
          fCurve("[sqrt(16000/2)*cos(t),sqrt(16000/3)*sin(t)]", 1, 0, Math.PI/2, OPEN);


          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fCurve("pow(x,1.5)", 0, 0, xmax, OPEN);
          fTeXlabel(25, ymax, "bl", "$y=ax^b$") ;
          fTeXlabel(xmax-23, 40, "bl", "$h(x,y)=600$") ;

     }
}
