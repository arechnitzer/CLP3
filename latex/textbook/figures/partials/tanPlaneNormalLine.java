                  /*  File:  tanPlaneNormalLine.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class tanPlaneNormalLine extends Template {

     static {templateClass = new tanPlaneNormalLine() ; }

     public void setup() {
          filePrefix = "tanPlaneNormalLine" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.7*1.0 ;      // in inches
          ysize = 2.2*1.0 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 2.5 ;
          ymin = -0.2 ;
          ymax = 2 ;
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
         fEnv("headHalfWidth", 2*1.2) ;
         fEnv("headLength", 6*1.2) ;
         double r = 0.08 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.07, "tr", "$y$") ;
         fTeXlabel(-0.03, ymax, "tr", "$z$") ;

         
         String Red = "0 1 1 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.5) ;
         fCurve("[t,t*t]", 1, ymin, 2.5, OPEN) ;
         fTeXlabel(Math.sqrt(ymax)-0.05, ymax-0.05, "rc", "$z=x^2+y^2$") ;
         fTeXlabel(Math.sqrt(ymax)+0.13, ymax-0.05, "lc", "tangent plane") ;

         r = 0.035 ;
         double x1 = 1.0 ; double y1 = x1*x1 ;
         double x2 = 3.0 ; 
         double x1a = 1.2 ; double y1a = x1a*x1a ;
         double x1b = 0.5 ; double y1b = x1b*x1b ;
         canvas.append( new fPsWrite(Black+"\n")) ;
         fLine(0.5*(ymin+1),ymin,  2,3) ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fLine(xmin,1.5-0.5*xmin, xmax,1.5-0.5*xmax) ;
         fTeXlabel(xmax+0.05,1.5-0.5*xmax, "lc", "normal line") ;


         canvas.append( new fPsWrite(Black+"\n")) ;
         fEnv("lineWidth", 0.5) ;
         fDisk(x1,y1, r,FILLED) ;
              fTeXlabel(x1-0.08,y1-0.07, "rc", "$(0,1,1)$") ;
         double h = 0.04 ;
         fLine(x1+2*h,y1-h, x1+h, y1-3*h) ;
         fLine(x1+h,y1-3*h, x1-h, y1-2*h) ;

         fTeXlabel(0.5*xmax,ymin+0.1, "tc", "side view") ;








          
     }
}
