                  /*  File:  OE14A_2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE14A_2 extends Template {

     static {templateClass = new OE14A_2() ; }

     public void setup() {
          filePrefix = "OE14A_2" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.3*2.0 ;      // in inches
          ysize = 1.3*2.0 ;   // in inches. 
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
          fTeXlabel(X+SX+0.01, Y+SY, "tl", "$\\scriptstyle \\nabla S$") ;
          fLine(X-TX,Y-TY, X+TX, Y+TY) ;
          fTeXlabel(X+TX+0.01, Y+TY, "cl", "$\\scriptstyle \\text{tangent plane}$") ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
               fLine(X+MX,Y+MY, X+FS*SX, Y+FS*SY) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
//          fEllipticalArc(X,Y, 0.07, 0.07, AM, AS, OPEN) ;
//          fEllipticalArc(X,Y, 0.12, 0.12, AT, AM, OPEN) ;


          fEnv("lineWidth",1.5) ;
          fEnv("headHalfWidth", 2*1.4) ;
          fEnv("headLength", 6*1.4) ;
          fArrow(X,Y, X+MX, Y+MY) ;
          fTeXlabel(X+0.5*MX, Y+0.5*MY+0.015, "bc", "$\\scriptstyle \\nabla T$") ;
          fArrow(X,Y, X+FS*SX, Y+FS*SY) ;
          fTeXlabel(X+FS*SX-0.03, Y+FS*SY, "tr", 
                           "$\\scriptstyle \\text{proj}_{\\nabla S} \\nabla T$") ;
          fTeXlabel(X+MX-0.5*FS*SX+0.02, Y+MY-0.5*FS*SY, "tl", 
                           "$\\scriptstyle -\\text{proj}_{\\nabla S} \\nabla T$") ;
          fArrow(X+MX, Y+MY, X+MX-FS*SX, Y+MY-FS*SY) ;
          fArrow(X, Y, X+MX-FS*SX, Y+MY-FS*SY) ;
          fTeXlabel(X+0.5*TX, Y+0.5*TY-0.01, "tr", "$\\scriptstyle \\vd$") ;



          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          fCurve("[t, 1-t*t*t]",1, 0,1, OPEN) ;

          double r = 0.02 ;
          fDisk(X, Y, r, r, FILLED) ;

          fEnv("useColorPs", "false") ;
          canvas.append( new fPsWrite(Black+"\n")) ;



       

     }
}
