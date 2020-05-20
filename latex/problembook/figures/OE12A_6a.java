                  /*  File:  OE12A_6a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE12A_6a extends Template {

     static {templateClass = new OE12A_6a() ; }

     public void setup() {
          filePrefix = "OE12A_6a" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0*0.4 ;      // in inches
          ysize = 5.0*0.4 ;   // in inches. 
          xmin = -1.5 ;
          xmax = 2.5 ;
          ymin = -0.5 ;
          ymax = 4.5 ;
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
//          { 
//            double[] xlist = { 0, 1,   2, 2, 0} ;
//            double[] ylist = { 0, -1, -4, 0, 0} ;
//            fPolygon(xlist, ylist, 5, FILLED) ;
//           }             
          fCurve("[t, t*t]",1, -1,2, FILLED) ;
          fEnv("psFillGray", 1.0) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fCurve("[t, t*t]",1, xmin,xmax, OPEN) ;
          fLine(xmin, xmin+2, xmax, xmax+2) ;
          fTeXlabel(Math.sqrt(2)+0.2, 2, "bl", "$\\scriptstyle x=\\sqrt{y}$") ;
          fTeXlabel(-1.5, 1.5*1.5+0.05, "bc", "$\\scriptstyle x=-\\sqrt{y}$") ;
          fTeXlabel(1.25, 3.25, "br", "$\\scriptstyle x=y-2$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[t, t*t]",1, -1,2, OPEN) ;
          fLine(-1,1, 2,4) ;

          fEnv("psFillGray", 0.0) ;
          double r = 0.07 ;
          fDisk(-1, 1, r, r, FILLED) ;
          fDisk(2, 4, r, r, FILLED) ;
          fTeXlabel(-1.1, 1, "cr", "$\\scriptstyle (-1,1)$") ;
          fTeXlabel(2.05,3.95, "tl", "$\\scriptstyle (2,4)$") ;



          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double Y = 0.6 ;
          double XL = -Math.sqrt(Y) ;
          double XR = Math.sqrt(Y) ;
          fEnv("lineWidth", 8.0) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XR = 0.2 ;
          XL = 0.5 ;
          fLine(XL,Y, XR,Y) ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          Y = 2.5 ;
          XR = Math.sqrt(Y) ;
          XL = Y-2 ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XR = 1.0 ;
          XL = 1.3 ;
          fLine(XL,Y, XR,Y) ;




          
     }
}
