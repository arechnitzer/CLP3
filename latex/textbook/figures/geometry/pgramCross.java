                  /*  File:  pgramCross.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pgramCross extends Template {

     static {templateClass = new pgramCross() ; }

     public void setup() {
          filePrefix = "pgramCross" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.8 ;      // in inches
          ysize = 1.5*0.8 ;   // in inches. 
          xmin = -100 ;
          xmax = 200 ;
          ymin = -50 ;
          ymax = 100 ;
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
         fRotate(10*Math.PI/180.0) ;

         fEnv("psFillGray", 0.8) ;
         {double[] xlist = {0, 150, 200, 50} ;
          double[] ylist = {0,   0, 50, 50} ;
          fPolygon(xlist,ylist, 4, FILLED) ;}

         fLine(50, 50,   200, 50) ;
         fLine(150, 0,   200, 50) ;

         {double[] xlist = {-85, 125, 200,-10} ;
          double[] ylist = {-25, -25, 50, 50} ;
          fPolygon(xlist,ylist, 4, CLOSED) ;}


         fDisk(0, 0, 2, 2, FILLED) ;
         canvas.append( new fPsWrite("0.5 setgray\n")) ;
         fLine( 0, 29-20,  9, 31.5-20) ;
         fLine( 9, 31.5-20, 9, 21.5-20) ;


         String Red = "0 1 1 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("psFillColor", Red) ;
         fEnv("useColorPs", "true") ;
         fEnv("lineWidth", 1.0) ;
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         fArrow(0, 0,   150, 0) ;
         fArrow(0, 0,    50, 50) ;

         String Blue = "1 1 0 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("psFillColor", Blue) ;
         fArrow(0, 0, 0, 80) ;
     }
}
