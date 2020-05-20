                  /*  File:  OE08A_2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE08A_2 extends Template {

     static {templateClass = new OE08A_2() ; }

     public void setup() {
          filePrefix = "OE08A_2" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 8.0*0.3 ;      // in inches
          ysize = 5.5*0.3 ;   // in inches. 
          xmin = -5.0 ;
          xmax = 3.0 ;
          ymin = -0.5 ;
          ymax = 5.0 ;
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
            double[] xlist = { 0, 2,- 4} ;
            double[] ylist = { 0, 4, 4} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fLine(-ymin,ymin,  -ymax, ymax) ;
          fLine(0.5*ymin,ymin,  0.5*ymax, ymax) ;
          fLine(xmin,4,  xmax, 4) ;
          fTeXlabel(0.5*ymax+0.1, ymax, "cl", "$x=y/2$") ;
          fTeXlabel(-ymax-0.1, ymax, "cr", "$x=-y$") ;
          fTeXlabel(xmax+0.1, 4.0, "cl", "$y=4$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          { 
            double[] xlist = { 0, 2,- 4} ;
            double[] ylist = { 0, 4, 4} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }  


          fEnv("psFillGray", 0.0) ;
          double r = 0.13 ;
          fDisk(2, 4, r, r, FILLED) ;
          fTeXlabel(2.08, 3.92, "tl", "$\\scriptstyle (2.4)$") ;
          fDisk(-4, 4, r, r, FILLED) ;
          fTeXlabel(-4.08, 3.92, "tr", "$\\scriptstyle (-4.4)$") ;
          fDisk(0, 0, r, r, FILLED) ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double Y = 3.0 ;
          double XL = -Y ;
          double XR = 0.5*Y ;
          fEnv("lineWidth", 7.0) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = -1.3 ;
          XR = -1.0 ;
          fLine(XL,Y, XR,Y) ;  
     }
}
