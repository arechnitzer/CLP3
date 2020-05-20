                  /*  File:  sin2Graph.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sin2Graph extends Template {

     static {templateClass = new sin2Graph() ; }

     public void setup() {
          filePrefix = "sin2Graph" ;    // used as the prefix for ps and lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.75 ;    
          ysize = 1.2 ;   
          double pi = Math.PI ;
          xmin = -0.2*pi ;
          xmax =  2.2*pi ;
          ymin = -1.2 ;
          ymax = 1.5 ;
          topmargin = 0.15 ;   // in inches
          bottommargin = 0.15 ;   // in inches
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

          double pi = Math.PI ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax,0) ;
          fLine(0,ymin, 0, ymax) ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fTeXlabel(xmax+0.1, 0, "cl", "$\\theta$") ;
          for(int i=-1 ; i<10 ; i++) {
               fLine(i*pi/4.0, 0,  i*pi/4.0, -0.15) ;
          }
          fTeXlabel(pi/4,-0.2, "tc", "$\\scriptstyle \\frac{\\pi}{4}$") ;
          fTeXlabel(pi/2-0.05,-0.2, "tc", "$\\scriptstyle \\frac{\\pi}{2}$") ;
//          fTeXlabel(3*pi/2+0.1,-0.2, "tc", "$\\scriptstyle \\frac{3\\pi}{2}$") ;
          fTeXlabel(pi+0.05,-0.2, "tc", "$\\scriptstyle \\pi$") ;
          fTeXlabel(2*pi+0.2,-0.2, "tc", "$\\scriptstyle 2\\pi$") ;
          fLine(-0.2,-1,  0,-1) ;
          fLine(-0.2,1,  0,1) ;
          fTeXlabel(-0.2,1, "rc", "$\\scriptstyle 1$") ;
          fTeXlabel(-0.2,-1, "rc", "$\\scriptstyle -1$") ;

          fEnv("lineWidth", 1.0) ;
          fTeXlabel(1.5*pi, 1.0, "cb", "$y=\\sin(2\\theta)$") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve("y=sin(2*x)", 0, 0, 2*pi, OPEN) ;
     }
}




