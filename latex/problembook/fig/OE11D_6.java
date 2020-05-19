                  /*  File:  OE11D_6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE11D_6 extends Template {

     static {templateClass = new OE11D_6() ; }

     public void setup() {
          filePrefix = "OE11D_6" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 2.3 ;
          ymin = -0.2 ;
          ymax = 2.3 ;
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
            double[] xlist = { 0, 1,  2} ;
            double[] ylist = { 2, 0,  0} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fTeXlabel(1.2, 0.3, "cc", "$R$") ;
          fTeXlabel(0.8, 0.3, "rc", "$x=\\frac{2-y}{2}$") ;
          fTeXlabel(1.1, 1.05, "lc", "$x=2-y$") ;



          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          { 
            double[] xlist = { 0, 1,  2} ;
            double[] ylist = { 2, 0,  0} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }      

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double Y = 0.7 ;
          double XL = (2-Y)/2 ;
          double XR = 2-Y ;
          fEnv("lineWidth", 6.0) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = 0.9 ;
          XR = 1.05 ;
          fLine(XL,Y, XR,Y) ;

          fEnv("psFillGray", 0.0) ;
          double r = 0.04 ;
          fDisk(0, 2, r, r, FILLED) ;
          fDisk(1, 0, r, r, FILLED) ;
          fDisk(2, 0, r, r, FILLED) ;
          fTeXlabel(2.0, -0.1, "tc", "$\\scriptstyle (2,0)$") ;
          fTeXlabel(1.0, -0.1, "tc", "$\\scriptstyle (1,0)$") ;
          fTeXlabel(-.05, 2.0, "cr", "$\\scriptstyle (0,2)$") ;

       
          
     }
}
