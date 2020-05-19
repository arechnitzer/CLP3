                  /*  File:  f4Level.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class f4Level extends Template {

     static {templateClass = new f4Level() ; }

     public void setup() {
          filePrefix = "f4Level" ;   
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
         double X = xmax ;
         fLine(-X, X, X, -X) ;
         fLine(-X, -X, X, X) ;

//         fDisk(0,0,r,r, FILLED) ;
//             fTeXlabel(0.0,0.2, "cc", "${\\scriptstyle f=0}$") ;
             fTeXlabel(0.35,-0.35, "bl", "${\\scriptstyle f=0}$") ;
             fTeXlabel(0.1, 0.5, "bl", "${\\scriptstyle f=0}$") ;

         fCurve("[pow(1+t*t*t*t, 0.25), t]", 1, xmin, xmax, OPEN) ;
         fCurve("[-pow(1+t*t*t*t, 0.25), t]", 1, xmin, xmax, OPEN) ;
            fTeXlabel(0.6, 0.2, "bl", "${\\scriptstyle f=1}$") ;
            fTeXlabel(-0.6, 0.2, "br", "${\\scriptstyle f=1}$") ;

         fCurve("[t, pow(1+t*t*t*t, 0.25)]", 1, xmin, xmax, OPEN) ;
         fCurve("[t, -pow(1+t*t*t*t, 0.25)]", 1, xmin, xmax, OPEN) ;
             fTeXlabel(0.1, 1.03, "bl", "${\\scriptstyle f=-1}$") ;
             fTeXlabel(0.1, -1.06, "tl", "${\\scriptstyle f=-1}$") ;


         fCurve("[pow(4+t*t*t*t, 0.25), t]", 1, xmin, xmax, OPEN) ;
         fCurve("[-pow(4+t*t*t*t, 0.25), t]", 1, xmin, xmax, OPEN) ;
            fTeXlabel(1.85, 0.2, "br", "${\\scriptstyle f=4}$") ;
            fTeXlabel(-1.85, 0.2, "bl", "${\\scriptstyle f=4}$") ;


         fCurve("[t, pow(4+t*t*t*t, 0.25)]", 1, xmin, xmax, OPEN) ;
         fCurve("[t, -pow(4+t*t*t*t, 0.25)]", 1, xmin, xmax, OPEN) ;
             fTeXlabel(0.1, 1.45, "bl", "${\\scriptstyle f=-4}$") ;
             fTeXlabel(0.1, -1.48, "tl", "${\\scriptstyle f=-4}$") ;




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

         fTeXlabel(0, ymin-0.2, "tc", "level curves of $f(x,y)=x^4-y^4$") ;




          
     }
}
