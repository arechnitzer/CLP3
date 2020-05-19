                  /*  File:  OE10D_5bh.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10D_5bh extends Template {

     static {templateClass = new OE10D_5bh() ; }

     public void setup() {
          filePrefix = "OE10D_5bh" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.0*0.5 ;      // in inches
          ysize = 2.0*0.5 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 4.5 ;
          ymin = -0.5 ;
          ymax = 1.5 ;
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
          { 
            double[] xlist = { 0, 4, 4, 0} ;
            double[] ylist = { 0, 0, 1, 1} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          fEnv("psFillGray", 1.0) ;
          fCurve("[4*t*t, t]",1, 0,1, FILLED) ;
          { 
            double[] xlist = { 0, 4.5, 4.5, 4,              2, 0} ;
            double[] ylist = { 0,   0,   1, 1, 1/Math.sqrt(2), 0} ;
            fPolygon(xlist, ylist, 6, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fCurve("[4*t*t, t]",1, 0,ymax, OPEN) ;
          fLine(xmin,1,  xmax, 1) ;
          fTeXlabel(1.5, Math.sqrt(1.5)/2.0, "tl", "$x=4y^2$") ;
          fTeXlabel(1.5, 1.05, "bl", "$y=1$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(0, 1, 4, 1) ;
          fLine(0,0,   0,1) ;
          fCurve("[4*t*t, t]",1, 0,1, OPEN) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.07 ;
          fDisk(4, 1, r, r, FILLED) ;
          fTeXlabel(4.0, 0.90, "tc", "$\\scriptstyle (4,1)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double Y = 0.7 ;
          double XR = 4*Y*Y ;
          double XL = 0 ;
          fEnv("lineWidth", 6.0) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XR = 0.65 ;
          XL = 0.5 ;
          fLine(XL,Y, XR,Y) ;          
     }
}
