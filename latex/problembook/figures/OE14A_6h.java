                  /*  File:  OE14A_6h.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE14A_6h extends Template {

     static {templateClass = new OE14A_6h() ; }

     public void setup() {
          filePrefix = "OE14A_6h" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 7.5*0.5 ;      // in inches
          ysize = 3.5*0.5 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 7 ;
          ymin = -0.5 ;
          ymax = 3 ;
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
            double[] xlist = { 0, 2, 2} ;
            double[] ylist = { 0, 2, 0} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }        
          fCurve("[t, sqrt(6-t)]",1, 2,5.999999, FILLED) ;
               { 
            double[] xlist = { 2, 6,           4, 2} ;
            double[] ylist = { 0, 0, Math.sqrt(2), 2} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }        


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.1, 0.0, "cl", "$x$") ;
          fTeXlabel(0.0, ymax+0.1, "bc", "$y$") ;

          fLine(2, ymin, 2, ymax) ;
          fTeXlabel(2-0.1, ymax, "tr", "$x=2$") ;
          fLine(xmin, xmin, ymax, ymax) ;
          fTeXlabel(ymax+0.1, ymax, "tl", "$x=y$") ;
          fCurve("[t, sqrt(6-t)]",1, 1,6, OPEN) ;
          fTeXlabel(3.95, 1.5, "bl", "$x=6-y^2$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          fCurve("[t, sqrt(6-t)]",1, 2,5.999999, OPEN) ;
          fLine(0, 0, 2, 2) ;          
          fLine(0, 0, 6, 0) ;   

          double r = 0.1 ;
          fTeXlabel(2-0.2, 2-0.07, "cr", "$\\scriptstyle (2,2)$") ;
          fDisk(2, 2, r, r, FILLED) ;
          fTeXlabel(5.9, -0.1, "tr", "$\\scriptstyle (6,0)$") ;
          fDisk(6, 0, r, r, FILLED) ;

          fEnv("useColorPs", "false") ;
          double yb = 0.7 ;  double yt = 0.85 ;
          double xl = yb ;  double xr = 6-yb*yb ; 
          double xll = 2.5 ;  double xrr = 2.65 ;

          fEnv("psFillGray", 0.6) ;
          { 
            double[] xlist = { xl,  xl,  xr, xr} ;
            double[] ylist = { yt,  yb,  yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             

          fEnv("psFillGray", 0.3) ;
          { 
            double[] xlist = { xll, xll, xrr, xrr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             



       

     }
}
