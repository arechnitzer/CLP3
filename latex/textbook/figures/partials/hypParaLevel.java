                  /*  File:  hypParaLevel.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hypParaLevel extends Template {

     static {templateClass = new hypParaLevel() ; }

     public void setup() {
          filePrefix = "hypParaLevel" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.5 ;      // in inches
          ysize = 2*1.5 ;   // in inches. 
          xmin = -4 ;
          xmax = 4 ;
          ymin = -4 ;
          ymax = 4 ;
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
         double C = 1 ; 
         double r = 0.08 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, 0.3) ;
         fLine(0, 0.55, 0, ymax) ;
         fTeXlabel(xmax, -0.1, "tr", "$x$") ;
         fTeXlabel(-0.1, ymax, "tr", "$y$") ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.0) ;
         fLine(xmin, ymin, xmax, ymax) ;
         fLine(xmin, -ymin, xmax, -ymax) ;
             fTeXlabel(0.0,0.3, "bc", "${\\scriptstyle f=0}$") ;
//             fTeXlabel(-0.35,0.2, "br", "${\\scriptstyle f=0}$") ;

         fCurve("[sqrt(t*t+"+C+"), t]", 1, ymin, ymax, OPEN) ;
         fCurve("[-sqrt(t*t+"+C+"), t]", 1, ymin, ymax, OPEN) ;
         fCurve("[t, sqrt(t*t+"+C+")]", 1, xmin, xmax, OPEN) ;
         fCurve("[t, -sqrt(t*t+"+C+")]", 1, xmin, xmax, OPEN) ;
            fTeXlabel(1.1,0.1, "bl", "${\\scriptstyle f=1}$") ;
            fTeXlabel(-1.1,0.1, "br", "${\\scriptstyle f=1}$") ;
            fTeXlabel(0.1,1.4, "bl", "${\\scriptstyle f=-1}$") ;
            fTeXlabel(0.1,-1.4, "tl", "${\\scriptstyle f=-1}$") ;
         C=4 ;
         fCurve("[sqrt(t*t+"+C+"), t]", 1, ymin, ymax, OPEN) ;
         fCurve("[-sqrt(t*t+"+C+"), t]", 1, ymin, ymax, OPEN) ;
         fCurve("[t, sqrt(t*t+"+C+")]", 1, xmin, xmax, OPEN) ;
         fCurve("[t, -sqrt(t*t+"+C+")]", 1, xmin, xmax, OPEN) ;
            fTeXlabel(2.1,0.1, "bl", "${\\scriptstyle f=4}$") ;
            fTeXlabel(-2.1,0.1, "br", "${\\scriptstyle f=4}$") ;
            fTeXlabel(0.1, 2.3, "bl", "${\\scriptstyle f=-4}$") ;
            fTeXlabel(0.1, -2.3, "tl", "${\\scriptstyle f=-4}$") ;
         C=9 ;
         fCurve("[sqrt(t*t+"+C+"), t]", 1, ymin, ymax, OPEN) ;
         fCurve("[-sqrt(t*t+"+C+"), t]", 1, ymin, ymax, OPEN) ;
         fCurve("[t, sqrt(t*t+"+C+")]", 1, xmin, xmax, OPEN) ;
         fCurve("[t, -sqrt(t*t+"+C+")]", 1, xmin, xmax, OPEN) ;
            fTeXlabel(3.1,0.1, "bl", "${\\scriptstyle f=9}$") ;
            fTeXlabel(-3.1,0.1, "br", "${\\scriptstyle f=9}$") ;
            fTeXlabel(0.1, 3.2, "bl", "${\\scriptstyle f=-9}$") ;
            fTeXlabel(0.1, -3.2, "tl", "${\\scriptstyle f=-9}$") ;


          
     }
}
