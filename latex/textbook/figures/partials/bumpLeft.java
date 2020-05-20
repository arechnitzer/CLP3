                  /*  File:  bumpLeft.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class bumpLeft extends Template {

     static {templateClass = new bumpLeft() ; }

     public void setup() {
          filePrefix="bumpLeft";//used as the prefix for the ps and lbl files
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.0*0.65 ;   // in inches
          ysize = 1*0.8 ;   // in inches
          xmin = -15 ;
          xmax = 800 ;
          ymin = -10 ;
          ymax = 90 ;
          topmargin = 0.3 ;   // in inches
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
          fTeXlabel(-7,ymax,"tr", "$y$") ;

          double x2 = 130 ;
          fLine(x2, 0, x2, -6) ;
          x2 = 130+250;
          fLine(x2, 0, x2, -6) ;
          x2 = 130+500;
          fLine(x2, 0, x2, -6) ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;

          double x1 = 60 ;
                 x2 = 130 ;
          double x3 = 210 ;
          fTeXlabel(x2+8,-9,"tc", "$z-2c$") ;
          fTeXlabel(x2,75,"bc", "$y=U(x\\!+\\!2c)$") ;
          fTeXlabel(x2,100,"bc", "$t=2$") ;
          fEnv("lineWidth", 1.0) ;
          { double[] xlist = { xmin, x1, x2, x3, xmax} ;
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
          canvas.append( new fPsWrite(Black+"\n")) ;
          fArrow(0.5*x1+0.5*x2+12, 35, 0.5*x1+0.5*x2-35, 35) ;
          canvas.append( new fPsWrite(Red+"\n")) ;


          x1 = 60 +250;
          x2 = 130+250;
          x3 = 210+250;
          fTeXlabel(x2,-9,"tc", "$z-c$") ;
          fTeXlabel(x2,75,"bc", "$y=U(x\\!+\\!c)$") ;
          fTeXlabel(x2,100,"bc", "$t=1$") ;
          { double[] xlist = {xmin, x1, x2, x3, xmax} ;
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
          canvas.append( new fPsWrite(Black+"\n")) ;
          fArrow(0.5*x1+0.5*x2+12, 35, 0.5*x1+0.5*x2-35, 35) ;
          canvas.append( new fPsWrite(Red+"\n")) ;


          x1 = 60 +500;
          x2 = 130+500;
          x3 = 210+500;
          fTeXlabel(x2,-10,"tc", "$z$") ;
          fTeXlabel(x2,75,"bc", "$y=U(x)$") ;
          fTeXlabel(x2,100,"bc", "$t=0$") ;
          { double[] xlist = { xmin, x1, x2, x3, xmax} ;
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
          canvas.append( new fPsWrite(Black+"\n")) ;
          fArrow(0.5*x1+0.5*x2+12, 35, 0.5*x1+0.5*x2-35, 35) ;
          canvas.append( new fPsWrite(Red+"\n")) ;

          
     }
}
