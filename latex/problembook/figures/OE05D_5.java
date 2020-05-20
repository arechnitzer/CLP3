                  /*  File:  OE05D_5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE05D_5 extends Template {

     static {templateClass = new OE05D_5() ; }

     public void setup() {
          filePrefix = "OE05D_5" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.5 ;      // in inches
          ysize = 2*1.5 ;   // in inches. 
          xmin = -3.3 ;
          xmax = 3.3 ;
          ymin = -3.3 ;
          ymax = 3.3 ;
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
         double r = 0.08 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, 0.45) ;
         fLine(0, 0.72, 0, ymax) ;
         fTeXlabel(xmax+0.05, 0, "cl", "$x$") ;
         fTeXlabel(0, ymax+0.05, "cb", "$y$") ;




         String Black = "0 0 0 1 setcmykcolor  " ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.0) ;
//       
         double C = 0 ;
         fLine(xmin, ymin, xmax, ymax) ;
         fLine(xmin, -ymin, xmax, -ymax) ;
             fTeXlabel(0.03,0.4, "bc", "${\\scriptstyle f=0}$") ;
//             fTeXlabel(-0.35,0.2, "br", "${\\scriptstyle f=0}$") ;

         C=1 ;
         fCurve("[sqrt(t*t+"+C+"), t]", 1, ymin, ymax, OPEN) ;
         fCurve("[-sqrt(t*t+"+C+"), t]", 1, ymin, ymax, OPEN) ;
         fCurve("[t, sqrt(t*t+"+C+")]", 1, xmin, xmax, OPEN) ;
         fCurve("[t, -sqrt(t*t+"+C+")]", 1, xmin, xmax, OPEN) ;
            fTeXlabel(1.1,0.1, "bl", "${\\scriptstyle f=1}$") ;
            fTeXlabel(-1.1,0.1, "br", "${\\scriptstyle f=1}$") ;
            fTeXlabel(0.1,1.2, "bl", "${\\scriptstyle f=1}$") ;
            fTeXlabel(0.1,-1.2, "tl", "${\\scriptstyle f=1}$") ;

         C=4 ;
         fCurve("[sqrt(t*t+"+C+"), t]", 1, ymin, ymax, OPEN) ;
         fCurve("[-sqrt(t*t+"+C+"), t]", 1, ymin, ymax, OPEN) ;
         fCurve("[t, sqrt(t*t+"+C+")]", 1, xmin, xmax, OPEN) ;
         fCurve("[t, -sqrt(t*t+"+C+")]", 1, xmin, xmax, OPEN) ;
            fTeXlabel(2.1,0.1, "bl", "${\\scriptstyle f=16}$") ;
            fTeXlabel(-2.1,0.1, "br", "${\\scriptstyle f=16}$") ;
            fTeXlabel(0.1, 2.2, "bl", "${\\scriptstyle f=16}$") ;
            fTeXlabel(0.1, -2.2, "tl", "${\\scriptstyle f=16}$") ;

         canvas.append( new fPsWrite(Black+"\n")) ;
         double h = 0.2 ;
         for (double i = 1 ; i < 3.5 ; i++) {
              fLine(i,0, i,-h) ;
              fLine(-i,0, -i,-h) ;
              fLine(0,i, -h,i) ;
              fLine(0,-i, -h,-i) ;
         }
         fTeXlabel(3.03,-1.4*h, "tc", "$3$") ;
         fTeXlabel(-3.03,-1.4*h, "tc", "$-3$") ;
         fTeXlabel(-1.4*h, 3, "rc", "$3$") ;
         fTeXlabel(-1.4*h, -3, "rc", "$-3$") ;

          
     }
}
