                  /*  File:  OE07A_7h.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE07A_7h extends Template {

     static {templateClass = new OE07A_7h() ; }

     public void setup() {
          filePrefix = "OE07A_7h" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5*0.4 ;      // in inches
          ysize = 10.5*0.25 ;   // in inches. 
          xmin = -1.5 ;
          xmax = 3.5 ;
          ymin = -0.5 ;
          ymax = 10.0 ;
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
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;

          fEnv("psFillGray", 0.9) ;
          fCurve("[t, t*t]",1, -1,3,FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fLine(xmin,2*xmin+3, xmax,2*xmax+3) ;
          fCurve("[t, t*t]",1, xmin,xmax,OPEN) ;
          fTeXlabel(2.5, 8.0, "br", "$\\scriptstyle x=(y-3)/2$") ;
          fTeXlabel(2.1,4, "cl", "$x=\\sqrt{y}$") ;
          fTeXlabel(xmin-0.3,xmin*xmin, "bc", "$x=-\\sqrt{y}$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[t, t*t]",1, -1,3,OPEN) ;
          fLine(-1,1, 3,9) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine(-1,1, 2,1) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
          fTeXlabel(2.1,1, "cl", "$y=1$") ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.07 ;
          fDisk(-1, 1, r, r*aspect, FILLED) ;
          fDisk(3, 9, r, r*aspect, FILLED) ;
          fTeXlabel(-1.15, 1.0, "cr", "$\\scriptstyle (-1,1)$") ;
          fTeXlabel(3.15, 9.0, "cl", "$\\scriptstyle (3,9)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double Y = 0.5 ;
          double XL = -Math.sqrt(Y)  ;
          double XR = Math.sqrt(Y) ;
          fEnv("lineWidth", 7.0) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = 0.2 ;
          XR = 0.4 ;
          fLine(XL,Y, XR,Y) ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          Y = 4.0 ;
          XL = (Y-3)/2  ;
          XR = Math.sqrt(Y) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = 1.0 ;
          XR = 1.2 ;
          fLine(XL,Y, XR,Y) ;          
          
     }
}
