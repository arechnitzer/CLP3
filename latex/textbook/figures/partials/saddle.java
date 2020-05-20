                  /*  File:  saddle.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class saddle extends Template {

     static {templateClass = new saddle() ; }

     public void setup() {
          filePrefix = "saddle" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 2.5 ;
          ymin = -0.5 ;
          ymax = 2.5 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0,   xmax, 0);
          fLine(0, ymin,    0, ymax);


          fEnv("lineWidth", 2.0) ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(xmin,ymin, xmax, ymax) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(xmin,1,  xmax,1) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillGray", 1.0) ;
          fEnv("lineWidth", 0.5) ;
          fDisk(1, 1,  0.05, 0.05, CLOSED+FILLED);
          fArrow(1.5, 0.5, 1.03, 0.97);
          fTeXlabel(1.5, 0.5, "tl", "$f=0$");
          fTeXlabel(xmax-0.25, ymax, "tr", "$f<0$");
          fTeXlabel(xmin+0.2, ymin+0.2, "br", "$f<0$");
          fTeXlabel(xmax, 1.05, "br", "$f>0$");
          fTeXlabel(xmin-0.2, 1.05, "bl", "$f>0$");


          fTeXlabel(xmax, -0.1, "tr", "$x$");
          fTeXlabel(-0.1, ymax, "tr", "$y$");

          fTeXlabel(0.95, 1.05, "br", "$(1,1)$");
          
     }
}
