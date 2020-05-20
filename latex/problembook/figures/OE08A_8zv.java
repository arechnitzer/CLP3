                  /*  File:  OE08A_8zv.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE08A_8zv extends Template {

     static {templateClass = new OE08A_8zv() ; }

     public void setup() {
          filePrefix = "OE08A_8zv" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.5 ;      // in inches
          ysize = 1.4*1.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 1.2 ;
          ymin = -0.2 ;
          ymax = 1.2 ;
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
          double Z = 0.1 ; double Y = 1-Z ; double X = Y*Y ;
          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { 0, 0,  X,  0.25*X} ;
            double[] ylist = { 0, Y,  Y,   0.5*Y} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }               
          fEnv("psFillGray", 1.0) ;
          fCurve("[t*t, t]",1, 0,Y, FILLED) ;
             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.03, 0, "cl", "$x$") ;
          fTeXlabel(0, ymax+0.03, "cb", "$y$") ;

          fLine(xmin,Y,  X, Y) ;
          fTeXlabel(X/2, Y+0.03, "cb", "$y=1-z$") ;
          fTeXlabel(0.53, 0.6, "ct", "$y=\\sqrt{x}$") ;

          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(X, Y, r, r, FILLED) ;
          fTeXlabel(X+0.33, Y+0.07, "cc", "$x=(1-z)^2$") ;
          fTeXlabel(X+0.33, Y-0.05, "cc", "$y=1-z$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[t*t, t]",1, 0,Y, OPEN) ;
          fLine(0,Y,  X,Y) ;
          fLine(0,0,  0,Y) ;




          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double XS = 0.2 ;
          double YB = Math.sqrt(XS) ;
          double YT = Y ;
          fEnv("lineWidth", 7.0) ;
          fLine(XS,YB, XS,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.6 ;
          YT = 0.67 ;
          fLine(XS,YB, XS,YT) ;  
     }
}
