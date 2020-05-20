                  /*  File:  polarArea3.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polarArea3 extends Template {

     static {templateClass = new polarArea3() ; }

     public void setup() {
          filePrefix = "polarArea3" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches
          xmin = -1 ;
          xmax = 5 ;
          ymin = -1 ;
          ymax = 5 ;
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
          double th1 = 30 ; double th1Rad = th1*Math.PI/180 ;
          double th2 = 50 ; double th2Rad = th2*Math.PI/180 ;
          double x1 = 4*Math.cos(th1Rad);
          double y1 = 4*Math.sin(th1Rad);
          double x2 = 4*Math.cos(th2Rad);
          double y2 = 4*Math.sin(th2Rad);
          double xm = 4*Math.cos(0.5*th1Rad+0.5*th2Rad);
          double ym = 4*Math.sin(0.5*th1Rad+0.5*th2Rad);

          fEnv("psFillGray", 0.9) ;
          fEllipticalArc (0,0, 4,4,  0, 360, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc (0,0, 4,4, th1, th2, WEDGE+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;



          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("lineWidth", 1.5) ;
          fEllipticalArc (0,0, 4,4, th1, th2, OPEN) ;
          fLine(0,0, x1, y1) ;
          fLine(0,0, x2, y2) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 0.5) ;


          fTeXlabel(0.7*x1, 0.7*y1-0.1, "tl", "$R(\\theta)$") ;
          fTeXlabel(0.7*x2, 0.7*y2+0.05, "br", "$R(\\theta)$") ;
          fTeXlabel(0.4*xm, 0.4*ym, "cc", "$\\dee{\\theta}$") ;



     }
}
