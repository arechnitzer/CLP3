                  /*  File:  OE14A_8.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE14A_8 extends Template {

     static {templateClass = new OE14A_8() ; }

     public void setup() {
          filePrefix = "OE14A_8" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = 0 ;
          xmax = 1.2 ;
          ymin = 0 ;
          ymax = 1.2 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          { 
            double[] xlist = { 0, 1, 1} ;
            double[] ylist = { 0, 1, 0} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }        


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$r$") ;
          fTeXlabel(-0.02, ymax, "tr", "$z$") ;

          double r = 0.15 ;
          fEllipticalArc(0,0,r,r, 45,90, OPEN) ;
//          fTeXlabel(0.05, 1.2*r, "bl", "$\\scriptstyle \\frac{\\pi}{4}$") ;
          fTeXlabel(0.03, 1.2*r, "bl", "$ \\frac{\\pi}{4}$") ;
          fTeXlabel(0.7, 0.3, "cc", "$E$") ;
          fLine(1, ymin, 1, ymax) ;
          fTeXlabel(1-0.03, ymax, "tr", "$r=1$") ;
          fLine(0, 0, ymax, ymax) ;
          fTeXlabel(ymax+0.03, ymax, "tl", "$z=r$") ;
//

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          { 
            double[] xlist = { 0, 1, 1} ;
            double[] ylist = { 0, 1, 0} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }        
          
     }
}
