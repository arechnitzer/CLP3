                  /*  File:  sectorArea.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sectorArea extends Template {

     static {templateClass = new sectorArea() ; }

     public void setup() {
          filePrefix = "sectorArea" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.2*0.24 ;      // in inches
          ysize = 4.2*0.24 ;   // in inches
          xmin = -0.2 ;
          xmax = 5 ;
          ymin = -0.2 ;
          ymax = 4 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {


          fEnv("lineWidth", 0.2) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          double rho = 4.5 ;
          double dth  = Math.PI/15 ;
          double th = Math.PI/5 ;
          double th1 = th - dth ;
          double th2 = th + dth ;
          double x1 = rho*Math.cos(th1);
          double y1 = rho*Math.sin(th1);
          double x2 = rho*Math.cos(th2);
          double y2 = rho*Math.sin(th2);

          fEnv("psFillGray", 0.8) ;
          fCurve("[4.5*cos(t),4.5*sin(t)]", 1, th1, th2, FILLED);
          double[] xlist = {0, x1, x2} ;
          double[] ylist = {0, y1, y2} ;
          fPolygon(xlist, ylist, 3, FILLED) ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("lineWidth", 1.0) ;
          fCurve("[4.5*cos(t),4.5*sin(t)]", 1,
                  th1, th2, OPEN);

          fLine(0,0, x1, y1) ;
          fLine(0,0, x2, y2) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

//          fTeXlabel(0.55*x1-0.1, 0.55*y1-0.1, "tl", "$\\rho$") ;
          fTeXlabel(0.55*x2+0.1, 0.55*y2+0.1, "br", "$\\rho$") ;
          fTeXlabel(0.2*x1+0.1, 0.2*y1+0.7, "tl", "$\\scriptstyle\\Delta\\theta$") ;



     }
}
