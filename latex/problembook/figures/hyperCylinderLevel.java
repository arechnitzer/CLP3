                  /*  File:  hyperCylinderLevel.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperCylinderLevel extends Template {

     static {templateClass = new hyperCylinderLevel() ; }

     public void setup() {
          filePrefix = "hyperCylinderLevel" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -0.05 ;
          xmax = 4.5 ;
          ymin = -0.05 ;
          ymax = 4.5 ;
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
         double Z = 2 ; 
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
//         canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
//         canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
         fTeXlabel(xmax, -0.1, "tr", "$x$") ;
         fTeXlabel(-0.03, ymax, "tr", "$y$") ;
//         fLine(1,0, 1,-0.13) ;
//         fTeXlabel(1, -0.18, "tc", "$1$") ;
//         fLine(2,0, 2,-0.13) ;
//         fTeXlabel(2, -0.18, "tc", "$2$") ;
//         fLine(3,0, 3,-0.13) ;
//         fTeXlabel(3, -0.18, "tc", "$3$") ;
//         fLine(4,0, 4,-0.13) ;
//         fTeXlabel(4, -0.18, "tc", "$4$") ;
//         fLine(0, 1, -0.1,1) ;
//         fTeXlabel(-0.15, 1, "rc", "$1$") ;
//         fLine(0, 2, -0.1,2) ;
//         fTeXlabel(-0.15, 2, "rc", "$2$") ;
//         fLine(0, 3, -0.1,3) ;
//         fTeXlabel(-0.15, 3, "rc", "$3$") ;
//         fLine(0, 4, -0.1,4) ;
//         fTeXlabel(-0.15, 4, "rc", "$4$") ;
         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
         String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;
         String Black = "0 0 0 setrgbcolor  " ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("useColorPs", "true") ;
         fEnv("psFillColor", Blue) ;
         fEnv("lineWidth", 1.0) ;
         Z = 0.25 ; 
              fLine(0,1/Z, xmax,1/Z) ;
              fTeXlabel(xmax,1/Z+0.05, "br", "${\\scriptstyle f=0.25}$") ;
         Z = 0.5 ; 
              fLine(0,1/Z, xmax,1/Z) ;
              fTeXlabel(xmax,1/Z+0.05, "br", "${\\scriptstyle f=0.5}$") ;
         Z = 1.0 ; 
              fLine(0,1/Z, xmax,1/Z) ;
              fTeXlabel(xmax,1/Z+0.05, "br", "${\\scriptstyle f=1}$") ;
         Z = 2.0 ; 
              fLine(0,1/Z, xmax,1/Z) ;
              fTeXlabel(xmax,1/Z+0.05, "br", "${\\scriptstyle f=2}$") ;
         Z = 3.0 ; 
              fLine(0,1/Z, xmax,1/Z) ;
              fTeXlabel(xmax,1/Z-0.05, "tr", "${\\scriptstyle f=3}$") ;
     }
}
