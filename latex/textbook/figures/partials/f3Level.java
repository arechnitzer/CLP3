                  /*  File:  f3Level.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class f3Level extends Template {

     static {templateClass = new f3Level() ; }

     public void setup() {
          filePrefix = "f3Level" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.3 ;      // in inches
          ysize = 2.3 ;   // in inches. 
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
         double r = 0.06 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.1, "tr", "$x$") ;
         fTeXlabel(-0.1, ymax, "tr", "$y$") ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("useColorPs", "true") ;
         fEnv("psFillColor", Red) ;
         fEnv("lineWidth", 1.0) ;
         double X = 1.7 ;
         fLine(-X, X, X+0.03, -X-0.03) ;

//         fDisk(0,0,r,r, FILLED) ;
//             fTeXlabel(0.0,0.2, "cc", "${\\scriptstyle f=0}$") ;
             fTeXlabel(0.35,-0.4, "bl", "${\\scriptstyle f=0}$") ;

         fCurve("[t, pow(1-t*t*t, 0.333333)]", 1, -1.63, 1, OPEN) ;
         fCurve("[t, -pow(t*t*t-1, 0.333333)]", 1, 1, 1.8, OPEN) ;
         fCurve("[pow(1-t*t*t, 0.333333), t]", 1, -0.5, 0.5, OPEN) ;
            fTeXlabel(0.3, 1.05, "bl", "${\\scriptstyle f=1}$") ;

         fCurve("[t, -pow(1+t*t*t, 0.333333)]", 1, -1, 1.7, OPEN) ;
         fCurve("[-t, pow(-1+t*t*t, 0.333333)]", 1, 1, 1.73, OPEN) ;
         fCurve("[-pow(1+t*t*t, 0.333333), t]", 1, -0.5, 0.5, OPEN) ;
            fTeXlabel(0.3, -1.2, "tl", "${\\scriptstyle f=-1}$") ;

         X = Math.pow(4, 0.333333)+0.01 ;
         fCurve("[t, pow(4-t*t*t, 0.333333)]", 1, -X+0.1, 1, OPEN) ;
         fCurve("[t, -pow(t*t*t-4, 0.333333)]", 1, X, 1.95, OPEN) ;
         fCurve("[pow(4-t*t*t, 0.333333), t]", 1, -0.5, X-0.1, OPEN) ;
            fTeXlabel(0.3, 1.63, "bl", "${\\scriptstyle f=4}$") ;

         fCurve("[-t,- pow(4-t*t*t, 0.333333)]", 1, -X+0.1, 1, OPEN) ;
         fCurve("[-t, pow(t*t*t-4, 0.333333)]", 1, X, 1.95, OPEN) ;
         fCurve("[-pow(4-t*t*t, 0.333333), -t]", 1, -0.5, X-0.1, OPEN) ;
            fTeXlabel(0.3, -1.7, "tl", "${\\scriptstyle f=-4}$") ;



//         fCurve("[t, pow(4-t*t*t*t, 0.25)]", 1, -X, X, OPEN) ;
//         fCurve("[t, -pow(4-t*t*t*t, 0.25)]", 1, -X, X, OPEN) ;
//         fCurve("[pow(4-t*t*t*t, 0.25), t]", 1, -X, X, OPEN) ;
//         fCurve("[-pow(4-t*t*t*t, 0.25), t]", 1, -X, X, OPEN) ;
//            fTeXlabel(0.3, X+0.13, "bl", "${\\scriptstyle f=-4}$") ;
//
//
//         X = Math.pow(9, 0.25)-0.1 ;
//         fCurve("[t, pow(9-t*t*t*t, 0.25)]", 1, -X, X, OPEN) ;
//         fCurve("[t, -pow(9-t*t*t*t, 0.25)]", 1, -X, X, OPEN) ;
//         fCurve("[pow(9-t*t*t*t, 0.25), t]", 1, -X, X, OPEN) ;
//         fCurve("[-pow(9-t*t*t*t, 0.25), t]", 1, -X, X, OPEN) ;
//            fTeXlabel(0.3, X+0.13, "bl", "${\\scriptstyle f=-9}$") ;

         fTeXlabel(0, ymin-0.2, "tc", "level curves of $f(x,y)=x^3+y^3$") ;




          
     }
}
