                  /*  File:  OE13D_6a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE13D_6a extends Template {

     static {templateClass = new OE13D_6a() ; }

     public void setup() {
          filePrefix = "OE13D_6a" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*0.5 ;      // in inches
          ysize = 3.0*0.5 ;   // in inches. 
          xmin = -1.5 ;
          xmax = 0.5 ;
          ymin = -2.5 ;
          ymax =  0.5 ;
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
            double[] xlist = { -1,   0,  0} ;
            double[] ylist = { -2,  -2,  0} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          double r = 0.5 ;
          fLine(xmax, 2*xmax, xmin, 2*xmin) ;
          fLine(xmax, -2, xmin, -2) ;
          fTeXlabel(xmin-0.05, -2.03, "cr", "$y=-2$") ;
          fTeXlabel(ymin/2, ymin-0.05, "ct", "$y=2x$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          { 
            double[] xlist = { -1,   0,  0} ;
            double[] ylist = { -2,  -2,  0} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }             

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth",0.5) ;
          fEnv("psFillGray", 0.0) ;
          r = 0.06 ;
          fDisk(-1, -2, r, r, FILLED) ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fArrow(-1.5, -1.5,   -1.05, -1.95) ;
          fTeXlabel(-1.5, -1.5, "cr", "$(-1,-2)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X  = -0.5 ;
          double YB = -2 ;
          double YT = 2*X;
          fEnv("lineWidth", 4.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = -1.65 ;
          YT = -1.5 ;
          fLine(X,YB, X,YT) ;




          
     }
}
