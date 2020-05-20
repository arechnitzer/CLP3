                  /*  File:  OE09A_8b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE09A_8b extends Template {

     static {templateClass = new OE09A_8b() ; }

     public void setup() {
          filePrefix = "OE09A_8b" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.3*1.0 ;      // in inches
          ysize = 1.9*1.0 ;   // in inches. 
          xmin = -1.0 ;
          xmax = 0.3 ;
          ymin = -1.6 ;
          ymax = 0.3 ;
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
         double ZZ =1.0 ;
         double XM =-(1-ZZ/3) ;
         double YM =-2*(1-ZZ/3) ;
          fEnv("psFillGray", 0.8) ;
         { 
            double[] xlist = { 0, XM,  0} ;
            double[] ylist = { 0, 0,  YM} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;

          fLine(-ymin/2+XM,ymin, -ymax/2+XM,ymax) ;
          fTeXlabel(0.4*XM-0.05,0.6*YM, "tr", "$-x-\\frac{y}{2}=1-\\frac{z}{3}$") ;
          fTeXlabel(-0.36,-0.25, "cc", "$E_z$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
         { 
            double[] xlist = { 0, XM,  0} ;
            double[] ylist = { 0, 0,  YM} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }             


          fEnv("lineWidth",0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillGray", 0.0) ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          double r = 0.04 ;
          fDisk(XM, 0, r, r, FILLED) ; fArrow(1.4*XM, -0.3,  XM-0.03,-0.03) ;
          fTeXlabel(1.4*XM, -0.3-0.01, "tc", "$\\scriptstyle x=-(1-z/3)$") ;
          fTeXlabel(1.4*XM, -0.3-0.15, "tc", "$\\scriptstyle y=0$") ;
          fDisk(0, YM, r, r, FILLED) ; fArrow(0.3, YM,  0.03,YM) ;
          fTeXlabel(0.33, YM, "cl", "$\\scriptstyle  x=0,\\ y=-2(1-z/3)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = -0.2 ;
          double YT = 0 ;
          double YB = -2*(1-ZZ/3+X) ;
          fEnv("lineWidth", 8.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = -0.6 ;
          YT = -0.45 ;
          fLine(X,YB, X,YT) ;          
     }
}
