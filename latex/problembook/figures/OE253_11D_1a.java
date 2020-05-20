                  /*  File:  OE253_11D_1a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE253_11D_1a extends Template {

     static {templateClass = new OE253_11D_1a() ; }

     public void setup() {
          filePrefix = "OE253_11D_1a" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 7.0*0.3 ;      // in inches
          ysize = 7.0*0.3 ;   // in inches. 
          xmin = -3.5 ;
          xmax = 3.5 ;
          ymin = -3.5 ;
          ymax = 3.5 ;
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
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.1, "tr", "$x$") ;
         fTeXlabel(-0.1, ymax, "tr", "$y$") ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         fEnv("useColorPs", "true") ;


           double C ;
           canvas.append( new fPsWrite(Blue+"\n")) ;
           fEnv("lineWidth", 1.0) ;
           fEnv("psFillColor", Blue) ;
           fDisk(0,0, r,r, FILLED)  ;
                  fTeXlabel(-0.1, -0.15, "tr", "${\\scriptstyle z=0,2}$") ;

           C = Math.sqrt(3) ;  fDisk(0,0, C,C)  ;
                  fTeXlabel(-0.1, -1.8, "tr", "${\\scriptstyle z=-1,3}$") ;

           C = Math.sqrt(8) ;  fDisk(0,0, C,C)  ;
                  fTeXlabel(-0.1, -2.92, "tr", "${\\scriptstyle z=-2,4}$") ;

           canvas.append( new fPsWrite(Black+"\n")) ;
          
     }
}

