                  /*  File:  OE10D_1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10D_1 extends Template {

     static {templateClass = new OE10D_1() ; }

     public void setup() {
          filePrefix = "OE10D_1" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.5 ;      // in inches
          ysize = 5.0*0.5 ;   // in inches. 
          xmin = -1.5 ;
          xmax = 1.5 ;
          ymin = -2.5 ;
          ymax = 2.5 ;
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
         double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
         double r = 0.1 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, 0, 0, ymax) ;
         fLine(0, ymin, 0, -0.4) ;
         fTeXlabel(xmax, -0.1, "tr", "$x$") ;
         fTeXlabel(-0.1, ymax, "tr", "$y$") ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         fEnv("useColorPs", "false") ;


           double C ;
           canvas.append( new fPsWrite(Red+"\n")) ;
           fEnv("lineWidth", 1.0) ;
           C = 0; fLine(0, ymin, 0,ymax) ;
                  fTeXlabel(-0.06, ymin, "br", "${\\scriptstyle f=0}$") ;

           C = 1; fDisk(0,1/C, 1/Math.abs(C),1/Math.abs(C), CLOSED) ;
                  fTeXlabel(1.06,1, "cl", "${\\scriptstyle f=1}$") ;

           C = -1; fDisk(0,1/C, 1/Math.abs(C),1/Math.abs(C), CLOSED) ;
                  fTeXlabel(1.06,-1, "cl", "${\\scriptstyle f=-1}$") ;


           C = 2; fDisk(0,1/C, 1/Math.abs(C),1/Math.abs(C), CLOSED) ;
                  fTeXlabel(0.2,1.0, "bl", "${\\scriptstyle f=2}$") ;

           C = -2; fDisk(0,1/C, 1/Math.abs(C),1/Math.abs(C), CLOSED) ;
                  fTeXlabel(0.2,-1.0, "tl", "${\\scriptstyle f=-2}$") ;

           canvas.append( new fPsWrite(Black+"\n")) ;
           fEnv("lineWidth", 0.5) ;
           fEnv("psFillGray", 1.0) ;
           fDisk(0,0,0.05,0.05, CLOSED+FILLED) ;
          
     }
}

