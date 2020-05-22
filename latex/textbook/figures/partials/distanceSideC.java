                  /*  File:  distanceSideC.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class distanceSideC extends Template {

     static {templateClass = new distanceSideC() ; }

     public void setup() {
          filePrefix = "distanceSideC" ;   
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
//         fLine(xmin, 0, xmax, 0) ;
//         fLine(0, ymin, 0, ymax) ;
//         fTeXlabel(xmax, -0.07, "tr", "$y$") ;
//         fTeXlabel(-0.03, ymax, "tr", "$z$") ;

         
         String Red = "0 1 1 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.5) ;

         r = 0.035 ;
         double x1 = 1.0 ; double y1 = 1 ;
         double x2 = x1-0.5 ; double y2 = y1 - 2*0.5 ;  
            double th2 = Math.atan(2.0)*180/Math.PI ;
         double x3 = x1 + 0.8 ; double y3 = y1- 0.4 ;   
           double th1 = Math.atan(0.5)*180/Math.PI ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fLine(xmin,1.5-0.5*xmin, xmax,1.5-0.5*xmax) ;
         fTeXlabel(xmax+0.05,1.5-0.5*xmax, "lc", "x+2y+3z=20") ;


         canvas.append( new fPsWrite(Black+"\n")) ;
         fLine(x1,y1, x2,y2) ;
         fEnv("lineWidth", 0.5) ;
         fLine(0.5*(ymin+1),ymin,  x1,y1) ;
         fDisk(x1,y1, r,FILLED) ;
         fDisk(x2,y2, r,FILLED) ;
         fDisk(x3,y3, r,FILLED) ;
         fLine(x2,y2, x3,y3) ;
              fTeXlabel(x1-0.08,y1-0.07, "rc", "$P=(a,b,c)$") ;
              fTeXlabel(x2-0.08,y2-0.07, "rc", "$Q=(1,1,1)$") ;
              fTeXlabel(x3+0.08,y3+0.07, "lc", "$R=(20,0,0)$") ;
         double h = 0.04 ;
         fLine(x1+2*h,y1-h, x1+h, y1-3*h) ;
         fLine(x1+h,y1-3*h, x1-h, y1-2*h) ;
         fArrow(x1,y1, x1+0.2, y1+0.4) ;
              fTeXlabel(x1+0.2,y1+0.4, "lb", "$\\left< 1,2,3\\right>$") ;
         double R = 0.15 ;
         fEllipticalArc(x2,y2, R, R, th1, th2, OPEN) ;
              fTeXlabel(x2+0.15,y2+0.13, "lb", "$\\theta$") ;









          
     }
}
