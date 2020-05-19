                  /*  File:  OE06D_4h.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06D_4h extends Template {

     static {templateClass = new OE06D_4h() ; }

     public void setup() {
          filePrefix = "OE06D_4h" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.75 ;      // in inches
          ysize = 5.0*0.5 ;   // in inches. 
          xmin = -0.5 ;
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
          double sq2 = Math.sqrt(2) ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;

          fEnv("psFillGray", 0.8) ;
          fCurve("[t, 1/t]",1, 1/sq2,1, FILLED) ;
          fCurve("[t, t*t]",1, 1,2, FILLED) ;
          { 
            double[] xlist = { 1/sq2, 3/4.0, 1, 1.5 , 2, 1/sq2} ;
            double[] ylist = {   sq2, 4/3.0, 1, 2.25, 4, sq2} ;
            fPolygon(xlist, ylist, 6, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fCurve("[t, 1/t]",1, 0.1, xmax, OPEN) ;
          fCurve("[t, t*t]",1, xmin,xmax, OPEN) ;
          fLine(xmin,2*xmin,  xmax, 2*xmax) ;
          fTeXlabel(1.5, 1.5*1.5, "tl", "$x=\\sqrt{y}$") ;
          fTeXlabel(1.5, 3, "br", "$x=y/2$") ;
          fTeXlabel(0.3, 4, "tl", "$x=1/y$") ;

          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine(1/sq2,sq2,  2,sq2) ;
          fTeXlabel(2.05, sq2+0.05, "cl", "$y=\\sqrt{2}$") ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;



          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[t, 1/t]",1, 1/sq2, 1, OPEN) ;
          fCurve("[t, t*t]",1, 1,2, OPEN) ;
          fLine(1/sq2, sq2, 2,4) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.04 ;
          fDisk(2, 4, r, r*aspect, FILLED) ;
          fTeXlabel(2.05, 3.95, "cl", "$\\scriptstyle (2,4)$") ;
          fDisk(1, 1, r, r*aspect, FILLED) ;
          fTeXlabel(1.07, 1.02, "cl", "$\\scriptstyle (1,1)$") ;
          fDisk(1/sq2, sq2, r, r*aspect, FILLED) ;
          fTeXlabel(1/sq2-0.05, sq2,"cr", 
                "$\\scriptstyle (\\frac{1}{\\sqrt{2}},\\sqrt{2})$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double Y = 0.4+0.6*sq2 ;
          double XR = Math.sqrt(Y) ;
          double XL = 1/Y ;
          fEnv("lineWidth", 5.0) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = 0.9 ;
          XR = 1.0 ;
          fLine(XL,Y, XR,Y) ;


          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          Y = 2.3 ;
          XR = Math.sqrt(Y) ;
          XL = Y/2 ;
          fEnv("lineWidth", 5.0) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = 1.3 ;
          XR = 1.4 ;
          fLine(XL,Y, XR,Y) ;          
     }
}
