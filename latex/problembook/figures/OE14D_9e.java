                  /*  File:  OE14D_9e.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE14D_9e extends Template {

     static {templateClass = new OE14D_9e() ; }

     public void setup() {
          filePrefix = "OE14D_9e" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0*0.3 ;      // in inches
          ysize = 7.0*0.3 ;   // in inches. 
          xmin = -0.5 ;
          xmax =  3.5 ;
          ymin = -0.5 ;
          ymax = 6.5 ;
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
          double Y = 1 ;
          {  double[] xlist = {3,   3,  Y*Y/2} ;
             double[] ylist = {Y*Y, 6,  Y*Y} ;
             fPolygon(xlist, ylist, 3, FILLED) ; }


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.1, 0.0, "cl", "$x$") ;
          fTeXlabel(0.0, ymax+0.1, "bc", "$z$") ;

          fLine(xmin, Y*Y, xmax, Y*Y) ;
          fTeXlabel(xmax+0.1, Y*Y, "cl", "$z=y^2$") ;
          fLine(3, ymin, 3, ymax) ;
          fTeXlabel(3.1, 0.5*(Y*Y+6), "cl", "$x=3$") ;
          fLine(xmin, 2*xmin, xmax, 2*xmax) ;
          fTeXlabel(0.3*(Y*Y+6)-0.1, 0.6*(Y*Y+6), "cr", "$z=2x$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          {  double[] xlist = {3,   3,  Y*Y/2} ;
             double[] ylist = {Y*Y, 6,  Y*Y} ;
             fPolygon(xlist, ylist, 3, CLOSED) ; }

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillGray", 0.0) ;
          fEnv("lineWidth",0.5) ;
          double r = 0.1 ;
          fDisk(3, Y*Y, r, r, FILLED) ;
          fTeXlabel(3, Y*Y-0.1, "tr", "$\\scriptstyle (3,y^2)$") ;
          fDisk(3, 6, r, r, FILLED) ;
          fTeXlabel(3.1, 6, "tl", "$\\scriptstyle (3,6)$") ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fArrow(-0.5,2,  Y*Y/2-0.05, Y*Y+0.05) ;
          fDisk(Y*Y/2, Y*Y, r, r, FILLED) ;
          fTeXlabel(-0.55, 2, "cr", "$\\scriptstyle (y^2/2,y^2)$") ;
          

     }
}
