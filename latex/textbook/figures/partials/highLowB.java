                  /*  File:  highLowB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class highLowB extends Template {

     static {templateClass = new highLowB() ; }

     public void setup() {
          filePrefix = "highLowB" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*1.8 ;      // in inches
          ysize = 1.2*1.8 ;   // in inches. 
          xmin = -3 ;
          xmax = 7 ;
          ymin = -3 ;
          ymax = 9 ;
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
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.07, "tr", "$y$") ;
         fTeXlabel(-0.03, ymax, "tr", "$z$") ;

         fArrow(2,7, 2,9) ;
         fArrow(2,-1, 2,-3) ;
         
         String Red = "0 1 1 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.5) ;
         fDisk(2,3, 4,4, CLOSED) ;
         fTeXlabel(2-3.8, 5, "rc", "$x^2-2x+y^2-4y+z^2-6z = 2$") ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fLine(xmin, 7, xmax, 7) ;
         canvas.append( new fPsWrite(Black+"\n")) ;
         fLine(xmin, -1, xmax, -1) ;
         double th = 30 ; double thRad = th*Math.PI/180 ;
         double r = 0.15 ;
         double x = 2+4*Math.cos(thRad) ;
         double y = 3-4*Math.sin(thRad) ;
         fDisk(x, y, r, r, FILLED) ;
         fTeXlabel(x, y+0.1, "br",   "$(x_0,y_0,z_0)$") ;
         fLine(x+10*Math.sin(thRad), y+10*Math.cos(thRad),  
               x-10*Math.sin(thRad), y-10*Math.cos(thRad) ) ;


         fTeXlabel(2,-3.2, "tc", "side view") ;








          
     }
}
