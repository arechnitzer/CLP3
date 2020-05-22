                  /*  File:  OE253_16D_2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE253_16D_2 extends Template {

     static {templateClass = new OE253_16D_2() ; }

     public void setup() {
          filePrefix = "OE253_16D_2" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.0*0.3 ;      // in inches
          ysize = 9.0*0.3 ;   // in inches. 
          xmin = -3.0 ;
          xmax =  3.0 ;
          ymin = -3.0 ;
          ymax =  6.0 ;
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
          fEnv("psFillGray", 0.9) ;
          double sq12 = Math.sqrt(12) ;
          fDisk(0,0, 2,2, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,sq12, 2,2, FILLED) ;

          fEnv("lineWidth",1.0) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
//              fLine(-3,3,  3,3) ;
              fEllipticalArc(0,0, 2,2, 120,420, OPEN) ;
              fEllipticalArc(0,sq12, 2,2,-60, 240, OPEN) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;



          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$z$") ;
//          fDisk(0,0, 2, 2, CLOSED) ;
//          fDisk(0,sq12, 2,2, CLOSED) ;

          fEnv("lineWidth",2.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEllipticalArc(0,sq12, 2,2, 240,300, OPEN) ;

          double r = 0.1 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(0,sq12, r,r, FILLED) ;
          fDisk(2,0,  r,r, FILLED) ;
          fDisk(1,sq12/2, r,r, FILLED) ;

          fEnv("lineWidth",0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fLine(0,0, 1,sq12/2) ;




          fTeXlabel(1.3,sq12/2+0.05, "lc", "$(1,0,\\sqrt{3})$") ;
//          fTeXlabel(0.05,sq12, "lc", "$(0,0,2\\sqrt{3})$") ;
          fTeXlabel(0.15,sq12, "lc", "$2\\sqrt{3}$") ;
//          fTeXlabel(2.05,0.05, "bl", "$(2,0,0)$") ;
          fTeXlabel(2.1,0.1, "bl", "$2$") ;
          fTeXlabel(0.2,0.5, "bc", "$\\scriptstyle\\frac{\\pi}{6}$") ;


          
     }
}
