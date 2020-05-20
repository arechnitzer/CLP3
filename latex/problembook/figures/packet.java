                  /*  File:  packet.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class packet extends Template {

     static {templateClass = new packet() ; }

     public void setup() {
          filePrefix="packet";//used as the prefix for the ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.6*0.65*1.5 ;   // in inches
          ysize = 1*0.8*1.5 ;   // in inches
          xmin = -15 ;
          xmax = 500 ;
          ymin = -10 ;
          ymax = 90 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.05 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax,-5,"tr", "$x$") ;
          fTeXlabel(-7,ymax,"tr", "$u$") ;

          double x1 = 30 ;
          double x2 = 100 ;
          double x3 = 180 ;
          fLine(x2, 0, x2, -5) ;
          fTeXlabel(x2,-7,"tc", "$z$") ;
          fTeXlabel(x2,72,"bc", "$u=F(x)$") ;
          fEnv("lineWidth", 1.0) ;
          { double[] xlist = { 0, x1, x2, x3, xmax} ;
            double[] ylist = {0, 0,  70,  0, 00} ;
            fBezier bez = new fBezier(xlist, ylist, 5, OPEN) ;
            bez.configure("vertex1scale", 2) ;
            bez.configure("vertex1inAngle", 0) ;
            bez.configure("vertex1outAngle", 0) ;
            bez.configure("vertex3scale", 2) ;
            bez.configure("vertex3inAngle", 0) ;
            bez.configure("vertex3outAngle", 0) ;
            canvas.append(bez) ;
          }


          x1 = 30 +250;
          x2 = 100+250;
          x3 = 180+250;
          fEnv("lineWidth", 0.5) ;
          fLine(x2, 0, x2, -5) ;
          fTeXlabel(x2,-7,"tc", "$z+ct$") ;
          fTeXlabel(x2,72,"bc", "$u=F(x-ct)$") ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          { double[] xlist = { 0, x1, x2, x3, xmax} ;
            double[] ylist = {0, 0,  70,  0, 00} ;
            fBezier bez = new fBezier(xlist, ylist, 5, OPEN) ;
            bez.configure("vertex1scale", 2) ;
            bez.configure("vertex1inAngle", 0) ;
            bez.configure("vertex1outAngle", 0) ;
            bez.configure("vertex3scale", 2) ;
            bez.configure("vertex3inAngle", 0) ;
            bez.configure("vertex3outAngle", 0) ;
            canvas.append(bez) ;
          }
          
     }
}
