                  /*  File:  OE09A_8a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE09A_8a extends Template {

     static {templateClass = new OE09A_8a() ; }

     public void setup() {
          filePrefix = "OE09A_8a" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6*0.8 ;      // in inches
          ysize = 2.2*0.8 ;   // in inches. 
          xmin = -1.2 ;
          xmax = 0.4 ;
          ymin = -0.2 ;
          ymax = 2.0 ;
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
         double XX =-0.5 ;
         double XM =-2*(1+XX) ;
         double YM =3*(1+XX) ;
          fEnv("psFillGray", 0.8) ;
         { 
            double[] xlist = { 0, XM,  0} ;
            double[] ylist = { 0, 0,  YM} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin+0.1, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$y$") ;
          fTeXlabel(-0.02, ymax, "tr", "$z$") ;

          fLine(2*ymin/3+XM,ymin, 2*ymax/3+XM,ymax) ;
          fTeXlabel(XM/2,YM/2, "br", "$-\\frac{y}{2}+\\frac{z}{3}=1+x$") ;
          fTeXlabel(-0.55,0.25, "cc", "$E_x$") ;


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
          fDisk(XM, 0, r, r, FILLED) ; fArrow(0.6*XM, ymin,  XM+0.03,-0.03) ;
          fTeXlabel(0.2*XM, ymin-0.01, "tc", "$\\scriptstyle y=-2(1+x)$") ;
          fTeXlabel(0.2*XM, ymin-0.18, "tc", "$\\scriptstyle z=0$") ;
          fDisk(0, YM, r, r, FILLED) ; fArrow(0.4, YM,  0.02,YM) ;
          fTeXlabel(0.45, YM, "cl", "$\\scriptstyle \\scriptstyle y=0,\\ z=3(1+x)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = -0.3 ;
          double YB = 0 ;
          double YT = 3*(1+XX+X/2) ;
          fEnv("lineWidth", 8.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.45 ;
          YT = 0.6 ;
          fLine(X,YB, X,YT) ;          
     }
}
