                  /*  File:  OE10A_5xy.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10A_5xy extends Template {

     static {templateClass = new OE10A_5xy() ; }

     public void setup() {
          filePrefix = "OE10A_5xy" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.6 ;      // in inches
          ysize = 1.4*1.6 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.3 ;
          ymin = -0.1 ;
          ymax = 1.3 ;
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
          double th1Rad = Math.atan(0.5) ; double th1 = th1Rad*180/Math.PI ;
          double x1 = Math.cos(th1Rad) ;  double y1 = Math.sin(th1Rad) ;
          double th2Rad = Math.atan(2.0) ; double th2 = th2Rad*180/Math.PI ;
          double x2 = Math.cos(th2Rad) ;  double y2 = Math.sin(th2Rad) ;
          fEllipticalArc(0,0, 1,1, th1, th2, WEDGE+FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fEllipticalArc(0,0, 1,1, -30, 120, OPEN) ;
          fTeXlabel(xmin-0.03,1, "cr", "$x=\\sqrt{1-y^2}$") ;

          fLine(0,0, xmax,xmax/2) ;
          fTeXlabel(xmax+0.03,xmax/2, "cl", "$x=2y$") ;
          
          fLine(0,0, ymax/2,ymax) ;
          fTeXlabel(ymax/2+0.03,ymax, "cl", "$x=y/2$") ;

          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine(xmin, y1, x1,y1) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
          fTeXlabel(xmin-0.03,y1, "cr", "$y=1/\\sqrt{5}$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, 1,1, th1, th2, OPEN) ;
          fLine(0,0, x1,y1) ;
          fLine(0,0, x2,y2) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.02 ;
          fDisk(x1, y1, r, r, FILLED) ;
          fTeXlabel(x1+0.05, y1+0.01, "tl", 
            "$\\scriptstyle \\left(\\frac{2}{\\sqrt{5}},\\frac{1}{\\sqrt{5}}\\right)$") ;
          fDisk(x2, y2, r, r, FILLED) ;
          fTeXlabel(x2+0.05, y2-0.01, "bl", 
            "$\\scriptstyle \\left(\\frac{1}{\\sqrt{5}},\\frac{2}{\\sqrt{5}}\\right)$") ;

 
          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double Y = 0.35 ;
          double XL = Y/2 ;
          double XR = 2*Y ;
          fEnv("lineWidth", 8.0) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = 0.35 ;
          XR = 0.42 ;
          fLine(XL,Y, XR,Y) ;  

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          Y = 0.7 ;
          XL = Y/2 ;
          XR = Math.sqrt(1-Y*Y) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = 0.52 ;
          XR = 0.59 ;
          fLine(XL,Y, XR,Y) ;          
        
     }
}
