                  /*  File:  collinear.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class collinear extends Template {

     static {templateClass = new collinear() ; }

     public void setup() {
          filePrefix = "collinear" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.4*0.5 ;      // in inches
          ysize = 3.9*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  4.2 ;
          ymin = -0.2 ;
          ymax =  3.7 ;
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
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

         canvas.append( new fPsWrite("0.7 setgray\n")) ;
         fLine(xmin, xmin-0.5, xmax, xmax-0.5) ;

         fEnv("lineWidth", 1.0) ;
         fEnv("headHalfWidth", 2*1.2) ;
         fEnv("headLength", 6*1.2) ;
         double ax = 1 ; double ay = 0.5 ;
         double bx = 2 ; double by = 1.5 ;
         double cx = 3 ; double cy = 2.5 ;
         double r = 0.05 ;
         fDisk(ax,ay,r,r, FILLED) ;
         fDisk(bx,by,r,r, FILLED) ;
         fDisk(cx,cy,r,r, FILLED) ;

         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
         canvas.append( new fPsWrite(Pink+"\n")) ;
         fEnv("lineWidth", 2.0) ;
         fArrow(ax, ay,   bx, by ) ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("lineWidth", 0.5) ;
         fArrow(ax, ay,   cx, cy ) ;


//         fTeXlabel(ax/2, -0.05, "tc", "$ \\va$" ) ;
//         fTeXlabel(ax+bx, by-0.05, "tl", "$ 2\\vb$" ) ;
//         fTeXlabel( ax/2+bx, by, "rb", "$ \\va+ 2\\vb$" ) ;
     }
}
