                  /*  File:  ellipse.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class ellipse extends Template {

     static {templateClass = new ellipse() ; }

     public void setup() {
          filePrefix = "ellipse" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -2 ;
          xmax = 2 ;
          ymin = -2 ;
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
         double z0 = 1 ; 
         double X = 0.5*Math.sqrt(1+z0*z0) ; double Y = Math.sqrt(1+z0*z0) ;
         double r = 0.08 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax+0.05, 0, "cl", "$x$") ;
         fTeXlabel(0, ymax+0.05, "bc", "$y$") ;
         fArrow(X+0.55, -0.55, X+0.08,-0.08) ;
         fArrow(-0.7, Y+0.22, -0.08,Y+0.08) ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.0) ;
         fDisk(0,0, X, Y, CLOSED) ;
         fDisk(X,0, r, r, FILLED) ;
         fDisk(0,Y, r, r, FILLED) ;
         fTeXlabel(X+0.5, -0.5, "tl", "$(\\tfrac{1}{2}\\sqrt{1+z_0^2}\\,,\\,0)$") ;
         fTeXlabel(-0.7, Y+0.2, "br", "$(0\\,,\\,\\sqrt{1+z_0^2}\\,)$") ;
         fEnv("lineWidth", 0.5) ;


          
     }
}
