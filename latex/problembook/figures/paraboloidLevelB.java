                  /*  File:  paraboloidLevelB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class paraboloidLevelB extends Template {

     static {templateClass = new paraboloidLevelB() ; }

     public void setup() {
          filePrefix = "paraboloidLevelB" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 2.3 ;
          ymin = -2.3 ;
          ymax = 0.2 ;
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
         double r = 0.05 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
//         canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
//         canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
         fTeXlabel(xmax, 0.05, "br", "$y$") ;
         fTeXlabel(-0.02, ymin, "br", "$x$") ;
         fLine(1,0, 1,0.08) ;
         fTeXlabel(1, 0.12, "bc", "$1$") ;
         fLine(2,0, 2,0.08) ;
         fTeXlabel(2, 0.12, "bc", "$2$") ;
         fLine(0, -1, -0.08,-1) ;
         fTeXlabel(-0.10, -1, "rc", "$1$") ;
         fLine(0, -2, -0.08,-2) ;
         fTeXlabel(-0.10, -2, "rc", "$2$") ;

         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
         String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;
         String Black = "0 0 0 setrgbcolor  " ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("useColorPs", "true") ;
         fEnv("psFillColor", Blue) ;
         fEnv("lineWidth", 1.0) ;
         fDisk(0,0, r, r, FILLED) ;
              fTeXlabel(0.05,-0.05, "tl", "${\\scriptstyle f=4}$") ;
         C = 1 ;  
         fEllipticalArc(0,0, C, C, -90, 0, OPEN) ;
              fTeXlabel(0.05, -C-0.02, "tl", "${\\scriptstyle f=3}$") ;
         C = Math.sqrt(2) ;
         fEllipticalArc(0,0, C, C,-90, 0, OPEN) ;
              fTeXlabel(0.05, -C-0.02, "tl", "${\\scriptstyle f=2}$") ;
         C = Math.sqrt(3) ; 
         fEllipticalArc(0,0, C, C, -90, 0, OPEN) ;
              fTeXlabel(0.05, -C-0.02, "tl", "${\\scriptstyle f=1}$") ;
         C = 2 ; H=0.4 ; 
         fEllipticalArc(0,0, C, C, -90, 0, OPEN) ;
              fTeXlabel(0.05, -C-0.02, "tl", "${\\scriptstyle f=0}$") ;

     }
}
