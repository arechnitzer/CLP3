                  /*  File:  planeLevelB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class planeLevelB extends Template {

     static {templateClass = new planeLevelB() ; }

     public void setup() {
          filePrefix = "planeLevelB" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 4.5 ;
          ymin = -4.5 ;
          ymax = 0.5 ;
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
         double C = 2 ; double H = 0.3 ;
         double r = 0.08 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
//         canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
//         canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
         fTeXlabel(xmax, 0.1, "br", "$y$") ;
         fTeXlabel(-0.03, ymin, "br", "$x$") ;
         fLine(1,0, 1, 0.13) ;
         fTeXlabel(1, 0.18, "bc", "$1$") ;
         fLine(2,0, 2,0.13) ;
         fTeXlabel(2, 0.18, "bc", "$2$") ;
         fLine(3,0, 3,0.13) ;
         fTeXlabel(3, 0.18, "bc", "$3$") ;
         fLine(4,0, 4, 0.13) ;
         fTeXlabel(4, 0.18, "bc", "$4$") ;
         fLine(0, -1, -0.1,-1) ;
         fTeXlabel(-0.15, -1, "rc", "$1$") ;
         fLine(0, -2, -0.1, -2) ;
         fTeXlabel(-0.15, -2, "rc", "$2$") ;
         fLine(0, -3, -0.1, -3) ;
         fTeXlabel(-0.15, -3, "rc", "$3$") ;
         fLine(0, -4, -0.1, -4) ;
         fTeXlabel(-0.15, -4, "rc", "$4$") ;
         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
         String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;
         String Black = "0 0 0 setrgbcolor  " ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("useColorPs", "true") ;
         fEnv("psFillColor", Blue) ;
         fEnv("lineWidth", 1.0) ;
         fDisk(0,0, r, r, FILLED) ;
              fTeXlabel(-0.1,-0.1, "tr", "${\\scriptstyle f=4}$") ;
         C = 3 ; H=0.3 ; 
         fLine(4-C,0, 0,-(4-C)) ;
              fTeXlabel(4-C-H, -H-0.02, "tl", "${\\scriptstyle f=3}$") ;
         C = 2 ;  H=0.6 ; 
         fLine(4-C,0, 0,-(4-C)) ;
              fTeXlabel(4-C-H, -H-0.02, "tl", "${\\scriptstyle f=2}$") ;
         C = 1 ;  H=0.9 ; 
         fLine(4-C,0, 0,-(4-C)) ;
              fTeXlabel(4-C-H, -H-0.02, "tl", "${\\scriptstyle f=1}$") ;
         C = 0 ;  H=1.2 ;
         fLine(4-C,0, 0,-(4-C)) ;
              fTeXlabel(4-C-H, -H-0.02, "tl", "${\\scriptstyle f=0}$") ;
     }
}
