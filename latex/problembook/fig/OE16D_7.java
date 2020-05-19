                  /*  File:  OE16D_7.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE16D_7 extends Template {

     static {templateClass = new OE16D_7() ; }

     public void setup() {
          filePrefix = "OE16D_7" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.2*0.8 ;      // in inches
          ysize = 2.5*0.8 ;   // in inches. 
          xmin = -1.6 ;
          xmax = 1.6 ;
          ymin = -0.2 ;
          ymax =  2.3 ;
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
          double r = 0.25 ;
          double x = 0.5 ; double y = 1+Math.sqrt(1-x*x) ;
          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,1, 1,1, 0, 90, FILLED) ;
          { 
            double[] xlist = { 0, x, 1,  0} ;
            double[] ylist = { 2, y, 1,  0} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$z$") ;

          fEllipticalArc(0,1, 1,1, 0, 360, OPEN) ;
          fLine(0,0, xmin, -xmin) ;
          fLine(0,0, xmax,  xmax) ;
          fEllipticalArc(0,0, r,r, 45, 90, OPEN) ;
          fTeXlabel(0.05, 1.1*r, "bl", "$\\frac{\\pi}{4}$") ;



          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
              fLine(xmin,1,  1,1) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

          fTeXlabel(0.45, 1.3, "cc", "$S$") ;
          fTeXlabel(xmin-0.05, 1, "rc", "$z=1$") ;
          fTeXlabel(0.95, 0.57, "cl", "$x^2+y^2+(z-1)^2=1$") ;
          fTeXlabel(0.95, 0.33, "cl", "or $z-1=\\pm\\sqrt{1-x^2-y^2}$") ;
          fTeXlabel(xmax+0.05, xmax, "cl", "$z=\\sqrt{x^2+y^2}$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,1, 1,1, 0, 90, OPEN) ;
          { 
            double[] xlist = {1,  0, 0} ;
            double[] ylist = {1,  0, 2} ;
            fPolygon(xlist, ylist, 3, OPEN) ;
           }             

          r = 0.04 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(1,1, r,r, FILLED) ;
          fTeXlabel(1.07, 1, "cl", "$\\scriptstyle (1,0,1)$") ;

          
     }
}
