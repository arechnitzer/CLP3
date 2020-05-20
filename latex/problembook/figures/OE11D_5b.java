                  /*  File:  OE11D_5b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE11D_5b extends Template {

     static {templateClass = new OE11D_5b() ; }

     public void setup() {
          filePrefix = "OE11D_5b" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.4 ;      // in inches
          ysize = 5.0*0.4 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 2.5 ;
          ymin = -4.5 ;
          ymax = 0.5 ;
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
          { 
            double[] xlist = { 0, 1,   2, 2, 0} ;
            double[] ylist = { 0, -1, -4, 0, 0} ;
            fPolygon(xlist, ylist, 5, FILLED) ;
           }             
          fEnv("psFillGray", 1.0) ;
          fCurve("[t, -t*t]",1, 0,2, FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fCurve("[t, -t*t]",1, 0,xmax, OPEN) ;
          fTeXlabel(Math.sqrt(-ymin)+0.1, ymin, "bl", "$\\scriptstyle y=-x^2$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(0, 0, 2, 0) ;
          fLine(2, 0, 2, -4) ;
          fCurve("[t, -t*t]",1, 0,2, OPEN) ;

          fEnv("psFillGray", 0.0) ;
          double r = 0.07 ;
          fDisk(2, 0, r, r, FILLED) ;
          fDisk(2, -4, r, r, FILLED) ;
          fTeXlabel(2.00, 0.1, "bc", "$\\scriptstyle (2,0)$") ;
          fTeXlabel(2.05,-3.95, "bl", "$\\scriptstyle (2,-4)$") ;



          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 1.5 ;
          double YT = 0 ;
          double YB = -X*X ;
          fEnv("lineWidth", 6.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YT = -1.0 ;
          YB = -1.17 ;
          fLine(X,YB, X,YT) ;




          
     }
}
