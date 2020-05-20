                  /*  File:  OE16D_2b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE16D_2b extends Template {

     static {templateClass = new OE16D_2b() ; }

     public void setup() {
          filePrefix = "OE16D_2b" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 7.0*0.4 ;      // in inches
          ysize = 8.0*0.4 ;   // in inches. 
          xmin = -2.0 ;
          xmax =  5.0;
          ymin = -4.0 ;
          ymax =  4.0 ;
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
//          fCurve("[t, t*t]",1, 0,1, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.07, ymax, "tr", "$z$") ;
          double h = 0.15 ;
          fLine(0,1, -h,1) ; fTeXlabel(-1.2*h,1, "cr", "$1$") ;
          fLine(0,2, -h,2) ; fTeXlabel(-1.2*h,2, "cr", "$2$") ;
          fLine(0,3, -h,3) ; fTeXlabel(-1.2*h,3, "cr", "$3$") ;

          h = 0.17 ;
          fLine(1,0, 1,-h) ; fTeXlabel(1,-1.3*h, "tc", "$1$") ;
          fLine(2,0, 2,-h) ; fTeXlabel(2,-1.3*h, "tc", "$2$") ;
          fLine(3,0, 3,-h) ; fTeXlabel(3,-1.3*h, "tc", "$3$") ;
          fLine(4,0, 4,-h) ; fTeXlabel(4,-1.3*h, "tc", "$4$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;


          { double[] xlist = {-2,    0, 1.6, 3, 5} ;
            double[] ylist = {-3, -2.5,   0, 1, 1.3} ;
            fBezier bez = new fBezier(xlist, ylist, 5, OPEN) ;
//            bez.configure("vertex1scale", 2) ;
            bez.configure("vertex0inAngle", 0) ;
            bez.configure("vertex0outAngle", 0) ;
//            bez.configure("vertex4scale", 2) ;
            bez.configure("vertex2inAngle", 50) ;
            bez.configure("vertex2outAngle", 50) ;
            canvas.append(bez) ;
            fTeXlabel(5.1, 1.3, "cl", "$y=1.9$") ;
          }


          { double[] xlist = {-2,     0,   1,  3, 5} ;
            double[] ylist = {-0.5, 0.15, 0.85,1.8,2.1} ;
            fBezier bez = new fBezier(xlist, ylist, 5, OPEN) ;
//            bez.configure("vertex1scale", 2) ;
//            bez.configure("vertex0inAngle", 0) ;
            bez.configure("vertex0outAngle", 0) ;
//            bez.configure("vertex4scale", 2) ;
//            bez.configure("vertex2inAngle", 50) ;
//            bez.configure("vertex2outAngle", 50) ;
            canvas.append(bez) ;
            fTeXlabel(5.1, 2.1, "cl", "$y=2.0$") ;
          }


          { double[] xlist = {-2,    0,   1,  3,    5} ;
            double[] ylist = { 2,  2.2, 2.3, 2.5, 2.6} ;
            fBezier bez = new fBezier(xlist, ylist, 5, OPEN) ;
//            bez.configure("vertex1scale", 2) ;
//            bez.configure("vertex0inAngle", 0) ;
//            bez.configure("vertex0outAngle", 0) ;
//            bez.configure("vertex4scale", 2) ;
//            bez.configure("vertex2inAngle", 50) ;
//            bez.configure("vertex2outAngle", 50) ;
            canvas.append(bez) ;
            fTeXlabel(5.1, 2.6, "cl", "$y=2.1$") ;

          }


//          fCurve("[t, t*t]",1, xmin,xmax, OPEN) ;
//          fLine(xmin,1, xmax,1) ;
//
//          fTeXlabel(xmax+0.05, 1, "lc", "$y=1$") ;
//          fTeXlabel(0.7, 0.49, "tl", "$y=x^2$") ;
//
//
//          fEnv("lineWidth",1.5) ;
//          String Red = "0 1 1 0 setcmykcolor  " ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
//          fCurve("[t, t*t]",1, 0,1, OPEN) ;
//          fLine(0,1, 1,1) ;
//          fLine(0,0, 0,1) ;
//
//          double r = 0.04 ;
//          fEnv("psFillGray", 0.0) ;
//          fDisk(1,1, r,r, FILLED) ;
//          fTeXlabel(0.97, 1.03, "br", "$\\scriptstyle (1,1)$") ;

          
     }
}
