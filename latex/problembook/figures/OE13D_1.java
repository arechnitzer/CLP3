                  /*  File:  OE13D_1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE13D_1 extends Template {

     static {templateClass = new OE13D_1() ; }

     public void setup() {
          filePrefix = "OE13D_1" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.3*1.5 ;      // in inches
          ysize = 1.3*1.5 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.2 ;
          ymin = 0.3 ;
          ymax = 1.6 ;
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
          fEnv("psFillGray", 0.8) ;
          double X = 0.4 ;
          double Y = 1-X*X*X ;
          double SX =  3*X*X*0.5 ; double SY = 1*0.5 ; 
              double AS = Math.atan(SY/SX)*180/Math.PI ;
          double TX =  1*0.7 ; double TY = -3*X*X*0.7 ;
              double AT = Math.atan(TY/TX)*180/Math.PI ;
          double FS = 0.5 ; double FT = 0.7 ;
          double MX =  FT*TX+FS*SX ; double MY = FT*TY+FS*SY  ;
              double AM = Math.atan(MY/MX)*180/Math.PI ;


          fEnv("lineWidth", 0.5) ;
//          fLine(xmin, 0, xmax, 0) ;
//          fLine(0, ymin, 0, ymax) ;
//          fTeXlabel(xmax+0.1, 0.0, "cl", "$x$") ;
//          fTeXlabel(0.0, ymax+0.1, "bc", "$y$") ;

          fEnv("lineWidth",0.5) ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fArrow(X,Y, X+SX, Y+SY) ;
          fTeXlabel(X+SX+0.01, Y+SY, "tl", "$\\vn$") ;
          fLine(X-TX,Y-TY, X+TX, Y+TY) ;
          fTeXlabel(X+TX+0.01, Y+TY, "cl", "plane") ;
          fTeXlabel(X+TX+0.01, Y+TY-0.09, "cl", "$x-y+2z=0$") ;
          fEllipticalArc(X,Y, 0.07, 0.07, AM, AS, OPEN) ;
          fTeXlabel(X+0.07, Y+0.07, "cl", "$\\theta$") ;
          fEllipticalArc(X,Y, 0.12, 0.12, AT, AM, OPEN) ;
          fTeXlabel(X+0.15, Y-0.045, "cl", "$\\alpha$") ;


          fEnv("lineWidth",1.5) ;
          fEnv("headHalfWidth", 2*1.4) ;
          fEnv("headLength", 6*1.4) ;
          fLine(X-MX,Y-MY, X+1.3*MX, Y+1.3*MY) ;
          fTeXlabel(X+1.3*MX+0.03, Y+1.3*MY, "cl", "line $L$") ;




       

     }
}
